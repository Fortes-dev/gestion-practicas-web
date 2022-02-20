/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesur.gestionpracticas.app;

import com.cesur.gestionpracticas.models.Alumno;
import com.cesur.gestionpracticas.models.Practica;
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

/**
 *
 * @author hierr
 */

@Controller
public class LoginController {
    
    @Autowired
    AlumnoRepository alRep;
    
    
    @GetMapping("/login")
    public String index(Model model){
        
        Alumno a= new Alumno(); 
        model.addAttribute("alumno",a);
        
        return "login";
    }
        
     @PostMapping(value="/login")
    public String loginCheck(@ModelAttribute(value="alumno") Alumno alumno , Model model){
        System.out.println("Entra en el loginCheck");
        String wrongPassword="Contraseña o email incorrectos";
        String wrongEmail="Email incorrecto";
        Alumno usuario = new Alumno();
        String retornar="";
         try {
             usuario = alRep.findByEmail(alumno.getEmail());
             
             if (!alumno.getPassword().equals(usuario.getPassword())) {
                 model.addAttribute("wrongPassword", wrongPassword);
                 System.out.println("Contraseña incorrecta");
                 retornar = "login";
             } else {
                 retornar = "redirect:/alumno/" + usuario.getId();
             }
         } catch (NullPointerException e) {
             model.addAttribute("wrongPassword", wrongEmail);
             retornar = "login";
         } finally {
             return retornar;
         }
        
        
        
        
    }
  
    
}
