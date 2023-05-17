package com.example.easynotes.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/firewall")
public class FirewallController {

	@GetMapping("/rule")
	public String getFirewallRule() throws IOException {
		String username = "josue";
		String password = "1234Test";
		String ipAddress = "74.208.41.132";
		String command = "powershell.exe Get-NetFirewallrule -DisplayName 'ArmouryHtmlDebugServer' | Get-NetFirewallAddressFilter";
		
		ProcessBuilder processBuilder = new ProcessBuilder("powershell.exe", "-command", command);
		processBuilder.redirectErrorStream(true);
		processBuilder.environment().put("USERNAME", username);
		processBuilder.environment().put("PASSWORD", password);
		processBuilder.environment().put("IPADDRESS", ipAddress);
		
		Process powerShellProcess = processBuilder.start();
		BufferedReader stdout = new BufferedReader(new InputStreamReader(powerShellProcess.getInputStream()));
		String line;
		while ((line = stdout.readLine()) != null) {
			System.out.println(line);
		}
		stdout.close();
		System.out.println("Standard Error:");
		
		StringBuilder output = new StringBuilder();
		BufferedReader stderr = new BufferedReader(new InputStreamReader(powerShellProcess.getErrorStream()));
		while ((line = stderr.readLine()) != null) {
			System.out.println(line);
		}
		stderr.close();
		System.out.println("Done");
		return output.toString();
	}

}
