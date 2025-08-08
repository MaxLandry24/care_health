package cm.skysoft.Care_Health.Controller;

import cm.skysoft.Care_Health.Dto.AuthRequest;
import cm.skysoft.Care_Health.Dto.AuthResponse;
import cm.skysoft.Care_Health.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class AuthControler implements AuthApi {
    private final UserService userService;

    @Override
    public AuthResponse authenticate(AuthRequest authRequest) {
        return userService.login(authRequest.getEmail(), authRequest.getPassword());
    }
}
