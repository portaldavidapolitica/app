package net.pvp.portal.bo;

import java.util.List;

import javax.inject.Inject;

import net.pvp.portal.dao.PermissaoDAO;
import net.pvp.portal.entidades.Permissao;
import net.pvp.portal.entidades.Usuario;

import org.springframework.stereotype.Service;

@Service("permissao")
public class PermissaoBO {

	@Inject
	private PermissaoDAO dao;


	public List<Permissao> getPermissoes(final Usuario usuario){
		return this.dao.getPermissoesUsuario(usuario);
	}

}
