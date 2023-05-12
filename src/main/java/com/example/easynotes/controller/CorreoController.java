package com.example.easynotes.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.service.CorreoService;

@RestController
@RequestMapping("/correo")
public class CorreoController {
	
	@Autowired
	CorreoService correoService;


    @GetMapping("/enviarCorreo")
    public String sendEmail() {
        correoService.sendEmail();
        return "Correo enviado";
    }
    
}
