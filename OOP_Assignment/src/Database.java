
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
					String username = extractData(parts, 0);
					
					// Extract ownedDisks as collection number
					String PokemonsString = extractData(parts, 1);
					PokemonsString = PokemonsString.replaceAll("\\[|\\]", ""); // Remove square brackets
					String[] PokemonsArray = PokemonsString.split(",\\s*"); // Split by commas
					ArrayList<String> collectionNumberList = new ArrayList<>(Arrays.asList(PokemonsArray));
					
					
					//Transfer array list string data into array list Pokemon data
					ArrayList<Pokemon> ownedPokemons = new ArrayList<>();
					for(String collectionNumber : collectionNumberList ) {
						for(Pokemon pokemon: loadPokemons("Pokemons.txt")) {
							if (collectionNumber.equals(pokemon.getCollectionNumber())) {
								ownedPokemons.add(pokemon);
								break;
							}
						}
					}
					
					
					// Extract tokens
					int tokens = Integer.parseInt(extractData(parts, 2));

					// Create Player object and add it to the list
					Player player = new Player(username, ownedPokemons, tokens);
					players.add(player);
				}
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return players;
	}

	public ArrayList<Pokemon> loadPokemons(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					String[] parts = line.split(",\\s*");

					// Extract data
					String collectionNumber = extractData(parts, 0);
					String grade = extractData(parts, 1);
					String name = extractData(parts, 2);
					int pokeEne = Integer.parseInt(extractData(parts, 3));
					String type = extractData(parts, 4);
					String moveName = extractData(parts, 5);
					int hp = Integer.parseInt(extractData(parts, 6));
					int attack = Integer.parseInt(extractData(parts, 7));
					int defense = Integer.parseInt(extractData(parts, 8));
					int speed = Integer.parseInt(extractData(parts, 9));
					
					HashMap<String, Double> effectiveness = new HashMap<>();
					
					if (type.equals("Normal")) {
						NormalType normalPokemon = new NormalType(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack,
								defense, speed, effectiveness);
						pokemons.add(normalPokemon);	//add normal
					} else if (type.equals("Fire")) {
						FireType firePokemon = new FireType(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack,
								defense, speed, effectiveness);
						pokemons.add(firePokemon);		//add fire
					} else if (type.equals("Grass")) {
						GrassType grassPokemon = new GrassType(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack,
								defense, speed, effectiveness);
						pokemons.add(grassPokemon);		//add grass
					} else if (type.equals("Water")) {
						WaterType waterPokemon = new WaterType(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack,
								defense, speed, effectiveness);
						pokemons.add(waterPokemon);		//add water
					} else {
						Pokemon pokemon = new Pokemon(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack,
								defense, speed);
						pokemons.add(pokemon);	//add Pokemon
					}
				}
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return pokemons;
	}

	public ArrayList<Pokeball> loadPokeballs(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					String[] parts = line.split(",\\s*");

					// Extract data
					String name = extractData(parts, 0);
					double catchRate = Double.parseDouble(extractData(parts, 1));

					Pokeball pokeball = new Pokeball(name, catchRate);
					pokeballs.add(pokeball);
				}
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return pokeballs;
	}

	public ArrayList<Score> loadTopScores(String filePath) {
		try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
			String line;

			while ((line = reader.readLine()) != null) {
				line = line.trim();
				if (!line.isEmpty()) {
					String[] parts = line.split(",\\s*");

					// Extract data
					String username = extractData(parts, 0);
//					int score = Integer.parseInt(extractData(parts, 1));

//					Score scores = new Score(username, score);
//					topScores.add(scores);
				}
			}

		} catch (IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
		return topScores;
	}
	
	

	// helper function to extract data
	public String extractData(String[] parts, int index) {
		String data = parts[index].split("=")[1].trim();
		return data;
	}

}
