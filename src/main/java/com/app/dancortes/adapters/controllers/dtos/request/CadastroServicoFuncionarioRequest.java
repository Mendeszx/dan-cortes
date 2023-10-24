package com.app.dancortes.adapters.controllers.dtos.request;

public class CadastroServicoFuncionarioRequest {

    private String funcionarioId;
    private String servicoId;

    public String getFuncionarioId() {
        return funcionarioId;
    }

    public void setFuncionarioId(String funcionarioId) {
        this.funcionarioId = funcionarioId;
    }

    public String getServicoId() {
        return servicoId;
    }

    public void setServicoId(String servicoId) {
        this.servicoId = servicoId;
    }
}
