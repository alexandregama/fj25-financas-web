package br.com.caelum.financas.dao;

import java.util.List;
import java.util.Optional;

import br.com.caelum.financas.modelo.Categoria;

public interface Categorias {

	List<Categoria> lista();

	Optional<Categoria> buscaPor(Long categoriaId);

	void salva(Categoria categoria);

	void remove(Categoria categoria);

}
