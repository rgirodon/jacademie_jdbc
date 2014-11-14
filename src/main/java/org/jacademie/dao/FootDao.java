package org.jacademie.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;




import org.apache.commons.lang3.exception.ExceptionUtils;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.jacademie.db.DatabaseUtils;
import org.jacademie.domain.Player;
import org.jacademie.domain.Team;

public class FootDao {

	private static Logger logger = LogManager.getLogger(FootDao.class);
	
	public Collection<Team> listAllEquipes() {
		
		Collection<Team> result = new ArrayList<Team>();
		
		Connection connection = DatabaseUtils.getConnection();
		
		if (connection != null) {
			try {
				Statement statement = connection.createStatement();
				
				ResultSet rs = statement.executeQuery("SELECT ID, NAME FROM TEAM ORDER BY NAME");
				
				while(rs.next()){
					
					Team team = new Team();
					
					Integer num = rs.getInt("ID");
					String name = rs.getString("NAME");
					
					team.setNum(num);
					team.setName(name);
					
					result.add(team);
				}
			}
			catch(SQLException e) {
				logger.error("Unable to retrieve All Equipe Names");
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		
		DatabaseUtils.closeConnection(connection);
		
		return result;
	}
	
	public void createNewEquipe(Team team) {
		
		Connection connection = DatabaseUtils.getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("INSERT INTO TEAM (NAME) VALUES (?)");
				
				statement.setString(1, team.getName());
				
				statement.execute();
			}
			catch(SQLException e) {
				logger.error("Unable to create New Equipe");
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		
		DatabaseUtils.closeConnection(connection);
	}

	public Collection<Player> listAllPlayersForEquipe(Integer equipeNum) {
		
		Collection<Player> result = new ArrayList<Player>();
		
		Connection connection = DatabaseUtils.getConnection();
		
		if (connection != null) {
			try {
				PreparedStatement statement = connection.prepareStatement("SELECT ID, NAME, NUMERO, EQUIPE_ID "
						                                                + "  FROM PLAYER "
						                                                + "  WHERE EQUIPE_ID = ? "
						                                                + " ORDER BY NUMERO");
				
				statement.setInt(1, equipeNum);
				
				ResultSet rs = statement.executeQuery();
				
				while(rs.next()){
					
					Player player = new Player();
					
					Integer num = rs.getInt("ID");					
					String name = rs.getString("NAME");
					Integer numero = rs.getInt("NUMERO");
					Integer equipeId = rs.getInt("EQUIPE_ID");
					
					player.setNum(num);
					player.setName(name);
					player.setNumero(numero);
					player.setEquipeId(equipeId);
					
					result.add(player);
				}
			}
			catch(SQLException e) {
				logger.error("Unable to retrieve All Players for team");
				logger.error(ExceptionUtils.getStackTrace(e));
			}
		}
		
		DatabaseUtils.closeConnection(connection);
		
		return result;
	}
}
