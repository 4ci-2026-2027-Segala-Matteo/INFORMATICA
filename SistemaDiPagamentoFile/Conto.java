package SistemaDiPagamentoFile;

public class Conto {
    private String intestatario;
    private double saldo;

    // Costruttore con parametri
    public Conto(String intest, double s) {
        if (intest != null) {
            this.intestatario = intest;
        } else {
            this.intestatario = "";
        }

        if (s >= 0) {
            this.saldo = s;
        } else {
            this.saldo = 0.0;
        }
    }
    

    // Costruttore di default
    public Conto() {
        this.intestatario = "";
        this.saldo = 0.0;
    }

    // Effettua un pagamento scalandolo dal saldo
    public void effettuaPagamento(Pagamento pagamento) throws SaldoInsufficienteException {
        if (pagamento == null) {
            throw new IllegalArgumentException("Il pagamento non può essere vuoto");
        }

        double costo = pagamento.getImporto();

        if (costo <= 0) {
            throw new IllegalArgumentException("L'importo del pagamento deve essere maggiore di 0");
        }

        if (this.saldo < costo) {
            throw new SaldoInsufficienteException("Saldo insufficiente per pagare " + pagamento.getBeneficiario()
                    + ". \nSaldo attuale: " + this.saldo
                    + "€. \nImporto da pagare: " + costo + "€.");
        }

        this.saldo -= costo;
        System.out.println("Pagamento effettuato. \nBeneficiario: " + pagamento.getBeneficiario()
                + "." + "\nImporto pagato: " + costo + "€.\n");
    }

    // Rappresentazione testuale
    public String toString() {
        return "Conto di: " + this.intestatario + "\nSaldo attuale: " + this.saldo + "€";
    }

    // Getter e setter saldo
    public double getSaldo() {
        return this.saldo;
    }

    public void setSaldo(double nuovoSaldo) {
        if (nuovoSaldo >= 0) {
            this.saldo = nuovoSaldo;
        }
    }

    // Getter e setter intestatario
    public String getIntestatario() {
        return this.intestatario;
    }

    public void setIntestatario(String nuovoNome) {
        if (nuovoNome != null) {
            this.intestatario = nuovoNome;
        }
    }
}