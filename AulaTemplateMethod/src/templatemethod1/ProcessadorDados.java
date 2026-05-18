package templatemethod1;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.List;

public abstract class ProcessadorDados {

    protected FileReader arquivo;

    public final void processar(String filePath) throws Exception {
        abrirArquivo(filePath);
        List<String> rawData = lerDados();
        List<String> metrics = processarDados(rawData);
        gerarRelatorio(metrics);
        fecharArquivo();
    }

    private void abrirArquivo(String filePath) throws FileNotFoundException {
        
        arquivo = new FileReader(filePath);
    }

    private void fecharArquivo() throws IOException {
        
    	arquivo.close();
    	
    }

    private void gerarRelatorio(List<String> metrics) {
        System.out.println("=== RELAT\u00D3RIO ===");
        for (var item : metrics) {
            System.out.println(item);
        }
        System.out.println("================");
    }

    
    protected abstract List<String> lerDados();

    protected abstract List<String> processarDados(List<String> rawData);
}

