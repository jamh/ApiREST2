package com.example.easynotes.controller;

import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.repository.EstacionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/apiparking")
public class EstacionamientoController {
	
	@Autowired
	EstacionamientoRepository repo;
	
	@GetMapping("/estacionamiento")
    public List<Estacionamiento> getAllEstacionamiento() {
        return repo.findAll();
    }
	
	@PutMapping("/actualizar99")
    public String actualizarColumna() {
        int actualizarPosicion= repo.actualizarPosicion();
        return "Se actualizaron " + actualizarPosicion + " elementos.";
        
    }
    
	
	

}
