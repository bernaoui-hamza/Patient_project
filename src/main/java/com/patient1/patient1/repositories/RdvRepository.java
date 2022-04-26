package com.patient1.patient1.repositories;

import com.patient1.patient1.entities.RendezVous;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RdvRepository extends JpaRepository<RendezVous,Long> {
}
