package pl.gispartner.ResourceManagerApp.service;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import pl.gispartner.ResourceManagerApp.model.ResourceDto;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;
import pl.gispartner.ResourceManagerApp.model.ResourceMapper;
import pl.gispartner.ResourceManagerApp.model.UserEntity;
import pl.gispartner.ResourceManagerApp.persistance.ResourceRepository;
import pl.gispartner.ResourceManagerApp.persistance.UserRepository;

import java.util.Date;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final UserRepository userRepository;

    public Long saveResource(ResourceDto resourceDto) {
        ResourceEntity resourceEntity = ResourceMapper.mapToEntity(resourceDto);
        UserEntity userEntity = userRepository.getReferenceById(resourceDto.getOwnerId());
        resourceEntity.setUser(userEntity);
        resourceEntity.setJsonData(ResourceMapper.saveToString(resourceDto.getJsonData()));
        ResourceEntity created = resourceRepository.save(resourceEntity);
        return created.getId();
    }

    public void deleteResource(Long resourceId) {
        resourceRepository.deleteById(resourceId);
    }

    @Transactional
    public void updateResourceName(Long resourceId, String newResourceName) {
        resourceRepository.updateResourceName(resourceId, newResourceName);
        ResourceEntity resourceEntity = resourceRepository.getReferenceById(resourceId);
        resourceEntity.setModifiedDate(new Date());
    }

    @Transactional
    public void updateJsonData(Long resourceId, JsonNode newJsonData) {
        resourceRepository.updateJsonData(resourceId, newJsonData);
        ResourceEntity resourceEntity = resourceRepository.getReferenceById(resourceId);
        resourceEntity.setModifiedDate(new Date());
    }

}
