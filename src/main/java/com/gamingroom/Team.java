package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * A simple class to hold information about a team
 * <p>
 * Notice the overloaded constructor that requires
 * an id and name to be passed when creating.
 * Also note that no mutators (setters) defined so
 * these values cannot be changed once a team is
 * created.
 * </p>
 * @author coce@snhu.edu
 *
 */
public class Team extends Entity {

	List<Player> players;


	/*
	 * Constructor with an identifier and name
	 */
	public Team(long id, String name) {
		super(id, name);
		players = new ArrayList<>();
	}

	/**
	 * Adds a player to the game if the player already doesn't exist.
	 * @param name The name of the player to add.
	 * @return the player instance (new or existing).
	 */
	public Player  addPlayer(String name) {
		Player player = null;
		Iterator<Player> iterator = players.iterator();


		// Iterate through the player to find if a player with same with the name already exists.
		while (iterator.hasNext()) {
			Player temp = iterator.next();
			if(temp.getName().equals(name)) {
				// Early exit and return the player.
				return temp;
			}
		}

		// If player does not exist, then add it to the current team.
		if(player == null) {
			player = new Player(GameService.getNextPlayerId(), name);
			players.add(player);
		}

		// return Player
		return player;
	}


	@Override
	public String toString() {
		return "Team [id=" + getId() + ", name=" + getName() + ", players=" + players + "]";
	}
}
