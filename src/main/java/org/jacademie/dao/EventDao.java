package org.jacademie.dao;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.hibernate.Session;
import org.jacademie.db.HibernateUtils;
import org.jacademie.domain.Event;

public class EventDao {

private static Logger logger = LogManager.getLogger(EventDao.class);
	
	public void createEvent(Event event) throws Exception {
		
		logger.info("Creating Event : " + event + "...");
		
		Session session = HibernateUtils.getSession();
		
		session.beginTransaction();
		
		session.save(event);
		
		session.getTransaction().commit();
		
		HibernateUtils.closeSession(session);
		
		logger.info("Event created.");
	}
}
