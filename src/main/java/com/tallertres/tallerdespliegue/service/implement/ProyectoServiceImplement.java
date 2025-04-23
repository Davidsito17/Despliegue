package com.tallertres.tallerdespliegue.service.implement;

import com.tallertres.tallerdespliegue.models.ProyectoEntity;
import com.tallertres.tallerdespliegue.repository.ProyectoRepository;
import com.tallertres.tallerdespliegue.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class ProyectoServiceImplement implements IProyectoService {

    @Autowired
    private ProyectoRepository proyectoRepository;

    @Override
    @Transactional
    public void save(ProyectoEntity proyecto) {
        proyectoRepository.save(proyecto);
    }

    @Override
    @Transactional(readOnly = true)
    public ProyectoEntity findById(Long id) {
        return proyectoRepository.findById(id).orElse(null);
    }

    @Override
    @Transactional(readOnly = true)
    public List<ProyectoEntity> findAll() {
        return proyectoRepository.findAll();
    }

    @Override
    @Transactional
    public void delete(Long id) {
        proyectoRepository.deleteById(id);
    }
}
