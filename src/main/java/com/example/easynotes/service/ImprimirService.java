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

    public void imprimirTicket(Estacionamiento estacionamiento) throws IOException {
        Estacionamiento foundUid = imprimirRepo.findByUid(estacionamiento.getUid());
        System.out.println(estacionamiento.getUid());
        System.out.println(foundUid.getId());
        if (foundUid != null) {

            imprimir imp = new imprimir();
            String uid = foundUid.getUid();

            Long Id = foundUid.getId();
            String id = Long.toString(Id);

            SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
            Date Entrada = foundUid.gethEntrada();
            String hEntrada = formato.format(Entrada);

            Date Pago = foundUid.gethPago();
            String hPago = formato.format(Pago);

            Double MontoPago = foundUid.getMontoPago();
            String montoPago = String.valueOf(MontoPago);

            imp.Sample("POS58 Printer(2)", uid, id, hEntrada, hEntrada, hPago, "$" + montoPago + ".00");

        } else {
            throw new RuntimeException("Numero de tarjeta no encontrado");
        }
    }
}


