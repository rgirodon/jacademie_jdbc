package org.jacademie.domain;

public class Player {

	private Integer num;
	
	private String name;
	
	private Integer numero;
	
	private Integer equipeId;

	@Override
	public String toString() {
		return "Player [num=" + num + ", name=" + name + ", numero=" + numero
				+ ", equipeId=" + equipeId + "]";
	}

	public Integer getNum() {
		return num;
	}

	public void setNum(Integer num) {
		this.num = num;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getNumero() {
		return numero;
	}

	public void setNumero(Integer numero) {
		this.numero = numero;
	}

	public Integer getEquipeId() {
		return equipeId;
	}

	public void setEquipeId(Integer equipeId) {
		this.equipeId = equipeId;
	}
	
	
}
