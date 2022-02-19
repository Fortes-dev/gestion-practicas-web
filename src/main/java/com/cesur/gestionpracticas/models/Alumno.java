/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import java.util.List;
import lombok.Data;

/**
 *
 * @author CarlosFortesMedina
 */
@Data
@Entity
@Table(name = "alumno")
public class Alumno implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false, length = 50)
    private String nombre;

    @Column(name = "apellidos", nullable = false)
    private String apellidos;

    @Column(name = "dni", nullable = false, length = 9)
    private String dni;

    @Column(name = "fecha_nac", nullable = false)
    private java.sql.Date fechaNac;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_empresa", nullable = false)
    private Empresa idEmpresa;

    @ManyToOne(optional = false)
    @JoinColumn(name = "id_profesor", nullable = false)
    private Profesor idProfesor;

    @Column(name = "horas_fct", nullable = false)
    private Integer horasFct;

    @Column(name = "horas_dual", nullable = false)
    private Integer horasDual;

    @Column(name = "curso", length = 64)
    private String curso;

    @Lob
    @Column(name = "foto_img")
    private Blob fotoImg;
    
    @Column(name = "foto_url", length = 100)
    private String fotoUrl;

    @OneToMany(mappedBy = "idAlumno", fetch = FetchType.EAGER, cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Practica> practicas;

   
}
