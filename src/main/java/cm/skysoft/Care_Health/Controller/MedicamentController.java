package cm.skysoft.Care_Health.Controller;

import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import cm.skysoft.Care_Health.Exception.NonValidEntity;
import cm.skysoft.Care_Health.Service.MedicamentService;
import lombok.RequiredArgsConstructor;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
public class MedicamentController implements MedicamentApi {


    private final MedicamentService medicamentService;

    @Override
    public List<MedicamentDTO> listMedicaments() {
        return this.medicamentService.findAllMedicament();
    }

    @Override
    public MedicamentDTO findMedicamentById(Integer id) {
        return this.medicamentService.findMedicamentById(id);
    }

    @Override
    public MedicamentDTO save(MedicamentDTO medicament) throws NonValidEntity {
        return this.medicamentService.saveMedicament(medicament);
    }

    @Override
    public MedicamentDTO update(MedicamentDTO medicament) throws NonValidEntity {
        return this.medicamentService.updateMedicament(medicament);
    }

    @Override
    public void delete(Integer id) {
        this.medicamentService.deleteMedicamentById(id);
    }



//    @GetMapping()
//    public String listMedicaments(Model model) {
//     model.addAttribute("medicaments",this.medicamentService.findAllMedicament());
//        return "medicament-list"  ;
//    }
//
//    @GetMapping("/new")
//    public String showForm(Model model) {
//        model.addAttribute("medicament", new MedicamentDTO());
//        return "form";
//    }
//
//    @PostMapping("/save")
//    public String save(@ModelAttribute MedicamentDTO medicament) throws NonValidEntity {
//        System.out.println("\n \n\n "+ medicament);
//        medicamentService.saveMedicament(medicament);
//        return "redirect:/medicaments";
//    }
//
//    @GetMapping("/edit/{id}")
//    public String edit(@PathVariable Integer id, Model model) {
//
//        MedicamentDTO dto = medicamentService.findMedicamentById(id);
//        model.addAttribute("medicament", dto);
//        return "form";
//    }
//
//    @GetMapping("/delete/{id}")
//    public String delete(@PathVariable Integer id) {
//        medicamentService.deleteMedicamentById(id);
//        return "redirect:/medicaments";
//    }
}
