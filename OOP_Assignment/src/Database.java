import java.util.*;
import java.io.*;

public class Database {
	private ArrayList<Player> players;
	private ArrayList<Pokemon> pokemons;
	private ArrayList<Pokeball> pokeballs;
	private ArrayList<Score> topScores;

	public Database() {
		this.players = new ArrayList<>();
		this.pokemons = new ArrayList<>();
		this.pokeballs = new ArrayList<>();
		this.topScores = new ArrayList<>();
	}

	public ArrayList<Player> loadPlayers(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			// while there are still lines to read
			while ((line = reader.readLine()) != null) {
                line = line.trim();
                if (!line.isEmpty()) {
                	// Split with spaces, except inside brackets
                	String[] parts = line.split(",\\s*(?![^\\[]*\\])");
                    
                    // Extract username
                    String username = parts[0].split("=")[1].trim();
                    
                    // Extract ownedDisks
                    String disksString = parts[1].split("=")[1].trim();
                    disksString = disksString.replaceAll("\\[|\\]", ""); // Remove square brackets
                    String[] disksArray = disksString.split(",\\s*"); // Split by commas
                    ArrayList<String> ownedDisks = new ArrayList<>(Arrays.asList(disksArray));
                  
                    // Extract tokens
                    int tokens = Integer.parseInt(parts[2].split("=")[1].trim());
                    
                    // Create Player object and add it to the list
                    Player player = new Player(username, ownedDisks, tokens);
                    players.add(player);
                }
            }

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return players;
	}

}
