package br.com.caelum.financas.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	public String rua;

	public String cidade;

	public String estado;

	public Endereco(String rua, String cidade, String estado) {
		this.rua = rua;
		this.cidade = cidade;
		this.estado = estado;
	}
	
	public Endereco() {
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

	public void setRua(String rua) {
		this.rua = rua;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}