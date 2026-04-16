package andrej.trajkovski.mk.earthquake_management.service;
import andrej.trajkovski.mk.earthquake_management.dto.DisplayEarthquakeDto;
import java.util.List;

public interface EarthquakeService {
    List<DisplayEarthquakeDto> save();

    List<DisplayEarthquakeDto> findAll();

    void deleteById(Long id);
}