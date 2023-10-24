package com.app.dancortes.adapters.persistence;

import com.app.dancortes.domain.entities.FuncionariosEntity;
import com.app.dancortes.domain.entities.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface FuncionariosRepository extends JpaRepository<FuncionariosEntity, Long> {
    Optional<FuncionariosEntity> findFuncionariosByUsuarioId(UsuariosEntity usuariosEntity);
}
