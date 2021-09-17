package fr.eni.jpa.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class DAOUtil {

	private static EntityManagerFactory emf;
	private static EntityManager em;
	
	static {
		emf = Persistence.createEntityManagerFactory("Mysql_UP");
		em = emf.createEntityManager();
	}
	
	public static EntityManager getEntityManager() {
		return em;
	}
	
	public static void close() {
		if(em != null && em.isOpen()) {
			em.close();
		}
		if(emf != null && emf.isOpen()) {
			emf.close();
		}
		
	}
	
}
