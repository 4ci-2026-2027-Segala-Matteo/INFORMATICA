package Distributore;
public class Car
{
    private final double resa;      
    private double gas;       
    
    public Car(double unaResa)
    {
        if(unaResa > 0){
            this.resa = unaResa;
        } else {
            this.resa = 0.0;
        }
        this.gas = 0.0;
    }
    

    public void drive(double km)
    {
        if(km <= 0){
            return;
        }
        
        double gasNecessario = km * this.resa;
        
        if(gasNecessario <= this.gas){
            this.gas -= gasNecessario;
        } else {
            this.gas = 0.0;
        }
    }
    
    public double getGas()
    {
        return this.gas;
    }
    
    public void addGas(double quantita)
    {
        if(quantita > 0){
            this.gas += quantita;
        }
    }
    
    public String toString()
    {
        return "Auto con resa " + this.resa + " l/km, gas nel serbatoio: " + this.gas + " litri";
    }
}