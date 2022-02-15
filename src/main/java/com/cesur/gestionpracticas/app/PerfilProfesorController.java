/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.cesur.gestionpracticas.app;

import javax.servlet.http.HttpSession;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *
 * @author medin
 */
@Controller
public class PerfilProfesorController {
    
    @GetMapping("/login")
    public String index(Model model, HttpSession session) {
        
        session.setAttribute("idAl", 12L);
        session.setAttribute("idPrac", 44L);
        
        return "perfilprofesor";
    }
    
}
