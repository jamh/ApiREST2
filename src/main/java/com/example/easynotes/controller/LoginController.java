package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Login;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.LoginRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apilogin")
public class LoginController {
	
	@Autowired
	LoginRepository loginRepository;
	
	
/*
	@PostMapping("/login")
    public Login createLogin(@Valid @RequestBody Login login) {
        return loginRepository.save(login);
    }
*/
	@GetMapping("/login/{id}")
    public Login getLoginById(@PathVariable(value = "id") Long loginId) {
        return loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("Login", "id", loginId));
    }
      /*
    @PutMapping("/login/{id}")
    public Login updateLogin(@PathVariable(value = "id") Long loginId,
                                           @Valid @RequestBody Login loginDetails) {

        Login login = loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("Login", "id", loginId));

        login.setEmpleado(loginDetails.getEmpleado());
        login.setPassword(loginDetails.getPassword());
        login.setCorreo(loginDetails.getCorreo());
        login.setExpiracion(loginDetails.getExpiracion());
        login.setPerfil(loginDetails.getPerfil());

        Login updatedLogin = loginRepository.save(login);
        return updatedLogin;
    }

    @DeleteMapping("/login/{id}")
    public ResponseEntity<?> deleteLogin(@PathVariable(value = "id") Long loginId) {
    	Login login = loginRepository.findById(loginId)
                .orElseThrow(() -> new ResourceNotFoundException("Login", "id", loginId));

        loginRepository.delete(login);

        return ResponseEntity.ok().build();
    } */

}
