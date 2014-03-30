package net.pvp.portal.dao;

import java.util.List;

import net.pvp.portal.entidades.Permissao;
import net.pvp.portal.entidades.Usuario;

import org.springframework.stereotype.Repository;

@Repository
public class PermissaoDAO extends DAOGenerico<Permissao>{

	public List<Permissao> getPermissoesUsuario(final Usuario usuario){
		return null;
	}

}
