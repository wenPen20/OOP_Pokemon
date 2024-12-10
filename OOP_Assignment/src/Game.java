import java.util.ArrayList;
import java.util.Scanner;

public class Game {
	Database db = new Database();
	ArrayList<Player> loadedPlayers = db.loadPlayers("Players.txt");
	ArrayList<Pokemon> loadedPokemons = db.loadPokemons("Pokemons.txt");
	ArrayList<Pokeball> loadedPokeballs = db.loadPokeballs("Pokeballs.txt");
	ArrayList<Score> loadedScores = db.loadTopScores("top5Scores.txt");

	public void start() {
		Scanner input = new Scanner(System.in);
		Ascii.WelcomeMessage();

		System.out.printf("\nEnter your username: ");
		String username = input.nextLine();

		boolean playerExist = false;
		for (Player player : loadedPlayers) {
			if (player.getUsername().equals(username)) {
				playerExist = true;
				System.out.println("\nLoaded Saved Player Data:");
				System.out.println(player);
				break;
			}
		}

		if (playerExist == false) {
			System.out.println("\nNew User!");
			System.out.printf("Username: %s \n", username);
			System.out.println("Owned Disks: []");
			System.out.println("Tokens: 0");
		}
		
		
		
		input.close();
	}
}
