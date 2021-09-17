package fr.eni.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

import fr.eni.jpa.entity.Adresse;

public class AdresseDAO {
	public Adresse findById(int id) {
		return DAOUtil.getEntityManager().find(Adresse.class,id);
	}
	
	public List<Adresse> findAll(){
		String req = "select Object(a) from Adresse a";
		return DAOUtil.getEntityManager().createQuery(req, Adresse.class).getResultList();
	}
	
	public void add (Adresse a) throws Exception{
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
	
	public void delete (Adresse a) throws Exception{
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
}
