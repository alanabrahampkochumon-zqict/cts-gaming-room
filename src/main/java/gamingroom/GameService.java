package gamingroom;

import java.util.ArrayList;
import java.util.List;
import java.util.Iterator;

/**
 * A singleton service for the game engine
 * 
 * @author coce@snhu.edu
 */
public class GameService {

	/**
	 * A list of the active games
	 */
	private static List<Game> games = new ArrayList<Game>();

	/*
	 * Holds the next game identifier
	 */
	private static long nextGameId = 1;

	// Internal variable to hold the singleton instance
	private static GameService gameService = null;
	
	/**
	 * Make the constructor private so that a new instance cannot be instantiated from outside the class.
	 */
	private GameService() { }
	
	/**
	 * Lazily initializes a singleton to GameService and returns a 
	 * new instance if an existing instance does not exist.
	 * 
	 * @return The singleton GameService instance.
	 */
	static GameService getGameService() {
		// The Singleton pattern ensures that only one instance of GameService exists in memory.
		// This prevents resource conflicts and ensures a single point of truth for game data.
		if (gameService == null)
			gameService = new GameService();
		return gameService;
	}

	/**
	 * Construct a new game instance
	 * 
	 * @param name the unique name of the game
	 * @return the game instance (new or existing)
	 */
	public Game addGame(String name) {

		// a local game instance
		Game game = null;

		// Use iterator to look for existing game with same name
		// if found, simply return the existing instance
		Iterator<Game> gamesIterator = games.iterator();
		
		// The Iterator pattern allows us to traverse the 'games' list without exposing the
		// underlying ArrayList structure, providing a safe way to search for existing records.
		while(gamesIterator.hasNext()){
			Game temp = gamesIterator.next(); // Local variable to store current game
			if(temp.getName().equals(name)) // If game's name match the passed-in name, return the current instance
				return temp;
		}
		 
		// if not found, make a new game instance and add to list of games
		if (game == null) {
			game = new Game(nextGameId++, name);
			games.add(game);
		}

		// return the new/existing game instance to the caller
		return game;
	}

	/**
	 * Returns the game instance at the specified index.
	 * <p>
	 * Scope is package/local for testing purposes.
	 * </p>
	 * @param index index position in the list to return
	 * @return requested game instance
	 */
	Game getGame(int index) {
		return games.get(index);
	}
	
	/**
	 * Returns the game instance with the specified id.
	 * 
	 * @param id unique identifier of game to search for
	 * @return requested game instance
	 */
	public Game getGame(long id) {
		
		// Use iterator to look for existing game with same id
		// if found, simply assign that instance to the local variable
		Iterator<Game> gamesIterator = games.iterator();
		
		// The Iterator pattern allows us to traverse the 'games' list without exposing the
		// underlying ArrayList structure, providing a safe way to search for existing records.
		while(gamesIterator.hasNext()){
			Game game = gamesIterator.next(); // Local variable to store current game
			if(game.getId() == id) // If game's name match the passed-in id, return the current instance
				return game;
		}
		
		// If game is not found, then return null
		return null;
	}

	/**
	 * Returns the game instance with the specified name.
	 * 
	 * @param name unique name of game to search for
	 * @return requested game instance
	 */
	public Game getGame(String name) {

		// Use iterator to look for existing game with same name
		// if found, simply assign that instance to the local variable
		Iterator<Game> gamesIterator = games.iterator();
		
		// The Iterator pattern allows us to traverse the 'games' list without exposing the
		// underlying ArrayList structure, providing a safe way to search for existing records.
		while(gamesIterator.hasNext()){
			Game game = gamesIterator.next(); // Local variable to store current game
			if(game.getName().equals(name)) // If game's name match the passed-in name, return the current instance
				return game;
		}

		// If game is not found, then return null
		return null;
	}

	/**
	 * Returns the number of games currently active
	 * 
	 * @return the number of games currently active
	 */
	public int getGameCount() {
		return games.size();
	}
}
