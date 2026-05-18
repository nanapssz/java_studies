package templatemethod1;

public class Sistema {
	public static void main(String[] args) throws Exception {
		
		System.out.println("--- Processando arquivo CSV ---");
		ProcessadorDados csvProcessor = new CSVProcessadorDados();
		csvProcessor.processar("dados.csv");

		System.out.println("\n--- Processando arquivo JSON ---");
		ProcessadorDados jsonProcessor = new JSONProcessadorDados();
		jsonProcessor.processar("dados.json");
	}
}
