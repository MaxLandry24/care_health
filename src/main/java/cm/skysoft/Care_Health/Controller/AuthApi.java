package cm.skysoft.Care_Health.Controller;

import cm.skysoft.Care_Health.Dto.AuthRequest;
import cm.skysoft.Care_Health.Dto.AuthResponse;
import io.swagger.annotations.Api;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

@Tag(name= "Authentication API")
@Api("Authentication API")
@RequestMapping(value = "/auth")
public interface AuthApi {

    @PostMapping("/login")
    AuthResponse authenticate(@RequestBody AuthRequest authRequest);

}
