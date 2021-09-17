package fr.eni.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.entity.Personne;

public class PersonneDAO {
	public Personne findById(int id) {
		return DAOUtil.getEntityManager().find(Personne.class,id);
	}
	
	public List<Personne> findAll(){
		String req = "select Object(p) from Personne p";
		return DAOUtil.getEntityManager().createQuery(req, Personne.class).getResultList();
	}
	
	public void add (Personne a) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.persist(a);
			et.commit();
		}catch(Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void delete (Personne a) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.remove(a);
			et.commit();
		}catch(Exception e) {
			et.rollback();
			throw e;
		}
	}
	
	public void update (Personne a) throws Exception{
		EntityManager em = DAOUtil.getEntityManager();
		EntityTransaction et = em.getTransaction();
		
		et.begin();
		try {
			em.merge(a);
			et.commit();
		}catch(Exception e) {
			et.rollback();
			throw e;
		}
	}
}
