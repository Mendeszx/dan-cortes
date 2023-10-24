package com.app.dancortes.domain.entities;

import com.app.dancortes.common.entities.CommonEntitiesColumns;
import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

import java.io.Serializable;

@EqualsAndHashCode(callSuper = true)
@Data
@Entity
@Table(name = "cabeleireiro")
public class CabeleireiroEntity extends CommonEntitiesColumns implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "cabeleireiro_id")
    private Long cabeleireiroId;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "usuario_id")
    private UsuariosEntity usuarioId;

    @Column(nullable = false, name = "nome")
    private String nome;

    @Column(unique = true, name = "cnpj")
    private String cnpj;

    @Column(unique = true, name = "cpf")
    private String cpf;

    @Column(name = "foto")
    private byte[] foto;

    @Column(name = "foto_de_capa")
    private byte[] fotoDeCapa;

    @Column(name = "descricao")
    private String descricao;

    @Column(nullable = false, unique = true, name = "telefone")
    private String telefone;

    @Column(nullable = false, name = "endereco")
    private String endereco;
}
