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
		Team team = null;
		Iterator<Team> iterator = teams.iterator();

		// Iterate through the teams to find if a team with same with the name already exists.
		while (iterator.hasNext()) {
			Team temp = iterator.next();
			if(temp.getName().equals(name)) {
				// Early exit and return the team.
				return team;
			}
		}

		// If player does not exist, then add it to the current team.
		if(team == null) {
			team = new Team(GameService.getNextTeamId(), name);
			teams.add(team);
		}

		// Return the team.
		return team;
	}


	@Override
	public String toString() {
		return "Game [id=" + getId() + ", name=" + getName() + ", teams=" + teams + "]";
	}

}
