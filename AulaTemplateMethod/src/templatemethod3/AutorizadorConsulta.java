/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package templatemethod3;

import java.util.List;

/**
 *
 * @author 02464024236
 */
public class AutorizadorConsulta extends AutorizarServico {

    @Override
    protected boolean verificarCobertura(SolicitacaoServico solicitacao, List<String> log) {
        return true;
    }

    @Override
    protected boolean verificarCarencia(SolicitacaoServico solicitacao, List<String> log) {
        return true;
    }

    @Override
    protected boolean verificarLimiteAnual(SolicitacaoServico solicitacao, List<String> log) {
        return true;
    }

    @Override
    protected double calcularValorPrestador(SolicitacaoServico solicitacao) {
        return 0.0;
    }
    
}
