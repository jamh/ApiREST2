package com.example.easynotes.controller;

import org.springframework.http.MediaType;
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
import com.example.easynotes.model.UsuarioIp;


@RestController
@RequestMapping("/powershell")
public class PowerShellController {
	
	@Autowired
	UsuariosIpRepository repoIp;

	 @PostMapping(path = "/ejecutar")
	    public ResponseEntity<String> PowerShell(@RequestBody UsuarioIp userIp) throws IOException {
	        UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
	        if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña())) {
	            String command = "powershell.exe  Get-NetFirewallrule -DisplayName 'ArmouryHtmlDebugServer' | Get-NetFirewallAddressFilter";
	            Process powerShellProcess = Runtime.getRuntime().exec(command);
	            powerShellProcess.getOutputStream().close();
	            String line;
	            System.out.println("Standard Output:");
	            BufferedReader stdout = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getInputStream()));
	            while ((line = stdout.readLine()) != null) {
	                System.out.println(line);
	            }
	            stdout.close();
	            System.out.println("Standard Error:");
	            BufferedReader stderr = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getErrorStream()));
	            while ((line = stderr.readLine()) != null) {
	                System.out.println(line);
	            }
	            stderr.close();
	            System.out.println("Done");
	            return ResponseEntity.ok("Ejecución de PowerShell exitosa");
	        } else {
	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	        }
	    }
}
