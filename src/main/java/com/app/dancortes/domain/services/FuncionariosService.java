package com.app.dancortes.domain.services;


import com.app.dancortes.adapters.persistence.FuncionariosRepository;
import com.app.dancortes.domain.entities.FuncionariosEntity;
import com.app.dancortes.domain.entities.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class FuncionariosService {

    @Autowired
    FuncionariosRepository funcionariosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void cadastrarNovoFuncionario(UsuariosEntity usuariosEntity) {
        FuncionariosEntity funcionariosEntity = new FuncionariosEntity();

        funcionariosEntity.setUsuarioId(usuariosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        funcionariosEntity.setDataDeCadastro(dataDeCadastro);
        funcionariosEntity.setFuncionarioAtivo(true);

        try {
            funcionariosRepository.save(funcionariosEntity);
        } catch (Exception e){
            throw new RuntimeException("Erro ao cadastrar novo funcionario.");
        }
    }

    public FuncionariosEntity findFuncionariosById(Long funcionarioId) {
        Optional<FuncionariosEntity> entity = funcionariosRepository.findById(funcionarioId);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Funcionário não encontrado");
        }
    }

    public FuncionariosEntity findFuncionariosByUsuarioId(UsuariosEntity usuariosEntity) {
        Optional<FuncionariosEntity> entity = funcionariosRepository.findFuncionariosByUsuarioId(usuariosEntity);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Funcionário não encontrado");
        }
    }
}
