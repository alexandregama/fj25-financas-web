package br.com.caelum.financas.mb;

import java.util.List;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;

public interface Movimentacoes {

	void adiciona(Movimentacao movimentacao);
	
	Movimentacao busca(Integer id);
	
	List<Movimentacao> lista();
	
	void remove(Movimentacao movimentacao);
	
	List<Movimentacao> buscaPorConta(Conta conta);
}
