/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Practica;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<com.cesur.gestionpracticas.models.Practica> list() {
        
        return rep.findAll();
    }
    
    @GetMapping("/{id}")
    public Practica practicaPorId(@PathVariable Long id) {
        return rep.getById(id);
    }

    
}
