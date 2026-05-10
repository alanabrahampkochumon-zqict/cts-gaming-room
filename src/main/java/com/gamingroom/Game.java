package com.gamingroom;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class Game extends Entity {
    private List<Team> teams;

	/**
	 * Constructor with an identifier and name
	 */
	public Game(long id, String name) {
        super(id, name);
        teams = new ArrayList<>();
	}

	/**
	 * Adds a team to the game if the team already doesn't exist.
	 * @param name The name of the team to add.
	 * @return the team instance (new or existing).
	 */
	public Team  addTeam(String name) {

		// Iterate through the teams to find if a team with same with the name already exists.
		Iterator<Team> iterator = teams.iterator();
		while (iterator.hasNext()) {
			Team temp = iterator.next();
			if(temp.getName().equals(name)) {
				// Early exit and return the team.
				return temp;
			}
		}

		// If player does not exist, then add it to the current team.
		Team team = new Team(GameService.getNextTeamId(), name);
		// Add the team to our existing list
		teams.add(team);
		// Return the new team.
		return team;
	}


	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + ", teams=" + teams + "]";
	}

}
