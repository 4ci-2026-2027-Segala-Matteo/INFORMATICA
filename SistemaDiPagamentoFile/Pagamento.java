package SistemaDiPagamentoFile;

public class Pagamento {
    private String beneficiario;
    public double importo;

    // Costruttore con parametri
    public Pagamento(String b, double i) {
        if (b != null) {
            this.beneficiario = b;
        } else {
            this.beneficiario = "";
        }

        if (i > 0) {
            this.importo = i;
        } else {
            this.importo = 0.0;
        }
    }

    // Costruttore di default
    public Pagamento() {
        this.beneficiario = "";
        this.importo = 0.0;
    }

    // Rappresentazione testuale
    public String toString() {
        return "Pagamento a favore di: " + this.beneficiario + "\nImporto: " + this.importo + "€";
    }

    // Getter e setter importo
    public double getImporto() {
        return this.importo;
    }

    public void setImporto(double nuovoImporto) {
        if (nuovoImporto > 0) {
            this.importo = nuovoImporto;
        }
    }

    // Getter e setter beneficiario
    public String getBeneficiario() {
        return this.beneficiario;
    }

    public void setBeneficiario(String nuovoBeneficiario) {
        if (nuovoBeneficiario != null) {
            this.beneficiario = nuovoBeneficiario;
        }
    }
}
