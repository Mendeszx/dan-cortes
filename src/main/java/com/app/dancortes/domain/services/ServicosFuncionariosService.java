package com.app.dancortes.domain.services;

import com.app.dancortes.adapters.persistence.ServicosFuncionariosRepository;
import com.app.dancortes.domain.entities.FuncionariosEntity;
import com.app.dancortes.domain.entities.ServicosEntity;
import com.app.dancortes.domain.entities.ServicosFuncionariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class ServicosFuncionariosService {

    @Autowired
    ServicosFuncionariosRepository servicosFuncionariosRepository;

    @Transactional
    public ServicosFuncionariosEntity cadastratNovoServicoParaFuncionario(FuncionariosEntity funcionariosEntity, ServicosEntity servicosEntity) {
        ServicosFuncionariosEntity servicosFuncionariosEntity = new ServicosFuncionariosEntity();

        servicosFuncionariosEntity.setFuncionarioId(funcionariosEntity);
        servicosFuncionariosEntity.setServicoId(servicosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        servicosFuncionariosEntity.setDataDeCadastro(dataDeCadastro);
        servicosFuncionariosEntity.setServicoFuncionarioAtivo(true);

        try {
            servicosFuncionariosEntity = servicosFuncionariosRepository.save(servicosFuncionariosEntity);
            return servicosFuncionariosEntity;
        } catch (Exception e) {
            throw e;
        }
    }
}
