package com.app.dancortes.adapters.persistence;

import com.app.dancortes.domain.entities.AgendamentosEntity;
import com.app.dancortes.domain.entities.FuncionariosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.time.LocalDate;
import java.util.List;

@Repository
public interface AgendamentosRepository extends JpaRepository<AgendamentosEntity, Long> {

    @Query(value = "SELECT * FROM AGENDAMENTOS u WHERE u.funcionarioId = ?1 AND u.dia = ?2", nativeQuery = true)
    List<AgendamentosEntity> findByFuncionarioIdAndDia(FuncionariosEntity funcionariosEntity, LocalDate localDate);
}
