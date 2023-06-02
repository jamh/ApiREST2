package com.example.easynotes.controller;

import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.example.easynotes.dto.PowerShellResponseDTO;
import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.model.UsuarioIp;
import com.example.easynotes.service.ImprimirService;

@RestController
@RequestMapping("/imprimir")
public class ImprimirController {
	
	@Autowired
	ImprimirService imprimirSer;
	
	@PostMapping("/ticket")
	public ResponseEntity<String> imprimirTicket(@RequestBody Estacionamiento estacionamiento) {
		try {
			imprimirSer.imprimirTicket(estacionamiento);
			return ResponseEntity.ok("Ticket impreso exitosamente.");
		} catch (IOException e) {
			return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error al imprimir el ticket.");
		} catch (RuntimeException e) {
			return ResponseEntity.badRequest().body(e.getMessage());
		}
	}

}
