package com.example.easynotes;

import com.github.anastaciocintra.escpos.EscPos;
import com.github.anastaciocintra.escpos.EscPosConst;
import com.github.anastaciocintra.escpos.Style;
import com.github.anastaciocintra.escpos.barcode.BarCode;
import com.github.anastaciocintra.escpos.barcode.QRCode;
import com.github.anastaciocintra.output.PrinterOutputStream;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.print.PrintService;
import org.apache.commons.lang3.StringUtils;
 		

/**
 *
 * @author jamhd
 */
public class imprimir {
    
    
   public void Sample(String printerName,String boleto,String folio,String fecha,String hEntrada,String hSalida,String importe) {

        // get the printer service by name passed on command line...
        //this call is slow, try to use it only once and reuse the PrintService variable.
        PrintService printService = PrinterOutputStream.getPrintServiceByName(printerName);
        EscPos escpos;
        try {
            escpos = new EscPos(new PrinterOutputStream(printService));

            Style title = new Style()
                    .setFontSize(Style.FontSize._1, Style.FontSize._1)
                    .setJustification(EscPosConst.Justification.Center);

//            escpos.writeLF(title, "Barcode");
//            escpos.feed(2);
            BarCode barcode = new BarCode();

          
              escpos.writeLF(title, "ESTACIONAMIENTO MARIA EUGENIA   MARTINEZ OVIEDO");
            escpos.feed(2);
           QRCode qrcode = new QRCode();
           
            escpos.writeLF("Av. Juarez #803,Col. la Villita Pachuca, Hidalgo, C.P. 42060    RFC MAOE6909168F5");
             escpos.feed(1);
             escpos.writeLF("H. Entrada:"+hEntrada);
             escpos.feed(1);
             escpos.writeLF("H. Salida:"+hSalida);
             escpos.feed(1);
             escpos.writeLF("Boleto:"+boleto);
             escpos.feed(1);
            escpos.writeLF("Folio:"+folio);                      
            escpos.feed(1);
              escpos.writeLF("Importe:"+importe);
            escpos.feed(1);
            escpos.writeLF("SI REQUIERE FACTURA SOLICITARLA AL ADMINISTRADOR  TIENE HASTA    FIN DE MES PARA FACTURAR");
            escpos.feed(1);
              escpos.writeLF("Tiene 9 min para salir en  caso contrario se le aplicara la      tarifa normal");
            escpos.feed(2);
              barcode.setSystem(BarCode.BarCodeSystem.UPCA);
            barcode.setHRIPosition(BarCode.BarCodeHRIPosition.BelowBarCode);
           barcode.setBarCodeSize(2, 100);
//            escpos.feed(2);//            escpos.feed(2);
//            escpos.feed(2);
//            escpos.feed(2);
//            escpos.feed(2);
//            escpos.feed(2);
            
             escpos.write(barcode, StringUtils.leftPad(folio, 11, '0'));
             escpos.feed(3);
          //  qrcode.setSize(7);
           // qrcode.setSize(7);
            //qrcode.setJustification(EscPosConst.Justification.Center);
           // escpos.write(qrcode, "estacionamiento?folio="+folio);
           // escpos.feed(3);


            escpos.close();

        } catch (IOException ex) {
            Logger.getLogger(imprimir.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java -jar xyz.jar (\"printer name\")");
            System.out.println("Printer list to use:");
            String[] printServicesNames = PrinterOutputStream.getListPrintServicesNames();
            for (String printServiceName : printServicesNames) {
                System.out.println(printServiceName);
            }

          //  System.exit(0);
        }
        imprimir obj = new imprimir();
        obj.Sample("POS58 Printer(2)","ADF808423","1234","02/02/2022","10:00:01 a. m","12:00:00 p.m.","$230.00");

    }
    
}
