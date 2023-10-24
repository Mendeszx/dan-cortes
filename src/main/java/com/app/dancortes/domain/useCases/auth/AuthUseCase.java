package com.app.dancortes.domain.useCases.auth;

import com.app.dancortes.adapters.controllers.dtos.request.LoginRequest;
import com.app.dancortes.adapters.controllers.dtos.response.LoginResponse;
import org.springframework.http.ResponseEntity;

public interface AuthUseCase {
    ResponseEntity<LoginResponse> login(LoginRequest loginRequest);
}
