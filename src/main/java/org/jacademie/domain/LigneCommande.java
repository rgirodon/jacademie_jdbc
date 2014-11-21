package org.jacademie.domain;

public class LigneCommande {

	private Integer id;
	
	private Integer quantite;
	
	private String labelProduit;

	public LigneCommande() {
		super();
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("LigneCommande [id=");
		builder.append(id);
		builder.append(", quantite=");
		builder.append(quantite);
		builder.append(", labelProduit=");
		builder.append(labelProduit);
		builder.append("]");
		return builder.toString();
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public Integer getQuantite() {
		return quantite;
	}

	public void setQuantite(Integer quantite) {
		this.quantite = quantite;
	}

	public String getLabelProduit() {
		return labelProduit;
	}

	public void setLabelProduit(String labelProduit) {
		this.labelProduit = labelProduit;
	}
	
	
}
