package com.app.dancortes.adapters.persistence;

import com.app.dancortes.domain.entities.CabeleireiroEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CabeleireiroRepository extends JpaRepository<CabeleireiroEntity, Long> {

}
