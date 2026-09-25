public class Animale {
    private String nome;
    private String specie;
    private int eta;
    private int energia;

    public Animale(){
        this.nome = null;
        this.specie = null;
        this.eta = 0;
        this.energia = 0;
    }

    public Animale(String n, String s, int anni, int ene) {
        if(n != null){
            this.nome = n;
        }
        if(s != null){
            this.specie = s;
        }
        if(anni >= 0){
            this.eta = anni;
        }
        if(ene >= 0 && ene <= 100){
            this.energia = ene;
        }
    }

    public void setNome(String n) {
        if(n != null){
            this.nome = n;
        }
    }

    public void setEta(int anni) {
        if(anni >= 0){
            this.eta = anni;
        }
    }

    public void setSpecie(String s) {
        if(s != null){
            this.specie = s;
        }
    }

    public void setEnergia(int ene) {
        if(ene >= 0 && ene <= 100){
            this.energia = ene;
        }
    }

    public String getNome() {
        return this.nome;
    }

    public int getEta() {
        return this.eta;
    }

    public String getSpecie() {
        return this.specie;
    }

    public int getEnergia() {
        return this.energia;
    }

    public void gioca(int quantita) {
        if(quantita < 0){
            return;
        }
        if(quantita > this.energia){
            this.energia = 0;
        } else {
            this.energia -= quantita;
        }
    }

    public void mangia(int quantita){
        if(quantita < 0){
            return;
        }
        if(this.energia + quantita <= 100){
            this.energia += quantita;
        } else {
            this.energia = 100;
        }
    }

    public String toString() {
        String out;
        out = "Il nome dell'animale è: " + this.nome;
        out += "\nLa specie dell'animale è: " + this.specie;
        out += "\nL'età dell'animale è: " + this.eta;
        out += "\nL'energia dell'animale è: " + this.energia;
        return out;
    }
}