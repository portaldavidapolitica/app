package net.pvp.portal.entidades;

// Generated 19/03/2014 20:53:07 by Hibernate Tools 3.4.0.CR1

import java.util.HashSet;
import java.util.Set;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 * Cidade generated by hbm2java
 */
@Entity
@Table(name = "cidade", catalog = "pvp_db")
public class Cidade implements java.io.Serializable {

	private int codigo;
	private Estado estado;
	private String nome;
	private Set<Filiacao> filiacaos = new HashSet<Filiacao>(0);

	public Cidade() {
	}

	public Cidade(Estado estado, String nome) {
		this.estado = estado;
		this.nome = nome;
	}

	public Cidade(Estado estado, String nome, Set<Filiacao> filiacaos) {
		this.estado = estado;
		this.nome = nome;
		this.filiacaos = filiacaos;
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
	@JoinColumn(name = "cod_estado", nullable = false)
	public Estado getEstado() {
		return this.estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Column(name = "nome", nullable = false, length = 50)
	public String getNome() {
		return this.nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "cidade")
	public Set<Filiacao> getFiliacaos() {
		return this.filiacaos;
	}

	public void setFiliacaos(Set<Filiacao> filiacaos) {
		this.filiacaos = filiacaos;
	}

}
