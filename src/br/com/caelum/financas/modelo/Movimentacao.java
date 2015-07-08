package br.com.caelum.financas.modelo;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
@Cacheable
public class Movimentacao implements Serializable {
 
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Integer id;
	private String descricao;
	private Calendar data;
	private BigDecimal valor;
	
	@ManyToOne 
	private Conta conta;
	
	@Enumerated(EnumType.STRING)
	private TipoMovimentacao tipoMovimentacao;
	
	@ManyToMany
	private List<Categoria> categorias = new ArrayList<>();
	
	@Override
	public String toString() {
		return "Movimentacao [id=" + id + ", descricao=" + descricao
				+ ", data=" + data + ", valor=" + valor + ", conta=" + conta
				+ ", tipoMovimentacao=" + tipoMovimentacao + "]";
	}
	
	public void adiciona(Categoria categoria) {
		categorias.add(categoria);
	}

	public TipoMovimentacao getTipoMovimentacao() {
		return tipoMovimentacao;
	}

	public void setTipoMovimentacao(TipoMovimentacao tipoMovimentacao) {
		this.tipoMovimentacao = tipoMovimentacao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Calendar getData() {
		return data;
	}

	public void setData(Calendar data) {
		this.data = data;
	}

	public BigDecimal getValor() {
		return valor;
	}

	public void setValor(BigDecimal valor) {
		this.valor = valor;
	}

	public Conta getConta() {
		return conta;
	}

	public void setConta(Conta conta) {
		this.conta = conta;
	}

	public boolean isValorNegativo() {
		return this.valor.compareTo(BigDecimal.ZERO) < 0;
	}
	
	public List<Categoria> getCategorias() {
		return categorias;
	}

}
