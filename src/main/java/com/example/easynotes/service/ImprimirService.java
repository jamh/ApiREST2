package com.example.easynotes.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.io.IOException;
import java.util.Date;
import java.text.SimpleDateFormat;
import com.example.easynotes.imprimir;
import com.example.easynotes.model.Estacionamiento;
import com.example.easynotes.repository.ImprimirRepository;

@Service
public class ImprimirService {

    @Autowired
    ImprimirRepository imprimirRepo;

    public void imprimirTicket(String uid, Estacionamiento estacionamiento) throws IOException {
        Estacionamiento foundUid = imprimirRepo.findByUid(uid);
        
        imprimir imp = new imprimir();
        String id = Long.toString(foundUid.getId());
        
        SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        String hEntrada = formato.format(foundUid.gethEntrada());
        String hPago = formato.format(foundUid.gethPago());
        String montoPago = String.valueOf(foundUid.getMontoPago());

        imp.Sample("POS58 Printer(2)", uid, id, hEntrada, hEntrada, hPago, "$" + montoPago + ".00");
    }
}



