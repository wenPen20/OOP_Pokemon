import java.util.*;

public class Game {
	Scanner input = new Scanner(System.in);
	Database db = new Database();
	Probability pb = new Probability();
	Probability pb2 = new Probability();
	StageSelector stage = new StageSelector();
	Battle battle;
	ArrayList<Player> loadedPlayers = db.loadPlayers("Players.txt");
	ArrayList<Pokemon> loadedPokemons = db.loadPokemons("Pokemons.txt");
	ArrayList<Pokeball> loadedPokeballs = db.loadPokeballs("Pokeballs.txt");
	ArrayList<Score> loadedScores = db.loadTopScores("top5Scores.txt");
	Pokemon rental1, rental2, enemy1, enemy2;
	Player player;

	public void start() {
		Ascii.WelcomeMessage();

		System.out.printf("\nEnter your username: ");
		String username = input.nextLine();

		boolean playerExist = false;
		for (Player player : loadedPlayers) {
			if (player.getUsername().equals(username)) {
				this.player = new Player(username, player.getOwnedDisks(), player.getTokens());
				
				System.out.println("\nLoaded Saved Player Data:");
				System.out.println(this.player);
				playerExist = true;
				break;
			}
		}

		if (playerExist == false) {
			player = new Player(username);
			
			System.out.println("\nHello New User! This is Your Player Data.");
			System.out.println(this.player);			
		}

		// select a stage and choose a pokemon to roar
		stage.selectStage();

		// roared pokemon / first rental pokemon
		rental1 = stage.getRoaredPokemon();
		rental2 = pb.selectRandomPokemon();
		rental2 = noDuplicate(rental1, rental2);

		// generate two enemy pokemons
		enemy1 = pb2.selectRandomPokemon();
		enemy2 = pb2.selectRandomPokemon();
		enemy2 = noDuplicate1(enemy1, enemy2);
		
		if (player.getOwnedDisks().size() > 0) {
			System.out.println("Your current owned disks: " + player.getOwnedDisks());
		} else {
			System.out.println("Your current owned disks: -");
		}
		
		// check if player has enough pokemons
		if (player.getOwnedDisks().size() < 2) { // if players dont have enough pokemons, use rentals
			System.out.println("You do not have enough disks to play, here's two rental Pokémons for you! \n");
			System.out.println(rental1);
			System.out.println(rental2);
			
			battle = new Battle(rental1, rental2, enemy1, enemy2);
			
		} else {
			// implement case for user to choose between rental and their own pokemons. 
		}
		
		
		
		

	}
	// make sure the two pokemons are different
	public Pokemon noDuplicate(Pokemon p1, Pokemon p2) {
		while (p1.getCollectionNumber().equals(p2.getCollectionNumber())) {
			p2 = pb.selectRandomPokemon();
		}
		return p2;
	}
	
	// make sure the two pokemons are different
	public Pokemon noDuplicate1(Pokemon p1, Pokemon p2) {
		while (p1.getCollectionNumber().equals(p2.getCollectionNumber())) {
			p2 = pb2.selectRandomPokemon(); //different database prevents the self-damage issue
		}
		return p2;
	}
	
}
