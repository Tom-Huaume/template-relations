package fr.eni.jpa.entity;

import java.util.List;

import fr.eni.jpa.dao.AdresseDAO;
import fr.eni.jpa.dao.DAOUtil;
import fr.eni.jpa.dao.PersonneDAO;

public class Test {

	public static void main(String[] args) {
		Adresse a1 = new Adresse("44000", "Nantes");
		Adresse a2 = new Adresse("33000", "Bordeaux");

		Personne p1 = new Personne("Lebrun", "Jeanne", a1);
		Personne p2 = new Personne("Leblond", "Annie", a2);

		
		PersonneDAO pDAO = new PersonneDAO();
		AdresseDAO aDAO = new AdresseDAO();
		
		try {
			pDAO.add(p1);
			pDAO.add(p2);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Personne> listeP = pDAO.findAll();
		System.out.println("Liste des personnes : ");
		for (Personne personne : listeP) {
			System.out.println(personne);
		}

		
		try {
			aDAO.delete(a1);
		}catch (Exception e) {
			e.printStackTrace();
		}
		
		List<Adresse> listeA = aDAO.findAll();
		System.out.println("Liste des adresses : ");
		for (Adresse adresse : listeA) {
			System.out.println(adresse);
		}
		
		listeP = pDAO.findAll();
		System.out.println("Liste des personnes : ");
		for (Personne personne : listeP) {
			System.out.println(personne);
		}

		DAOUtil.close();
	}

}
