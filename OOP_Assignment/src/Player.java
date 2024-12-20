import java.util.*;

public class Player {
	private String username;
	private ArrayList<Pokemon> ownedPokemons;
	private int tokens;
	
    String red = "\033[31m";  	// Red
    String green = "\u001B[32m";// Green
    String blue = "\033[36m";	// Blue
    String yellow = "\033[33m";	// Yellow
    String gray = "\033[90m";	// Gray
    String reset = "\033[0m";  	// Reset to default color

	// creating new player
	public Player(String username) {
		setUsername(username);
		setOwnedDisks(new ArrayList<Pokemon>());
		this.tokens = 10;
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

	//returns a POKEMON datatype array of the player's disks
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

	public void setOwnedDisks(ArrayList<Pokemon> ownedDisks) {
		this.ownedPokemons = ownedDisks;
	}
	
	public void addToOwnedDisks(Pokemon pokemon) {
		for(Pokemon ownedpokemon: this.ownedPokemons) {
			if(pokemon.getName().equals(ownedpokemon.getName())) {
				throw new IllegalArgumentException("Duplicate");
			}
		}
		this.ownedPokemons.add(pokemon);			
	}

	public int getTokens() {
		return tokens;
	}

	public void earnTokens(int tokens) {
		this.tokens += tokens;
	}

	public void useToken(int cost) {
		if(cost > this.tokens) {
			throw new IllegalArgumentException("Insufficient");
		}
		else {
			this.tokens -= cost;			
		}
	}
	
	// other methods
	
	public void saveDisk(ArrayList<Pokemon> pokemon) {
		if(pokemon.isEmpty()) {
			System.out.println("No Pokémon caught, unable to save disks...");
		}
		while(!pokemon.isEmpty()) {
			try {
				Scanner input = new Scanner(System.in);
				System.out.printf("Your total tokens: %s%d\n%s", yellow, this.tokens, reset);
				System.out.print("Pokémons caught: " + blue);
				ArrayList<String> pokemonNames = new ArrayList<>();
				for(Pokemon pokemonString: pokemon) {
					pokemonNames.add(pokemonString.getName());
				}
				System.out.println(pokemonNames + reset + "\n"
						+ "Spend tokens to save pokémon as disks? [" + green + "Y" + reset + "/" + red + "N" + reset + "]");
				if(input.nextLine().toLowerCase().matches("y")) {
					int count = 1;
					for(Pokemon savablePokemon: pokemon) {
						System.out.printf("\n%s[%d]: %s%d token(s)%s\n", blue, count, yellow, savablePokemon.getCost(), reset); 
						savablePokemon.setHp(savablePokemon.getMaxHp());
						System.out.println(savablePokemon);
						count++;
					}
					System.out.println("Choose pokemon to save [or 0 to return]");
					int pokeselect = input.nextInt();
					if(pokeselect >= 1 && pokeselect <= pokemon.size()) {
						addToOwnedDisks(pokemon.get(pokeselect-1));
						useToken(pokemon.get(pokeselect-1).getCost());
						System.out.printf("%s- %d tokens!\n", blue, pokemon.get(pokeselect-1).getCost());
						System.out.printf("%s+ %s!%s\n\n", green, pokemon.get(pokeselect-1).getName(), reset);
						pokemon.remove(pokeselect-1);
						continue;
					}
					else if (pokeselect == 0){
						continue;
					}
				}
				else {
					break;
				}
			}
			catch(IllegalArgumentException e) {
				if(e.getMessage().equals("Insufficient")) {
					System.out.println(red + "Insufficient funds!\n" + reset);
					continue;
				}
				else if(e.getMessage().equals("Duplicate")) {
					System.out.println(red+ "You already have that Pokémon!\n" + reset);
					continue;
				}
			}
		}
	}
	
	public void awardTokens(Pokemon faintedPokemon) { //Determine the grade of fainted pokemon to award player with the appropriate tokens
    	int tokensEarned = 0;
    	switch(faintedPokemon.getGrade()) {
    		case "★":
    			tokensEarned = 1;
    			break;
    		case "★★":
    			tokensEarned = 2;
    			break;
    		case "★★★":
    			tokensEarned = 3;
    			break;
    		case "★★★★":
    			tokensEarned = 4;
    			break;
    		case "★★★★★":
    			tokensEarned = 5;	
    			break;
    	}
    	System.out.printf(yellow + "+ %d tokens!\n\n" + reset, tokensEarned);
    	earnTokens(tokensEarned);
    }
	
	
	@Override
	public String toString() {
		return String.format("Username: %s \n"
				+ "Owned Disks: %s \n"
				+ "Tokens: %s \n", username, getOwnedDiskNames(), tokens);
	}
}
