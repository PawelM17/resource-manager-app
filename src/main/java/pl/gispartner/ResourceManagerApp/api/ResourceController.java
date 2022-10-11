package pl.gispartner.ResourceManagerApp.api;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gispartner.ResourceManagerApp.model.ResourceDto;
import pl.gispartner.ResourceManagerApp.service.ResourceService;

@RestController
@RequestMapping("/api/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @PostMapping
    public Long saveResource(@RequestBody ResourceDto resourceDto) {
        return resourceService.saveResource(resourceDto);
    }

    @DeleteMapping("/{resourceId}")
    public void deleteResource(@PathVariable("resourceId") Long resourceId) {
        resourceService.deleteResource(resourceId);
    }

    @PutMapping("/name/{resourceId}")
    public void updateResourceName(@PathVariable("resourceId") Long resourceId, @RequestBody String newResourceName) {
        resourceService.updateResourceName(resourceId, newResourceName);
    }

    @PutMapping("/data/{resourceId}")
    public void updateJsonData(@PathVariable("resourceId") Long resourceId, @RequestBody JsonNode newJsonData) {
        resourceService.updateJsonData(resourceId, newJsonData);
    }

}
