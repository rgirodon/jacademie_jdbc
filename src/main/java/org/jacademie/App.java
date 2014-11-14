package org.jacademie;

import java.util.Collection;

import org.apache.log4j.Logger;
import org.jacademie.dao.FootDao;
import org.jacademie.domain.Team;

/**
 * Hello world!
 *
 */
public class App {
	
	private static Logger logger = Logger.getLogger(App.class);
	
    public static void main( String[] args ) {
    	    	
        logger.info( "Welcome to FootDb App !" );
                
        FootDao dao = new FootDao();
        
        Collection<Team> equipes = dao.listAllEquipes();
        
        for (Team equipe : equipes) {
        	
        	logger.info("Find : " + equipe);
        }
        
        logger.info("Creating new team...");
        
        Team newTeam = new Team();
        newTeam.setName("INTER MILAN");
        
        dao.createNewEquipe(newTeam);
        
        logger.info("Team created.");
        
        equipes = dao.listAllEquipes();
        
        for (Team equipe : equipes) {
        	
        	logger.info("Find : " + equipe);
        }
        
        
        /*
        Connection connection = null;
        
        try {
        	Class.forName("org.hsqldb.jdbcDriver");
        	
        	connection = DriverManager.getConnection("jdbc:hsqldb:hsql://localhost/footdb", "SA", "");
        	
        	Statement statement = connection.createStatement();
			
			ResultSet rs = statement.executeQuery("SELECT NAME FROM TEAM ORDER BY NAME");
			
			while(rs.next()){
				logger.info("Find Team : " + rs.getString("NAME")) ;
			}
        }
        catch(Exception e) {
        	logger.error(ExceptionUtils.getStackTrace(e));
        }
        finally {
        	if (connection != null) {
        		
        		try {
					connection.close();
				} 
        		catch (SQLException e) {
        			logger.error(ExceptionUtils.getStackTrace(e));
				}
        	}
        }
        */
        
        logger.info( "Thanks for using us !" );
    }
}
