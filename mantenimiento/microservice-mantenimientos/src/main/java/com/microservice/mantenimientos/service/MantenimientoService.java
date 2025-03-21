package com.microservice.mantenimientos.service;

import com.microservice.mantenimientos.model.Mantenimiento;
import com.microservice.mantenimientos.repository.MantenimientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class MantenimientoService {
    
    private final MantenimientoRepository mantenimientoRepository;
    
    @Autowired
    public MantenimientoService(MantenimientoRepository mantenimientoRepository) {
        this.mantenimientoRepository = mantenimientoRepository;
    }
    
    // Obtener todos los mantenimientos
    public List<Mantenimiento> getAllMantenimientos() {
        return mantenimientoRepository.findAll();
    }
    
    // Obtener mantenimiento por ID
    public Optional<Mantenimiento> getMantenimientoById(Integer id) {
        return mantenimientoRepository.findById(id);
    }
    
    // Obtener mantenimientos por equipo ID
    public List<Mantenimiento> getMantenimientosByEquipoId(Integer equipoId) {
        return mantenimientoRepository.findByEquipoId(equipoId);
    }
    
    // Guardar un mantenimiento
    public Mantenimiento saveMantenimiento(Mantenimiento mantenimiento) {
        return mantenimientoRepository.save(mantenimiento);
    }
    
    // Actualizar un mantenimiento
    public Mantenimiento updateMantenimiento(Integer id, Mantenimiento mantenimientoDetails) {
        Optional<Mantenimiento> mantenimientoData = mantenimientoRepository.findById(id);
        
        if (mantenimientoData.isPresent()) {
            Mantenimiento mantenimiento = mantenimientoData.get();
            mantenimiento.setEquipoId(mantenimientoDetails.getEquipoId());
            mantenimiento.setDescripcion(mantenimientoDetails.getDescripcion());
            mantenimiento.setFechaMantenimiento(mantenimientoDetails.getFechaMantenimiento());
            mantenimiento.setResponsable(mantenimientoDetails.getResponsable());
            return mantenimientoRepository.save(mantenimiento);
        } else {
            throw new RuntimeException("Mantenimiento not found with id: " + id); // Throwing an exception instead of returning null
        }
    }

    
    // Eliminar un mantenimiento
    public void deleteMantenimiento(Integer id) {
        mantenimientoRepository.deleteById(id);
    }
}
