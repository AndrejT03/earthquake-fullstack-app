package andrej.trajkovski.mk.earthquake_management;
import andrej.trajkovski.mk.earthquake_management.dto.DisplayEarthquakeDto;
import andrej.trajkovski.mk.earthquake_management.exception.EarthquakeNotFoundException;
import andrej.trajkovski.mk.earthquake_management.model.Earthquake;
import andrej.trajkovski.mk.earthquake_management.repository.EarthquakeRepository;
import andrej.trajkovski.mk.earthquake_management.service.EarthquakeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.Transactional;
import java.util.List;
import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@ActiveProfiles("test")
@Transactional
public class EarthquakeServiceIntegrationTest {
    @Autowired
    private EarthquakeService earthquakeService;

    @Autowired
    private EarthquakeRepository earthquakeRepository;

    @BeforeEach
    void cleanDb() {
        earthquakeRepository.deleteAll();
    }

    @Test
    void findAll_whenNoData_returnsEmptyList() {
        List<DisplayEarthquakeDto> result = earthquakeService.findAll();
        assertTrue(result.isEmpty());
    }

    @Test
    void findAll_returnsMappedDtosFromDatabase() {
        Earthquake eq1 = earthquakeRepository.save(
                new Earthquake(null, 3.4, "mb", "Skopje", "M 3.4 - Skopje", 1710000000000L)
        );
        Earthquake eq2 = earthquakeRepository.save(
                new Earthquake(null, 4.1, "ml", "Ohrid", "M 4.1 - Ohrid", 1710000001000L)
        );

        List<DisplayEarthquakeDto> result = earthquakeService.findAll();

        assertEquals(2, result.size());
        assertTrue(result.stream().anyMatch(d ->
                d.id().equals(eq1.getId()) &&
                        d.magnitude().equals(3.4) &&
                        d.mag_type().equals("mb") &&
                        d.place().equals("Skopje")
        ));
        assertTrue(result.stream().anyMatch(d ->
                d.id().equals(eq2.getId()) &&
                        d.magnitude().equals(4.1) &&
                        d.mag_type().equals("ml") &&
                        d.place().equals("Ohrid")
        ));
    }

    @Test
    void deleteById_existingId_deletesRow() {
        Earthquake eq = earthquakeRepository.save(
                new Earthquake(null, 2.9, "md", "Bitola", "M 2.9 - Bitola", 1710000002000L)
        );

        earthquakeService.deleteById(eq.getId());
        assertFalse(earthquakeRepository.existsById(eq.getId()));
    }

    @Test
    void deleteById_missingId_throwsEarthquakeNotFoundException() {
        Long missingId = 99999L;

        assertThrows(EarthquakeNotFoundException.class,
                () -> earthquakeService.deleteById(missingId));
    }
}