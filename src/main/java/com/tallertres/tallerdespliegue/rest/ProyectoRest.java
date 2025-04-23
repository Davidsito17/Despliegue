package com.tallertres.tallerdespliegue.rest;

import com.tallertres.tallerdespliegue.models.ProyectoEntity;
import com.tallertres.tallerdespliegue.service.IProyectoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/proyecto")
public class ProyectoRest {

    @Autowired
    private IProyectoService proyectoService;

    @PostMapping("/crear")
    public ResponseEntity<ProyectoEntity> save(@RequestBody ProyectoEntity proyectoRequest) {
        try {
            proyectoService.save(proyectoRequest);
            return ResponseEntity.ok(proyectoRequest);
        }catch (Exception e) {
            System.out.println("Error es:" + e.getMessage());
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
    }

    @PutMapping("/editar/{id}")
    public ResponseEntity<ProyectoEntity> Update(@Validated @RequestBody ProyectoEntity proyecto, @PathVariable ("id") Long id) {
        ProyectoEntity proyecto1 = proyectoService.findById(id);
        proyecto1.setNombre(proyecto.getNombre());
        proyectoService.save(proyecto1);

        return ResponseEntity.ok(proyecto1);
    }

    @GetMapping("/list")
    public ResponseEntity<List<ProyectoEntity>> list() {
        return ResponseEntity.ok(proyectoService.findAll());
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<String> delete(@PathVariable ("id") Long id) {
        proyectoService.delete(id);
        return ResponseEntity.ok("Dispositivo eliminado");
    }

}
