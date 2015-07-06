package br.com.caelum.financas.mb;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import br.com.caelum.financas.modelo.Conta;
import br.com.caelum.financas.modelo.Movimentacao;
import br.com.caelum.financas.modelo.TipoMovimentacao;

public interface Movimentacoes {

	void adiciona(Movimentacao movimentacao);
	
	Movimentacao busca(Integer id);
	
	List<Movimentacao> lista();
	
	void remove(Movimentacao movimentacao);
	
	List<Movimentacao> buscaPorConta(Conta conta);
	
	List<Movimentacao> listaPorValorETipo(BigDecimal valor, TipoMovimentacao tipo);

	Optional<BigDecimal> valorTotalDa(Conta conta);

	List<Movimentacao> listaPorTitular(String titular);

	List<ValorPorMesEAno> listaMesesComMovimentacoes();

	List<ValorPorMesEAno> listaMesesComMovimentacoesPorContaETipo(Conta conta,
			TipoMovimentacao tipoMovimentacao);

	List<ValorPorMesEAno> listaMesesComMovimentacoesPorContaETipoETotalMinimo(
			Conta conta, TipoMovimentacao tipoMovimentacao, BigDecimal totalMinimo);

	List<Movimentacao> listaMovimentacoesPorCriteria();
	
}
