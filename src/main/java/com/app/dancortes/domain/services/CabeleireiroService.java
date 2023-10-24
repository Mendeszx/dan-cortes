package com.app.dancortes.domain.services;


import com.app.dancortes.adapters.controllers.dtos.request.CadastroCabeleireiroRequest;
import com.app.dancortes.adapters.persistence.CabeleireiroRepository;
import com.app.dancortes.adapters.persistence.FuncionariosRepository;
import com.app.dancortes.domain.entities.CabeleireiroEntity;
import com.app.dancortes.domain.entities.FuncionariosEntity;
import com.app.dancortes.domain.entities.UsuariosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CabeleireiroService {

    @Autowired
    CabeleireiroRepository cabeleireiroRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void cadastrarNovoCabeleireiro(UsuariosEntity usuariosEntity, CadastroCabeleireiroRequest cadastroCabeleireiroRequest) {
        CabeleireiroEntity cabeleireiroEntity = new CabeleireiroEntity();

        BeanUtils.copyProperties(cadastroCabeleireiroRequest, cabeleireiroEntity);

        cabeleireiroEntity.setUsuarioId(usuariosEntity);

        LocalDate dataDeCadastro = LocalDate.now();

        cabeleireiroEntity.setDataDeCadastro(dataDeCadastro);

        try {
            cabeleireiroRepository.save(cabeleireiroEntity);
        } catch (Exception e){
            throw new RuntimeException("Erro ao cadastrar novo cabeleireiro.");
        }
    }
}
