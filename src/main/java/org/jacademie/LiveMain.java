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
import org.jacademie.dao.ClientDao;
import org.jacademie.dao.CommandeDao;
import org.jacademie.dao.EventDao;
import org.jacademie.db.Constants;
import org.jacademie.db.HibernateUtils;
import org.jacademie.domain.Client;
import org.jacademie.domain.Commande;
import org.jacademie.domain.CommandeStatus;
import org.jacademie.domain.Entreprise;
import org.jacademie.domain.Event;
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
			
			ClientDao clientDao = new ClientDao();
			
			EventDao eventDao = new EventDao();
			
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
			/*
			LigneCommande lc = commandeDao.findLigneCommandeById(8);
			
			if (lc != null) {
				
				lc.setQuantite(10);
				
				commandeDao.updateLigneCommande(lc);
			}
			
			HibernateUtils.tearDown();
			*/
			
			/*
			commandeDao.deleteLigneCommande(8);
			
			HibernateUtils.tearDown();
			*/
			
			
			
			/*
			CommandeStatus status = new CommandeStatus();
			status.setLabel("En Cours d'exécution");
			
			commandeDao.createCommandeStatus(status);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			CommandeStatus status = commandeDao.findCommandeStatusById(1);
			
			LigneCommande lc1 = new LigneCommande();
			lc1.setLabelProduit("Livre 2");
			lc1.setQuantite(1);
			
			LigneCommande lc2 = new LigneCommande();
			lc2.setLabelProduit("Disque 2");
			lc2.setQuantite(1);
			
			Commande c = new Commande();
			c.setDate(new Date());
			c.setStatus(status);
			c.addLigne(lc1);
			c.addLigne(lc2);
			
			commandeDao.createCommande(c);
			
			HibernateUtils.tearDown();
			*/
			
			
			/*			
			CommandeStatus status = commandeDao.findCommandeStatusById(2);		
			
			Commande commande = commandeDao.findCommandeById(2);
			
			commande.setStatus(status);
			
			commandeDao.updateCommande(commande);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Commande commande = commandeDao.findCommandeById(2);
			
			for (LigneCommande ligneCommande : commande.getLignes()) {
				
				Integer quantite = ligneCommande.getQuantite();
				
				ligneCommande.setQuantite(quantite + 1);
			}
			
			commandeDao.updateCommande(commande);
			
			HibernateUtils.tearDown();
			*/
			
			
			/*
			Session session = HibernateUtils.getSession(); 

			session.beginTransaction();
						
			Commande commande = (Commande)session.get(Commande.class, 1);

			LigneCommande lc2 = new LigneCommande();
			lc2.setLabelProduit("Disque 5");
			lc2.setQuantite(1);
			
			commande.addLigne(lc2);
			
			session.getTransaction().commit();
			
			session.close();
			
			HibernateUtils.tearDown();
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
			particulier.setNumeroClient(1000);
			particulier.setPrenom("Jean");
			particulier.setNom("Dupont");			

			clientDao.createClient(particulier);
			
			Entreprise entreprise = new Entreprise();
			entreprise.setNumeroClient(2000);
			entreprise.setSiret("LEntreprise");
			
			clientDao.createClient(entreprise);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Client client1 = clientDao.findClientById(1);
			
			logger.info(client1.toString());
			
			Client client2 = clientDao.findClientById(2);
			
			logger.info(client2.toString());
			
			HibernateUtils.tearDown();
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
			// creer un commandeStatus
			CommandeStatus status = new CommandeStatus();
			status.setLabel("Livrée");
			
			commandeDao.createCommandeStatus(status);
			
			// creer un client
			Entreprise e = new Entreprise();
			e.setSiret("ABC");
			e.setNumeroClient(123);
			
			// creer une commande avec ses lignes de commande
			LigneCommande lc = new LigneCommande();
			lc.setQuantite(1);
			lc.setLabelProduit("Brosse à dents");
			
			Commande c = new Commande();
			c.setDate(new Date());
			c.setStatus(status);
			c.addLigne(lc);
			
			e.ajouterCommande(c);
			
			clientDao.createClient(e);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Client client1 = clientDao.findClientById(1);
			
			logger.info("Client : " + client1);
			logger.info("Nb Commandes : " + client1.getCommandes().size());
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Commande commande1 = commandeDao.findCommandeById(1);
			logger.info("Commande : " + commande1);
			logger.info("Concerne le client : " + commande1.getClient());
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Client client1 = clientDao.findClientById(1);
			
			CommandeStatus status = commandeDao.findCommandeStatusById(1);
			
			Commande c = new Commande();
			c.setDate(new Date());
			c.setStatus(status);
			
			LigneCommande lc = new LigneCommande();
			lc.setQuantite(1);
			lc.setLabelProduit("Dentifrice");
			
			c.addLigne(lc);
			
			client1.ajouterCommande(c);
			
			clientDao.updateClient(client1);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Entreprise e1 = new Entreprise();
			e1.setNumeroClient(1000);
			e1.setSiret("ABC1");
			
			clientDao.createClient(e1);
			
			Entreprise e2 = new Entreprise();
			e2.setNumeroClient(1001);
			e2.setSiret("ABC2");
			
			clientDao.createClient(e2);
			
			Entreprise e3 = new Entreprise();
			e3.setNumeroClient(1023);
			e3.setSiret("BAC3");
			
			clientDao.createClient(e3);
			
			Event ev1 = new Event();
			ev1.setDate(new Date());
			ev1.setDescription("Event inter entreprise");
			
			ev1.ajouterInvite(e1);
			ev1.ajouterInvite(e2);
			ev1.ajouterInvite(e3);
			
			eventDao.createEvent(ev1);
			
			HibernateUtils.tearDown();
			*/
			
			/*
			Particulier p1 = new Particulier();
			p1.setNumeroClient(1000);
			p1.setNom("P1");
			
			clientDao.createClient(p1);
			
			Particulier p2 = new Particulier();
			p2.setNumeroClient(1000);
			p2.setNom("P2");
			
			clientDao.createClient(p2);
			
			Particulier p3 = new Particulier();
			p3.setNumeroClient(1000);
			p3.setNom("P3");
			
			clientDao.createClient(p3);
			
			
			
			Event ev1 = new Event();
			ev1.setDate(new Date());
			ev1.setDescription("Event inter particuliers");
			
			ev1.ajouterInvite(p1);
			ev1.ajouterInvite(p2);
			ev1.ajouterInvite(p3);
			
			eventDao.createEvent(ev1);
			
			HibernateUtils.tearDown();
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
			*/
			
			
			List<Entreprise> entreprises = clientDao.retrieveEntreprisesByOptionalSiretAndNumero("A", null);
			
			for (Entreprise entreprise : entreprises) {
				
				logger.info("Found by siret only : " + entreprise.toString());
			}
			
			entreprises = clientDao.retrieveEntreprisesByOptionalSiretAndNumero(null, 1002);
			
			for (Entreprise entreprise : entreprises) {
				
				logger.info("Found by numero only : " + entreprise.toString());
			}
			
			entreprises = clientDao.retrieveEntreprisesByOptionalSiretAndNumero("A", 1002);
			
			for (Entreprise entreprise : entreprises) {
				
				logger.info("Found by siret and numero : " + entreprise.toString());
			}
			
			/*
			List<Particulier> particuliers = clientDao.retrieveWithCriteriaParticuliersByName("P");
			
			for (Particulier particulier : particuliers) {
				
				logger.info("Found : " + particulier.toString());
			}
			*/
			
			HibernateUtils.tearDown();
			
			
			/*
			List<Commande> commandes = commandeDao.findCommandesByProduct("Brosse");
			
			for (Commande commande : commandes) {
				
				logger.info("Found : " + commande.toString());
				
				logger.info(commande.getClient() + " has ordered 'Brosse*' !");
			}
			
			HibernateUtils.tearDown();
			*/
			
			/*
			List<Client> clients = clientDao.retrieveAllClients();
			
			for (Client client : clients) {
				
				logger.info("Found : " + client.toString());
			}
			
			HibernateUtils.tearDown();
			*/
			
			/*
			CommandeStatus archivedStatus = commandeDao.findCommandeStatusByLabel(Constants.COMMANDE_STATUS_ARCHIVEE_LABEL);
			
			List<Commande> commandes = commandeDao.findCommandesByStatus(Constants.COMMANDE_STATUS_LIVREE_LABEL);
			
			for (Commande commande : commandes) {
				
				logger.info("Found : " + commande.toString());
				
				commande.setStatus(archivedStatus);
				
				commandeDao.updateCommande(commande);
			}
			
			HibernateUtils.tearDown();
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
