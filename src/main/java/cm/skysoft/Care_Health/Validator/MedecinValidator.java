package cm.skysoft.Care_Health.Validator;

import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class MedecinValidator {


    public List<String> validateMedecin(MedicamentDTO medicamentDTO) {

        List<String> errors = new ArrayList<>();

        if (medicamentDTO.getNom() == null || medicamentDTO.getNom().isEmpty()) {
            errors.add("Le nom ne peut pas être vide.");
        }
        return errors;
    }
}
