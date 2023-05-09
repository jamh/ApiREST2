package com.example.easynotes.controller;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.repository.ExpiradosRepository;
import com.example.easynotes.service.ExpiradosService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/apiexpirados")
public class ExpiradosController {
	
	@Autowired
	private  ExpiradosRepository repo;

   /* public ExpiradosController(ExpiradosService expiradosService) {
        this.expiradosService = expiradosService;
    }*/

    @GetMapping("/expirados")
    public List<expiradosDTO> buscaExpiradosData() {
        return repo.buscaExpirados();
    }
    
    
}
