package org.jacademie.domain;

public class Team {

	private Integer num;
	
	private String name;

	public Team() {
		super();
	}
	
	public Team(Integer num, String name) {
		super();
		this.num = num;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Team [num=" + num + ", name=" + name + "]";
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
	
	
}
