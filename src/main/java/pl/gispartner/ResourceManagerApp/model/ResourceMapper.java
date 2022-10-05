package pl.gispartner.ResourceManagerApp.model;

import org.springframework.stereotype.Component;

@Component
public class ResourceMapper {

    public ResourceEntity mapToEntity(ResourceDto resourceDto) {
        return ResourceEntity.builder()
                .resourceId(resourceDto.getResourceId())
                .name(resourceDto.getName())
                .build();
    }
}
