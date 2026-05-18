package templatemethod2;

import java.util.ArrayList;
import java.util.List;

public class ValidadorCliente extends ValidadorDados {

    @Override
    protected List<String> validarFormato(List<String> data) {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(";");
            if (parts.length != 3) {
                errors.add("Linha " + (i+1) + ": formato inválido (esperado: nome;idade;cpf) - recebido: " + line);
            }
        }
        return errors;
    }

    @Override
    protected List<String> validarRegrasNegocio(List<String> data) {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String[] parts = data.get(i).split(";");
            if (parts.length < 3) continue;

            String nome = parts[0];
            int idade = Integer.parseInt(parts[1]);
            String cpf = parts[2];

            if (nome == null || nome.trim().isEmpty()) {
                errors.add("Linha " + (i+1) + ": nome não pode ser vazio.");
            }
            if (idade < 18) {
                errors.add("Linha " + (i+1) + ": cliente menor de idade (" + idade + " anos).");
            }
            if (!isValidCPF(cpf)) {
                errors.add("Linha " + (i+1) + ": CPF inválido (" + cpf + ").");
            }
        }
        return errors;
    }

    private boolean isValidCPF(String cpf) {
        // Implementacao simplificada 
        return cpf != null && cpf.matches("\\d{3}\\.\\d{3}\\.\\d{3}-\\d{2}");
    }
}
