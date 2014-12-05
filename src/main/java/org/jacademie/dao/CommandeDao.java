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

	
	public void createCommandeStatus(CommandeStatus commandeStatus) throws Exception {
		
		logger.info("Creating CommandeStatus : " + commandeStatus + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(commandeStatus);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("CommandeStatus created.");
	}

	public CommandeStatus findCommandeStatusById(int id) throws Exception {
		
		logger.info("Finding CommandeStatus with id : " + id + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		CommandeStatus result = (CommandeStatus)session.get(CommandeStatus.class, id);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		if (result != null) {

			logger.info("CommandeStatus found : " + result);
		}
		else {
			logger.info("CommandeStatus not found");
		}
		
		return result;
	}

	public void createCommande(Commande commande) throws Exception {
		
		logger.info("Creating Commande : " + commande + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(commande);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Commande created.");
	}
	
	public Commande findCommandeById(int id) throws Exception {
		
		logger.info("Finding Commande with id : " + id + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Commande result = (Commande)session.get(Commande.class, id);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		if (result != null) {

			logger.info("Commande found : " + result);
		}
		else {
			logger.info("Commande not found");
		}
		
		return result;
	}
	
	public void updateCommande(Commande commande) throws Exception {
		
		logger.info("Updating Commande : " + commande + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.merge(commande);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Commande updated.");
	}

	public List<Commande> findCommandesByProduct(String product) throws Exception {
		
		logger.info("Retrieving Commande by product : " + product.toUpperCase() + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Commande.byProduct");
		
		query.setString("product", product.toUpperCase() + "%");
		
		List<Commande> result = query.list();
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Commande retrieved : " + result.size());
		
		return  result;
	}
	
	
	/*
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
