package com.example.easynotes.controller;

import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.service.ExpiradosService;
import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
@RequestMapping("/api")
public class ExpiradosController {
	
	private final ExpiradosService expiradosService;

    public ExpiradosController(ExpiradosService expiradosService) {
        this.expiradosService = expiradosService;
    }

    @GetMapping("/expirados")
    public List<expiradosDTO> getDataFromTwoTables() {
        return expiradosService.getDataFromTwoTables();
    }
    
    
}
