package org.jacademie.dao;

import java.util.Date;
import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.Restrictions;
import org.jacademie.db.HibernateUtils;
import org.jacademie.domain.Client;
import org.jacademie.domain.Commande;
import org.jacademie.domain.CommandeStatus;
import org.jacademie.domain.Entreprise;
import org.jacademie.domain.LigneCommande;
import org.jacademie.domain.Particulier;

public class CommandeDao {

	private static Logger logger = LogManager.getLogger(CommandeDao.class);
	
	public void createLigneCommande(LigneCommande ligneCommande) throws Exception {
		
		logger.info("Creating LigneCommande : " + ligneCommande + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(ligneCommande);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("LigneCommande created.");
	}

	public LigneCommande findLigneCommandeById(Integer id) throws Exception {
		
		logger.info("Finding LigneCommande with id : " + id + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		LigneCommande result = (LigneCommande)session.get(LigneCommande.class, id);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		if (result != null) {

			logger.info("LigneCommande found : " + result);
		}
		else {
			logger.info("LigneCommande not found");
		}
		
		return result;
	}

	public void updateLigneCommande(LigneCommande ligneCommande) throws Exception {
		
		logger.info("Updating LigneCommande : " + ligneCommande + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.merge(ligneCommande);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("LigneCommande updated.");
	}

	public void deleteLigneCommande(Integer id) throws Exception {
		
		logger.info("Deleting LigneCommande with id : " + id + "...");
		
		LigneCommande ligneCommande = this.findLigneCommandeById(id);

		if (ligneCommande != null) {
		
			Session session = HibernateUtils.getSession();
			
			session.beginTransaction();
			
			session.delete(ligneCommande);
			
			session.getTransaction().commit();
			
			HibernateUtils.closeSession(session);
			
			logger.info("LigneCommande deleted.");
		}
		else {
			logger.info("LigneCommande was not found and could not be deleted.");
		}
	}

	/*
	public void createCommandeStatus() throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		CommandeStatus cs1 = new CommandeStatus();
		cs1.setLabel("EN ATTENTE D'EXPEDITION");

		CommandeStatus cs2 = new CommandeStatus();
		cs2.setLabel("EXPEDITIEE");
		
		session.save(cs1);
		
		session.save(cs2);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
	}
	
	
	public void createCommandes() throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();

		LigneCommande l1 = new LigneCommande();
		l1.setLabelProduit("Playmobil Cowboys");
		l1.setQuantite(1);
		
		LigneCommande l2 = new LigneCommande();
		l2.setLabelProduit("Playmobil Indiens");
		l2.setQuantite(2);
		
		Commande c = new Commande();
		c.addLigne(l1);
		c.addLigne(l2);
		//c.addClient(cl1);
		//c.addClient(cl2);
		c.setDate(new Date());
		//c.setStatus(commandeStatus);
		
		session.save(c);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
	}

	public void retrieveCommandes() throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		Commande commande = (Commande)session.get(Commande.class, 1);
		
		logger.info(commande.toString());
		
		HibernateUtils.closeSession(session);
	}

	public void updateCommandes() throws Exception {

		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Commande commande = (Commande)session.get(Commande.class, 1);

		for (LigneCommande ligneCommande : commande.getLignes()) {
			
			ligneCommande.setQuantite(ligneCommande.getQuantite() + 1);
		}
		
		LigneCommande l3 = new LigneCommande();
		l3.setLabelProduit("Playmobil Diligence");
		l3.setQuantite(1);
		
		commande.addLigne(l3);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
	}

	public void deleteCommandes() throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Commande commande = (Commande)session.get(Commande.class, 1);

		session.delete(commande);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
	}

	public void createClients() throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Particulier c1 = new Particulier();
		c1.setNom("Girodon");
		c1.setPrenom("Remy");
		
		Entreprise c2 = new Entreprise();
		c2.setSiret("123456789");
		
		session.save(c1);
		
		session.save(c2);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
	}

	public void queryClients() throws Exception {
		
		Session session = HibernateUtils.getSession();
		
		
		logger.info("Making some HQL Query...");
		
		Query hqlQuery = session.createQuery("FROM Particulier WHERE Nom LIKE ?");
		
		hqlQuery.setString(0, "G%");
		
		List<Particulier> hqlQueryResult = hqlQuery.list();
		
		for (Particulier particulier : hqlQueryResult) {
			
			logger.info("HQL Query found : " + particulier.toString());
		}
		
		
		logger.info("Making some HQL Named Query...");
		
		Query hqlNamedQuery = session.getNamedQuery("particuliersByName");
		
		hqlNamedQuery.setString("name", "G%");
		
		List<Particulier> hqlNamedQueryResult = hqlNamedQuery.list();
		
		for (Particulier particulier : hqlNamedQueryResult) {
			
			logger.info("HQL Named Query found : " + particulier.toString());
		}
		
				
		logger.info("Making some Criteria Query...");
		
		Criteria criteria = session.createCriteria(Particulier.class)
								.add(Restrictions.like("nom", "G%"));
		
		List<Particulier> hqlCriteriaQueryResult = criteria.list();
		
		for (Particulier particulier : hqlCriteriaQueryResult) {
			
			logger.info("Criteria Query found : " + particulier.toString());
		}
		
		
		HibernateUtils.closeSession(session);
	}
*/
	
}
