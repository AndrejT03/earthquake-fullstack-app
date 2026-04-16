package andrej.trajkovski.mk.earthquake_management.dto;
import java.util.List;

public record ApiResponseDto(List<Feature> features) {
    public record Feature(
            Properties properties
    ) {}

    public record Properties(
            Double mag,
            String magType,
            String place,
            String title,
            Long time
    ) {}
}