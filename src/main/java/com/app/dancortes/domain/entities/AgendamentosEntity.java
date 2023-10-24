package com.app.dancortes.domain.entities;

import com.app.dancortes.common.entities.CommonEntitiesColumns;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;
import java.sql.Time;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "agendamentos")
public class AgendamentosEntity extends CommonEntitiesColumns implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "agendamento_id")
    private Long agendamentoId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuariosEntity usuariosEntity;

    @ManyToOne
    @JoinColumn(name = "servico_id", referencedColumnName = "servico_id")
    private ServicosEntity servicoId;

    @ManyToOne
    @JoinColumn(name = "funcionario_id", referencedColumnName = "funcionario_id")
    private FuncionariosEntity funcionarioId;

    @Temporal(TemporalType.DATE)
    @Column(nullable = false, name = "dia")
    private LocalDate dia;

    @Column(nullable = false, name = "inicio")
    private Time inicio;

    @Column(nullable = false, name = "fim")
    private Time fim;

    @Column(nullable = false, name = "cancelado")
    private boolean cancelado;
}
