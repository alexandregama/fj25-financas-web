package br.com.caelum.financas.modelo;

import javax.persistence.Embeddable;

@Embeddable
public class Endereco {

	public String rua;

	public String cidade;

	public String estado;

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

}