package net.pvp.portal.autenticacao;

import java.util.List;

import net.pvp.portal.bo.BeanDelegator;
import net.pvp.portal.entidades.Permissao;
import net.pvp.portal.entidades.Usuario;

import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;

public class ProvedorPadrao implements AuthenticationProvider{

	@Override
	public Authentication authenticate(final Authentication auth)
			throws AuthenticationException {
		final UsernamePasswordAuthenticationToken token = (UsernamePasswordAuthenticationToken) auth;
		final String username = token.getName();
		final String senha = token.getCredentials().toString();

		final Usuario usuario = BeanDelegator.getInstance().getUsuarioBO().getUsuarioPorLogin(username);
		usuario.setSenha(senha);
		final boolean autenticou = BeanDelegator.getInstance().getUsuarioBO().logon(usuario);

		if (!autenticou) {
			return null;
		}

		final List<Permissao> permissoes = BeanDelegator.getInstance().getPermissaoBO().getPermissoes(usuario);
		final Autenticador resultado = new Autenticador(usuario, permissoes);
		resultado.setAuthenticated(usuario != null);
		return resultado;
	}

	@Override
	public boolean supports(final Class<?> auth) {
		return UsernamePasswordAuthenticationToken.class.isAssignableFrom(auth);
	}



}
