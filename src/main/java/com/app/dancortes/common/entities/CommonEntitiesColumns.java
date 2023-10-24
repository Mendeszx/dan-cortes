package com.app.dancortes.common.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.time.LocalDate;

@Data
public class CommonEntitiesColumns {

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "data_de_cadastro")
    private LocalDate dataDeCadastro;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "data_de_atualizacao")
    private LocalDate dataDeAtualizacao;
}
