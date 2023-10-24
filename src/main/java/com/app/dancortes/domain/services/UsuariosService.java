package com.app.dancortes.domain.services;

import com.app.dancortes.adapters.controllers.dtos.request.CadastroUsuarioRequest;
import com.app.dancortes.adapters.persistence.UsuariosRepository;
import com.app.dancortes.common.enums.RoleEnum;
import com.app.dancortes.domain.entities.FuncionariosEntity;
import com.app.dancortes.domain.entities.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class UsuariosService {

    @Autowired
    UsuariosRepository usuariosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    public Optional<UsuariosEntity> findByEmail(String email) {
        return usuariosRepository.findByEmail(email);
    }

    @Transactional
    public void cadastrarNovoUsuario(CadastroUsuarioRequest cadastroUsuarioRequest) {
        UsuariosEntity usuariosEntity = new UsuariosEntity();
        BeanUtils.copyProperties(cadastroUsuarioRequest, usuariosEntity);

        usuariosEntity.setSenha(new BCryptPasswordEncoder().encode(cadastroUsuarioRequest.getSenha()));

        LocalDate dataDeNascimento = LocalDate.parse(cadastroUsuarioRequest.getDataDeNascimento());

        LocalDate dataDeCadastro = LocalDate.now();

        usuariosEntity.setDataDeNascimento(dataDeNascimento);
        usuariosEntity.setDataDeCadastro(dataDeCadastro);
        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO);
        usuariosEntity.setUsuarioAtivo(true);

        usuariosRepository.save(usuariosEntity);
    }

    @Transactional
    public void atualizarUsuarioParaUsuarioFuncionario(UsuariosEntity usuariosEntity) {
        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO_FUNCIONARIO);
        usuariosEntity.setDataDeAtualizacao(LocalDate.now());

        try {
            usuariosRepository.save(usuariosEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuario para funcionario.");
        }
    }

    public UsuariosEntity findUsuariosById(Long usuarioId) {
        Optional<UsuariosEntity> entity = usuariosRepository.findById(usuarioId);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public UsuariosEntity findUsuariosByCpf(String cpf) {
        Optional<UsuariosEntity> entity = usuariosRepository.findByCpf(cpf);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Usuário não encontrado");
        }
    }

    public void atualizarUsuarioParaUsuarioCabeleireiro(UsuariosEntity usuariosEntity) {
        usuariosEntity.setRole(RoleEnum.ROLE_USUARIO_CABELEREIRO);
        usuariosEntity.setDataDeAtualizacao(LocalDate.now());

        try {
            usuariosRepository.save(usuariosEntity);
        } catch (Exception e) {
            throw new RuntimeException("Erro ao atualizar usuario para cabeleireiro.");
        }
    }
}
