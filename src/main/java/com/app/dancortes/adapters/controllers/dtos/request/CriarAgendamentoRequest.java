package com.app.dancortes.adapters.controllers.dtos.request;

import lombok.Data;

@Data
public class CriarAgendamentoRequest {

    private String usuarioId;

    private String empresaId;

    private String servicoId;

    private String funcionarioId;

    private String dia;

    private String inicio;

    private String fim;
}
