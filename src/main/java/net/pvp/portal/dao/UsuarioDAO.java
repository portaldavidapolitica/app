package net.pvp.portal.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.NonUniqueResultException;
import javax.persistence.Query;
import javax.persistence.QueryTimeoutException;

import net.pvp.portal.entidades.Usuario;

public class UsuarioDAO extends DAOGenerico<Usuario>{

	public UsuarioDAO(){
		super();
	}

	public void inserirUsuario(final Usuario usuario){
		this.inserir(usuario);
	}

	public void atualizarUsuario(final Usuario usuario){
		this.atualizar(usuario);
	}

	public void excluirUsuario(final Usuario usuario){
		this.excluir(usuario);
	}

	public List<Usuario> listarUsuarios(){
		return this.findAll();
	}

	public Usuario pesquisaUsuarioPorId(final Integer id){
		return this.findById(id);
	}

	public Usuario getUsuarioPorLogin(final String login){
		final String sql = "SELECT u FROM Usuario u WHERE u.login = :login)";
		final Query q = this.getEntityManager().createQuery(sql);
		q.setParameter("login", login);
		try{
			return (Usuario) q.getSingleResult();
		} catch (final NonUniqueResultException e){
			return null;
		} catch (final NoResultException e){
			return null;
		} catch(final IllegalStateException e){
			return null;
		} catch(final QueryTimeoutException e){
			return null;
		}
	}

}
