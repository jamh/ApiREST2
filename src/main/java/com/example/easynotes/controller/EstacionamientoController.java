package com.example.easynotes.controller;

import com.example.easynotes.exception.ResourceNotFoundException;
import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.model.Note;
import com.example.easynotes.repository.EstacionamientoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/apiparking")
public class EstacionamientoController {
	
	@Autowired
	EstacionamientoRepository repo;
	
	@GetMapping("/estacionamiento")
    public List<Estacionamiento> getAllEstacionamiento() {
        return repo.findAll();
    }

}
