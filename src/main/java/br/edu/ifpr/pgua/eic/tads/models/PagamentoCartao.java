package br.edu.ifpr.pgua.eic.tads.models;

import br.edu.ifpr.pgua.eic.tads.models.abstracts.Pagamento;

public class PagamentoCartao extends Pagamento {
    private Double valor;

    @Override
    public void processarPagamento(){
        System.out.println("pagamento com cartão crédito");
    }
}
