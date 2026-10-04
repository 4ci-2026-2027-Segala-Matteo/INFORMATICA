package SistemaDiPagamento;

public class Pagamento {
    private String beneficiario;
    private double importo;

    public Pagamento(){
        this.beneficiario = null;
        this.importo = 0.0;
    }
    
    public Pagamento(String beneficiario, double importo) {
        if(beneficiario != null && importo > 0){
            this.beneficiario = beneficiario;
        }else{
            this.beneficiario = null;
        }
        if(importo > 0){
            this.importo = importo;
        }else{
            this.importo = 0.0;
        }
    }

    public String getBeneficiario() {
        return this.beneficiario;
    }

    public double getImporto() {
        return this.importo;
    }

    public void setBeneficiario(String beneficiario) {
        if(beneficiario != null && importo > 0){
            this.beneficiario = beneficiario;
        }
    }

    public void setImporto(double importo) {
        if(importo > 0){
            this.importo = importo;
        }
    }
}
