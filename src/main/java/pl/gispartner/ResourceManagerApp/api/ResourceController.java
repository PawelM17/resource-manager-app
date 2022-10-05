package pl.gispartner.ResourceManagerApp.api;


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

}
