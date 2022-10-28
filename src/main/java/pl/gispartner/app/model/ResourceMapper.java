package pl.gispartner.app.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonNode;
import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@RequiredArgsConstructor
@Component
public class ResourceMapper {

    private final ObjectMapper objectMapper;

    public ResourceEntity mapToEntity(ResourceDto resourceDto) {
        return ResourceEntity.builder()
                .id(resourceDto.getId())
                .name(resourceDto.getName())
                .resourceType(resourceDto.getResourceType())
                .build();
    }

    public ResourceDto mapToDto(ResourceEntity resourceEntity) {
        return ResourceDto.builder()
                .id(resourceEntity.getId())
                .name(resourceEntity.getName())
                .resourceType(resourceEntity.getResourceType())
                .ownerId(resourceEntity.getUser().getId())
                .jsonData(saveToJson(resourceEntity.getJsonData()))
                .build();
    }

    public String saveToString(JsonNode jsonData) {
        String data;
        try {
            data = objectMapper.writeValueAsString(jsonData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return data;
    }

    public JsonNode saveToJson(String stringData) {
        JsonNode jsonData;
        try {
            jsonData = objectMapper.readTree(stringData);
        } catch (JsonProcessingException e) {
            throw new RuntimeException(e);
        }
        return jsonData;
    }

}
