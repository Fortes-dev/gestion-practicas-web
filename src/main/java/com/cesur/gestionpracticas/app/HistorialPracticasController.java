package com.cesur.gestionpracticas.app;


import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import javax.servlet.http.HttpSession;
import java.util.ArrayList;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HistorialPracticasController {

    @Autowired
    private PracticasRepository repPrac;
    @Autowired
    private AlumnoRepository repAl;


    @RequestMapping(value="/historialPractica/{id}", method = RequestMethod.GET)
    public String setHistorial(Model atrb, @PathVariable Long id) {
        //session.setAttribute("idAl", 2L);
        //Long idAlum = (Long) session.getAttribute("idAl");
        System.out.println("el id que llega es "+id);
        Alumno al = repAl.getById(id);
        String nombre = al.getNombre();
        String curso = al.getCurso();
        ArrayList<Practica> practicas = new ArrayList<>(al.getPracticas());
        atrb.addAttribute("nombre", nombre);
        atrb.addAttribute("curso", curso);
        atrb.addAttribute("practicas", practicas);

        return "historialPractica";
    }


}
