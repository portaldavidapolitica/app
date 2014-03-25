package net.pvp.portal.entidades;

// Generated 25/03/2014 20:13:13 by Hibernate Tools 3.4.0.CR1

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/**
 * PermissaoUsuario generated by hbm2java
 */
@Entity
@Table(name = "permissao_usuario", catalog = "pvp_db")
public class PermissaoUsuario implements java.io.Serializable {

	private PermissaoUsuarioId id;
	private TipoUsuario tipoUsuario;
	private Permissao permissao;

	public PermissaoUsuario() {
	}

	public PermissaoUsuario(PermissaoUsuarioId id) {
		this.id = id;
	}

	public PermissaoUsuario(PermissaoUsuarioId id, TipoUsuario tipoUsuario,
			Permissao permissao) {
		this.id = id;
		this.tipoUsuario = tipoUsuario;
		this.permissao = permissao;
	}

	@EmbeddedId
	@AttributeOverrides({
			@AttributeOverride(name = "codTipoUsuario", column = @Column(name = "cod_tipo_usuario")),
			@AttributeOverride(name = "codPermissao", column = @Column(name = "cod_permissao")) })
	public PermissaoUsuarioId getId() {
		return this.id;
	}

	public void setId(PermissaoUsuarioId id) {
		this.id = id;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_tipo_usuario", insertable = false, updatable = false)
	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "cod_permissao", insertable = false, updatable = false)
	public Permissao getPermissao() {
		return this.permissao;
	}

	public void setPermissao(Permissao permissao) {
		this.permissao = permissao;
	}

}
