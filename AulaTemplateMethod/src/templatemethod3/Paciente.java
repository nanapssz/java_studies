package templatemethod3;

import java.time.LocalDate;
import java.util.Map;

public class Paciente {
	private final String nome;
	private final String plano; // BASICO, EXECUTIVO, PREMIUM
	private final LocalDate dataAssociacao;
	private final boolean mensalidadeEmDia;
	private final Map<String, Integer> usosPorAnoServico; // quantidade usada no ano

	public Paciente(String nome, String plano, LocalDate dataAssociacao, boolean mensalidadeEmDia,
			Map<String, Integer> usosPorAnoServico) {
		this.nome = nome;
		this.plano = plano;
		this.dataAssociacao = dataAssociacao;
		this.mensalidadeEmDia = mensalidadeEmDia;
		this.usosPorAnoServico = usosPorAnoServico;
	}

	public String getNome() {
		return nome;
	}

	public String getPlano() {
		return plano;
	}

	public LocalDate getDataAssociacao() {
		return dataAssociacao;
	}

	public boolean isMensalidadeEmDia() {
		return mensalidadeEmDia;
	}

	public int getUsosAno(String servico) {
		return usosPorAnoServico.getOrDefault(servico, 0);
	}
}
