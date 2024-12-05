import java.util.*;

public class TestClass {

	public static void main(String[] args) {
		Database db = new Database();
		
		ArrayList<Player> loadedPlayers = db.loadPlayers("Players.txt");
		System.out.println("=========================");
		System.out.println("Player Database");
		System.out.println("=========================");
		for (Player player : loadedPlayers) {
			System.out.println(player);
			System.out.println();
		}

		ArrayList<Pokemon> loadedPokemons = db.loadPokemons("Pokemons.txt");
		// If current stage is "Fire", add probability to the object
		db.assignProbabilities(loadedPokemons, "Fire");
		
		System.out.println("=========================");
		System.out.println("Pokemon Database");
		System.out.println("=========================");
		for (Pokemon pokemon : loadedPokemons) {
			System.out.println(pokemon);
			System.out.println();
		}

		ArrayList<Pokeball> loadedPokeballs = db.loadPokeballs("Pokeballs.txt");
		System.out.println("=========================");
		System.out.println("Pokeball Database");
		System.out.println("=========================");
		for (Pokeball pokeball : loadedPokeballs) {
			System.out.println(pokeball);
			System.out.println();
		}
		
		
		ArrayList<Score> loadedScores = db.loadScores("top5Scores.txt");
		System.out.println("=========================");
		System.out.println("Score Database");
		System.out.println("=========================");
		for (Score scores : loadedScores) {
			System.out.println(scores);
			System.out.println();
		}
	}

}
