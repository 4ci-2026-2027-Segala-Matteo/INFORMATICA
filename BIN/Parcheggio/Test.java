package Parcheggio;

public import java.util.*;

public class Test
{
    public static void main(String [] args){
        Scanner sc = new Scanner(System.in);
        ArrayList<Car> auto = new ArrayList<Car>();
        int scelta = -2;
        String m = "";
        String t = "";
        Car c = null;
        boolean esiste = false;
        double ore = 0.0;
        double conto = 0.0;
        double nuovoCosto = 0.0;
        int nuoviPosti = 0;

        System.out.println("Benvenuto!");
        System.out.println("Qual'è il costo orario del parcheggio (in euro)?");
        double costo = sc.nextDouble();
        System.out.println("Quanti posti ha il parcheggio?");
        int posti = sc.nextInt();
        Parcheggio park = new Parcheggio(costo, posti);

        do{
            System.out.println();
            System.out.println("Scegli un'opzione e scrivi il suo numero corrispondente:");
            System.out.println("1. Aggiungi un veicolo");
            System.out.println("2. Mostra informazioni del veicolo");
            System.out.println("3. Entra nel parcheggio");
            System.out.println("4. Esci dal parcheggio");
            System.out.println("5. Modifica posti totali");
            System.out.println("6. Modifica costo orario");
            System.out.println("7. Mostra stato del parcheggio");
            System.out.println("0. Chiudi il programma");

            scelta = sc.nextInt();
            switch(scelta){
                case 1:
                    System.out.println();
                    System.out.println("Qual'è la marca del veicolo?");
                    m = sc.nextLine();
                    System.out.println("Qual'è la targa del veicolo? (TUTTA IN MAIUSCOLO)");
                    t = sc.nextLine();
                    while(t.length() != 6){
                        System.out.println("ERRORE: TARGA NON VALIDA (deve avere 6 caratteri e TUTTA IN MAIUSCOLO)");
                        System.out.println("Qual'è la targa del veicolo?");
                        t = sc.nextLine();
                    }
                    esiste = false;
                    for(int i = 0; i < auto.size(); i++){
                        if(auto.get(i).getTarga().equals(t)){
                            esiste = true;
                        }
                    }
                    if(esiste){
                        System.out.println("ERRORE: esiste già un veicolo con questa targa");
                    }else{
                        auto.add(new Car(m, t));
                        System.out.println("Veicolo aggiunto!");
                    }
                    break;

                case 2:
                    System.out.println();
                    System.out.println("Qual'è la targa del veicolo?");
                    t = sc.nextLine();
                    c = null;
                    for(int i = 0; i < auto.size(); i++){
                        if(auto.get(i).getTarga().equals(t)){
                            c = auto.get(i);
                        }
                    }
                    if(c == null){
                        System.out.println("Veicolo non trovato");
                    }else{
                        System.out.println(c);
                        if(park.contiene(t)){
                            System.out.println("Il veicolo è dentro il parcheggio");
                        }else{
                            System.out.println("Il veicolo è fuori dal parcheggio");
                        }
                    }
                    break;

                case 3:
                    System.out.println();
                    System.out.println("Qual'è la targa del veicolo?");
                    t = sc.nextLine();
                    c = null;
                    for(int i = 0; i < auto.size(); i++){
                        if(auto.get(i).getTarga().equals(t)){
                            c = auto.get(i);
                        }
                    }
                    if(c == null){
                        System.out.println("Veicolo non trovato");
                    }else{
                        
                        if(park.entra(c)){
                            System.out.println("Veicolo entrato nel parcheggio");
                        }else{
                            if(park.contiene(t)){
                                System.out.println("Il veicolo è già dentro il parcheggio");
                            }else{
                                System.out.println("Parcheggio pieno!");
                            }
                        }
                    }
                    break;

                case 4:
                    System.out.println();
                    System.out.println("Qual'è la targa del veicolo?");
                    t = sc.nextLine();
                    c = null;
                    for(int i = 0; i < auto.size(); i++){
                        if(auto.get(i).getTarga().equals(t)){
                            c = auto.get(i);
                        }
                    }
                    if(c == null){
                        System.out.println("Veicolo non trovato");
                    }else{
                        if(!park.contiene(t)){
                        System.out.println("Il veicolo non è dentro il parcheggio");
                        }else{
                        System.out.println("Quante ore è rimasto nel parcheggio?");
                        ore = Double.parseDouble(sc.nextLine().trim().replace(',', '.'));
                        conto = park.esce(c, ore);
                        System.out.println("Veicolo uscito. Importo da pagare: " + conto + " €");
                        }
                    }
                    break;

                case 5:
                    System.out.println();
                    System.out.println("Quanti posti totali deve avere il parcheggio?");
                    nuoviPosti = sc.nextInt();
                    if(park.setPostiTotali(nuoviPosti)){
                        System.out.println("Posti aggiornati");
                    }else{
                        System.out.println("ERRORE: numero non valido o minore delle auto presenti");
                    }
                    break;

                case 6:
                    System.out.println();
                    System.out.println("Qual'è il nuovo costo orario (in euro)?");
                    nuovoCosto = sc.nextDouble();
                    if(nuovoCosto > 0){
                        park.setCosto(nuovoCosto);
                        System.out.println("Costo aggiornato");
                    }else{
                        System.out.println("ERRORE: il costo deve essere maggiore di 0");
                    }
                    break;

                case 7:
                    System.out.println();
                    System.out.println(park);
                    break;

                case 0:
                    System.out.println("Arrivederci!");
                    break;

                default:
                    System.out.println("Opzione non valida");
            }
        }while(scelta != 0);
    }
}