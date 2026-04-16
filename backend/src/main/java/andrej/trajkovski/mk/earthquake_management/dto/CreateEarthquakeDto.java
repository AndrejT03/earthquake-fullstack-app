package andrej.trajkovski.mk.earthquake_management.dto;
import andrej.trajkovski.mk.earthquake_management.model.Earthquake;

public record CreateEarthquakeDto(
        Double magnitude,
        String mag_type,
        String place,
        String title,
        Long time
) {

    public Earthquake toEarthquake() {
        Earthquake eq = new Earthquake();
        eq.setMagnitude(magnitude);
        eq.setMag_type(mag_type);
        eq.setPlace(place);
        eq.setTitle(title);
        eq.setTime(time);
        return eq;
    }
}