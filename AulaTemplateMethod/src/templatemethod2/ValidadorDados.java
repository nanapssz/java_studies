package templatemethod2;

import java.util.ArrayList;
import java.util.List;

public abstract class ValidadorDados {

    public final ResultadoValidacao validar(List<String> lines) {
        List<String> data = loadData(lines);
        List<String> formatErrors = validarFormato(data);
        List<String> businessErrors = validarRegrasNegocio(data);
        List<String> allErrors = new ArrayList<>();
        allErrors.addAll(formatErrors);
        allErrors.addAll(businessErrors);
        return new ResultadoValidacao(allErrors.isEmpty(), allErrors);
    }

    protected List<String> loadData(List<String> lines) {

    	// Ignora linhas vazias e comentarios
        List<String> result = new ArrayList<>();
        for (String line : lines) {
            if (line != null && !line.trim().isEmpty() && !line.trim().startsWith("#")) {
                result.add(line.trim());
            }
        }
        return result;
    }

    protected abstract List<String> validarFormato(List<String> data);
    protected abstract List<String> validarRegrasNegocio(List<String> data);
}
