package com.microservice.mantenimientos.controller;

import com.microservice.mantenimientos.model.Mantenimiento;
import com.microservice.mantenimientos.service.MantenimientoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/mantenimientos")
public class MantenimientoController {
    
    private final MantenimientoService mantenimientoService;
    
    @Autowired
    public MantenimientoController(MantenimientoService mantenimientoService) {
        this.mantenimientoService = mantenimientoService;
    }
    
    // Obtener todos los mantenimientos
    @GetMapping
    public ResponseEntity<List<Mantenimiento>> getAllMantenimientos() {
        List<Mantenimiento> mantenimientos = mantenimientoService.getAllMantenimientos();
        return new ResponseEntity<>(mantenimientos, HttpStatus.OK);
    }
    
    // Obtener mantenimiento por ID
    @GetMapping("/{id}")
    public ResponseEntity<Mantenimiento> getMantenimientoById(@PathVariable("id") Integer id) {
        Optional<Mantenimiento> mantenimientoData = mantenimientoService.getMantenimientoById(id);
        
        return mantenimientoData.map(mantenimiento -> new ResponseEntity<>(mantenimiento, HttpStatus.OK))
                .orElseGet(() -> new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }
    
    // Obtener mantenimientos por equipo ID
    @GetMapping("/equipo/{equipoId}")
    public ResponseEntity<List<Mantenimiento>> getMantenimientosByEquipoId(@PathVariable("equipoId") Integer equipoId) {
        List<Mantenimiento> mantenimientos = mantenimientoService.getMantenimientosByEquipoId(equipoId);
        return new ResponseEntity<>(mantenimientos, HttpStatus.OK);
    }
    
    // Crear un nuevo mantenimiento
    @PostMapping
    public ResponseEntity<Mantenimiento> createMantenimiento(@RequestBody Mantenimiento mantenimiento) {
        try {
            Mantenimiento _mantenimiento = mantenimientoService.saveMantenimiento(mantenimiento);
            return new ResponseEntity<>(_mantenimiento, HttpStatus.CREATED);
        } catch (Exception e) {
            return ResponseEntity.badRequest().body(null); // Changed to return 400 Bad Request
        }
    }

    // Actualizar un mantenimiento
    @PutMapping("/{id}")
    public ResponseEntity<Mantenimiento> updateMantenimiento(@PathVariable("id") Integer id, @RequestBody Mantenimiento mantenimiento) {
        try {
            Mantenimiento updatedMantenimiento = mantenimientoService.updateMantenimiento(id, mantenimiento);
            
            if (updatedMantenimiento != null) {
                return new ResponseEntity<>(updatedMantenimiento, HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(null); // Handle exceptions
        }
    }

    // Eliminar un mantenimiento
    @DeleteMapping("/{id}")
    public ResponseEntity<HttpStatus> deleteMantenimiento(@PathVariable("id") Integer id) {
        try {
            mantenimientoService.deleteMantenimiento(id);
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        } catch (Exception e) {
            return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
