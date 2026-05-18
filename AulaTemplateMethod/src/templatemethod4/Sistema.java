package templatemethod4;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

public class Sistema {
    public static void main(String[] args) {
        // Criando alguns serviços utilizados
        List<ServicoUtilizado> servicos = new ArrayList<>();

        // Chamada local: 120 minutos (ganha desconto de 10%)
        servicos.add(new ServicoUtilizado(
            ETipoServico.CHAMADA_LOCAL,
            LocalDateTime.now(),
            120,
            0,
            0
        ));

        // Chamada local: 30 minutos (sem desconto)
        servicos.add(new ServicoUtilizado(
            ETipoServico.CHAMADA_LOCAL,
            LocalDateTime.now(),
            30,
            0,
            0
        ));

        // Chamada longa distância: 60 minutos (desconto de 15%)
        servicos.add(new ServicoUtilizado(
            ETipoServico.CHAMADA_LD,
            LocalDateTime.now(),
            60,
            0,
            0
        ));

        // SMS: 250 mensagens (desconto de 20%)
        servicos.add(new ServicoUtilizado(
            ETipoServico.SMS,
            LocalDateTime.now(),
            0,
            250,
            0
        ));

        // Internet: 6000 MB (desconto de 5%)
        servicos.add(new ServicoUtilizado(
            ETipoServico.INTERNET,
            LocalDateTime.now(),
            0,
            0,
            6000
        ));

        // Internet: 1000 MB (sem desconto)
        servicos.add(new ServicoUtilizado(
            ETipoServico.INTERNET,
            LocalDateTime.now(),
            0,
            0,
            1000
        ));

        // Calculando a fatura
        FaturaService faturaService = new FaturaService();
        double total = faturaService.calcularTotalFatura(servicos);
        double totalIcms = 0;

        // Exibindo resultados detalhados
        System.out.println("=== DETALHAMENTO DA FATURA ===\n");
        for (int i = 0; i < servicos.size(); i++) {
            ServicoUtilizado s = servicos.get(i);
            double valor = faturaService.calcularValorServico(s);
            System.out.printf("Servico %d: %s\n", i+1, s.getTipo());
            switch (s.getTipo()) {
                case CHAMADA_LOCAL:
                    System.out.printf("  Minutos: %d\n", s.getTempoMinutos());
                    break;
                case CHAMADA_LD:
                    System.out.printf("  Minutos: %d\n", s.getTempoMinutos());
                    break;
                case SMS:
                    System.out.printf("  Quantidade: %d\n", s.getQuantidade());
                    break;
                case INTERNET:
                    System.out.printf("  Dados: %d MB\n", s.getDadosMegabytes());
                    break;
            }
            System.out.printf("  Valor final (com ICMS): R$ %.2f\n\n", valor);
            totalIcms += 0; // nao consigo resolver
        }

        System.out.printf("=== TOTAL DO ICMS: R$ %.2f ===\n", totalIcms); // nao consigo resolver
        System.out.printf("=== TOTAL DA FATURA: R$ %.2f ===\n", total);
    }
}
