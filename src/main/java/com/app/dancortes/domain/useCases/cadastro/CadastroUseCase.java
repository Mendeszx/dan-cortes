package com.app.dancortes.domain.useCases.cadastro;


import com.app.dancortes.adapters.controllers.dtos.request.*;
import com.app.dancortes.adapters.controllers.dtos.response.*;
import org.springframework.http.ResponseEntity;

public interface CadastroUseCase {
    ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest);
    ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(CadastroFuncionarioRequest cadastroFuncionarioRequest);
    ResponseEntity<CadastroCabeleireiroResponse> cadastrarNovoCabeleireiro(CadastroCabeleireiroRequest cadastroCabeleireiroRequest);
    ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(CadastroServicoRequest cadastroServicoRequest);
    ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest);
}
