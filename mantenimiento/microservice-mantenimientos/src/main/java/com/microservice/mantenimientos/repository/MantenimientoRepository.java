package com.microservice.mantenimientos.repository;

import com.microservice.mantenimientos.model.Mantenimiento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MantenimientoRepository extends JpaRepository<Mantenimiento, Integer> {
    
    // Método para buscar mantenimientos por ID de equipo
    List<Mantenimiento> findByEquipoId(Integer equipoId);
}