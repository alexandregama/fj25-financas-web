package br.com.caelum.financas.modelo;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import javax.persistence.Cacheable;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import javax.persistence.Version;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;

@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"agencia", "numero"})})
@Entity
@Cacheable
public class Conta implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;
	private String titular;
	private String agencia;
	private String numero;
	
	@Column(name = "banco", nullable = false, length = 20)
	private String banco;
	
	@Version
	private Integer versao;
	
	@OneToMany(mappedBy = "conta")
	@Cache(usage = CacheConcurrencyStrategy.TRANSACTIONAL)
	private List<Movimentacao> movimentacoes;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getTitular() {
		return titular;
	}

	public void setTitular(String titular) {
		this.titular = titular;
	}

	public String getAgencia() {
		return agencia;
	}

	public void setAgencia(String agencia) {
		this.agencia = agencia;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getBanco() {
		return banco;
	}

	public void setBanco(String banco) {
		this.banco = banco;
	}
	
	public List<Movimentacao> getMovimentacoes() {
		return Collections.unmodifiableList(movimentacoes);
	}

	public int quantidadeDeMovimentacoes() {
		return this.movimentacoes.size();
	}

}
