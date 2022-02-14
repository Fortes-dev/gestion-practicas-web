/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.controllers;

import com.cesur.gestionpracticas.models.Practica;
import com.cesur.gestionpracticas.repositories.PracticasRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author medin
 */

@Controller
@RequestMapping("/api")
public class AnadirPracticaController {
    
    @Autowired
    private PracticasRepository rep;
    
    @GetMapping("/")
    public List<Practica> list() {
        return rep.findAll();
    }
    
}
