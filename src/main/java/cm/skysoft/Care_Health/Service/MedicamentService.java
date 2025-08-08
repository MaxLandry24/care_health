package cm.skysoft.Care_Health.Service;

import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import cm.skysoft.Care_Health.Entity.Medicament;
import cm.skysoft.Care_Health.Exception.NonValidEntity;

import java.util.List;

public interface MedicamentService {

     List<MedicamentDTO> findAllMedicament();
     MedicamentDTO findMedicamentById(Integer id);
     MedicamentDTO saveMedicament(MedicamentDTO medicament) throws NonValidEntity;
     MedicamentDTO updateMedicament(MedicamentDTO medicament);
     void deleteMedicamentById(Integer id);
}
