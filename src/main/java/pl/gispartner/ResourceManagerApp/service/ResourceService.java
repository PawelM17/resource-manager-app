package pl.gispartner.ResourceManagerApp.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.exceptions.ResourceNotFoundException;
import pl.gispartner.ResourceManagerApp.exceptions.UserNotFoundException;
import pl.gispartner.ResourceManagerApp.model.ResourceDto;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;
import pl.gispartner.ResourceManagerApp.model.ResourceMapper;
import pl.gispartner.ResourceManagerApp.model.UserEntity;
import pl.gispartner.ResourceManagerApp.persistance.ResourceRepository;
import pl.gispartner.ResourceManagerApp.persistance.UserRepository;

import java.util.Date;
import java.util.List;
import java.util.Objects;

import static pl.gispartner.ResourceManagerApp.model.UserType.SUPER_USER;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;
    private final ResourceMapper resourceMapper;

    public ResourceDto getResource(Long resourceId) {
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource is not found for id = " + resourceId));
        return resourceMapper.mapToDto(resourceEntity);
    }

    public List<ResourceDto> getAllUserResources(Long userId) {
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User is not found for id = " + userId));
        return userEntity.getResources().stream()
                .map(resourceMapper::mapToDto)
                .toList();
    }

    public Long saveResource(ResourceDto resourceDto) {
        ResourceEntity resourceEntity = resourceMapper.mapToEntity(resourceDto);
        UserEntity userEntity = userRepository.findById(resourceDto.getOwnerId())
                .orElseThrow(() -> new UserNotFoundException("User is not found for id = " + resourceDto.getOwnerId()));
        resourceEntity.setUser(userEntity);
        resourceEntity.setJsonData(resourceMapper.saveToString(resourceDto.getJsonData()));

        ResourceEntity created = resourceRepository.save(resourceEntity);
        return created.getId();
    }

    public String deleteResource(Long resourceId, Long userId) {
        if (!isUserValid(userId, resourceId)) {
            return "This operation cannot be performed - lack of authority";
        }
        resourceRepository.deleteById(resourceId);
        return "Changes have been successfully saved";
    }

    @Transactional
    public String updateResourceName(Long resourceId, String newResourceName, Long userId) {
        if (!isUserValid(userId, resourceId)) {
            return "This operation cannot be performed - lack of authority";
        }
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource is not found for id = " + resourceId));
        resourceEntity.setName(newResourceName);
        resourceEntity.setModifiedDate(new Date());
        return "Changes have been successfully saved";
    }

    @Transactional
    public String updateJsonData(Long resourceId, JsonNode newJsonData, Long userId) {
        if (!isUserValid(userId, resourceId)) {
            return "This operation cannot be performed - lack of authority";
        }
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource is not found for id = " + resourceId));
        resourceEntity.setJsonData(resourceMapper.saveToString(newJsonData));
        resourceEntity.setModifiedDate(new Date());
        return "Changes have been successfully saved";
    }

    public boolean isUserValid(Long userId, Long resourceId) {
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new ResourceNotFoundException("Resource is not found for id = " + resourceId));
        UserEntity userEntity = userRepository.findById(userId)
                .orElseThrow(() -> new UserNotFoundException("User is not found for id = " + userId));
        return Objects.equals(userId, resourceEntity.getUser().getId()) || Objects.equals(userEntity.getUserType(), SUPER_USER);
    }

}
