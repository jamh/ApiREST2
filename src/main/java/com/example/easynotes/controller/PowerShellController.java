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

import com.example.easynotes.service.PowerShellService;
import com.example.easynotes.dto.PowerShellResponseDTO;
import com.example.easynotes.model.UsuarioIp;
import com.example.easynotes.repository.UsuariosIpRepository;

@RestController
@RequestMapping("/powershell")
public class PowerShellController {

	@Autowired
	PowerShellService powerShellService;

	@PostMapping("/VerRegla")
    public ResponseEntity<String> executePowerShell(@RequestBody UsuarioIp userIp) {
        try {
            String result = powerShellService.VerRegla(userIp);
            return ResponseEntity.ok(result);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("Error en la ejecución de PowerShell");
        } catch (RuntimeException e) {
            return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(e.getMessage());
        }
    }
	
	@PostMapping("/AgregarUsuario")
    public ResponseEntity<PowerShellResponseDTO> agregarIp(@RequestBody UsuarioIp userIp) {
        try {
            powerShellService.AgregarIp(userIp);
            PowerShellResponseDTO response = new PowerShellResponseDTO("Se agregó correctamente el usuario", 1);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PowerShellResponseDTO("Error en la ejecución de PowerShell", 0));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new PowerShellResponseDTO(e.getMessage(), 0));
        }
    }
	
    @PostMapping("/BorrarUsuario")
    public ResponseEntity<PowerShellResponseDTO> borrarIp(@RequestBody UsuarioIp userIp) {
        try {
            powerShellService.borrarIp(userIp);
            PowerShellResponseDTO response = new PowerShellResponseDTO("Se borró correctamente la IP", 1);
            return ResponseEntity.ok(response);
        } catch (IOException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(new PowerShellResponseDTO("Error en la ejecución de PowerShell", 0));
        } catch (RuntimeException e) {
            return ResponseEntity.badRequest().body(new PowerShellResponseDTO(e.getMessage(), 0));
        }
    }
}
