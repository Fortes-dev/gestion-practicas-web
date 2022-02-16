/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hierr
 */
@Controller
public class PrincipalAlumnoController {
    @Autowired
   private AlumnoRepository repAl;
    
    @GetMapping("/alumno/{id}")
    public String nombreAlumno(@PathVariable Long id, Model model){
//       List<Long>list=new ArrayList<>();
//       list.add(id);
//       
//       Collection<Long> collection = list;
//       Iterable<Long> iterable = collection;
        Alumno a = repAl.getById(id);
        model.addAttribute("principalAlumno",a );
        return "principalAlumno";
    }
}
