package com.tka.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.tka.entity.Player;

public class IPLDao {
	private String path ="com.mysql.cj.jdbc.Driver";
	private String url ="jdbc:mysql://localhost:3306/advjava_db";
	private String user ="root";
	private String pass ="root";
	
	private String select ="SELECT * FROM player";
	private String insert ="INSERT INTO player VALUES (?,?,?,?,?,?)";
	private String update ="UPDATE player SET Team = ? WHERE p_id = ?";
	private String update1 ="UPDATE player SET Runs = ? WHERE p_id = ?";
	private String update2 ="UPDATE player SET Wickets = ? WHERE p_id = ?";
	private String delete ="DELETE FROM player WHERE p_id = ?";
	
	private Connection conn =null;
	private PreparedStatement pst= null;
	private ResultSet rs =null;
	
	private List<Player> allplayer = null;
	
	public List<Player> getAllPlayer(){
		
		try {
			Class.forName(path);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			pst = conn.prepareStatement(select);
			
			rs = pst.executeQuery();
			
			allplayer =new ArrayList<>();
			while(rs.next()) {
				int p_id = rs.getInt(1);
				int j_n = rs.getInt(2);
				String p_name = rs.getString(3);
				int runs = rs.getInt(4);
				int wickets = rs.getInt(5);
				String team = rs.getString(6);
				
				Player player =new Player(p_id,j_n,p_name,runs,wickets,team);
				
				allplayer.add(player);
				
			}
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return allplayer;
	}
	
//	INSERT
	public int insertPlayer(Player p) throws SQLException{ 
		try {
			Class.forName(path);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			pst = conn.prepareStatement(insert);
			pst.setInt(1, p.getP_id());
			pst.setInt(2, p.getJ_n());
			pst.setString(3, p.getP_name());
			pst.setInt(4, p.getRuns());
			pst.setInt(5, p.getWicket());
			pst.setString(6, p.getTeam());
			return pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
//	UPDATE Team
	public int updatePlayer(Player p) {
		try {
			Class.forName(path);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			pst = conn.prepareStatement(update);
			pst.setString(1, p.getTeam());
			pst.setInt(2, p.getP_id());
			return pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
//	Update Runs
	public int updateRuns(Player p) {
		
		try {
			Class.forName(path);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			pst = conn.prepareStatement(update1);
			pst.setInt(1, p.getRuns());
			pst.setInt(2, p.getP_id());
			return pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
	
//	Update Wickets
	public int updateWickets(Player p) {
		try {
			Class.forName(path);
			
			conn = DriverManager.getConnection(url, user, pass);
			
			pst = conn.prepareStatement(update2);
			pst.setInt(1, p.getWicket());
			pst.setInt(2, p.getP_id());
			return pst.executeUpdate();
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		
		return 0;
	}
	
//	DELETE
	public int deletePlayer(Player p) {
		try {
			Class.forName(path);
			
			conn = DriverManager.getConnection(url, user, pass);
			pst =conn.prepareStatement(delete);
			pst.setInt(1, p.getP_id());
			return pst.executeUpdate();
			
			
			
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return 0;
	}
}

