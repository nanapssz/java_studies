package templatemethod1;

import java.io.BufferedReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class CSVProcessadorDados extends ProcessadorDados {

 @Override
 protected List<String> lerDados() {
     List<String> lines = new ArrayList<>();
     String line;
     try {
         try (BufferedReader br = new BufferedReader(arquivo)) {
             while ((line = br.readLine()) != null) {
                 lines.add(line);
             }
         }
     } catch (IOException e) {
         e.printStackTrace();
     }
     return lines; }

 @Override
 protected List<String> processarDados(List<String> rawData) {
     double total = 0.0;
     int count = 0;
     for (String line : rawData) {
         String[] parts = line.split(",");
         if (parts.length >= 3) {
             double valor = Double.parseDouble(parts[1]);
             int quantidade = Integer.parseInt(parts[2]);
             total += valor * quantidade;
             count++;
         }
     }
     List<String> metrics = new ArrayList<>();
     
     metrics.add("Total de Vendas (R$) : " + total);
     metrics.add("M\u00E9dia por Produto (R$) : " + String.format("%.2f", count > 0 ? total / count : 0));
     
     return metrics;
 }
}

