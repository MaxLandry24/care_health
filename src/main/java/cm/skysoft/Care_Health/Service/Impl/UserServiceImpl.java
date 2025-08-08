package cm.skysoft.Care_Health.Service.Impl;

import cm.skysoft.Care_Health.Dao.UserRepository;
import cm.skysoft.Care_Health.Dto.AuthResponse;
import cm.skysoft.Care_Health.Service.UserService;
import cm.skysoft.Care_Health.security.JwtTokenService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
@Slf4j
public class UserServiceImpl implements UserService {
    private final JwtTokenService jwtTokenService;
    private final AuthenticationManager authenticationManager;

    @Override
    public AuthResponse login(String username, String password) {
        try {
            Authentication authentication = authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                    username, password
            ));
            UserDetails userDetails = (UserDetails) authentication.getPrincipal();
            String token = jwtTokenService.generateToken(userDetails);

            log.info("Connexion reussie");
            return new AuthResponse(token);
        }
        catch (Exception e) {
            log.error("Tentative de connexion echouée : " + e.getMessage());
            throw new RuntimeException("Email ou mot de passe incorrect");
        }


    }
}
