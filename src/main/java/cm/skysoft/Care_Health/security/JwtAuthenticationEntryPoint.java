package cm.skysoft.Care_Health.security;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.AuthenticationEntryPoint;
import org.springframework.security.web.access.AccessDeniedHandler;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
@RequiredArgsConstructor
public class JwtAuthenticationEntryPoint implements AuthenticationEntryPoint, AccessDeniedHandler {

    private final SecurityErrorResponse securityErrorResponse;

    @Override
    public void commence(
            HttpServletRequest request,
            HttpServletResponse response,
            AuthenticationException authException
    ) throws IOException {
        securityErrorResponse.sendErrorResponse(
                request,
                response,
                HttpServletResponse.SC_UNAUTHORIZED,
                authException.getMessage()
        );
    }

    @Override
    public void handle(HttpServletRequest request, HttpServletResponse response, AccessDeniedException accessDeniedException) throws IOException {
        securityErrorResponse.sendErrorResponse(
                request,
                response,
                HttpServletResponse.SC_UNAUTHORIZED,
                accessDeniedException.getMessage()
        );
    }
}
