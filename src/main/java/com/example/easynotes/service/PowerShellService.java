package com.example.easynotes.service;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.easynotes.model.UsuarioIp;
import com.example.easynotes.repository.UsuariosIpRepository;

@Service
public class PowerShellService {

	@Autowired
	UsuariosIpRepository repoIp;

	public String VerRegla(UsuarioIp userIp) throws IOException {
		UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
		if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña())
				&& foundUser.getIp().equals(userIp.getIp())) {

			String command = "powershell.exe  Get-NetFirewallrule -DisplayName 'Puerto1521' | Get-NetFirewallAddressFilter";

			Process powerShellProcess = Runtime.getRuntime().exec(command);

			powerShellProcess.getOutputStream().close();

			String line;
			StringBuilder output = new StringBuilder(); // Almacena la salida de PowerShell

			BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
			while ((line = stdout.readLine()) != null) {
				System.out.println(line);
				output.append(line).append("\n"); // Agrega la línea a la salida
			}
			stdout.close();

			BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
			while ((line = stderr.readLine()) != null) {
				System.out.println(line);
				output.append(line).append("\n");
			}
			stderr.close();
			System.out.println("Done");

			return output.toString(); // Devuelve la salida de PowerShell como resultado

		} else {
			throw new RuntimeException("Credenciales inválidas");
		}
	}

	public void AgregarIp(UsuarioIp userIp) throws IOException {
		UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
		if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña())) {
			if (foundUser.getIp().equals(userIp.getIp())) {
				throw new RuntimeException("El usuario ya esta registrado");
			}
			if (userIp.getIp() != null) {
				List<String> ipList = repoIp.findDistinctIp();
				if (ipList.contains(userIp.getIp())) {
	                throw new RuntimeException("IP inválida");
	            }
				else {
					foundUser.setIp(userIp.getIp());
					repoIp.save(foundUser);
					ipList = repoIp.findDistinctIp();
					if (!ipList.isEmpty()) {
						StringBuilder remoteAddresses = new StringBuilder();
						
						for (String ip : ipList) {
							remoteAddresses.append("'").append(ip).append("', ");
						}
						
						remoteAddresses.deleteCharAt(remoteAddresses.length() - 2);
						String command = "powershell.exe Remove-NetFirewallRule -DisplayName 'Puerto1521'";
						Process powerShellProcess = Runtime.getRuntime().exec(command);
						powerShellProcess.getOutputStream().close();
						
						command = "powershell.exe New-NetFirewallRule -DisplayName 'Puerto1521' -Action Allow -Protocol TCP -LocalPort 1521 -RemoteAddress "
								+ remoteAddresses.toString();
						powerShellProcess = Runtime.getRuntime().exec(command);
						powerShellProcess.getOutputStream().close();
						
						String line;
						System.out.println("Standard Output:");
						BufferedReader stdout = new BufferedReader(
								new InputStreamReader(powerShellProcess.getInputStream()));
						
						while ((line = stdout.readLine()) != null) {
							System.out.println(line);
						}
						
						stdout.close();
						System.out.println("Standard Error:");
						BufferedReader stderr = new BufferedReader(
								new InputStreamReader(powerShellProcess.getErrorStream()));
						while ((line = stderr.readLine()) != null) {
							System.out.println(line);
						}
						stderr.close();
						
						System.out.println("Done");
					} 
					
				}
				// return ResponseEntity.ok("Ejecución de PowerShell completa");
			} else {
				throw new RuntimeException("Falta agregar la direccion IP");
			}

		} else {
			foundUser.setUsuario(userIp.getIp());
			throw new RuntimeException("Credenciales inválidas");
		}
	}
	
	public void borrarIp(UsuarioIp userIp) throws IOException {
		UsuarioIp foundUser = repoIp.findByUsuario(userIp.getUsuario());
		if (foundUser.getIp() == null) {
			throw new RuntimeException("La IP ya se encuentra borrada");
		}
		if (foundUser != null && foundUser.getContraseña().equals(userIp.getContraseña()) && foundUser.getIp().equals(userIp.getIp())) {
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
				}
				stdout.close();
				System.out.println("Standard Error:");
				BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
				while ((line = stderr.readLine()) != null) {
					System.out.println(line);
				}
				stderr.close();
			}
				System.out.println("Done");

		} else {
			throw new RuntimeException("Credenciales inválidas");
		}
	}

}
