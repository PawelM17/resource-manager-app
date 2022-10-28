package pl.gispartner.app.model;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.*;

@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ResourceDto {

    private Long id;
    private String name;
    private ResourceType resourceType;
    private Long ownerId;
    private JsonNode jsonData;
}
