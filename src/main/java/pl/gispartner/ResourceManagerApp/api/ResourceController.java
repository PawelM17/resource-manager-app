package pl.gispartner.ResourceManagerApp.api;


import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;
import pl.gispartner.ResourceManagerApp.model.ResourceEntity;
import pl.gispartner.ResourceManagerApp.service.ResourceService;

@RestController
@RequestMapping("/api/resource")
@RequiredArgsConstructor
public class ResourceController {

    private final ResourceService resourceService;

    @PostMapping("/save")
    public void saveResource (@RequestBody ResourceEntity resourceEntity){
        resourceService.saveResource(resourceEntity);
    }
    @DeleteMapping("/delete")
    public void deleteResource (@RequestBody ResourceEntity resourceEntity){
        resourceService.deleteResource(resourceEntity);
    }

}
