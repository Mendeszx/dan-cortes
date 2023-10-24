package com.app.dancortes.adapters.persistence;

import com.app.dancortes.domain.entities.UsuariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuariosRepository extends JpaRepository<UsuariosEntity, Long> {
    Optional<UsuariosEntity> findByEmail(String email);

    Optional<UsuariosEntity> findByCpf(String cpf);
}
