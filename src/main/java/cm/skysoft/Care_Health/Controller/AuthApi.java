package cm.skysoft.Care_Health.Controller;

import cm.skysoft.Care_Health.Dto.AuthRequest;
import cm.skysoft.Care_Health.Dto.AuthResponse;
import cm.skysoft.Care_Health.Dto.MedicamentDTO;
import cm.skysoft.Care_Health.Exception.NonValidEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(value = "/auth")
public interface AuthApi {

    @PostMapping("/login")
    AuthResponse authenticate(@RequestBody AuthRequest authRequest);

}
