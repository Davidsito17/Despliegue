package com.tallertres.tallerdespliegue.service;

import com.tallertres.tallerdespliegue.models.ProyectoEntity;

import java.util.List;

public interface IProyectoService {

    public void save(ProyectoEntity proyecto);
    public ProyectoEntity findById(Long id);
    public List<ProyectoEntity> findAll();
    public void delete(Long id);
}
