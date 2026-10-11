package Parcheggio;
import java.util.*;

public class Parcheggio
{
    private int postiDisponibili;
    private double costoOrario;
    private int postiTotali;
    private String[] v;         

    public Parcheggio()
    {
        this.postiTotali = 0;
        this.postiDisponibili = 0;
        this.costoOrario = 0.0;
        this.v = new String[0];
    }

    public Parcheggio(double cO, int pT){
        if(pT > 0){
            this.postiTotali = pT;
        }else{
            this.postiTotali = 0;
        }
        this.postiDisponibili = this.postiTotali;

        if(cO > 0.0){
            this.costoOrario = cO;
        }else{
            this.costoOrario = 0.0;
        }
        
        this.v = new String[this.postiTotali];
        Arrays.fill(this.v, "");
    }

    // Costruttore di copia
    public Parcheggio(Parcheggio p){
        this.postiTotali = p.postiTotali;
        this.postiDisponibili = p.postiDisponibili;
        this.costoOrario = p.costoOrario;
        this.v = p.v.clone();
    }

    //Set
    // Cambia il numero totale di posti, mantenendo le auto già dentro.
    // Restituisce false se il nuovo numero non è valido o è inferiore alle auto presenti.
    public boolean setPostiTotali(int pT){
        int occupati = this.postiTotali - this.postiDisponibili;
        if(pT <= 0 || pT < occupati){
            return false;
        }
        String[] nuovo = new String[pT];
        Arrays.fill(nuovo, "");
        int k = 0;
        for(int i = 0; i < this.v.length; i++){
            if(!this.v[i].equals("")){
                nuovo[k] = this.v[i];
                k++;
            }
        }
        this.v = nuovo;
        this.postiTotali = pT;
        this.postiDisponibili = pT - occupati;
        return true;
    }

    public void setCosto(double cO){
        if(cO > 0.0){
            this.costoOrario = cO;
        }
    }

    //Get
    public int getPostiTotali(){
        return this.postiTotali;
    }
    public int getPostiDisponibili(){
        return this.postiDisponibili;
    }
    public double getCostoOrario(){
        return this.costoOrario;
    }

    // Dice se un'auto con quella targa è dentro il parcheggio
    public boolean contiene(String targa){
        if(targa == null){
            return false;
        }
        for(int i = 0; i < this.v.length; i++){
            if(this.v[i].equals(targa)){
                return true;
            }
        }
        return false;
    }

    public boolean entra(Car auto){
        if(auto == null || auto.getTarga() == null){
            return false;
        }
        if(this.postiDisponibili <= 0 || this.contiene(auto.getTarga())){
            return false;
        }
        for(int i = 0; i < this.v.length; i++){
            if(this.v[i].equals("")){
                this.v[i] = auto.getTarga();
                this.postiDisponibili--;
                return true;
            }
        }
        return false;
    }

    public double esce(Car auto, double ore){
        if(auto == null || auto.getTarga() == null){
            return 0.0;
        }
        if(ore < 0){
            ore = 0;
        }
        for(int i = 0; i < this.v.length; i++){
            if(this.v[i].equals(auto.getTarga())){
                this.v[i] = "";
                this.postiDisponibili++;
                return ore * this.costoOrario;
            }
        }
        return 0.0;
    }

    public String toString(){
        String out = "";
        out += "Il costo del parcheggio è: " + this.costoOrario + " €/ora";
        out += "\nPosti disponibili: " + this.postiDisponibili + " su " + this.postiTotali;
        return out;
    }
}
