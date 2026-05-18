package templatemethod3;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.Map;

public class Sistema {
	
    public static void main(String[] args) {
        
    	// Pacientes
        Map<String, Integer> usosJoao = new HashMap<>();
        usosJoao.put("CONSULTA", 10); // ja usou 10 consultas no ano
        Paciente joao = new Paciente("Joao", "EXECUTIVO", LocalDate.now().minusDays(20), true, usosJoao);

        Map<String, Integer> usosMaria = new HashMap<>();
        usosMaria.put("CIRURGIA", 1); // ja usou 1 cirurgia no ano
        Paciente maria = new Paciente("Maria", "PREMIUM", LocalDate.now().minusMonths(7), true, usosMaria);

        Paciente ana = new Paciente("Ana", "BASICO", LocalDate.now().minusDays(10), false, new HashMap<>());

        // Prestadores
        Prestador cardiologista = new Prestador("Dr. Silva", "CARDIOLOGIA");
        Prestador fisioterapeuta = new Prestador("Dra. Clara", "FISIOTERAPIA");
        Prestador cirurgiao = new Prestador("Dr. Joseh", "CIRURGIA GERAL");

        // Solicitacoes
        SolicitacaoServico s1 = new SolicitacaoServico(joao, cardiologista, "CONSULTA", LocalDate.now());
        SolicitacaoServico s2 = new SolicitacaoServico(joao, fisioterapeuta, "CONSULTA", LocalDate.now());
        SolicitacaoServico s3 = new SolicitacaoServico(maria, cirurgiao, "CIRURGIA", LocalDate.now());
        SolicitacaoServico s4 = new SolicitacaoServico(ana, cardiologista, "CONSULTA", LocalDate.now());

        /*
        System.out.println("--- Teste Autoriza\u00e7\u00e3o Consulta ---");
        AutorizarServico autorizadorConsulta = new AutorizadorConsulta(); 
        System.out.println("Joao com cardiologista: " + autorizadorConsulta.autorizar(s1));
        System.out.println("Joao com fisioterapeuta: " + autorizadorConsulta.autorizar(s2));
        System.out.println("Ana (mensalidade atrasada): " + autorizadorConsulta.autorizar(s4));

        System.out.println("\n--- Teste Autoriza\u00e7\u00e3o Cirurgia ---");
        AutorizarServico autorizadorCirurgia = new AutorizadorCirurgia(); 
        System.out.println("Maria com cirurgiao: " + autorizadorCirurgia.autorizar(s3));
        */
        
        /*
         SAIDA ESPERADA: 
        --- Teste Autorização Consulta ---
        João com cardiologista: AUTORIZADA - Valor a pagar ao prestador: R$ 80,00
        Justificativa: Cobertura ok; Carência ok; Limite anual ok (usou 10/12); Mensalidade em dia; Valor calculado: R$ 80.0

        João com fisioterapeuta: NEGADA - Justificativa: Especialidade FISIOTERAPIA não coberta para consulta

        Ana (mensalidade atrasada): NEGADA - Justificativa: Cobertura ok; Carência não atendida (mínimo 30 dias, associada há 10 dias); Mensalidade em atraso

        --- Teste Autorização Cirurgia ---
        Maria com cirurgião: AUTORIZADA - Valor a pagar ao prestador: R$ 3000,00
        Justificativa: Cobertura ok; Carência ok; Limite anual ok (usou 1/2); Mensalidade em dia; Valor calculado: R$ 3000.0
        */
    }
}