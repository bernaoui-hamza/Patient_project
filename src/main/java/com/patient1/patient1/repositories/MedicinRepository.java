package com.patient1.patient1.repositories;

import com.patient1.patient1.entities.Medecin;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MedicinRepository extends JpaRepository<Medecin,Long> {
    Page<Medecin> findByNomMedecinContains(String kw, Pageable pageable);
}
