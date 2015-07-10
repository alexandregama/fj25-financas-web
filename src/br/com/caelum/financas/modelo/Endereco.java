package br.com.caelum.financas.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	public final String rua;

	public final String cidade;

	public final String estado;
	
	public Endereco(String rua, String cidade, String estado) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}

	public String getRua() {
		return rua;
	}

	public String getCidade() {
		return cidade;
	}

	public String getEstado() {
		return estado;
	}

}