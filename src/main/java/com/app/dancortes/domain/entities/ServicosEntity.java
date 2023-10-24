package com.app.dancortes.domain.entities;

import com.app.dancortes.common.entities.CommonEntitiesColumns;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Time;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "servicos")
public class ServicosEntity extends CommonEntitiesColumns implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "servico_id")
    private Long servicoId;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(nullable = false, name = "valor")
    private BigDecimal valor;

    @Column(nullable = false, name = "duracao")
    private Time duracao;

    @Column(name = "descricao")
    private String descricao;


    @Column(nullable = false, name = "servico_ativo")
    private boolean servicoAtivo;
}
