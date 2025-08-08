package cm.skysoft.Care_Health.Service.Impl;

import cm.skysoft.Care_Health.Dao.MedicamentRepository;
import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import cm.skysoft.Care_Health.Entity.Medicament;
import cm.skysoft.Care_Health.Exception.NonValidEntity;
import cm.skysoft.Care_Health.Mapper.MedicamentMapper;
import cm.skysoft.Care_Health.Service.MedicamentService;
import cm.skysoft.Care_Health.Validator.MedecinValidator;
import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service("Medoox")
@RequiredArgsConstructor
public class MedicamentImpl implements MedicamentService {

    private final MedicamentRepository medicamentRepository;
    private final MedecinValidator medecinValidator;
    private final MedicamentMapper medicamentMapper;

    @Override
    public List<MedicamentDTO> findAllMedicament() {

        //        for (Medicament medicament : medicamentList) {
//            MedicamentDTO medicamentDTO = this.toMedicamentDTO(medicament);
//            medicamentDTOList.add(medicamentDTO);
//        }

//        List<MedicamentDTO> medicamentDTOList =  medicamentList.stream().map(medicament -> this.toMedicamentDTO(medicament)).toList();

//
//        for (int i = 0; i < medicamentDTOList.size(); i++) {
//            MedicamentDTO medicamentDTO = this.toMedicamentDTO(medicamentList.get(i));
//            medicamentDTOList.add(medicamentDTO);
//        }

        List<MedicamentDTO> medicamentDTOList = new ArrayList<>();

        List<Medicament> medicamentList = medicamentRepository.findAll();

        medicamentList.forEach(medicament -> {
            MedicamentDTO medicamentDTO = this.medicamentMapper.toDto(medicament);
            medicamentDTOList.add(medicamentDTO);
        });

        return medicamentDTOList;

    }

    @Override
    public MedicamentDTO findMedicamentById(Integer id) {
//        Optional<Medicament> medicamentOptional = this.medicamentRepository.findById(id);
//
//        if (medicamentOptional.isEmpty()) {
//            throw new EntityNotFoundException("Medicament not found with id: " + id);
//        }
//        return this.toMedicamentDTO(medicamentOptional.get());

        return this.medicamentRepository.findById(id)
                .map(this.medicamentMapper::toDto)
                .orElseThrow(() -> new EntityNotFoundException("Medicament not found with id: " + id));
    }

    @Override
    public MedicamentDTO saveMedicament(MedicamentDTO medicamentDto) throws NonValidEntity {
        List<String> errorList = this.medecinValidator.validateMedecin(medicamentDto);

        if (!errorList.isEmpty()) {
            throw new NonValidEntity("Entity not valid", 90, errorList);
        }
        Medicament medicament = this.medicamentRepository.save(this.medicamentMapper.toEntity(medicamentDto));
        return this.medicamentMapper.toDto(medicament);
    }

    @Override
    public MedicamentDTO updateMedicament(MedicamentDTO medicament) {

//        Optional<Medicament> medicamentOptional = this.medicamentRepository.findById(medicament.getId());
//
//        if(medicamentOptional.isEmpty()){
//            throw new EntityNotFoundException("Medicament not found with id: " + idMedicament);
//        }

        Medicament medicamentInDB = this.medicamentMapper.toEntity(this.findMedicamentById(medicament.getId()));
        medicamentInDB.setNom(medicament.getNom());
        medicamentInDB.setDescription(medicament.getDescription());
        Medicament medicamentSaved = this.medicamentRepository.save(medicamentInDB);
        return this.medicamentMapper.toDto(medicamentSaved);
    }

    @Override
    public void deleteMedicamentById(Integer id) {

        //        Optional<Medicament> medicamentOptional = this.medicamentRepository.findById(medicament.getId());
//
//        if(medicamentOptional.isEmpty()){
//            throw new EntityNotFoundException("Medicament not found with id: " + idMedicament);
//        }
        this.findMedicamentById(id);
        this.medicamentRepository.deleteById(id);
    }


//    private MedicamentDTO toMedicamentDTO(Medicament entity) {
////        MedicamentDTO dto = new MedicamentDTO();
////        dto.setId(entity.getId());
////        dto.setNom(entity.getNom());
////        dto.setDescription(entity.getDescription());
////        return dto;
//
//        return MedicamentDTO.builder()
//                .id(entity.getId())
//                .nom(entity.getNom())
//                .description(entity.getDescription())
//                .build();
//    }
//
//    private Medicament toMedicamentEntity(MedicamentDTO dto) {
////        Medicament entity = new Medicament();
////        entity.setId(dto.getId());
////        entity.setNom(dto.getNom());
////        entity.setDescription(dto.getDescription());
////        return entity;
//
//        return Medicament.builder()
//                .id(dto.getId())
//                .nom(dto.getNom())
//                .description(dto.getDescription())
//                .build();
//    }
}
