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
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author medin
 */
@Controller
public class ModificarPracticaController {

    @Autowired
    private PracticasRepository rep;

    @RequestMapping(value = "/modificar/{idP}", method = RequestMethod.GET)
    public String setModificar(@PathVariable Long idP,Model pagina) {


        Practica p = rep.getById(idP);

        ArrayList<String> array = new ArrayList<String>();
        array.add("Dual");
        array.add("FCT");

        pagina.addAttribute("prac", p);
        pagina.addAttribute("practica", p);
        pagina.addAttribute("tipoarray", array);

        return "modificarpractica";
    }


    @RequestMapping(value = "/modificar/{idP}", method = RequestMethod.POST)
    public String modificar(@ModelAttribute Practica prac, @PathVariable Long idP) {
        Alumno al = rep.getById(idP).getIdAlumno();
        prac.setId(idP);
        prac.setIdAlumno(al);
        rep.save(prac);
        return "redirect:/alumno/"+al.getId();

    }

    @Transactional
    @RequestMapping(value = "/modificar/delete/{idP}", method = RequestMethod.GET)
    public String eliminar(@ModelAttribute Practica prac, @PathVariable Long idP) {
        Alumno al = rep.getById(idP).getIdAlumno();

        rep.deleteFromId(idP);

        return "redirect:/alumno/"+al.getId();

    }

}
