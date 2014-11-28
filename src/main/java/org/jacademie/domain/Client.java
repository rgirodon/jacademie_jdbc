package org.jacademie.domain;

import java.util.HashSet;
import java.util.Set;

public class Client {

	private Integer id;
	
	private Integer numeroClient;
	
	// private Set<Commande> commandes;
	
	

	public Client() {
		super();
		
		// this.commandes = new HashSet<Commande>();
	}
	
	@Override
	public String toString() {
		return "Client [id=" + id + ", numeroClient=" + numeroClient + "]";
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

	public Integer getNumeroClient() {
		return numeroClient;
	}

	public void setNumeroClient(Integer numeroClient) {
		this.numeroClient = numeroClient;
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
