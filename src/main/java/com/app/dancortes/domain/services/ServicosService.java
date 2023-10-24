package com.app.dancortes.domain.services;

import com.app.dancortes.adapters.controllers.dtos.request.CadastroServicoRequest;
import com.app.dancortes.adapters.persistence.ServicosRepository;
import com.app.dancortes.domain.entities.ServicosEntity;
import jakarta.transaction.Transactional;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;
import java.util.Optional;

@Service
public class ServicosService {

    @Autowired
    ServicosRepository servicosRepository;

    private final static String DATE_FORMAT = "dd-MM-yyyy";

    @Transactional
    public void criarNovoServicoParaEmpresa(CadastroServicoRequest cadastroServicoRequest) {
        ServicosEntity servicosEntity = new ServicosEntity();
        BeanUtils.copyProperties(cadastroServicoRequest, servicosEntity);

        servicosEntity.setValor(new BigDecimal(cadastroServicoRequest.getValor()));
        servicosEntity.setDuracao(Time.valueOf(cadastroServicoRequest.getDuracao()));

        LocalDate dataDeCadastro = LocalDate.now();

        servicosEntity.setDataDeCadastro(dataDeCadastro);
        servicosEntity.setServicoAtivo(true);

        servicosEntity = servicosRepository.save(servicosEntity);
    }

    public ServicosEntity findServicosById(Long servicoId) {
        Optional<ServicosEntity> entity = servicosRepository.findById(servicoId);

        if (entity.isPresent()) {
            return entity.get();
        } else {
            throw new RuntimeException("Serviço não encontrado.");
        }
    }
}
