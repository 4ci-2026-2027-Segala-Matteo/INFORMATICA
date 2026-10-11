package SistemaDiPagamentoFile;

public class SaldoInsufficienteException extends Exception{
    public SaldoInsufficienteException (String messaggio) {
        super(messaggio);
    }
}
