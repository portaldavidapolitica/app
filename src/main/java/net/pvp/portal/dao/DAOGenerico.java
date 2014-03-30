package net.pvp.portal.dao;

import java.lang.reflect.ParameterizedType;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.PersistenceUnit;
import javax.persistence.Query;

import org.springframework.stereotype.Repository;

@Repository
public abstract class DAOGenerico<T> {

	protected Class<T> classePersistente;

	public DAOGenerico(){
		this.classePersistente = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private EntityManagerFactory emf;

	@PersistenceUnit(name = "pvpPU")
	public void setEntityManagerFactory(final EntityManagerFactory emf){
		this.emf = emf;
	}

	protected EntityManager getEntityManager(){
		return this.emf.createEntityManager();
	}


	void inserir(final T objeto){
		this.getEntityManager().persist(objeto);
	}

	void excluir(final T objeto){
		this.getEntityManager().remove(objeto);
	}

	void atualizar(final T objeto){
		this.getEntityManager().merge(objeto);
	}

	public T findById(final Integer id) {
		return this.getEntityManager().find(this.classePersistente, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		final String sql = "FROM " + this.classePersistente.getSimpleName();
		final Query query = this.getEntityManager().createQuery(sql);
		return query.getResultList();
	}
}
