import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		Database db = new Database();
		ArrayList<Player> loadedPlayers = db.loadPlayers("Players.txt");
		
		for (Player player : loadedPlayers) {
            System.out.println("Username: " + player.getUsername());
            System.out.println("Owned Disks: " + player.getOwnedDisks());
            System.out.println("Tokens: " + player.getTokens());
            System.out.println();
        }
	}

}
