package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.EstacionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
	
	@DeleteMapping("/BorrarPosicion/{posicion}")
    public String eliminarPorPosicion(@PathVariable Long posicion) {
        repo.deleteByPosicion(posicion);
        return "El registro con la posición " + posicion + " ha sido eliminado.";
    }
    
	
	

}
