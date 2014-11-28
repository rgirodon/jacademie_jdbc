package org.jacademie.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.jacademie.db.HibernateUtils;
import org.jacademie.domain.Client;
import org.jacademie.domain.LigneCommande;

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

}
