package com.microservice.mantenimientos.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "mantenimientos")
public class Mantenimiento {
    
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    
    @Column(name = "equipo_id")
    private Integer equipoId;
    
    @Column(name = "descripcion", columnDefinition = "TEXT")
    private String descripcion;
    
    @Column(name = "fecha_mantenimiento")
    @Temporal(TemporalType.DATE)
    private Date fechaMantenimiento;
    
    @Column(name = "responsable")
    private String responsable;
    
    // Constructores
    public Mantenimiento() {
    }
    
    public Mantenimiento(Integer equipoId, String descripcion, Date fechaMantenimiento, String responsable) {
        this.equipoId = equipoId;
        this.descripcion = descripcion;
        this.fechaMantenimiento = fechaMantenimiento;
        this.responsable = responsable;
    }
    
    // Getters y Setters
    public Integer getId() {
        return id;
    }
    
    public void setId(Integer id) {
        this.id = id;
    }
    
    public Integer getEquipoId() {
        return equipoId;
    }
    
    public void setEquipoId(Integer equipoId) {
        this.equipoId = equipoId;
    }
    
    public String getDescripcion() {
        return descripcion;
    }
    
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    
    public Date getFechaMantenimiento() {
        return fechaMantenimiento;
    }
    
    public void setFechaMantenimiento(Date fechaMantenimiento) {
        this.fechaMantenimiento = fechaMantenimiento;
    }
    
    public String getResponsable() {
        return responsable;
    }
    
    public void setResponsable(String responsable) {
        this.responsable = responsable;
    }
}