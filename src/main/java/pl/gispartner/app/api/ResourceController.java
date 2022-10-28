package pl.gispartner.app.api;

import com.fasterxml.jackson.databind.JsonNode;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gispartner.app.model.ResourceDto;
import pl.gispartner.app.service.ResourceService;

import java.util.List;

@RestController
@RequestMapping("/api/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @GetMapping("/{resourceId}")
    public ResourceDto getResource(@PathVariable("resourceId") Long resourceId) {
        return resourceService.getResource(resourceId);
    }

    @GetMapping
    public List<ResourceDto> getAllUserResources(@RequestHeader Long userId) {
        return resourceService.getAllUserResources(userId);
    }

    @PostMapping
    public Long saveResource(@RequestBody ResourceDto resourceDto) {
        return resourceService.saveResource(resourceDto);
    }

    @DeleteMapping("/{resourceId}")
    public String deleteResource(@PathVariable("resourceId") Long resourceId, @RequestHeader Long userId) {
        return resourceService.deleteResource(resourceId, userId);
    }

    @PutMapping("/{resourceId}/name")
    public String updateResourceName(@PathVariable("resourceId") Long resourceId, @RequestBody String newResourceName, @RequestHeader Long userId) {
        return resourceService.updateResourceName(resourceId, newResourceName, userId);
    }

    @PutMapping("/{resourceId}/data")
    public String updateJsonData(@PathVariable("resourceId") Long resourceId, @RequestBody JsonNode newJsonData, @RequestHeader Long userId) {
        return resourceService.updateJsonData(resourceId, newJsonData, userId);
    }

}
