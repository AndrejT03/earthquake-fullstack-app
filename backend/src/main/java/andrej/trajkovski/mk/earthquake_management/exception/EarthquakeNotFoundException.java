package andrej.trajkovski.mk.earthquake_management.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class EarthquakeNotFoundException extends RuntimeException {

    public EarthquakeNotFoundException(Long id) {
        super(String.format("Earthquake with id: %d is not found", id));
    }
}