package pl.gispartner.ResourceManagerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gispartner.ResourceManagerApp.model.ResourceDto;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;
import pl.gispartner.ResourceManagerApp.model.ResourceMapper;
import pl.gispartner.ResourceManagerApp.persistance.ResourceRepository;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final ResourceMapper resourceMapper;

    public Long saveResource(ResourceDto resourceDto) {
        ResourceEntity resourceEntity = resourceRepository.save(resourceMapper.mapToEntity(resourceDto));
        return resourceEntity.getResourceId();
    }

    public void deleteResource(Long resourceId) {
        resourceRepository.deleteById(resourceId);
    }

}
