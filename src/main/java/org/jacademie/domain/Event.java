package org.jacademie.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;


public class Event {

	private Integer id;
	
	private Date date;
	
	private String description;
	
	private Set<Client> invitedClients;

	public Event() {
		super();
		
		this.invitedClients = new HashSet<Client>();
	}

	public void ajouterInvite(Client client) {
		
		this.invitedClients.add(client);
		
		client.getInvitations().add(this);
	}
	
	@Override
	public String toString() {
		return "Event [id=" + id + ", date=" + date + ", description="
				+ description + ", invitedClients=" + invitedClients + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Set<Client> getInvitedClients() {
		return invitedClients;
	}

	public void setInvitedClients(Set<Client> invitedClients) {
		this.invitedClients = invitedClients;
	}
	
	
}
