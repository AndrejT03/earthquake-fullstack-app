package andrej.trajkovski.mk.earthquake_management.dto;
import andrej.trajkovski.mk.earthquake_management.model.Earthquake;
import java.util.List;
import java.util.stream.Collectors;

public record DisplayEarthquakeDto(
        Long id,
        Double magnitude,
        String mag_type,
        String place,
        String title,
        Long time
) {

    public static DisplayEarthquakeDto from(Earthquake eq) {
        return new DisplayEarthquakeDto(
                eq.getId(),
                eq.getMagnitude(),
                eq.getMag_type(),
                eq.getPlace(),
                eq.getTitle(),
                eq.getTime()
        );
    }

    public static List<DisplayEarthquakeDto> from(List<Earthquake> list) {
        return list.stream()
                .map(DisplayEarthquakeDto::from)
                .collect(Collectors.toList());
    }
}