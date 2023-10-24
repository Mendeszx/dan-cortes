package com.app.dancortes.adapters.controllers;

import com.app.dancortes.adapters.controllers.dtos.request.*;
import com.app.dancortes.adapters.controllers.dtos.response.*;
import com.app.dancortes.domain.useCases.cadastro.CadastroUseCase;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/cadastro")
public class CadastroController {

    @Autowired
    private CadastroUseCase cadastroUseCase;

    @PostMapping("/usuario")
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(@RequestBody CadastroUsuarioRequest cadastroUsuarioRequest) {
        return cadastroUseCase.cadastrarNovoUsuario(cadastroUsuarioRequest);
    }

    @PostMapping("/cabeleireiro")
    public ResponseEntity<CadastroCabeleireiroResponse> cadastrarNovoCabeleireiro(@RequestBody CadastroCabeleireiroRequest cadastroCabeleireiroRequest) {
        return cadastroUseCase.cadastrarNovoCabeleireiro(cadastroCabeleireiroRequest);
    }

    @PostMapping("/funcionario")
    public ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(@RequestBody CadastroFuncionarioRequest cadastroFuncionarioRequest) {
        return cadastroUseCase.cadastrarNovoFuncionario(cadastroFuncionarioRequest);
    }

    @PostMapping("/servico")
    public ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(@RequestBody CadastroServicoRequest cadastroServicoRequest) {
        return cadastroUseCase.cadastrarNovoServico(cadastroServicoRequest);
    }

    @PostMapping("/servico-funcionario")
    public ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(@RequestBody CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest) {
        return cadastroUseCase.cadastrarNovoServicoParaFuncionario(cadastroServicoFuncionarioRequest);
    }
}
