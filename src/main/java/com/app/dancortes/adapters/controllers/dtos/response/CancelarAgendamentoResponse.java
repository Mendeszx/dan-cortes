package com.app.dancortes.adapters.controllers.dtos.response;

import lombok.Data;
import org.springframework.http.HttpStatus;

@Data
public class CancelarAgendamentoResponse {

    private int httpStatusCode;

    private HttpStatus httpStatus;

    private String mensagem;
}
