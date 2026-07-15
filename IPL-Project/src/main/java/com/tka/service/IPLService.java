package com.tka.service;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tka.dao.IPLDao;
import com.tka.entity.Player;

public class IPLService {
	
	private List<Player> allPlayer ;
	private IPLDao ipldao;
	
	public List<Player> getAllPlayer(){
		ipldao = new IPLDao();
		allPlayer = ipldao.getAllPlayer();
		return allPlayer;
	}
//	Sort by Team 
	public List<Player> getPlayerByTeam(String team){
		List<Player> teamlist = new ArrayList<>();
		allPlayer = this.getAllPlayer();
		for(Player p : allPlayer) {
			if(p.getTeam().equalsIgnoreCase(team)) {
				teamlist.add(p);
			}
		}
		return teamlist;
	}
//	INSERT Player
	public String addPlayer(Player p) {
		try {
			ipldao =new IPLDao();
			int row = ipldao.insertPlayer(p);
			if(row > 0) {
				return "Player Inserted Succefully";
			}else {
				return "Faild to Insert";
			}
		} catch (SQLException e) {
			e.printStackTrace();
			return "Error"+ e.getMessage();
		}
	}
	
//	UPDATE Player
	public String updatePlayer(Player p) {
		ipldao =new IPLDao();
		int up = ipldao.updatePlayer(p);
		if(up > 0) {
			return "Updated Player Team Successfully";
		}else {
			return "Faild to Update";
		}
	}
	
//	UPDATE Player Runs
	public String updateRuns(Player p) {
		ipldao =new IPLDao();
		int up = ipldao.updateRuns(p);
		if(up > 0) {
			return "Updated Player Runs Successfully";
		}else {
			return "Faild to Update";
		}
	}
	
//	UPDATE Player Wickets
	public String updateWickets(Player p) {
		ipldao =new IPLDao();
		int up = ipldao.updateWickets(p);
		if(up > 0) {
			return "Updated Player Wickets Successfully";
		}else {
			return "Faild to Update";
		}
	}
	
//	DELETE Player
	public String deletePlayer(Player p) {
		ipldao =new IPLDao();
		int dp = ipldao.deletePlayer(p);
		if(dp > 0) {
			return "Deleted Player Successfully";
		}else {
			return "Faild to Delete";
		}
	}
	
//	Most Runs Score / Orange Cap
	public Player mostRuns() {
		Player most = null ;
		for(Player p : allPlayer) {
			if(most == null || p.getRuns() > most.getRuns()) {
				most = p;
			}
		}
		return most;
	}
	
//	Most Wickets Taken / Purple Cap
	public Player mostWickets() {
		Player most = null ;
		for(Player p : allPlayer) {
			if(most == null || p.getWicket() > most.getWicket()) {
				most = p;
			}
		}
		return most;
	}
}

