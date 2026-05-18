package templatemethod3;

import java.time.LocalDate;

//Solicitação de serviço
class SolicitacaoServico {
	private final Paciente paciente;
	private final Prestador prestador;
	private final String servico; // "CONSUTA", "CIRURGIA", "RAIO-X", etc.
	private final LocalDate dataSolicitacao;

	public SolicitacaoServico(Paciente paciente, Prestador prestador, String servico, LocalDate dataSolicitacao) {
		this.paciente = paciente;
		this.prestador = prestador;
		this.servico = servico;
		this.dataSolicitacao = dataSolicitacao;
	}

	public Paciente getPaciente() {
		return paciente;
	}

	public Prestador getPrestador() {
		return prestador;
	}

	public String getServico() {
		return servico;
	}

	public LocalDate getDataSolicitacao() {
		return dataSolicitacao;
	}
}

