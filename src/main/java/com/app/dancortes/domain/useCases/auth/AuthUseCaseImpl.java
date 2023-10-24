package com.app.dancortes.domain.useCases.auth;


import com.app.dancortes.adapters.controllers.dtos.request.LoginRequest;
import com.app.dancortes.adapters.controllers.dtos.response.LoginResponse;
import com.app.dancortes.domain.entities.UsuariosEntity;
import com.app.dancortes.domain.services.TokenService;
import com.app.dancortes.domain.services.UsuariosService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.stereotype.Service;

@Service
public class AuthUseCaseImpl implements AuthUseCase {

    @Autowired
    UsuariosService usuariosService;

    @Autowired
    private AuthenticationManager authenticationManager;

    @Autowired
    private TokenService tokenService;

    @Override
    public ResponseEntity<LoginResponse> login(LoginRequest loginRequest) {
        LoginResponse response;
        try {
            UsernamePasswordAuthenticationToken dataLogin = new UsernamePasswordAuthenticationToken(loginRequest.getEmail(), loginRequest.getSenha());
            Authentication authenticate = this.authenticationManager.authenticate(dataLogin);
            UsuariosEntity usuario = (UsuariosEntity) authenticate.getPrincipal();
            String token = tokenService.generateToken(usuario, "login");
            response = loginResponse(200, HttpStatus.OK, token, "Login realizado com sucesso.");

        } catch (AuthenticationException e) {
            response = loginResponse(400, HttpStatus.BAD_REQUEST, "", "Erro: " + e.getMessage());
        }
        return ResponseEntity.status(response.getHttpStatusCode()).body(response);
    }

    private LoginResponse loginResponse(int code, HttpStatus httpStatus, String token, String mensagem) {
        LoginResponse response = new LoginResponse();

        response.setHttpStatusCode(code);
        response.setHttpStatus(httpStatus);
        response.setToken(token);
        response.setMensagem(mensagem);

        return response;
    }
}
