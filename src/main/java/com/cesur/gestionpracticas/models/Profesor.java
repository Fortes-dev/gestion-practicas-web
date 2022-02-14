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
@Table(name = "profesor")
public class Profesor implements Serializable {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Lob
    @Column(name = "foto_img")
    private Blob fotoImg;

   
}
