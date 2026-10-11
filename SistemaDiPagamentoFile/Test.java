package SistemaDiPagamentoFile;

import java.io.*;
import java.util.Scanner;

public class Test {
    public static void main(String[] args) {

        Conto contoMatteo = new Conto("Matteo Segala", 500.00);
        System.out.println(contoMatteo.toString());

        try {
            File fileDati = new File("bin/SistemaPagamentoFile/pagamenti.txt");
            Scanner lettore = new Scanner(fileDati);

            FileWriter scrittoreFile = new FileWriter("bin/SistemaPagamentoFile/file_transazioni.txt", false);
            PrintWriter log = new PrintWriter(scrittoreFile);

            log.println("Conto intestato a: " + contoMatteo.getIntestatario() + " Saldo: " + contoMatteo.getSaldo() + "€\n");

            int contatoreRighe = 0;

            while (lettore.hasNextLine()) {
                contatoreRighe++;
                String linea = lettore.nextLine();

                // Salta le righe vuote
                if (linea.isEmpty()) {
                    continue;
                }

                String[] campi = linea.split(",");

                // Riga non valida: deve avere esattamente beneficiario e importo
                if (campi.length != 2) {
                    log.println("Errore riga " + contatoreRighe + ": " + linea + "\n");
                    continue;
                }

                String nomeBeneficiario = campi[0];
                double cifra = Double.parseDouble(campi[1]);

                Pagamento pagamento = new Pagamento(nomeBeneficiario, cifra);

                try {
                    contoMatteo.effettuaPagamento(pagamento);
                    log.println("Pagamento: " + cifra + "€. Beneficiario: " + nomeBeneficiario);
                } catch (SaldoInsufficienteException e) {
                    System.out.println("Errore: " + e.getMessage() + "\n");
                    log.println("\nFALLITO: " + e.getMessage() + "\n");
                }
            }

            lettore.close();
            log.close();
            scrittoreFile.close();
        } catch (IOException e) {
            e.printStackTrace();
        }

        System.out.println("Stato conto:" + contoMatteo.toString());
    }
}