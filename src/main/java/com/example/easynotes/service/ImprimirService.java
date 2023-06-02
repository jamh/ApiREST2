package com.example.easynotes.service;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import com.example.easynotes.*;
import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.repository.ImprimirRepository;

@Service
public class ImprimirService {
	
	@Autowired
	ImprimirRepository imprimirRepo;
	
    public void imprimirTicket(Estacionamiento estacionamiento) throws IOException {
    	Estacionamiento foundUid= imprimirRepo.findByUid(estacionamiento.getUid());
    	System.out.println(estacionamiento.getUid());
    	System.out.println(estacionamiento.getId());
    	if(foundUid!= null) {
    			
    		imprimir imp = new imprimir();
                String uid= estacionamiento.getUid();
                
                Long Id= estacionamiento.getId();
                String id= Long.toString(Id);
                
                
                SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
                Date Entrada= estacionamiento.gethEntrada();
                String hEntrada= formato.format(Entrada);
                
                Date Pago= estacionamiento.gethPago();
                String hPago= formato.format(Pago);
                
                Double MontoPago= estacionamiento.getMontoPago();
                String montoPago= String.valueOf(MontoPago);
                
                imp.Sample("POS58 Printer(2)", uid ,id, hEntrada, hEntrada, hPago,"$"+ montoPago +".00");
    	} else {
    		throw new RuntimeException("Numero de tarjeta no encontrado");
    	}
    	
    	
    }
}

