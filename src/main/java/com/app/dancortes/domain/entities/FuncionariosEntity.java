package com.app.dancortes.domain.entities;

import com.app.dancortes.common.entities.CommonEntitiesColumns;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "funcionarios")
public class FuncionariosEntity extends CommonEntitiesColumns implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "funcionario_id")
    private Long funcionarioId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuariosEntity usuarioId;

    @Column(name = "descricao")
    private String descricao;

    @Column(nullable = false, name = "funcionario_ativo")
    private boolean funcionarioAtivo;
}
