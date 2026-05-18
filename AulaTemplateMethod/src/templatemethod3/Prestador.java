package templatemethod3;

public class Prestador {
	private final String nome;
	private final String especialidade; // ex: "CARDIOLOGIA", "FISIOTERAPIA", "CIRURGIA GERAL"

	public Prestador(String nome, String especialidade) {
		this.nome = nome;
		this.especialidade = especialidade;
	}
	
	public String getNome() {
		return nome;
	}

	public String getEspecialidade() {
		return especialidade;
	}
}

