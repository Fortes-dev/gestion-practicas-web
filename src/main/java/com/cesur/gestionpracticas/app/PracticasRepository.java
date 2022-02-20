/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import org.hibernate.Session;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

/**
 *
 * @author medin
 */
public interface PracticasRepository  extends JpaRepository<Practica, Long>{

    @Query("select p from Practica p where p.idAlumno = ?1 order by p.fecha desc")
    List<Practica> findByFecha(Alumno a, Pageable pageable);

    @Modifying
    @Query("delete from Practica p where p.id = ?1")
    void deleteFromId(Long id);

}
