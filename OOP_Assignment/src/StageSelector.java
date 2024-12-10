import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StageSelector {
	
	private int stage;
	private Scanner scanner = new Scanner(System.in);
	private List<String> selectedPokemon = new ArrayList<>();
	private List<String> selectedPokemonType = new ArrayList<>();
	private List<String> selectedPokemonGrade = new ArrayList<>();
	private String[] selectedPokemonRoar = new String[3];
	private String[] selectedPokemonRoarType = new String[3];
	private String[] selectedPokemonRoarGrade = new String[3];
	private String roaredPokemon;
	private String roaredPokemonType;
	private String roaredPokemonGrade;
	private String grade;
	private String temp;
	
	public StageSelector() { }

	public StageSelector(String roaredPokemon, String grade) {
        this.roaredPokemon = roaredPokemon;
        this.grade = grade;
    }


	//Prompts the user to choose a stage (Fire, Water, or Grass) and sets the stage value.
	public void setStage() {
		System.out.println("===========================================================");
        System.out.print("[1] Fire, [2] Water, [3] Grass\nChoose a stage: ");
        int input = scanner.nextInt();
        System.out.println("===========================================================");
		this.stage = input;
	}

	//Selects pokemon based on the current stage and adjusts probabilities to favor stage-aligned pokemon.
    public void Stage() {
        Probability probability = new Probability();
        PokemonResult result = probability.readRandomPokemon(); 

        HashMap<String, String> pokemon = result.getPokemon();
        grade = result.getGrade();

    	switch (stage) {
        case 1:
        	adjustProb(pokemon, "Fire");
        	break;
        case 2:
        	adjustProb(pokemon, "Water");
        	break;
        case 3:
        	adjustProb(pokemon, "Grass");
        	break;
    }
    	
        if (!selectedPokemon.contains(temp)) {
            selectedPokemon.add(temp);
            selectedPokemonGrade.add(grade);
            System.out.println("Grade: " + grade);
        }
    }
    
	/*
	 Adjusts the probability of selecting pokemon based on their type, based on the type of the stage.
	 pokemon is a dictionary of pokemon names and their types.
	 type The type to prioritize (Fire, Water, or Grass).
	 */
    public void adjustProb(HashMap<String, String> pokemon, String type) {
        List<String> results = new ArrayList<>();
        double randomValue = Math.random();
        randomValue = Math.round(randomValue * 100) / 100.0;

        HashMap<String, String> lowerChancePokemon = new HashMap<>();

        for (String key : pokemon.keySet()) {
            String pokeType = pokemon.get(key);

            if (pokeType.equals(type)) {
                results.add(key + ": " + pokeType);
            } else {
                lowerChancePokemon.put(key, pokeType);
            }
        }

        if (randomValue >= 0.00 && randomValue < 0.60) {
            for (String result : results) {
                String pokemonName = result.split(": ")[0];
                String pokemonType = result.split(": ")[1];
                temp = pokemonName;
                if (!selectedPokemon.contains(temp)) {
                	System.out.println("Selected " + result);
                	selectedPokemonType.add(pokemonType);
                }            
            }
        } else if (randomValue >= 0.60 && randomValue < 1.00) {
        	// Randomly select a Pokémon from the lower chance dictionary
            Random random = new Random();
            List<String> lowerChanceKeys = new ArrayList<>(lowerChancePokemon.keySet());
            
            // Get a random index from the list of lower chance Pokémon keys
            int randomIndex = random.nextInt(lowerChanceKeys.size());
            String randomKey = lowerChanceKeys.get(randomIndex);

            // Retrieve the Pokémon type using the random key
            String randomPokeType = lowerChancePokemon.get(randomKey);
            
            temp = randomKey;
            if (!selectedPokemon.contains(temp)) {
            	System.out.println("Selected: " + randomKey + ": " + randomPokeType);
            }
            selectedPokemonType.add(randomPokeType);
        }
    }
    
	/*
	 Allows the user to select a pokemon to roar from the chosen pokemon list.
	 Updates the roaring pokemon's attributes.
	 */
    public void roarSelector() {
    	int input = 0;
    	
    	for (int h = 0; h < selectedPokemon.size(); h++) {
    	    selectedPokemonRoar[h] = selectedPokemon.get(h);
    	    selectedPokemonRoarType[h] = selectedPokemonType.get(h);
    	    selectedPokemonRoarGrade[h] = selectedPokemonGrade.get(h);
    	}

    	System.out.println("===========================================================");
    	System.out.print("[1] " + selectedPokemonRoar[0] + ", [2] " + selectedPokemonRoar[1] + ", [3] " + selectedPokemonRoar[2] + "\n" + "Choose a pokemon to roar: ");
    	input = scanner.nextInt();
    	
    	printSetRoarAttribtes(input - 1);
    	System.out.println("===========================================================");
    }

	 // Sets the attributes of the roaring pokemon based on the user's choice.
    public void printSetRoarAttribtes(int input) {
    	System.out.println(selectedPokemonRoar[input] + " is roaring!");
    	roaredPokemon = selectedPokemonRoar[input];
    	roaredPokemonType = selectedPokemonRoarType[input];
    	roaredPokemonGrade = selectedPokemonRoarGrade[input];
    }
    
	//Executes the entire roaring process: sets the stage, selects pokemon, and prompts the user to choose a roaring pokemon.
    public void roar() {
    	setStage();
    	while (selectedPokemon.size() < 3) {
    		Stage();
    	}
        roarSelector();
    }
    
    public String getRoaredPokemon() {
    	return roaredPokemon;
    }
    
    public String getRoaredPokemonType() {
    	return roaredPokemonType;
    }
    
    public String getRoaredPokemonGrade() {
    	return roaredPokemonGrade;
    }
}

