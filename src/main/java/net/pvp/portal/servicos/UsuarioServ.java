package net.pvp.portal.servicos;

import javax.inject.Inject;

import net.pvp.portal.dao.UsuarioDAO;
import net.pvp.portal.entidades.Usuario;

import org.springframework.stereotype.Service;
@Service("usuario")
public class UsuarioServ {

	@Inject
	UsuarioDAO dao;

	public boolean logon(final Usuario usuario){
		return false;
	}

	public Usuario getUsuarioPorLogin(final String login){
		return this.dao.getUsuarioPorLogin(login);
	}

}
