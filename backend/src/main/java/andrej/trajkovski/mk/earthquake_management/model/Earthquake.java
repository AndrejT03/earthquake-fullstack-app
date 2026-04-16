package andrej.trajkovski.mk.earthquake_management.model;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Earthquake {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private double magnitude;

    private String mag_type;

    private String place;

    private String title;

    private Long time;
}