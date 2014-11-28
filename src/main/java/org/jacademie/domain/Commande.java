package org.jacademie.domain;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Commande {

	private Integer id;
	
	private Date date;
	
	private CommandeStatus status;
	
	private Set<LigneCommande> lignes;
	
	// private Set<Client> clients;

	private Client client;
	
	public Commande() {
		
		super();
		
		this.lignes = new HashSet<LigneCommande>();
		
		//this.clients = new HashSet<Client>();
	}
	
	public void addLigne(LigneCommande ligneCommande) {
		
		this.lignes.add(ligneCommande);
	}
	
	public void removeLigne(LigneCommande ligneCommande) {
		
		this.lignes.remove(ligneCommande);
	}
	/*
	public void addClient(Client client) {
		
		this.clients.add(client);
	}
	
	public void removeClient(Client client) {
		
		this.clients.remove(client);
	}
	*/
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Commande [id=");
		builder.append(id);
		builder.append(", date=");
		builder.append(date);
		builder.append(", lignes=");
		builder.append(lignes);
		builder.append("]");
		return builder.toString();
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

	public CommandeStatus getStatus() {
		return status;
	}

	public void setStatus(CommandeStatus status) {
		this.status = status;
	}
	
	
	public Set<LigneCommande> getLignes() {
		return lignes;
	}

	public void setLignes(Set<LigneCommande> lignes) {
		this.lignes = lignes;
	}

	
	public Client getClient() {
		return client;
	}

	public void setClient(Client client) {
		this.client = client;
	}
	

	/*
	public Set<Client> getClients() {
		return clients;
	}

	public void setClients(Set<Client> clients) {
		this.clients = clients;
	}
	*/
	
	
}
