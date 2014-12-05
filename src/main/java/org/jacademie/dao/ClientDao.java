package org.jacademie.dao;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Query;
import org.hibernate.Session;
import org.jacademie.db.HibernateUtils;
import org.jacademie.domain.Client;
import org.jacademie.domain.Entreprise;
import org.jacademie.domain.LigneCommande;
import org.jacademie.domain.Particulier;

public class ClientDao {

	private static Logger logger = LogManager.getLogger(ClientDao.class);
	
	public void createClient(Client client) throws Exception {
		
		logger.info("Creating Client : " + client + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(client);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Client created.");
	}

	public Client findClientById(int id) throws Exception {
		
		logger.info("Finding Client with id : " + id + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Client result = (Client)session.get(Client.class, id);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		if (result != null) {

			logger.info("Client found : " + result);
		}
		else {
			logger.info("Client not found");
		}
		
		return result;
	}

	public void updateClient(Client client) throws Exception {

		logger.info("Updating Client : " + client + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.merge(client);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Client updated.");
	}

	public List<Entreprise> retrieveEntreprisesBySiret(String siret) throws Exception {
		
		logger.info("Retrieving Entreprise by siret : " + siret + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		// Query query = session.createQuery("FROM Entreprise ent WHERE ent.siret LIKE :siret");
		
		Query query = session.getNamedQuery("Entreprise.bySiret");
		
		query.setString("siret", siret + "%");
		
		List<Entreprise> result = query.list();
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Entreprise retrieved : " + result.size());
		
		return  result;
	}
	
	public List<Particulier> retrieveParticuliersByName(String name) throws Exception {
		
		logger.info("Retrieving Particulier by name : " + name.toUpperCase() + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		// Query query = session.createQuery("FROM Entreprise ent WHERE ent.siret LIKE :siret");
		
		Query query = session.getNamedQuery("Particulier.byName");
		
		query.setString("name", name.toUpperCase() + "%");
		
		List<Particulier> result = query.list();
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Particulier retrieved : " + result.size());
		
		return  result;
	}

	public List<Client> retrieveAllClients() throws Exception {
		
		logger.info("Retrieving all Clients...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		Query query = session.getNamedQuery("Client.all");
		
		List<Client> result = query.list();
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Clients retrieved : " + result.size());
		
		return  result;
	}
}
