package br.com.caelum.financas.dao;

import java.util.List;

import br.com.caelum.financas.modelo.Gerente;

public interface Gerentes {

	List<Gerente> lista();

	void cadastra(Gerente gerente);

	void atualiza(Gerente gerente);

}
