package cm.skysoft.Care_Health.Service;

import cm.skysoft.Care_Health.Dto.AuthResponse;

public interface UserService {
    AuthResponse login(String username, String password);
}
