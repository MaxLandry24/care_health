package cm.skysoft.Care_Health.Dto;

import lombok.*;

import java.time.LocalDate;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Builder
@ToString
public class OrdonnanceDTO {
    private Integer id;
    private LocalDate dateEmission;
}
