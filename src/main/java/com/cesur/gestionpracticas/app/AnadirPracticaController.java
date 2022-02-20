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
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

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

//    @GetMapping("/anadir")
    @RequestMapping(value="/anadir/{id}", method = RequestMethod.GET)
    public String setAnadir(@PathVariable Long id,Model pagina){
    
        System.out.println(id);
        System.out.println("Ejecutando método setAnadir");
        ArrayList<String> array = new ArrayList<String>();
        array.add("Dual");
        array.add("FCT");

        Practica p = new Practica();
        
        
        pagina.addAttribute("prac", p);
        pagina.addAttribute("tipoarray", array);
        pagina.addAttribute("fecha", new Date());
        pagina.addAttribute("idAl",id);
        
        return "anadirpractica";
    }


    @RequestMapping(value="/anadir/{id}", method = RequestMethod.POST)
    public String anadir(@ModelAttribute Practica prac,@PathVariable Long id,Model pagina) {
        System.out.println(id);

        System.out.println(prac.toString());
        Alumno a = repAl.getById(id);
        prac.setIdAlumno(a);

        rep.save(prac);
        
        return "redirect:/alumno/"+id;
    }
    
//    @RequestMapping(value="@{'/editar-practica/'+${principalAlumno.id}+'/'+${p.id}}", method = RequestMethod.GET)
//    public String editarPractica(@ModelAttribute Practica prac,@PathVariable Long idPrac, @PathVariable Long idAl, Model pagina){
//        
//        Alumno a = repAl.getById(idAl);
//        List <Practica> practicas =a.getPracticas();
//        
//        for(Practica p:practicas){
//           if(p.getId()==idPrac){
//               pagina.addAttribute(p);
//           } 
//        }
//        
//        return "anadirPractica";
//    }
    

}
