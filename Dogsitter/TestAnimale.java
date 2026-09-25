import java.util.*;
import java.io.*;

public class TestAnimale{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        String n = "";
        String s = "";
        int anni = 0;
        int ene = 0;
        int quantita = 0;
        char scelta = ' ';
        int num = -1;

        System.out.println("Inserisci il nome dell'animale:");
        n = sc.nextLine();
        System.out.println("Inserisci la specie dell'animale:");
        s = sc.nextLine();
        System.out.println("Inserisci l'età dell'animale:");
        anni = sc.nextInt();
        System.out.println("Inserisci l'energia dell'animale:");
        ene = sc.nextInt();
        sc.nextLine();

        Animale a = new Animale(n, s, anni, ene);

        System.out.println(a);

        System.out.println("Vuoi giocare con l'animale? (s/n)");
        scelta = sc.nextLine().charAt(0);

        if(scelta == 's'){
            if(a.getEnergia() >= 5){
                System.out.println("Inserisci la quantità di energia da spendere per giocare:");
                quantita = sc.nextInt();
                sc.nextLine();
                a.gioca(quantita);
            }else{
                System.out.println("L'animale non ha abbastanza energia per giocare.");
                System.out.println("Vuoi far mangiare l'animale? (s/n)");
                scelta = sc.nextLine().charAt(0);
                if(scelta == 's'){
                    if(a.getEnergia() <= 100){
                        System.out.println("Inserisci la quantità di energia da dare all'animale:");
                        quantita = sc.nextInt();
                        sc.nextLine();
                        a.mangia(quantita);
                    }
                }
            }
        } else {
            if(scelta == 'n'){
                System.out.println("Vuoi far mangiare l'animale? (s/n)");
                scelta = sc.nextLine().charAt(0);
                if(scelta == 's'){
                    if(a.getEnergia() <= 100){
                        System.out.println("Inserisci la quantità di energia da dare all'animale:");
                        quantita = sc.nextInt();
                        sc.nextLine();
                        a.mangia(quantita);
                    }
                }
            }
        }

        while(num != 0){
            System.out.println("Seleziona un'azione da eseguire:");
            System.out.println("1. Gioca con l'animale");
            System.out.println("2. Fai mangiare l'animale");
            System.out.println("3. Cambia il nome del animale");
            System.out.println("4. Cambia l'età del animale");
            System.out.println("5. Cambia la specie dell'animale");
            System.out.println("6. Cambia l'energia dell'animale");
            System.out.println("7. Visualizza le informazioni dell'animale");
            System.out.println("0. Esci");

            num = sc.nextInt();
            sc.nextLine();

            switch(num){
                case 1:
                    if(a.getEnergia() >= 5){
                        System.out.println("Inserisci la quantità di energia da spendere per giocare:");
                        quantita = sc.nextInt();
                        sc.nextLine();
                        a.gioca(quantita);
                    }else{
                        System.out.println("L'animale non ha abbastanza energia per giocare.");
                    }
                    break;
                case 2:
                    if(a.getEnergia() <= 100){
                        System.out.println("Inserisci la quantità di energia da dare all'animale:");
                        quantita = sc.nextInt();
                        sc.nextLine();
                        a.mangia(quantita);
                    }
                    break;
                case 3:
                    System.out.println("Inserisci il nuovo nome dell'animale:");
                    n = sc.nextLine();
                    a.setNome(n);
                    break;
                case 4:
                    System.out.println("Inserisci la nuova età dell'animale:");
                    anni = sc.nextInt();
                    sc.nextLine();
                    a.setEta(anni);
                    break;
                case 5:
                    System.out.println("Inserisci la nuova specie dell'animale:");
                    s = sc.nextLine();
                    a.setSpecie(s);
                    break;
                case 6:
                    System.out.println("Inserisci la nuova energia dell'animale:");
                    ene = sc.nextInt();
                    sc.nextLine();
                    a.setEnergia(ene);
                    break;
                case 7:
                    System.out.println(a);
                    break;
            }
        }
        System.out.println("Uscita dal programma.");
    }
}