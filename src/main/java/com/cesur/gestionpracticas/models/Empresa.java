/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.models;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Blob;
import lombok.Data;

/**
 *
 * @author CarlosFortesMedina
 */
@Data
@Entity
@Table(name = "empresa")
public class Empresa implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tutor_empresa", nullable = false)
    private String tutorEmpresa;

    @Column(name = "localizacion_url", length = 800)
    private String localizacionUrl;

    @Column(name = "telefono", nullable = false)
    private Integer telefono;

    @Column(name = "email_tutor", nullable = false)
    private String emailTutor;
    
    @Column(name = "latitud", nullable = false)
    private Double latitud;
    
    @Column(name = "longitud", nullable = false)
    private Double longitud;

    @Lob
    @Column(name = "logo_img")
    private Blob logoImg;

    @Column(name = "foto_url", nullable = false)
    private String fotoUrl;
    
}
