package org.jacademie;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.Restrictions;
import org.hibernate.service.ServiceRegistry;
import org.jacademie.dao.CommandeDao;
import org.jacademie.db.HibernateUtils;
import org.jacademie.domain.Client;
import org.jacademie.domain.Commande;
import org.jacademie.domain.CommandeStatus;
import org.jacademie.domain.Entreprise;
import org.jacademie.domain.LigneCommande;
import org.jacademie.domain.Particulier;

public class LiveMain {

	private static Logger logger = LogManager.getLogger(LiveMain.class);
	
	/**
	 * @param args
	 */
	public static void main(String[] args) {
		try {
			HibernateUtils.setUp();
			
			CommandeDao commandeDao = new CommandeDao();
			
			/*
			LigneCommande lc1 = new LigneCommande();
			lc1.setLabelProduit("Livre 1");
			lc1.setQuantite(1);
			
			LigneCommande lc2 = new LigneCommande();
			lc2.setLabelProduit("Disque 1");
			lc2.setQuantite(1);
			
			commandeDao.createLigneCommande(lc1);
			
			commandeDao.createLigneCommande(lc2);
			
			HibernateUtils.tearDown();
			*/
			
			LigneCommande lc = commandeDao.findLigneCommandeById(8);
			
			lc.setQuantite(10);
			
			commandeDao.updateLigneCommande(lc);
			
			HibernateUtils.tearDown();
			
			/*
			commandeDao.deleteLigneCommande(8);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			CommandeStatus status = new CommandeStatus();
			status.setLabel("En Cours de préparation");
			session.save(status);
			
			session.getTransaction().commit();
			
			session.beginTransaction();

			LigneCommande lc1 = new LigneCommande();
			lc1.setLabelProduit("Livre 1");
			lc1.setQuantite(1);
			
			LigneCommande lc2 = new LigneCommande();
			lc2.setLabelProduit("Disque 1");
			lc2.setQuantite(1);
			
			Commande c = new Commande();
			c.setDate(new Date());
			c.setStatus(status);
			c.addLigne(lc1);
			c.addLigne(lc2);
			
			session.save(c);
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			CommandeStatus status = new CommandeStatus();
			status.setLabel("En Cours d'expédition");
			session.save(status);

			session.getTransaction().commit();
			
			session.beginTransaction();			
			
			Commande commande = (Commande)session.get(Commande.class, 2);
			
			commande.setStatus(status);
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			Commande commande = (Commande)session.get(Commande.class, 2);

			LigneCommande lc2 = new LigneCommande();
			lc2.setLabelProduit("Disque 5");
			lc2.setQuantite(1);
			
			commande.addLigne(lc2);
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			CommandeStatus status = new CommandeStatus();
			status.setLabel("Livrée");
			session.save(status);
			
			session.getTransaction().commit();
			
			session.beginTransaction();
			
			Commande commande = (Commande)session.get(Commande.class, 2);
			
			session.getTransaction().commit();
			
			session.close();
			
			
			commande.setStatus(status);
			
			
			Session nouvelleSession = sessionFactory.openSession();
			
			nouvelleSession.beginTransaction();
			
			nouvelleSession.merge(commande);
			
			nouvelleSession.getTransaction().commit();
			
			nouvelleSession.close();
			
			sessionFactory.close();
			*/
			
			/* 
			Particulier particulier = new Particulier();
			particulier.setPrenom("Jean");
			particulier.setNom("Dupont");
			
			Entreprise entreprise = new Entreprise();
			entreprise.setSiret("LEntreprise");
			
			
			session.save(particulier);
			session.save(entreprise);
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			Particulier particulier = (Particulier)session.get(Particulier.class, 1);
			particulier.setPrenom("Jeanne");
			
			Entreprise entreprise = (Entreprise)session.get(Entreprise.class, 2);
			
			session.getTransaction().commit();
			
			session.close();
			
			
			entreprise.setSiret("TUTUTU");
			
			
			Session nouvelleSession = sessionFactory.openSession();
			
			nouvelleSession.beginTransaction();
			
			nouvelleSession.merge(entreprise);
			
			nouvelleSession.getTransaction().commit();
			
			nouvelleSession.close();
			
			
			sessionFactory.close();
			*/
			
			/*
			Particulier particulier = (Particulier)session.get(Particulier.class, 1);
			
			session.delete(particulier);
			
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();	
			*/
			
			/*
			// creer un client
			Entreprise e = new Entreprise();
			e.setSiret("ABC");
			
			// sauver ce client
			session.save(e);
			
			// creer une commande avec ses lignes de commande
			LigneCommande lc = new LigneCommande();
			lc.setQuantite(1);
			lc.setLabelProduit("Brosse à dents");
			
			Commande c = new Commande();
			c.setDate(new Date());
			c.addLigne(lc);
			
			// affecter le client a la commande
			c.setClient(e);
			
			// sauver cette commande
			session.save(c);
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			Entreprise e1 = new Entreprise();
			e1.setSiret("ABC1");
			
			Entreprise e2 = new Entreprise();
			e2.setSiret("ABC2");
			
			Entreprise e3 = new Entreprise();
			e3.setSiret("BAC3");
			
			session.save(e1);
			session.save(e2);
			session.save(e3);
			
			// Query hqlQuery = session.createQuery("FROM Entreprise ent WHERE ent.siret LIKE :siret");
			
			Query hqlQuery = session.getNamedQuery("entreprisesBySiret");
			
			hqlQuery.setString("siret", "A%");
			
			List<Entreprise> hqlQueryResult = hqlQuery.list();
			
			for (Entreprise entreprise : hqlQueryResult) {
				
				System.out.println("HQL Query found : " + entreprise.toString());
				
				// entreprise.setSiret("A-" + entreprise.getSiret());
			}			
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			Criteria criteria = session.createCriteria(Entreprise.class);
			
			criteria.add(Restrictions.ilike("siret", "a%"));
			
			List<Entreprise> hqlQueryResult = criteria.list();
			
			for (Entreprise entreprise : hqlQueryResult) {
				
				System.out.println("Criteria found : " + entreprise.toString());
				
				entreprise.setSiret("A-" + entreprise.getSiret());
			}
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
			
			/*
			Particulier client = new Particulier();
			client.setNom("Durand");
			client.setPrenom("Michel");
			
			session.save(client);
			
			
			LigneCommande lc1 = new LigneCommande();
			lc1.setLabelProduit("Livre 1");
			lc1.setQuantite(1);
			
			LigneCommande lc2 = new LigneCommande();
			lc2.setLabelProduit("Disque 1");
			lc2.setQuantite(1);
			
			Commande c = new Commande();
			c.setDate(new Date());			
			c.addLigne(lc1);
			c.addLigne(lc2);
			
			client.ajouterCommande(c);
			
			session.save(c);
			
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
		    */
			
			/*
			Query hqlQuery = session.getNamedQuery("commandesForParticulierByPrenom");
			
			hqlQuery.setString("prenom", "Jean%");
			
			List<Commande> commandes = hqlQuery.list();
			
			for (Commande commande : commandes) {
				
				System.out.println("Found : " + commande.toString());
			}			
			
			session.getTransaction().commit();
			
			session.close();
			
			sessionFactory.close();
			*/
		}
		catch(Exception e) {
			e.printStackTrace();
		}
	}

}
