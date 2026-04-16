package andrej.trajkovski.mk.earthquake_management.service.impl;
import andrej.trajkovski.mk.earthquake_management.dto.*;
import andrej.trajkovski.mk.earthquake_management.exception.*;
import andrej.trajkovski.mk.earthquake_management.model.Earthquake;
import andrej.trajkovski.mk.earthquake_management.repository.EarthquakeRepository;
import andrej.trajkovski.mk.earthquake_management.service.EarthquakeService;
import org.springframework.dao.DataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import java.util.*;

@Service
public class EarthquakeServiceImpl implements EarthquakeService {
    private final EarthquakeRepository repository;
    private final String API_URL = "https://earthquake.usgs.gov/earthquakes/feed/v1.0/summary/all_hour.geojson";

    public EarthquakeServiceImpl(EarthquakeRepository repository) {
        this.repository = repository;
    }

    @Override
    public List<DisplayEarthquakeDto> save() {

        ApiResponseDto response;

        try {
            response = new RestTemplate().getForObject(API_URL, ApiResponseDto.class);
        } catch (RestClientException ex) {
            throw new ExternalApiUnavailableException("USGS API is unavailable.", ex);
        }

        if (response == null || response.features() == null) {
            throw new InvalidGeoJsonException("GeoJSON response is null or missing 'features'.");
        }

        repository.deleteAll();

        List<Earthquake> earthquakes = response.features().stream()
                .map(f -> f.properties())
                .filter(p -> p !=null && p.mag() != null && p.mag() > 2.0)
                .map(p -> new CreateEarthquakeDto(
                        p.mag(),
                        p.magType(),
                        p.place(),
                        p.title(),
                        p.time() != null ? p.time() : 0L
                ).toEarthquake())
                .toList();

        try {
            return DisplayEarthquakeDto.from(repository.saveAll(earthquakes));
        } catch (DataAccessException ex) {
            throw new DatabaseOperationException("Database error while saving earthquakes.", ex);
        }
    }

    @Override
    public List<DisplayEarthquakeDto> findAll() {
        try {
            return DisplayEarthquakeDto.from(repository.findAll());
        } catch (DataAccessException ex) {
            throw new DatabaseOperationException("Database error while loading earthquakes.", ex);
        }
    }

    @Override
    public void deleteById(Long id) {
        try {
            if (!repository.existsById(id)) {
                throw new EarthquakeNotFoundException(id);
            }
            repository.deleteById(id);
        } catch (DataAccessException ex) {
            throw new DatabaseOperationException("Database error while deleting earthquake with id: " + id, ex);
        }
    }
}