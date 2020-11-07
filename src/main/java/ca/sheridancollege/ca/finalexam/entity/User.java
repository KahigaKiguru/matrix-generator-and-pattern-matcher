package ca.sheridancollege.ca.finalexam.entity;

import javax.persistence.*;

@Entity
public class User {

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int Id;
	@Column(name = "name")
	private String name;
	@Column(name = "games_played",unique = false)
	private int gamesPlayed = 0;
	@Column(name = "games_won")
	private int gamesWon = 0;
	@Column(name = "games_lost")
	private int gamesLost = 0;
	@Column(name = "score")
	private int score = 0;
	
	public User() {}
	
	public User(String name, int gamesPlayed, int gamesWon, int gamesLost, int score){
		this.name = name;
		this.gamesPlayed = gamesPlayed;
		this.gamesWon = gamesWon;
		this.gamesLost = gamesLost;
		this.score = score;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	public String getName() {
		return name;
	}
	public void addGamesPlayed(boolean won) {
		if(won) {
			gamesPlayed++;
			addGamesWon();
			addScore();
		}else
			gamesPlayed++;
			addGamesLost();
	}
	
	private void addGamesWon() {
		gamesWon++;
	}
	private void addGamesLost() {
		gamesLost++;
	}
	public void addScore() {
		score += 100;
	}
	
	
}
