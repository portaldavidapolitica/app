package net.pvp.portal.autenticacao;

import java.util.Collection;
import java.util.List;

import net.pvp.portal.entidades.Permissao;
import net.pvp.portal.entidades.Usuario;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;

public class Autenticador implements Authentication{

	/**
	 *
	 */
	private static final long serialVersionUID = 5992241905786512080L;
	private final Usuario usuario;
	private final List<Permissao> permissoes;
	private boolean authenticated;

	public Autenticador(final Usuario usuario, final List<Permissao> permissoes){
		this.usuario = usuario;
		this.permissoes = permissoes;
	}

	@Override
	public boolean isAuthenticated() {
		return this.authenticated;
	}

	@Override
	public void setAuthenticated(final boolean authenticated) {
		this.authenticated = authenticated;
	}

	@Override
	public String getName() {
		return this.usuario != null ? this.usuario.getNome() : null;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {
		return this.permissoes;
	}

	@Override
	public Object getCredentials() {
		return this.usuario != null ? this.usuario.getSenha() : null;
	}

	@Override
	public Object getDetails() {
		return this.usuario;
	}

	@Override
	public Object getPrincipal() {
		return this.usuario != null ? this.usuario.getLogin() : null;
	}


}
