import java.util.ArrayList;

public class Player {
	private String username;
	private ArrayList<String> ownedDisks;
	private int tokens;
	
	// creating new player
	public Player(String username) {
		this.username = username;
		this.ownedDisks = new ArrayList<String>();
		this.tokens = 0;
	}

	// retrieve player
	public Player(String username, ArrayList<String> ownedDisks, int tokens) {
		this.username = username;
		this.ownedDisks = ownedDisks;
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
		return ownedDisks;
	}

	public void setOwnedDisks(ArrayList<String> ownedDisks) {
		this.ownedDisks = ownedDisks;
	}

	public int getTokens() {
		return tokens;
	}

	public void setTokens(int tokens) {
		this.tokens = tokens;
	}

	@Override
	public String toString() {
		return String.format("Player [username=%s, ownedDisks=%s, tokens=%s]", username, ownedDisks, tokens);
	}
	
	// other methods
	public void useToken(int cost) {
		this.tokens -= cost;
	}
	
	public void saveDisk(String pokemon) {
		this.ownedDisks.add(pokemon);
	}
	
}
