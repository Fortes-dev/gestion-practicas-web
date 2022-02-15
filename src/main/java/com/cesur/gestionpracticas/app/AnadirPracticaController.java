/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import java.net.NetworkInterface;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author medin
 */
@Controller
public class AnadirPracticaController {

    @Autowired
    private PracticasRepository rep;
    @Autowired
    private AlumnoRepository repAl;

    @GetMapping("/anadir")
    public String setAnadir(Model pagina) {

        ArrayList<String> array = new ArrayList<String>();
        array.add("Dual");
        array.add("FCT");

        pagina.addAttribute("prac", new Practica());
        pagina.addAttribute("tipoarray", array);
        pagina.addAttribute("fecha", new Date());

        return "anadirpractica";
    }

    @PostMapping("/anadir")
    public String anadir(@ModelAttribute Practica prac, Model model) {
        
        Alumno a = repAl.getById(12L);
        
        prac.setIdAlumno(a);
        rep.save(prac);
        return "perfilprofesor";
    }

}
