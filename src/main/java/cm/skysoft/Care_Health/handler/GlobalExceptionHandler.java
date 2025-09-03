package cm.skysoft.Care_Health.handler;

import jakarta.servlet.http.HttpServletRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;

/**
 * Gestionnaire global des exceptions pour l'application.
 * <p>
 * Cette classe centralise la gestion des erreurs et fournit des réponses
 * cohérentes et informatives aux clients de l'API. Elle transforme les
 * exceptions techniques en réponses HTTP appropriées avec des messages
 * compréhensibles pour les utilisateurs finaux.
 */
@Slf4j
@RestControllerAdvice
public class GlobalExceptionHandler {

    /**
     * Gestion des erreurs de validation des données.
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<ValidationErrorResponse> handleValidationErrors(MethodArgumentNotValidException ex) {

        Map<String, String> errors = new HashMap<>();
        ex.getBindingResult().getAllErrors().forEach(error -> {
            String fieldName = ((FieldError) error).getField();
            String errorMessage = error.getDefaultMessage();
            errors.put(fieldName, errorMessage);
        });

        ValidationErrorResponse errorResponse = ValidationErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.BAD_REQUEST.value())
                .error("Validation Failed")
                .message("Les données fournies ne respectent pas les critères de validation")
                .validationErrors(errors)
                .build();

        log.warn("Erreurs de validation: {}", errors);

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    /**
     * Gestion des erreurs génériques non prévues.
     */
    @ExceptionHandler(Exception.class)
    public ResponseEntity<ErrorResponse> handleGenericException(Exception ex) {
        log.error("Erreur inattendue: ", ex);

        ErrorResponse errorResponse = ErrorResponse.builder()
                .timestamp(LocalDateTime.now())
                .status(HttpStatus.INTERNAL_SERVER_ERROR.value())
                .error("Internal Server Error")
                .message("Une erreur inattendue s'est produite. Veuillez réessayer plus tard.")
                .build();

        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(UsernameNotFoundException.class)
    public ResponseEntity<ErrorResponse> handleUsernameNotFoundException(UsernameNotFoundException ex, HttpServletRequest request) {
        log.warn("Utilisateur non trouvé: {}", ex.getMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
             .timestamp(LocalDateTime.now())
             .status(HttpStatus.NOT_FOUND.value())
             .error(ex.getMessage())
            .message(ex.getMessage())
          .path(request.getRequestURI())
          .build();
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorResponse);
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<ErrorResponse> handleRuntimeException(RuntimeException ex, HttpServletRequest request) {
        log.warn("Erreur runtime: {}", ex.getMessage());
        ErrorResponse errorResponse = ErrorResponse.builder()
             .timestamp(LocalDateTime.now())
             .status(HttpStatus.BAD_REQUEST.value())
             .error(ex.getMessage())
            .message(ex.getMessage())
          .path(request.getRequestURI())
          .build();
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(errorResponse);
    }

}
