/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Practica;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author medin
 */
public interface PracticasRepository  extends JpaRepository<Practica, Long>{
    
}
