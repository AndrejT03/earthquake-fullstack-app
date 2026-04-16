package andrej.trajkovski.mk.earthquake_management.exception;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.SERVICE_UNAVAILABLE)
public class ExternalApiUnavailableException extends RuntimeException {
    public ExternalApiUnavailableException(String message) {
        super(message);
    }

    public ExternalApiUnavailableException(String message, Throwable cause) {
        super(message, cause);
    }
}