package com.example.easynotes.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.dto.EstacionamientoDTO;
import com.example.easynotes.dto.expiradosDTO;
import com.example.easynotes.model.Descuentos;
import com.example.easynotes.repository.DescuentosRepository;

@RestController
@RequestMapping("/apidescuentos")
public class DescuentosController {
	
	@Autowired
	DescuentosRepository repodes;
	
	@GetMapping("/descuentos")
    public List<Descuentos> getAllDescuentos() {
        return repodes.findAll();
    }
	
	@GetMapping("/estatus1")
	public List<Descuentos> findEstatus() {
		return repodes.findEstatus();
	}
	/*
	@GetMapping("/tarjetas")
    public List<EstacionamientoDTO> buscaTarjeta() {
        return repodes.buscaTarjeta();
    }*/
	
	@PutMapping("/actualizarUsado")
    public String actualizarColumna() {
        int actualizarEstatus= repodes.actualizarEstatus();
        return "Se actualizaron " + actualizarEstatus + " elementos.";
        
    }
	
	@DeleteMapping("/borrarDescuentos/{id}")
    public ResponseEntity<String> borrarRegistroPorId(@PathVariable Long id) {
        repodes.BorrarPorId(id);
        return new ResponseEntity<>("Registro borrado exitosamente", HttpStatus.OK);
    }
	
	@PostMapping("/insertarDescuentos")
    public ResponseEntity<String> insertarRegistro(@RequestBody Descuentos descuentos) {
        repodes.insertarDescuentos(
        		descuentos.getEstatus(),
        		descuentos.getFechaCap(),
        		descuentos.getTarjeta());
        return new ResponseEntity<>("Registro insertado exitosamente", HttpStatus.CREATED);
    }
	
	@GetMapping("/tarjetas")
    public List<Object[]> obtenerInformacionTarjetas() {
        return repodes.obtenerInformacionTarjetas();
    }
	
	
}
