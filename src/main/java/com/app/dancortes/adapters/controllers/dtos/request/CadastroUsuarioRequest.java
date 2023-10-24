package com.app.dancortes.adapters.controllers.dtos.request;

import lombok.Data;

@Data
public class CadastroUsuarioRequest {

    private String nome;
    private String cpf;
    private String numeroCelular;
    private String dataDeNascimento;
    private String sexo;
    private String endereco;
    private String email;
    private String senha;
}
