package com.app.dancortes.domain.useCases.cadastro;

import com.app.dancortes.adapters.controllers.dtos.request.*;
import com.app.dancortes.adapters.controllers.dtos.response.*;
import com.app.dancortes.domain.entities.*;
import com.app.dancortes.domain.services.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
public class CadastroUseCaseImpl implements CadastroUseCase {

    @Autowired
    UsuariosService usuariosService;
    @Autowired
    FuncionariosService funcionariosService;
    @Autowired
    CabeleireiroService cabeleireiroService;
    @Autowired
    ServicosService servicosService;
    @Autowired
    ServicosFuncionariosService servicosFuncionariosService;

    @Override
    public ResponseEntity<CadastroUsuarioResponse> cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        CadastroUsuarioResponse cadastroUsuarioResponse;

        try {
            usuariosService.cadastrarNovoUsuario(cadastroUsuarioRequest);
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(201, HttpStatus.CREATED, "Usuário cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroUsuarioResponse = criarCadastroUsuarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroUsuarioResponse.getHttpStatusCode()).body(cadastroUsuarioResponse);
    }

    @Override
    public ResponseEntity<CadastroFuncionarioResponse> cadastrarNovoFuncionario(CadastroFuncionarioRequest cadastroFuncionarioRequest) {
        CadastroFuncionarioResponse cadastroFuncionarioResponse;

        try {
            UsuariosEntity usuariosEntity = usuariosService.findUsuariosById(cadastroFuncionarioRequest.getUsuarioId());
            funcionariosService.cadastrarNovoFuncionario(usuariosEntity);
            usuariosService.atualizarUsuarioParaUsuarioFuncionario(usuariosEntity);
            cadastroFuncionarioResponse = criarCadastroFuncionarioResponse(201, HttpStatus.CREATED, "Funcionario cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroFuncionarioResponse = criarCadastroFuncionarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroFuncionarioResponse.getHttpStatusCode()).body(cadastroFuncionarioResponse);
    }

    @Override
    public ResponseEntity<CadastroCabeleireiroResponse> cadastrarNovoCabeleireiro(CadastroCabeleireiroRequest cadastroCabeleireiroRequest) {
        CadastroCabeleireiroResponse cadastroCabeleireiroResponse;

        try {
            UsuariosEntity usuariosEntity = usuariosService.findUsuariosById(cadastroCabeleireiroRequest.getUsuarioId());
            cabeleireiroService.cadastrarNovoCabeleireiro(usuariosEntity, cadastroCabeleireiroRequest);
            usuariosService.atualizarUsuarioParaUsuarioCabeleireiro(usuariosEntity);
            cadastroCabeleireiroResponse = criarCadastroCabeleireiroResponse(201, HttpStatus.CREATED, "Cabeleireiro cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroCabeleireiroResponse = criarCadastroCabeleireiroResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroCabeleireiroResponse.getHttpStatusCode()).body(cadastroCabeleireiroResponse);
    }

    @Override
    public ResponseEntity<CadastroServicoResponse> cadastrarNovoServico(CadastroServicoRequest cadastroServicoRequest) {
        CadastroServicoResponse cadastroServicoResponse;

        try {
//            EmpresasEntity empresasEntity = empresasService.findEmpresaById(Long.valueOf(cadastroServicoRequest.getEmpresaId()));
//            servicosService.criarNovoServicoParaEmpresa(cadastroServicoRequest, empresasEntity);
            cadastroServicoResponse = criarCadastroServicoResponse(201, HttpStatus.CREATED, "Serviço cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroServicoResponse = criarCadastroServicoResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroServicoResponse.getHttpStatusCode()).body(cadastroServicoResponse);
    }

    @Override
    public ResponseEntity<CadastroServicoFuncionarioResponse> cadastrarNovoServicoParaFuncionario(CadastroServicoFuncionarioRequest cadastroServicoFuncionarioRequest) {
        CadastroServicoFuncionarioResponse cadastroServicoFuncionarioResponse;

        try {
            FuncionariosEntity funcionariosEntity = funcionariosService.findFuncionariosById(Long.valueOf(cadastroServicoFuncionarioRequest.getFuncionarioId()));
            ServicosEntity servicosEntity = servicosService.findServicosById(Long.valueOf(cadastroServicoFuncionarioRequest.getServicoId()));
            ServicosFuncionariosEntity servicosFuncionariosEntity = servicosFuncionariosService.cadastratNovoServicoParaFuncionario(funcionariosEntity, servicosEntity);
            cadastroServicoFuncionarioResponse = criarCadastroServicoFuncionarioResponse(201, HttpStatus.CREATED, "Serviço para funcionario cadastrado com sucesso.");

        } catch (Exception e) {
            cadastroServicoFuncionarioResponse = criarCadastroServicoFuncionarioResponse(400, HttpStatus.BAD_REQUEST, "Erro: " + e.getMessage());
        }

        return ResponseEntity.status(cadastroServicoFuncionarioResponse.getHttpStatusCode()).body(cadastroServicoFuncionarioResponse);
    }

    private CadastroServicoFuncionarioResponse criarCadastroServicoFuncionarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroServicoFuncionarioResponse cadastroServicoFuncionarioResponse = new CadastroServicoFuncionarioResponse();

        cadastroServicoFuncionarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroServicoFuncionarioResponse.setHttpStatus(httpStatus);
        cadastroServicoFuncionarioResponse.setMensagem(mensagem);

        return cadastroServicoFuncionarioResponse;
    }

    private CadastroUsuarioResponse criarCadastroUsuarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroUsuarioResponse cadastroUsuarioResponse = new CadastroUsuarioResponse();

        cadastroUsuarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroUsuarioResponse.setHttpStatus(httpStatus);
        cadastroUsuarioResponse.setMensagem(mensagem);

        return cadastroUsuarioResponse;
    }

    private CadastroFuncionarioResponse criarCadastroFuncionarioResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroFuncionarioResponse cadastroUsuarioResponse = new CadastroFuncionarioResponse();

        cadastroUsuarioResponse.setHttpStatusCode(httpStatusCode);
        cadastroUsuarioResponse.setHttpStatus(httpStatus);
        cadastroUsuarioResponse.setMensagem(mensagem);

        return cadastroUsuarioResponse;
    }

    private CadastroCabeleireiroResponse criarCadastroCabeleireiroResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroCabeleireiroResponse cadastroCabeleireiroResponse = new CadastroCabeleireiroResponse();

        cadastroCabeleireiroResponse.setHttpStatusCode(httpStatusCode);
        cadastroCabeleireiroResponse.setHttpStatus(httpStatus);
        cadastroCabeleireiroResponse.setMensagem(mensagem);

        return cadastroCabeleireiroResponse;
    }

    private CadastroServicoResponse criarCadastroServicoResponse(int httpStatusCode, HttpStatus httpStatus, String mensagem) {
        CadastroServicoResponse cadastroServicoResponse = new CadastroServicoResponse();

        cadastroServicoResponse.setHttpStatusCode(httpStatusCode);
        cadastroServicoResponse.setHttpStatus(httpStatus);
        cadastroServicoResponse.setMensagem(mensagem);

        return cadastroServicoResponse;
    }
}
