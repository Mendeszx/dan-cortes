package com.app.dancortes.adapters.persistence;

import com.app.dancortes.domain.entities.ServicosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ServicosRepository extends JpaRepository<ServicosEntity, Long> {
}
