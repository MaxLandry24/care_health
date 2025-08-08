package cm.skysoft.Care_Health.Entity;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name="dossiermedical")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class DossierMedical {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String descrition;
    @OneToOne
    Patient patient;
}
