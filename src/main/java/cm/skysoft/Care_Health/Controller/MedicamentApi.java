package cm.skysoft.Care_Health.Controller;

import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import cm.skysoft.Care_Health.Exception.NonValidEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/medicaments")
public interface MedicamentApi {

    @GetMapping()
    List<MedicamentDTO> listMedicaments();

    @GetMapping("/findById")
    MedicamentDTO findMedicamentById(@RequestParam("id") Integer id);

    @PostMapping("/save")
    MedicamentDTO save(@RequestBody MedicamentDTO medicament) throws NonValidEntity;

    @PutMapping("/edit")
    MedicamentDTO update(@RequestBody MedicamentDTO medicament) throws NonValidEntity;

    @DeleteMapping("/delete/{id}")
    @PreAuthorize("hasAuthority('ROLE_SUPER_ADMIN')")
    void delete(@PathVariable Integer id);
}
