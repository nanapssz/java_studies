package templatemethod4;
import java.util.List;

public class FaturaService {

    private static final double ICMS_LOCAL = 0.18;
    private static final double ICMS_LD = 0.25;
    private static final double ICMS_SMS = 0.15;
    private static final double ICMS_INTERNET = 0.20;

    public double calcularValorServico(ServicoUtilizado servico) {
        double valorBruto = 0.0;
        double icms = 0.0;

        switch (servico.getTipo()) {
            case CHAMADA_LOCAL:
                valorBruto = servico.getTempoMinutos() * 0.50; // R$ 0,50 por minuto
                icms = ICMS_LOCAL;
                if (servico.getTempoMinutos() > 100) {
                    valorBruto = valorBruto * 0.90; // desconto de 10% acima de 100 min
                }
                break;
            case CHAMADA_LD:
                valorBruto = servico.getTempoMinutos() * 1.20; // R$ 1,20 por minuto
                icms = ICMS_LD;
                if (servico.getTempoMinutos() > 50) {
                    valorBruto = valorBruto * 0.85; // desconto de 15% acima de 50 min
                }
                break;
            case SMS:
                valorBruto = servico.getQuantidade() * 0.10; // R$ 0,10 por SMS
                icms = ICMS_SMS;
                if (servico.getQuantidade() > 200) {
                    valorBruto = valorBruto * 0.80; // desconto de 20% acima de 200 SMS
                }
                break;
            case INTERNET:
                valorBruto = servico.getDadosMegabytes() * 0.05; // R$ 0,05 por MB
                icms = ICMS_INTERNET;
                if (servico.getDadosMegabytes() > 5000) {
                    valorBruto = valorBruto * 0.95; // desconto de 5% acima de 5GB
                }
                break;
            default:
                throw new IllegalArgumentException("Tipo de serviço desconhecido");
        }

        double valorComIcms = valorBruto * (1 + icms);
        return valorComIcms;
    }

    public double calcularTotalFatura(List<ServicoUtilizado> servicos) {
        double total = 0.0;
        for (ServicoUtilizado s : servicos) {
            total += calcularValorServico(s);
        }
        return total;
    }
}