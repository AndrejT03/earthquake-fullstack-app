package andrej.trajkovski.mk.earthquake_management.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_GATEWAY)
public class InvalidGeoJsonException extends RuntimeException {

    public InvalidGeoJsonException(String message) {
        super(message);
    }

    public InvalidGeoJsonException(String message, Throwable cause) {
        super(message, cause);
    }
}