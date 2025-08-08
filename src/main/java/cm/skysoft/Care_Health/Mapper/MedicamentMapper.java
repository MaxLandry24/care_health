package cm.skysoft.Care_Health.Mapper;

import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import cm.skysoft.Care_Health.Entity.Medicament;
import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

@Mapper(componentModel = "spring")
public interface MedicamentMapper extends EntityMapper<MedicamentDTO, Medicament>{

//    @Mapping(source = "noms", target = "nom")
//    @Mapping(source = "ordonnanceList", target = "ordonnanceList", ignore = true)

    Medicament toEntity(MedicamentDTO dto);
    MedicamentDTO toDto(Medicament entity);

}
