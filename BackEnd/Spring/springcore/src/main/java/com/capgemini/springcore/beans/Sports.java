package com.capgemini.springcore.beans;

import java.util.Map;

public class Sports {

	private String name;
	private int totalPlayers;
	private Map<String, String> teamInfo;
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTotalPlayers() {
		return totalPlayers;
	}
	public void setTotalPlayers(int totalPlayers) {
		this.totalPlayers = totalPlayers;
	}
	public Map<String, String> getTeamInfo() {
		return teamInfo;
	}
	public void setTeamInfo(Map<String, String> teamInfo) {
		this.teamInfo = teamInfo;
	}
	
	
	
}
