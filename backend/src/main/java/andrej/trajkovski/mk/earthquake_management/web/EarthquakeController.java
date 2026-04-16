package andrej.trajkovski.mk.earthquake_management.web;
import andrej.trajkovski.mk.earthquake_management.dto.DisplayEarthquakeDto;
import andrej.trajkovski.mk.earthquake_management.service.EarthquakeService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/earthquakes")
@CrossOrigin(origins = "http://localhost:5173")
@Tag(name = "Earthquake API", description = "Endpoints for managing earthquakes data.")
public class EarthquakeController {
    private final EarthquakeService service;
    public EarthquakeController(EarthquakeService service) {
        this.service = service;
    }

    @GetMapping("/fetch")
    public List<DisplayEarthquakeDto> fetchAndSaveEarthquakes() {
        return service.save();
    }

    @GetMapping
    public List<DisplayEarthquakeDto> findAll() {
        return service.findAll();
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}