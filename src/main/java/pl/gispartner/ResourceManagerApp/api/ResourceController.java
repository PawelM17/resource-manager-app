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
    public String deleteResource(@PathVariable("resourceId") Long resourceId, @RequestHeader Long userId) {
        if (resourceService.validateResourceOwner(userId, resourceId)) {
            resourceService.deleteResource(resourceId);
            return "Changes have been successfully saved";
        } else {
            return "This operation cannot be performed";
        }
    }

    @PutMapping("/{resourceId}/name")
    public String updateResourceName(@PathVariable("resourceId") Long resourceId, @RequestBody String newResourceName, @RequestHeader Long userId) {
        if (resourceService.validateResourceOwner(userId, resourceId)) {
            resourceService.updateResourceName(resourceId, newResourceName);
            return "Changes have been successfully saved";
        } else {
            return "This operation cannot be performed";
        }
    }

    @PutMapping("/{resourceId}/data")
    public String updateJsonData(@PathVariable("resourceId") Long resourceId, @RequestBody JsonNode newJsonData, @RequestHeader Long userId) {
        if (resourceService.validateResourceOwner(userId, resourceId)) {
            resourceService.updateJsonData(resourceId, newJsonData);
            return "Changes have been successfully saved";
        } else {
            return "This operation cannot be performed";
        }
    }

}
