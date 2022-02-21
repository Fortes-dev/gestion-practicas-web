/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.cesur.gestionpracticas.app;

import javax.servlet.http.HttpSession;
import org.springframework.boot.web.servlet.error.ErrorController;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 *
 * @author hierr
 */
@Controller
public class ErrorControlador implements ErrorController {
    @RequestMapping("/error")
    public String handleError(Model model, HttpSession sesion){
        Long id = (Long) sesion.getAttribute("usuario");
        model.addAttribute("id", id);
        return "error";
    }
    
}
