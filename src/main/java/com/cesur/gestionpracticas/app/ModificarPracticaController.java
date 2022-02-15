/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import java.util.ArrayList;
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
public class ModificarPracticaController {

    @Autowired
    private PracticasRepository rep;
    @Autowired
    private AlumnoRepository repAl;

    @GetMapping("/modificar")
    public String setModificar(Model pagina, HttpSession session) {

        Long idPrac = (Long) session.getAttribute("idPrac");
        Practica p = rep.getById(idPrac);

        ArrayList<String> array = new ArrayList<String>();
        array.add("Dual");
        array.add("FCT");

        pagina.addAttribute("prac", p);
        pagina.addAttribute("practica", p);
        pagina.addAttribute("tipoarray", array);

        return "modificarpractica";
    }

    @PostMapping("/modificar")
    public String modificar(Model pagina, @ModelAttribute Practica prac, HttpSession session) {

        Long idAl = (Long) session.getAttribute("idAl");
        Long idPrac = (Long) session.getAttribute("idPrac");
        Alumno a = repAl.getById(idAl);
        prac.setIdAlumno(a);
        prac.setId(idPrac);

        rep.save(prac);

        return "perfilprofesor";

    }

}
