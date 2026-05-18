package templatemethod2;

import java.util.List;

public class ResultadoValidacao {
    private final boolean valid;
    private final List<String> errors;

    public ResultadoValidacao(boolean valid, List<String> errors) {
        this.valid = valid;
        this.errors = errors;
    }

    public boolean isValid() { return valid; }
    public List<String> getErrors() { return errors; }

    @Override
    public String toString() {
        if (valid) 
        	return "V\u00C1LIDO: nenhum erro encontrado.";
        else
        	return "INV\u00C1LIDO:\n" + String.join("\n", errors);
    }
}