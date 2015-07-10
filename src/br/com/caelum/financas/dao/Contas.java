package br.com.caelum.financas.dao;

import java.util.List;

import br.com.caelum.financas.modelo.Conta;

public interface Contas {

	void adiciona(Conta conta) throws AgenciaEmBrancoException;

	Conta busca(Integer id);

	List<Conta> lista();

	void remove(Conta conta);

	void atualiza(Conta conta);

	List<Conta> buscaPorTitularCriteria(String titular);

}
