
public class Conto {
    private String intestatario;
    private double saldo;

    public Conto() {
    }

    public Conto(){
        this.intestatario = null;
        this.saldo = 0.0;
    }
    
    public Conto(String intestatario, double saldo) {
        if(this.intestatario != null){
            this.intestatario = intestatario;
        }else{
            this.intestatario = null;
        }
        if(this.saldo >= 0){
            this.saldo = saldo;
        }else{
            this.saldo = 0.0;
        }
    }
    
    public String getIntestatario(){
        return this.intestatario;
    }
    
    public double getSaldo() {
        return this.saldo;
    }
    
    public void setIntestatario(String Intestatario){
        if(this.intestatario != null){
            this.intestatario = intestatario;
        }
    }
    
    public void setSaldo(double saldo){
        if(this.saldo >= 0){
            this.saldo = saldo;
        }
    }
    
    public String effettuaPagamento(Pagamento pagamento)
            throws SaldoInsufficienteException {

        if (pagamento.getImporto() <= 0) {
            throw new IllegalArgumentException(
                    "L'importo del pagamento deve essere maggiore di zero.");
        }

        if (pagamento.getImporto() > this.saldo) {
            throw new SaldoInsufficienteException(
                    "Saldo insufficiente per effettuare il pagamento.");
        }

        saldo = saldo - pagamento.getImporto();

        String out="";
        out+="Pagamento effettuato.";
        out+="\n Beneficiario: "+pagamento.getBeneficiario();
        out+="\n Importo: "+ pagamento.getImporto();
        out+="\n Saldo residuo: " + saldo;
        return out;
    }

    
}
