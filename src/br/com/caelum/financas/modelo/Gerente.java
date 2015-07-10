package br.com.caelum.financas.modelo;

import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Gerente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	private String nome;
	
	private String telefone;
	
	@Embedded
	private Endereco data;

	public Long getId() {
		return id;
	}

	public String getNome() {
		return nome;
	}

	public String getTelefone() {
		return telefone;
	}

	public String getRua() {
		return data.rua;
	}

	public String getCidade() {
		return data.cidade;
	}

	public String getEstado() {
		return data.estado;
	}
	
}
