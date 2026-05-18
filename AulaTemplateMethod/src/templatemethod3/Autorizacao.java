package templatemethod3;

public class Autorizacao {
    private final boolean autorizada;
    private final String justificativa;
    private final double valorPagoPrestador;

    public Autorizacao(boolean autorizada, String justificativa, double valorPagoPrestador) {
        this.autorizada = autorizada;
        this.justificativa = justificativa;
        this.valorPagoPrestador = valorPagoPrestador;
    }

    public boolean isAutorizada() { return autorizada; }
    public String getJustificativa() { return justificativa; }
    public double getValorPagoPrestador() { return valorPagoPrestador; }

    @Override
    public String toString() {
        if (autorizada) {
            return String.format("AUTORIZADA - Valor a pagar ao prestador: R$ %.2f\nJustificativa: %s",
                    valorPagoPrestador, justificativa);
        } else {
            return String.format("NEGADA - Justificativa: %s", justificativa);
        }
    }
}
