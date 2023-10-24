package com.app.dancortes.adapters.controllers.dtos.response;

import com.app.dancortes.domain.entities.AgendamentosEntity;
import lombok.Data;
import org.springframework.http.HttpStatus;

import java.util.List;

@Data
public class DisponibilidadeAgendamentoResponse {

    private int httpStatusCode;

    private HttpStatus httpStatus;

    private List<AgendamentosEntity> agendamentos;

    private String mensagem;
}
