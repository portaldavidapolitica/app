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

	@SuppressWarnings("unchecked")
	public DAOGenerico(){
		this.classePersistente = (Class<T>) ((ParameterizedType) this.getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}
	
	@PersistenceUnit
	private EntityManagerFactory emf;

	void inserir(final T objeto){
		this.getEmf().persist(objeto);
	}

	void excluir(final T objeto){
		this.getEmf().remove(objeto);
	}

	void atualizar(final T objeto){
		this.getEmf().merge(objeto);
	}

	public T findById(final Integer id) {
		return this.getEmf().find(this.classePersistente, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		final String sql = "FROM " + this.classePersistente.getSimpleName();
		final Query query = this.getEmf().createQuery(sql);
		return query.getResultList();
	}

	public EntityManager getEmf() {
		return emf.createEntityManager();
	}

	public void setEmf(EntityManagerFactory emf) {
		this.emf = emf;
	}
}
