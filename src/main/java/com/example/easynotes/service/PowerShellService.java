package com.example.easynotes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.UsuarioIp;
import com.example.easynotes.repository.UsuariosIpRepository;

@RestController
public class PowerShellService {

	@Autowired
	UsuariosIpRepository repoIp;

	@PostMapping(path = "/VerRegla")
	public ResponseEntity<String> PowerShell(@RequestBody UsuarioIp userIp) throws IOException {
		UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
		if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña())) {
			String command = "powershell.exe Get-NetFirewallrule -DisplayName 'Puerto1521'";
			Process powerShellProcess = Runtime.getRuntime().exec(command);
			powerShellProcess.getOutputStream().close();
			String line;
			System.out.println("Standard Output:");
			BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
			while ((line = stdout.readLine()) != null) {
				System.out.println(line);
				return ResponseEntity.ok(line);
			}
			stdout.close();
			System.out.println("Standard Error:");
			BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
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

	@PostMapping(path = "/AgregarUsuario")
	public ResponseEntity<String> Agregar(@RequestBody UsuarioIp userIp) throws IOException {
		UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
		if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña())) {
			if (userIp.getIp() != null) {
				foundUser.setIp(userIp.getIp());
				repoIp.save(foundUser);
				List<String> ipList = repoIp.findDistinctIp();
				if (!ipList.isEmpty()) {
					StringBuilder remoteAddresses = new StringBuilder();
				    for (String ip : ipList) {
				        remoteAddresses.append("'").append(ip).append("', ");
				    }
				    remoteAddresses.deleteCharAt(remoteAddresses.length() - 2);
					String command = "powershell.exe Remove-NetFirewallRule -DisplayName 'Puerto1521'";
					Process powerShellProcess = Runtime.getRuntime().exec(command);
					powerShellProcess.getOutputStream().close();
					command = "powershell.exe New-NetFirewallRule -DisplayName 'Puerto1521' -Action Allow -Protocol TCP -LocalPort 1521 -RemoteAddress " + remoteAddresses.toString();
					powerShellProcess = Runtime.getRuntime().exec(command);
					powerShellProcess.getOutputStream().close();
					String line;
					System.out.println("Standard Output:");
					BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
					while ((line = stdout.readLine()) != null) {
						System.out.println(line);
						return ResponseEntity.ok(line);
					}
					stdout.close();
					System.out.println("Standard Error:");
					BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
					while ((line = stderr.readLine()) != null) {
						System.out.println(line);
						return ResponseEntity.ok(line);
					}
					stderr.close();
					System.out.println("Done");
				}
				return ResponseEntity.ok("Ejecución de PowerShell completa");
			} else {
				return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Falta agregar la ip");
			}

		} else {
			foundUser.setUsuario(userIp.getIp());
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales invalidas");
		}
	}

	@PostMapping(path = "/BorrarIp")
	public ResponseEntity<String> borrarIp(@RequestBody UsuarioIp userIp) throws IOException {
		UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
		if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña()) && foundUser.getIp().equals(userIp.getIp())) {
			foundUser.setIp(null);
			repoIp.save(foundUser);
			List<String> ipList = repoIp.findDistinctIp();
			if (!ipList.isEmpty()) {
				StringBuilder remoteAddresses = new StringBuilder();
			    for (String ip : ipList) {
			        remoteAddresses.append("'").append(ip).append("', ");
			    }
			    remoteAddresses.deleteCharAt(remoteAddresses.length() - 2);
				String command = "powershell.exe Remove-NetFirewallRule -DisplayName 'Puerto1521'";
				Process powerShellProcess = Runtime.getRuntime().exec(command);
				powerShellProcess.getOutputStream().close();
				command = "powershell.exe New-NetFirewallRule -DisplayName 'Puerto1521' -Action Allow -Protocol TCP -LocalPort 1521 -RemoteAddress " + remoteAddresses.toString();
				System.out.println(command);
				powerShellProcess = Runtime.getRuntime().exec(command);
				powerShellProcess.getOutputStream().close();
				String line;
				System.out.println("Standard Output:");
				BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
				while ((line = stdout.readLine()) != null) {
					System.out.println(line);
					return ResponseEntity.ok(line);
				}
				stdout.close();
				System.out.println("Standard Error:");
				BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
				while ((line = stderr.readLine()) != null) {
					System.out.println(line);
					return ResponseEntity.ok(line);
				}
				stderr.close();
			}
				System.out.println("Done");
				return ResponseEntity.ok("Direccion Ip borrada");

		} else {
			return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Credenciales inválidas");
		}
	}
}
