import java.util.ArrayList;

public class Player {
	private String username;
	private ArrayList<Pokemon> ownedPokemons;
	private int tokens;
	private Score highScore;
	

	// creating new player
	public Player(String username) {
		this.username = username;
		this.ownedPokemons = new ArrayList<Pokemon>();
		this.tokens = 0;
	}

	// retrieve player
	public Player(String username, ArrayList<Pokemon> ownedDisks, int tokens) {
		this.username = username;
		this.ownedPokemons = ownedDisks;
		this.tokens = tokens;
	}

	// setter and getters
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public ArrayList<Pokemon> getOwnedDisks() {
		return ownedPokemons;
	}
	
	//returns a STRING array of the player's disks
	public ArrayList<String> getOwnedDiskNames() {
		ArrayList<String> ownedPokemonNames = new ArrayList<>();
		for(Pokemon pokemon: this.ownedPokemons) {
			ownedPokemonNames.add(pokemon.getName());
		}
		return ownedPokemonNames;
	}

	//returns a POKEMON datatype array of the player's disks
	public void setOwnedDisks(ArrayList<Pokemon> ownedDisks) {
		this.ownedPokemons = ownedDisks;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	public Score getHighScore() {
		return highScore;
	}
	
	public void setHighScore(Score highScore) {
		this.highScore = highScore;
	}

	
	// other methods
	public void useToken(int cost) {
		this.tokens -= cost;
	}
	
	public void saveDisk(Pokemon pokemon) {
		this.ownedPokemons.add(pokemon);
	}
	
	@Override
	public String toString() {
		return String.format("Username: %s \n"
				+ "Owned Disks: %s \n"
				+ "Tokens: %s \n", username, getOwnedDiskNames(), tokens);
	}
}
