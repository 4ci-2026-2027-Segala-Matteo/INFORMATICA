package Distributore;

import java.util.*;

public class TestDistributoreBenzina
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        
        System.out.println("Quanto e' il prezzo a litro?");
        double prezzo = sc.nextDouble();
        DistributoreBenzina posto = new DistributoreBenzina(prezzo);
        
        System.out.println("Quanti litri rifornire subito il distributore?");
        double scortaIniziale = sc.nextDouble();
        posto.rifornisci(scortaIniziale);
        
        System.out.println(posto);
        
        Car auto1 = new Car(0.06); 
        Car auto2 = new Car(0.10);
        Car auto3 = new Car(0.08);
        
        posto.vendi(15.0, auto1);
        posto.vendi(20.0, auto2);
        posto.vendi(10.0, auto3);
        
        System.out.println("Dopo i primi rifornimenti:");
        System.out.println("Auto1: " + auto1);
        System.out.println("Auto2: " + auto2);
        System.out.println("Auto3: " + auto3);
        System.out.println(posto);
        
        auto1.drive(80);
        auto2.drive(120);
        auto3.drive(50);
        
        System.out.println("Dopo i viaggi:");
        System.out.println("Auto1: " + auto1);
        System.out.println("Auto2: " + auto2);
        System.out.println("Auto3: " + auto3);
        
        posto.vendi(10.0, auto1);
        posto.vendi(25.0, auto2);
        
        System.out.println("Dopo il secondo rifornimento:");
        System.out.println("Auto1: " + auto1);
        System.out.println("Auto2: " + auto2);
        System.out.println(posto);
        
        if(posto.getDeposito() < 20){
            System.out.println("Il distributore e' quasi vuoto, lo riforniamo...");
            posto.rifornisci(200);
        }
        
        posto.vendi(25.0, auto2);
        System.out.println("Auto2 dopo il rifornimento del distributore: " + auto2);
        System.out.println(posto);
        
        System.out.println("Il prezzo aumenta!");
        posto.aggiorna(prezzo + 0.15);
        System.out.println(posto);
    }
}
