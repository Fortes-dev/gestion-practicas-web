/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import java.util.ArrayList;
import java.util.Date;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

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

        Practica p = new Practica();
        

        pagina.addAttribute("prac", p);
        pagina.addAttribute("tipoarray", array);
        pagina.addAttribute("fecha", new Date());

        return "anadirpractica";
    }

    @PostMapping("/anadir")
    public String anadir(@ModelAttribute Practica prac, Model model, HttpSession session) {

        Long idAl = (Long) session.getAttribute("idAl");
        
        Alumno a = repAl.getById(idAl);
        prac.setIdAlumno(a);

        rep.save(prac);
        return "perfilprofesor";
    }

}
