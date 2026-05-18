package templatemethod3;

import java.util.ArrayList;
import java.util.List;

public abstract class AutorizarServico {

    public final Autorizacao autorizar(SolicitacaoServico solicitacao) {
        List<String> log = new ArrayList<>();

        // Passo 1: Cobertura do plano para o servicvo e especialidade
        if (!verificarCobertura(solicitacao, log)) {
            return new Autorizacao(false, String.join("; ", log), 0.0);
        }

        // Passo 2: Carencia
        if (!verificarCarencia(solicitacao, log)) {
            return new Autorizacao(false, String.join("; ", log), 0.0);
        }

        // Passo 3: Limite anual
        if (!verificarLimiteAnual(solicitacao, log)) {
            return new Autorizacao(false, String.join("; ", log), 0.0);
        }

        // Passo 4: Mensalidades em dia
        if (!verificarMensalidades(solicitacao, log)) {
            return new Autorizacao(false, String.join("; ", log), 0.0);
        }

        // Passo 5: Calcular valor a pagar ao prestador
        double valor = calcularValorPrestador(solicitacao);
        log.add("Valor calculado: R$ " + valor);

        return new Autorizacao(true, String.join("; ", log), valor);
    }

    // Metodo com implementacao padrao que pode ser sobrescrita
    protected boolean verificarMensalidades(SolicitacaoServico solicitacao, List<String> log) {
        if (!solicitacao.getPaciente().isMensalidadeEmDia()) {
            log.add("Mensalidade em atraso");
            return false;
        }
        return true;
    }

    protected abstract boolean verificarCobertura(SolicitacaoServico solicitacao, List<String> log);
    protected abstract boolean verificarCarencia(SolicitacaoServico solicitacao, List<String> log);
    protected abstract boolean verificarLimiteAnual(SolicitacaoServico solicitacao, List<String> log);
    protected abstract double calcularValorPrestador(SolicitacaoServico solicitacao);
}