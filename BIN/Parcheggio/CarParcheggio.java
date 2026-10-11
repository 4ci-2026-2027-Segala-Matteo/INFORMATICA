package Parcheggio;

public class CarParcheggio
{
    private String marca;
    private String targa;

    public Car()
    {
        this.marca = null;
        this.targa = null;
    }

    public Car(String m, String t){
        this.marca = m;
        this.targa = t;  
    }

    //set
    public void setMarca(String m){
        if(m != null){
            this.marca = m;
        }
    }
    public void setTarga(String t){
        if(t != null){
            this.targa = t;
        }
    }
    //get
    public String getMarca(){
        return this.marca;
    }
    public String getTarga(){
        return this.targa;
    }

    public String toString(){
        return "Marca: " + this.marca + ", targa: " + this.targa;
    }
}
