package com.tallertres.tallerdespliegue.repository;

import com.tallertres.tallerdespliegue.models.ProyectoEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProyectoRepository extends JpaRepository<ProyectoEntity, Long> {
}
