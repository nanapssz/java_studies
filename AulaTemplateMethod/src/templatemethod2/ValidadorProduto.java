/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templatemethod2;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author 02464024236
 */
public class ValidadorProduto extends ValidadorDados {

    @Override
    protected List<String> validarFormato(List<String> data) {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String line = data.get(i);
            String[] parts = line.split(";");
            if (parts.length != 4) {
                errors.add("Linha " + (i+1) + ": formato inválido (esperado: codigo;nome;preco;estoque) - recebido: " + line);
            }
        }
        return errors;
    }

    @Override
    protected List<String> validarRegrasNegocio(List<String> data) {
        List<String> errors = new ArrayList<>();
        for (int i = 0; i < data.size(); i++) {
            String[] parts = data.get(i).split(";");
            if (parts.length < 4) continue;

            String codigo = parts[0];
            String nome = parts[1];
            String preco = parts[2];
            int estoque = Integer.parseInt(parts[3]);
            
            if (codigo == null || codigo.trim().isEmpty()) {
                errors.add("Linha " + (i+1) + ": Codigo não pode ser vazio!(" + codigo + ")");
            }
            if (nome == null || nome.trim().isEmpty() || nome.length() < 3) {
                errors.add("Linha " + (i+1) + ": Nome não pode ser vazio ou com menos de três letras!(" + nome + ")");
            }
            if (ehDecimal(preco)) {
                if (Float.parseFloat(preco) < 0) {
                    errors.add("Linha " + (i+1) + ": Preço menor que zero!(" + preco + ")");
                }    
            } else {
                errors.add("Linha " + (i+1) + ": Preço nao esta no formato decimal com ponto!(" + preco + ")");
            }
            if (estoque < 1) {
                errors.add("Linha " + (i+1) + ": Estoque menor ou igual a zero! (" + estoque + ")");
            }
        }
        return errors;
    }
    
    public static boolean ehDecimal(String valor) {
        String regex = "^[-+]?\\d*\\.\\d+$";
        return valor != null && valor.matches(regex);
    }    
}
