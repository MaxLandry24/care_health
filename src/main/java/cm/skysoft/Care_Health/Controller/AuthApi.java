package cm.skysoft.Care_Health.Controller;

import cm.skysoft.Care_Health.Dto.AuthRequest;
import cm.skysoft.Care_Health.Dto.AuthResponse;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@RequestMapping(value = "/auth")
public interface AuthApi {

    @PostMapping("/login")
    AuthResponse authenticate(@RequestBody AuthRequest authRequest);

}
