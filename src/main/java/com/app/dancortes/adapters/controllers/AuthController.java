package com.app.dancortes.adapters.controllers;

import com.app.dancortes.adapters.controllers.dtos.request.LoginRequest;
import com.app.dancortes.adapters.controllers.dtos.response.LoginResponse;
import com.app.dancortes.domain.useCases.auth.AuthUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/auth")
public class AuthController {

    @Autowired
    AuthUseCase authUseCase;

    @PostMapping("/login")
    ResponseEntity<LoginResponse> login(@RequestBody LoginRequest loginRequest) {
        return authUseCase.login(loginRequest);
    }
}
