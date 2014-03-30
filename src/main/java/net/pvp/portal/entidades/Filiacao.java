package net.pvp.portal.entidades;

// Generated 19/03/2014 20:53:07 by Hibernate Tools 3.4.0.CR1

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * Filiacao generated by hbm2java
 */
@Entity
@Table(name = "filiacao", catalog = "pvp_db")
public class Filiacao implements java.io.Serializable {

	private int codigo;
	private Cidade cidade;
	private Partido partido;
	private Candidato candidato;
	private char indAtiva;

	public Filiacao() {
	}

	public Filiacao(Cidade cidade, Partido partido, Candidato candidato,
			char indAtiva) {
		this.cidade = cidade;
		this.partido = partido;
		this.candidato = candidato;
		this.indAtiva = indAtiva;
	}

	@Id
	@GeneratedValue(strategy = IDENTITY)
	@Column(name = "codigo", unique = true, nullable = false)
	public int getCodigo() {
		return this.codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_cidade", nullable = false)
	public Cidade getCidade() {
		return this.cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_partido", nullable = false)
	public Partido getPartido() {
		return this.partido;
	}

	public void setPartido(Partido partido) {
		this.partido = partido;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_candidato", nullable = false)
	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@Column(name = "ind_ativa", nullable = false, length = 1)
	public char getIndAtiva() {
		return this.indAtiva;
	}

	public void setIndAtiva(char indAtiva) {
		this.indAtiva = indAtiva;
	}

}
