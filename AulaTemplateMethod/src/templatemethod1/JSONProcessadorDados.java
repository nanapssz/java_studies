package templatemethod1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class JSONProcessadorDados extends ProcessadorDados {

	@Override
	protected List<String> lerDados() {
		List<String> lines = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(arquivo)) {
			String line;
			while ((line = br.readLine()) != null) {
				lines.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return lines;
	}

	@Override
	protected List<String> processarDados(List<String> rawData) {
		
		double total = 0.0;
		int count = 0;
		for (String json : rawData) {
			// Simulacao simples de parse
			// Em projetos reais use as bibliotecas Jackson/Gson
			String precoStr = json.replaceAll(".*\"preco\":([0-9]+).*", "$1");
			String qtdStr = json.replaceAll(".*\"qtd\":([0-9]+).*", "$1");
			double preco = Double.parseDouble(precoStr);
			int qtd = Integer.parseInt(qtdStr);
			total += preco * qtd;
			count++;
		}
		
		List<String> metrics = new ArrayList<>();

		metrics.add("Total de Vendas (R$) : " + total);
		metrics.add("Quantidade Total de Itens : " + (double) count);
		
		return metrics;
	}
}
