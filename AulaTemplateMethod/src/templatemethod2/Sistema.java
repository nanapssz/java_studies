package templatemethod2;

import java.util.Arrays;
import java.util.List;

public class Sistema {
	
    public static void main(String[] args) {
        // Dados de exemplo
        List<String> clientes = Arrays.asList(
            "Joao Silva;25;123.456.789-00",
            "Maria;17;x987.654.321-00",
            "Ana;30;cpf_invalido"
        );

        List<String> produtos = Arrays.asList(
            "001;Smartphone;999.99;10",
            "002;TV 50\";,-200;5",        // formato invalido
            "003;PC;1500.00;-1",          // nome muito curto e estoque negativo
            "004;XY;50.00;20"             // nome muito curto
        );

        System.out.println("--- Valida\u00e7\u00e3o de Clientes ---");
        ValidadorDados cv = new ValidadorCliente();
        ResultadoValidacao r1 = cv.validar(clientes);
        System.out.println(r1);

        
        System.out.println("\n--- Validação de Produtos ---");
        ValidadorDados pv = new ValidadorProduto();
        ResultadoValidacao r2 = pv.validar(produtos);
        System.out.println(r2);
        
    }
}