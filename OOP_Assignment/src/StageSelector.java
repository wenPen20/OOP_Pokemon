import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class StageSelector {
	
	private int stage;
	private Scanner scanner = new Scanner(System.in);
	private List<String> selectedPokemon = new ArrayList<>();
	private String[] selectedPokemonRoar = new String[3];
	private String temp;

	public void setStage() {
		System.out.println("===========================================================");
        System.out.print("[1] Fire, [2] Water, [3] Grass\nChoose a stage: ");
        int input = scanner.nextInt();
        System.out.println("===========================================================");
		this.stage = input;
	}

	public StageSelector() {
        
    }

    public void Stage() {
        Probability probability = new Probability();
        PokemonResult result = probability.readRandomPokemon(); 

        HashMap<String, String> pokemon = result.getPokemon();
        String grade = result.getGrade();

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
            System.out.println("Grade: " + grade);
        }
    }
    
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

        if (randomValue >= 0.00 && randomValue < 0.50) {
            for (String result : results) {
                    String pokemonName = result.split(": ")[0];
                    temp = pokemonName;
                    if (!selectedPokemon.contains(temp)) {
                    	System.out.println("Selected " + result);
                    }
            }
        } else if (randomValue >= 0.50 && randomValue < 1.00) {
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
        }
    }
    
    public void roarSelector(){
    	int i = 0, input = 0;
    	
    	for (String pokemon : selectedPokemon) {
    		selectedPokemonRoar[i] = pokemon;
        	i++;
    	}
    	

    	System.out.println("===========================================================");
    	System.out.print("[1] " + selectedPokemonRoar[0] + ", [2] " + selectedPokemonRoar[1] + ", [3] " + selectedPokemonRoar[2] + "\n" + "Choose a pokemon to roar: ");
    	input = scanner.nextInt();
    	
    	switch (input) {
        case 1:
        	System.out.println(selectedPokemonRoar[0] + " is roaring!");
        	break;
        case 2:
        	System.out.println(selectedPokemonRoar[1] + " is roaring!");
        	break;
        case 3:
        	System.out.println(selectedPokemonRoar[2] + " is roaring!");
        	break;
    }
    	System.out.println("===========================================================");
    	
    }
    
    public void roar() {
    	setStage();
    	while (selectedPokemon.size() < 3) {
    		Stage();
    	}
        roarSelector();
        //test
    } 
}
