package com.example.easynotes.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.service.ExpiradosService;

import java.util.List;


@RestController
@RequestMapping("/apiexpirados")
public class ExpiradosController {
	
	@Autowired
	private  ExpiradosService repo;

   public ExpiradosController(ExpiradosService repo) {
        this.repo = repo;
    }

    @GetMapping("/expirados")
    public List<expiradosDTO> buscaExpiradosData() {
    	System.out.println("Entro");
        return repo.buscaExpiradosData();
    }
    
    
}
