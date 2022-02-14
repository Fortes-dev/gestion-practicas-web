/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Date;
import lombok.Data;

/**
 *
 * @author CarlosFortesMedina
 */
@Data
@Entity
@Table(name = "practicas")
public class Practica implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_alumno", nullable = false)
    private Alumno idAlumno;

    @Column(name = "fecha", nullable = false)
    private Date fecha;

    @Column(name = "tipo", nullable = false, length = 4)
    private String tipo;

    @Column(name = "horas_empleadas", nullable = false)
    private Integer horasEmpleadas;

    @Column(name = "descripcion", nullable = false, length = 1000)
    private String descripcion;

    @Column(name = "observaciones", nullable = false, length = 1000)
    private String observaciones;

    
}
