package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.EstacionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

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
	
	@DeleteMapping("/Borrar/{id}")
    public ResponseEntity<String> borrarRegistroPorId(@PathVariable Long id) {
        repo.deleteById(id);
        return new ResponseEntity<>("Registro borrado exitosamente", HttpStatus.OK);
    }
	
	@PostMapping("/Insertar")
    public ResponseEntity<String> insertarRegistro(@RequestBody Estacionamiento estacionamiento) {
        repo.insertarEstacionamiento(
        		estacionamiento.getUid(), 
        		estacionamiento.gethEntrada(), 
        		estacionamiento.gethSalida(),
                estacionamiento.gethPago(), 
                estacionamiento.getPosicion(), 
                estacionamiento.getFecha(), 
                estacionamiento.getMontoPago(),
                estacionamiento.getPagado(), 
                estacionamiento.getDescuento(), 
                estacionamiento.getImporteDescuento(), 
                estacionamiento.getFechaCap());
        return new ResponseEntity<>("Registro insertado exitosamente", HttpStatus.CREATED);
    }
	

}
