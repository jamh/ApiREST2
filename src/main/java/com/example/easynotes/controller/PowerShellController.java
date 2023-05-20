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
	
	@PostMapping(path = "/BorrarIp")
    public ResponseEntity<String> Crear(@RequestBody UsuarioIp userIp) throws IOException {
        UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
        if (foundUser != null && foundUser.getUsuario().equals("Admin") && foundUser.getContraseña().equals(userIp.getContraseña())) {
            
        	String command = "powershell.exe Remove-NetFirewallRule -DisplayName 'Puerto1521' ";
            Process powerShellProcess = Runtime.getRuntime().exec(command);
            powerShellProcess.getOutputStream().close();
            command= "powershell.exe New-NetFirewallRule -DisplayName 'Puerto1521' -Action allow";
            powerShellProcess = Runtime.getRuntime().exec(command);
            powerShellProcess.getOutputStream().close();
            String line;
            System.out.println("Standard Output:");
            BufferedReader stdout = new BufferedReader(new InputStreamReader(
                powerShellProcess.getInputStream()));
            while ((line = stdout.readLine()) != null) {
                System.out.println(line);
                return ResponseEntity.ok(line);
            }
            stdout.close();
            System.out.println("Standard Error:");
            BufferedReader stderr = new BufferedReader(new InputStreamReader(
                powerShellProcess.getErrorStream()));
	            while ((line = stderr.readLine()) != null) {
                System.out.println(line);
                return ResponseEntity.ok(line);
            }
            stderr.close();
            System.out.println("Done");
            return ResponseEntity.ok("Ejecución de PowerShell exitosa");
        } else {
        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
        }
    }

	 @PostMapping(path = "/VerRegla")
	    public ResponseEntity<String> PowerShell(@RequestBody UsuarioIp userIp) throws IOException {
	        UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
	        if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña()) && foundUser.getIp().equals(userIp.getIp())) {
	            
	        	String command = "powershell.exe  Get-NetFirewallrule -DisplayName 'Puerto1521' | Get-NetFirewallAddressFilter";
	            Process powerShellProcess = Runtime.getRuntime().exec(command);
	            powerShellProcess.getOutputStream().close();
	            String line;
	            System.out.println("Standard Output:");
	            BufferedReader stdout = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getInputStream()));
	            while ((line = stdout.readLine()) != null) {
	                System.out.println(line);
	                return ResponseEntity.ok(line);
	            }
	            stdout.close();
	            System.out.println("Standard Error:");
	            BufferedReader stderr = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getErrorStream()));
   	            while ((line = stderr.readLine()) != null) {
	                System.out.println(line);
	                return ResponseEntity.ok(line);
	            }
	            stderr.close();
	            System.out.println("Done");
	            return ResponseEntity.ok("Ejecución de PowerShell exitosa");
	        } else {
	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	        }
	    }
	 
	 @PostMapping(path = "/AgregarIp")
	    public ResponseEntity<String> Agregar(@RequestBody UsuarioIp userIp) throws IOException {
	        UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
	        if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña()) &&foundUser.getIp().equals(userIp.getIp())) {
	            
	        	String command = "powershell.exe Get-NetFirewallrule -DisplayName 'Puerto1521' | Get-NetFirewallAddressFilter | Set-NetFirewallAddressFilter -RemoteAddress " + foundUser.getIp();
	        	Process powerShellProcess = Runtime.getRuntime().exec(command);
	            powerShellProcess.getOutputStream().close();
	            String line;
	            System.out.println("Standard Output:");
	            BufferedReader stdout = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getInputStream()));
	            while ((line = stdout.readLine()) != null) {
	                System.out.println(line);
	                return ResponseEntity.ok(line);
	            }
	            stdout.close();
	            System.out.println("Standard Error:");
	            BufferedReader stderr = new BufferedReader(new InputStreamReader(
	                powerShellProcess.getErrorStream()));
	            while ((line = stderr.readLine()) != null) {
	                System.out.println(line);
	                return ResponseEntity.ok(line);
	            }
	            stderr.close();
	            System.out.println("Done");
	            return ResponseEntity.ok("Ejecución de PowerShell completa"); 
	        } else {
	        	return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
	        }
	    }
}
