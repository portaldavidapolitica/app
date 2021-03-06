package net.pvp.portal.entidades;

// Generated 19/03/2014 20:53:07 by Hibernate Tools 3.4.0.CR1

import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import static javax.persistence.GenerationType.IDENTITY;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

/**
 * Postagem generated by hbm2java
 */
@Entity
@Table(name = "postagem", catalog = "pvp_db")
public class Postagem implements java.io.Serializable {

	private int codigo;
	private Usuario usuario;
	private Candidato candidato;
	private Status status;
	private String titulo;
	private String descricao;
	private String fonte;
	private Date dataInclusao;

	public Postagem() {
	}

	public Postagem(String titulo, String descricao, String fonte,
			Date dataInclusao) {
		this.titulo = titulo;
		this.descricao = descricao;
		this.fonte = fonte;
		this.dataInclusao = dataInclusao;
	}

	public Postagem(Usuario usuario, Candidato candidato, Status status,
			String titulo, String descricao, String fonte, Date dataInclusao) {
		this.usuario = usuario;
		this.candidato = candidato;
		this.status = status;
		this.titulo = titulo;
		this.descricao = descricao;
		this.fonte = fonte;
		this.dataInclusao = dataInclusao;
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
	@JoinColumn(name = "cod_usuario")
	public Usuario getUsuario() {
		return this.usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_candidato")
	public Candidato getCandidato() {
		return this.candidato;
	}

	public void setCandidato(Candidato candidato) {
		this.candidato = candidato;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_status")
	public Status getStatus() {
		return this.status;
	}

	public void setStatus(Status status) {
		this.status = status;
	}

	@Column(name = "titulo", nullable = false)
	public String getTitulo() {
		return this.titulo;
	}

	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	@Column(name = "descricao", nullable = false)
	public String getDescricao() {
		return this.descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	@Column(name = "fonte", nullable = false, length = 65535)
	public String getFonte() {
		return this.fonte;
	}

	public void setFonte(String fonte) {
		this.fonte = fonte;
	}

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name = "data_inclusao", nullable = false, length = 19)
	public Date getDataInclusao() {
		return this.dataInclusao;
	}

	public void setDataInclusao(Date dataInclusao) {
		this.dataInclusao = dataInclusao;
	}

}
