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
		this.classePersistente = (Class<T>) ((ParameterizedType) getClass().getGenericSuperclass()).getActualTypeArguments()[0];
	}

	private EntityManagerFactory emf;
	
	@PersistenceUnit
	public void setEntityManagerFactory(EntityManagerFactory emf){
		this.emf = emf;
	}
	
	protected EntityManager getEntityManager(){
		return emf.createEntityManager();
	}
	
	
	void inserir(T objeto){
		getEntityManager().persist(objeto);
	}
	
	void excluir(T objeto){
		getEntityManager().remove(objeto);
	}
	
	void atualizar(T objeto){
		getEntityManager().merge(objeto);
	}

	public T findById(Integer id) {
		return getEntityManager().find(classePersistente, id);
	}

	@SuppressWarnings("unchecked")
	public List<T> findAll() {
		String sql = "FROM " + classePersistente.getSimpleName();
		Query query = getEntityManager().createQuery(sql);
		return query.getResultList();
	}
}
