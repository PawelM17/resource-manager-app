package pl.gispartner.ResourceManagerApp.service;

import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;
import pl.gispartner.ResourceManagerApp.persistance.ResourceRepository;

@Service
@RequiredArgsConstructor
public class ResourceService {

    private final ResourceRepository resourceRepository;

    public void saveResource(ResourceEntity resourceEntity) {
        resourceRepository.save(new ResourceEntity(resourceEntity.getResourceId(), resourceEntity.getName()));
    }

    public void deleteResource(ResourceEntity resourceEntity) {
        resourceRepository.delete(resourceEntity);
    }

}
