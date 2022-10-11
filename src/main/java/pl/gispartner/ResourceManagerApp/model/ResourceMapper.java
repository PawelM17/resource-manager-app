package pl.gispartner.ResourceManagerApp.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;

public class ResourceMapper {
    public static ResourceEntity mapToEntity(ResourceDto resourceDto) {
        return ResourceEntity.builder()
                .id(resourceDto.getId())
                .name(resourceDto.getName())
                .resourceType(resourceDto.getResourceType())
                .build();
    }

    public static String saveToString(JsonNode jsonData) {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(SerializationFeature.FAIL_ON_EMPTY_BEANS, false);
        String data;
        try {
            data = objectMapper.writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

}
