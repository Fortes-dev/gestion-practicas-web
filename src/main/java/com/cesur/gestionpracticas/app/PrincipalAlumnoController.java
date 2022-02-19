/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
import java.io.IOException;
import java.sql.Blob;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StreamUtils;
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
    public String infoAlumno(@PathVariable Long id, Model model){
        
        Alumno a = repAl.getById(id); 
        model.addAttribute("principalAlumno",a );
        int horasDualRest=calcularHoras("Dual", a,"restantes");
        int horasFctRest=calcularHoras("fct", a,"restantes");
        
        int horasDualReal=calcularHoras("Dual", a,"realizadas");;
        int horasFctReal=calcularHoras("Dual", a,"realizadas");;
        
        
        model.addAttribute("horasDualRest", horasDualRest);
        model.addAttribute("horasFctRest", horasFctRest);
        model.addAttribute("horasDualReal", horasDualReal);
        model.addAttribute("horasFctReal", horasFctReal);
        return "principalAlumno";
    }
       
    public int calcularHoras(String tipo, Alumno a, String totrest){
        Integer horas = 0;
        var list = a.getPracticas();

        for (Practica p : list) {
            if (p.getTipo().equals(tipo)) {
                horas += p.getHorasEmpleadas();
            }
        }

        if (totrest.equals("restantes")) {
            return 450 - horas;
        } else {
            return horas;
        }
        
    }
}
