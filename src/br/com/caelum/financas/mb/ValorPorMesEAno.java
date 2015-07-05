package br.com.caelum.financas.mb;

import java.math.BigDecimal;

public class ValorPorMesEAno {

	private final int ano;

	private final int mes;

	private final BigDecimal total;

	public ValorPorMesEAno(int ano, int mes, BigDecimal total) {
		this.ano = ano;
		this.mes = mes;
		this.total = total;
	}

	public int getAno() {
		return ano;
	}

	public int getMes() {
		return mes;
	}

	public BigDecimal getTotal() {
		return total;
	}

}
