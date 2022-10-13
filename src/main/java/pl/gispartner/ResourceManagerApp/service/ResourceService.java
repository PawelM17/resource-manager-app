package pl.gispartner.ResourceManagerApp.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.model.*;
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
        return resourceMapper.mapToDto(resourceRepository.getReferenceById(resourceId));
    }

    public List<ResourceDto> getAllUserResources(Long userId) {
        UserEntity userEntity = userRepository.getReferenceById(userId);
        return userEntity.getResources().stream()
                .map(resourceMapper::mapToDto)
                .toList();
    }

    public Long saveResource(ResourceDto resourceDto) {
        ResourceEntity resourceEntity = resourceMapper.mapToEntity(resourceDto);
        UserEntity userEntity = userRepository.getReferenceById(resourceDto.getOwnerId());

        resourceEntity.setUser(userEntity);
        resourceEntity.setJsonData(resourceMapper.saveToString(resourceDto.getJsonData()));

        ResourceEntity created = resourceRepository.save(resourceEntity);
        return created.getId();
    }

    public String deleteResource(Long resourceId, Long userId) {
        if (!isUserValid(userId, resourceId)) {
            return "This operation cannot be performed";
        }
        resourceRepository.deleteById(resourceId);
        return "Changes have been successfully saved";
    }

    @Transactional
    public String updateResourceName(Long resourceId, String newResourceName, Long userId) {
        if (!isUserValid(userId, resourceId)) {
            return "This operation cannot be performed";
        }
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        resourceEntity.setName(newResourceName);
        resourceEntity.setModifiedDate(new Date());
        return "Changes have been successfully saved";
    }

    @Transactional
    public String updateJsonData(Long resourceId, JsonNode newJsonData, Long userId) {
        if (!isUserValid(userId, resourceId)) {
            return "This operation cannot be performed";
        }
        ResourceEntity resourceEntity = resourceRepository.findById(resourceId)
                .orElseThrow(() -> new RuntimeException("Resource not found"));
        resourceEntity.setJsonData(resourceMapper.saveToString(newJsonData));
        resourceEntity.setModifiedDate(new Date());
        return "Changes have been successfully saved";
    }

    public boolean isUserValid(Long userId, Long resourceId) {
        ResourceEntity resourceEntity = resourceRepository.getReferenceById(resourceId);
        UserEntity userEntity = userRepository.getReferenceById(userId);
        return Objects.equals(userId, resourceEntity.getUser().getId()) || Objects.equals(userEntity.getUserType(), SUPER_USER);
    }

}
