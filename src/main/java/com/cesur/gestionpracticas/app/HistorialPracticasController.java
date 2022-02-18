package com.cesur.gestionpracticas.app;


import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;

@Controller
public class HistorialPracticasController {

    @Autowired
    private PracticasRepository repPrac;
    @Autowired
    private AlumnoRepository repAl;


    @GetMapping("/historial")
    public String setHistorial(Model atrb, HttpSession session) {
        //session.setAttribute("idAl", 2L);
        Long idAlum = (Long) session.getAttribute("idAl");
        Alumno al = repAl.getById(idAlum);
        String nombre = al.getNombre();
        String curso = al.getCurso();
        ArrayList<Practica> practicas = new ArrayList<>(al.getPracticas());
        atrb.addAttribute("nombre", nombre);
        atrb.addAttribute("curso", curso);
        atrb.addAttribute("practicas", practicas);

        return "hitorialPractica";
    }


}
