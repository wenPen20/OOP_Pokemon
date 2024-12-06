import java.util.ArrayList;

public class Player {
	private String username;
	private ArrayList<String> ownedPokemons;
	private int tokens;
	
	// creating new player
	public Player(String username) {
		this.username = username;
		this.ownedPokemons = new ArrayList<String>();
		this.tokens = 0;
	}

	// retrieve player
	public Player(String username, ArrayList<String> ownedDisks, int tokens) {
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

	public ArrayList<String> getOwnedDisks() {
		return ownedPokemons;
	}

	public void setOwnedDisks(ArrayList<String> ownedDisks) {
		this.ownedPokemons = ownedDisks;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return String.format("Username: %s \n"
				+ "Owned Disks: %s \n"
				+ "Tokens: %s \n", username, ownedPokemons, tokens);
	}
	
	// other methods
	public void useToken(int cost) {
		this.tokens -= cost;
	}
	
	public void saveDisk(String pokemon) {
		this.ownedPokemons.add(pokemon);
	}
	
}
