
import java.util.*;

public class Game {
	Scanner input = new Scanner(System.in);
	private Database db = new Database();
	private Probability pb = new Probability();
	private Probability pb2 = new Probability();
	private StageSelector stage = new StageSelector();
	private Battle battle;
	private ArrayList<Player> loadedPlayers = db.loadPlayers("Players.txt");
	private Pokemon rental1, rental2, enemy1, enemy2, allypoke1, allypoke2;
	private Player player;
	private boolean loadedRental = true;

	public void start() {
		Ascii.WelcomeMessage();

		System.out.printf("\nEnter your username: ");
		String username = input.nextLine();
		String pName = "";
		
		boolean playerExist = false;
		for (Player player : loadedPlayers) {
			if (player.getUsername().equals(username)) {
				this.player = new Player(username, player.getOwnedDisks(), player.getTokens());
				pName = username;
				
				System.out.println("\nLoaded Saved Player Data:");
				System.out.println(this.player);
				playerExist = true;
				break;
			}
		}

		if (playerExist == false) {
			player = new Player(username);
			pName = username;
			
			// add this new user to file.txt if player is not null
			if (!username.contentEquals("")){
				Player newPlayerAdd = new Player(username);
				db.updatePlayerFile(newPlayerAdd);
				this.loadedPlayers = db.loadPlayers("Players.txt");
			}
			
			System.out.println("\nHello New User! This is Your Player Data.");
			System.out.println(this.player);			
		}
		
		// game loop
		while (true) {
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
				System.out.printf("Your current owned disks: %d\n", player.getOwnedDisks().size());
			}
			else {
				System.out.println("Your current owned disks: -");
			}
			
			// check if player has enough pokemons
			if (player.getOwnedDisks().size() < 2) { // if players dont have enough pokemons, use rentals
				System.out.println("You do not have enough disks to play, here's two rental Pokémons for you! \n");
				System.out.println(rental1);
				System.out.println(rental2);
				
				battle = new Battle(username, rental1, rental2, enemy1, enemy2, db);
				
				// prints old and new top scores
				Top5Player newPlayer = new Top5Player(pName, battle.getScore());
				// prints score, update score textfile
				newPlayer.updateScoreAndWriteToFile(newPlayer, db);
				
			} else {
				//case for user to choose between rental and their own pokemons.
				
				Scanner input = new Scanner(System.in);
				System.out.printf("Saved pokemon available to use!\n"
						+ "[1] Load saved pokemon or [2] use rentals?\n");
				if(input.nextInt()==1) {
					int count = 0;
					System.out.println();
					for(Pokemon pokemon: player.getOwnedDisks()) {
						System.out.printf("[%d] ", count);
						System.out.println(pokemon);
						count++;
					}
					
					while(true) {
						System.out.println("Choose the first pokemon on your team!");
						int pokeselect1 = input.nextInt();
						if(pokeselect1 >= 0 && pokeselect1 < player.getOwnedDisks().size()) {
							allypoke1 = player.getOwnedDisks().get(pokeselect1);
						}
						else {
							System.out.println("Enter a valid selection!");
							continue;
						}
						
						System.out.println("Choose the second pokemon on your team!");
						int pokeselect2 = input.nextInt();
						if(pokeselect2 >= 0 && pokeselect2 < player.getOwnedDisks().size() && pokeselect1 != pokeselect2) {
							allypoke2 = player.getOwnedDisks().get(pokeselect2);
							break;
						}
						else {
							System.out.println("Enter a valid selection! (no duplicate selections)");
							continue;
						}
						
					}
					System.out.printf("\nPokemon chosen: \n%s\n%s\n", allypoke1, allypoke2);
					
					battle = new Battle(username, allypoke1, allypoke2, enemy1, enemy2, db);

					// prints old and new top scores
					Top5Player newPlayer = new Top5Player(pName, battle.getScore());
					// prints score, update score textfile
					newPlayer.updateScoreAndWriteToFile(newPlayer, db);
				}
				else {
					System.out.println("Loading rentals...");
					System.out.println(rental1);
					System.out.println(rental2);
					loadedRental = false;
					
					battle = new Battle(username, rental1, rental2, enemy1, enemy2, db);
					
					// prints old and new top scores
					Top5Player newPlayer = new Top5Player(pName, battle.getScore());
					// prints score, update score textfile
					newPlayer.updateScoreAndWriteToFile(newPlayer, db);
				}
		}
			int redoGame = 0;
			while(true) {
				try {
					System.out.print("\nType [1] to start another round or [2] to stop: ");
					redoGame = input.nextInt();
					
					if (redoGame == 1 || redoGame == 2) {
						break;
					}
					else {
						System.out.println("Incorrect input");
					}
				} catch (InputMismatchException e) {
					System.out.println("Input Error ");
					input.nextLine();
					continue;
				}
			}
			
			if (redoGame == 1) {
				if (loadedRental) {
                    resetPokemonsAlly();
                }
                else {
                    resetPokemonRental();
                }
				continue;
			}
			else if (redoGame == 2) {
				Ascii.ThankYouMessage();
				input.close();
				break;
			}

		}	

	}
	
	public void resetPokemonsAlly() {
        allypoke1.reset();
        allypoke2.reset();
        allypoke1 = null;
        allypoke2 = null;
        enemy1.reset();
        enemy2.reset();
    }

    public void resetPokemonRental() {
        rental1.reset();
        rental2.reset();
        enemy1.reset();
        enemy2.reset();
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
