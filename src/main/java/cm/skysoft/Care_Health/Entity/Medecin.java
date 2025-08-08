package cm.skysoft.Care_Health.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "medecin")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@ToString
public class Medecin {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String nom;
    private String specialite;
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL, mappedBy = "medecin")
    private List<Consultation> consultationList = new ArrayList<>();
    @ManyToOne
    @JoinColumn(name = "service_id", referencedColumnName = "id")
    ServiceMedical serviceMedical;
}
