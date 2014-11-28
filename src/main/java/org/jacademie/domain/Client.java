package org.jacademie.domain;

import java.util.HashSet;
import java.util.Set;

public class Client {

	private Integer id;
	
	// private Set<Commande> commandes;
	
	public Client() {
		super();
		
		// this.commandes = new HashSet<Commande>();
	}

	/*
	public void ajouterCommande(Commande commande) {
		
		this.commandes.add(commande);
		
		commande.setClient(this);
	}
	*/
	
	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	/*
	public Set<Commande> getCommandes() {
		return commandes;
	}

	public void setCommandes(Set<Commande> commandes) {
		this.commandes = commandes;
	}
	*/
	
}
