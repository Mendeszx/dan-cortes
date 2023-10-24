package com.app.dancortes.adapters.controllers.dtos.request;

import lombok.Data;

@Data
public class CadastroCabeleireiroRequest {

    private Long usuarioId;
    private String nome;
    private String cnpj;
    private String cpf;
    private String telefone;
    private String endereco;
}
