package templatemethod4;

import java.time.LocalDateTime;

public class ServicoUtilizado {
    private ETipoServico tipo;
    private LocalDateTime dataHora;
    private int tempoMinutos;      // para chamadas
    private int quantidade;        // para SMS (numero de mensagens)
    private long dadosMegabytes;   // para internet

    public ServicoUtilizado(ETipoServico tipo, LocalDateTime dataHora, int tempoMinutos, int quantidade, long dadosMegabytes) {
        this.tipo = tipo;
        this.dataHora = dataHora;
        this.tempoMinutos = tempoMinutos;
        this.quantidade = quantidade;
        this.dadosMegabytes = dadosMegabytes;
    }

    public ETipoServico getTipo() { return tipo; }
    public LocalDateTime getDataHora() { return dataHora; }
    public int getTempoMinutos() { return tempoMinutos; }
    public int getQuantidade() { return quantidade; }
    public long getDadosMegabytes() { return dadosMegabytes; }
}

