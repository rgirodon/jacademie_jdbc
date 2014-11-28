package org.jacademie;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.dao.CommandeDao;
import org.jacademie.db.HibernateUtils;

public class MainHibernate {

	private static Logger logger = LogManager.getLogger(MainHibernate.class);
	
    public static void main( String[] args ) {
    	try {
    		logger.info("Setting up Hibernate...");
    		
	    	HibernateUtils.setUp();
	    	
	    	logger.info("Hibernate is set up.");
	    	
	    	CommandeDao commandeDao = new CommandeDao();
	    	
	    	
	    	/* Exo 1 
	    	logger.info("Creating LigneCommandes...");
	    	
	    	commandeDao.createLigneCommandes();	    	
	    	
	    	logger.info("LigneCommandes created.");
	    	*/
	    	
	    	/* Exo 2 
	    	logger.info("Retrieving LigneCommandes...");
	    	
	    	commandeDao.retrieveLigneCommandes();	    	
	    	
	    	logger.info("LigneCommandes retrieved.");
	    	*/
	    	
	    	
	    	/* Exo 3 
	    	logger.info("Updating LigneCommandes...");
	    	
	    	commandeDao.updateLigneCommandes();	    	
	    	
	    	logger.info("LigneCommandes updated.");
	    	*/
	    	
	    	
	    	/* Exo 3-Bis 
	    	logger.info("Updating Detached LigneCommandes...");
	    	
	    	commandeDao.updateDetachedLigneCommandes();	    	
	    	
	    	logger.info("Detached LigneCommandes updated.");
	    	*/
	    	
	    	
	    	/* Exo 4  
	    	logger.info("Deleting LigneCommandes...");
	    	
	    	commandeDao.deleteLigneCommandes();	    	
	    	
	    	logger.info("LigneCommandes deleted.");
			*/
	    	
	    	
	    	/* Exo 5 */ 
	    	/* 5.1 
	    	logger.info("Creating CommandeStatus...");
	    	
	    	commandeDao.createCommandeStatus();
	    	
	    	logger.info("CommandeStatus created.");
	    	*/
	    	
	    	/* 5.2  
	    	logger.info("Creating Clients...");
	    	
	    	commandeDao.createClients();	    	
	    	
	    	logger.info("Clients created.");
	    	*/
	    	
	    	/* 5.3    
	    	logger.info("Creating Commandes...");	    		    	
	    	
	    	commandeDao.createCommandes();	    	
	    	
	    	logger.info("Commandes created.");
	    	*/
	    	
	    	/* Exo 6 
	    	logger.info("Retrieving Commandes...");
	    	
	    	commandeDao.retrieveCommandes();	    	
	    	
	    	logger.info("Commandes retrieved.");
			*/
	    	
	    	
	    	/* Exo 7  
	    	logger.info("Updating Commandes...");
	    	
	    	commandeDao.updateCommandes();	    	
	    	
	    	logger.info("Commandes updated.");
	    	
	    	*/
	    	
	    	
	    	/* Exo 8   
	    	logger.info("Deleting Commandes...");
	    	
	    	commandeDao.deleteCommandes();	    	
	    	
	    	logger.info("Commandes deleted.");
	    	*/
	    	
	    	
	    	/* Exo 9 
	    	logger.info("Creating Clients...");
	    	
	    	commandeDao.createClients();	    	
	    	
	    	logger.info("Clients created.");
	    	*/
	    	
	    	
	    	/* Exo 10 
	    	logger.info("Querying Clients...");
	    	
	    	commandeDao.queryClients();	    	
	    	
	    	logger.info("Clients queried.");
	    	*/
	    	
	    	
	    	logger.info("Shutting down Hibernate...");
	    	
	    	HibernateUtils.tearDown();
	    	
	    	logger.info("Hibernate is shut down.");
    	}
    	catch(Exception e) {
    		e.printStackTrace();
    	}
    }
}
