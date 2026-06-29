package com.tka.entity;

public class Player {
	private int p_id;
	private int j_n;
	private String p_name; 
	private int runs;
	private int wicket;
	private String team;
	
	public Player() {
		
	}

	public Player(int p_id,int j_n, String p_name, int runs, int wicket, String team) {
		super();
		this.p_id = p_id;
		this.j_n = j_n;
		this.p_name = p_name;
		this.runs = runs;
		this.wicket = wicket;
		this.team = team;
	}

	public int getJ_n() {
		return j_n;
	}

	public void setJ_n(int j_n) {
		this.j_n = j_n;
	}

	public String getP_name() {
		return p_name;
	}

	public void setP_name(String p_name) {
		this.p_name = p_name;
	}

	public int getRuns() {
		return runs;
	}

	public void setRuns(int runs) {
		this.runs = runs;
	}

	public int getWicket() {
		return wicket;
	}

	public void setWicket(int wicket) {
		this.wicket = wicket;
	}

	public String getTeam() {
		return team;
	}

	public void setTeam(String team) {
		this.team = team;
	}

	public int getP_id() {
		return p_id;
	}

	public void setP_id(int p_id) {
		this.p_id = p_id;
	}

	@Override
	public String toString() {
		return "Player [j_n=" + j_n + ", p_name=" + p_name + "]";
	}
	
}
