package pl.gispartner.ResourceManagerApp.model;

public class ResourceMapper {

    public static ResourceEntity mapToEntity(ResourceDto resourceDto) {
        return ResourceEntity.builder()
                .id(resourceDto.getId())
                .name(resourceDto.getName())
                .resourceType(resourceDto.getResourceType())
                .build();
    }
}
