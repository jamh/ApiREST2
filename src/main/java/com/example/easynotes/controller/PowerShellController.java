package com.example.easynotes.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.repository.UsuariosIpRepository;
import com.example.easynotes.service.PowerShellService;
import com.example.easynotes.model.UsuarioIp;

@RestController
@RequestMapping("/powershell")
public class PowerShellController {
	
	private final PowerShellService powerShellService;

    @Autowired
    public PowerShellController(PowerShellService powerShellService) {
        this.powerShellService = powerShellService;
    }

    @PostMapping("/VerRegla")
    public ResponseEntity<String> verRegla(@RequestBody UsuarioIp userIp) {
        try {
            return powerShellService.PowerShell(userIp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la ejecución de PowerShell");
        }
    }

    @PostMapping("/AgregarIp")
    public ResponseEntity<String> agregarUsuario(@RequestBody UsuarioIp userIp) {
        try {
            return powerShellService.Agregar(userIp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la ejecución de PowerShell");
        }
    }
    
    @PostMapping("/BorrarIp")
    public ResponseEntity<String> borrarIp(@RequestBody UsuarioIp userIp) {
        try {
            return powerShellService.borrarIp(userIp);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la ejecución de PowerShell");
        }
    }
	

	
}
