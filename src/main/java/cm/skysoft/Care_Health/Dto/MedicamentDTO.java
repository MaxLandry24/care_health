package cm.skysoft.Care_Health.Dto;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class MedicamentDTO {
    private Integer id;
    private String nom;
    private String description;
    private List<OrdonnanceDTO> ordonnanceList = new ArrayList<>();

}
