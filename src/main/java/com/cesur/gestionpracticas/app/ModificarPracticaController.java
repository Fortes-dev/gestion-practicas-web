/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Practica;
import java.util.ArrayList;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author medin
 */
@Controller
public class ModificarPracticaController {

    @Autowired
    private PracticasRepository rep;

    @RequestMapping("/modificar/{id}")
    public String setModificar(Model pagina, @PathVariable Long id) {
        
        Practica p = rep.getById(id);
        
        ArrayList<String> array = new ArrayList<String>();
        array.add("Dual");
        array.add("FCT");
        
        pagina.addAttribute("prac", p);
        pagina.addAttribute("practica", p);
        pagina.addAttribute("tipoarray", array);
        
        return "modificarpractica";
    }
    
    @PostMapping("/modificar/{id}")
    public String modificar(Model pagina, @PathVariable Long id, @ModelAttribute Practica prac) {
        
        Practica p = rep.getById(id);
        
        p.setFecha(prac.getFecha());
        p.setObservaciones(prac.getObservaciones());
        p.setDescripcion(prac.getDescripcion());
        p.setHorasEmpleadas(prac.getHorasEmpleadas());
        p.setTipo(prac.getTipo());
        
        rep.save(p);
        
        return "modificarpractica";
       
    }
    
}
