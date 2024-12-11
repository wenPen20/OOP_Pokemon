import java.util.*;

public class StageSelector {
	
	private int stage;
	private Scanner scanner = new Scanner(System.in);
	private ArrayList<Pokemon> selectedPokemon = new ArrayList<>();
	private Pokemon roaredPokemon;
	
	public StageSelector() { 
		
	}
	
	// Executes the entire roaring process: sets the stage, selects pokemon, and prompts the user to choose a roaring pokemon.
    public void selectStage() {
    	// prompts user to select a stage
    	System.out.println("===========================================================");
        System.out.print("[1] Fire, [2] Water, [3] Grass\nChoose a stage: ");
        int input = scanner.nextInt();
        System.out.println("===========================================================");
		this.stage = input;
		
		System.out.println("Three wild Pokémons appeared!\n");
		
		// generate three random pokemons to choose from
    	while (selectedPokemon.size() < 3) {
    		Stage();
    	}
    	
    	// prompts user to select one of three pokemons
    	System.out.println("===========================================================");
    	System.out.printf("[1] %s \n[2] %s \n[3] %s \n", selectedPokemon.get(0).getName(), selectedPokemon.get(1).getName(), selectedPokemon.get(2).getName());
    	System.out.print("Choose a Pokémon to roar: ");
    	input = scanner.nextInt();
    	System.out.println("===========================================================");
    	
    	roaredPokemon = selectedPokemon.get(input - 1); 
    	System.out.printf("%s is roaring! \n\n", roaredPokemon.getName());
       
    }
	

	// Selects pokemon based on the current stage and adjusts probabilities to favor stage-aligned pokemon.
    public void Stage() {
        Probability probability = new Probability();
        ArrayList<Pokemon> pokemons = probability.getSameGradePokemons(); 

    	switch (stage) {
        case 1:
        	adjustProb(pokemons, "Fire");
        	break;
        case 2:
        	adjustProb(pokemons, "Water");
        	break;
        case 3:
        	adjustProb(pokemons, "Grass");
        	break;
    	}
    }
    
	/* Increase rate of pokemon with same type as stage */
    public void adjustProb(ArrayList<Pokemon> pokemon, String type) {
    	Pokemon higherChancePokemon = new Pokemon(); // store a single pokemon
    	ArrayList<Pokemon> lowerChancePokemon = new ArrayList<>(); // store the three other pokemons
        double randomValue = Math.random();
        randomValue = Math.round(randomValue * 100) / 100.0;
        
        // separate the rate up pokemon from the other three
        for (Pokemon p : pokemon) {
        	if (type.equals(p.getType())) {
        		higherChancePokemon = p;
        	} else {
        		lowerChancePokemon.add(p);
        	}
        }
        
        
        // if chosen the rate up pokemon, get its name and grade (maybe even print out the entire pokemon details)
        if (randomValue >= 0.00 && randomValue < 0.60) {
        	boolean pExist = false;
        	
        	// loop through the list to check if duplicate pokemon exist
        	for (Pokemon p : selectedPokemon) {
        		if (p.getCollectionNumber().equals(higherChancePokemon.getCollectionNumber())) {
        			pExist = true;
        		}
        	}
        	
        	// if not exist, add to the list
        	if (pExist == false) {
        		selectedPokemon.add(higherChancePokemon);
        		System.out.printf("%s %s \n", higherChancePokemon.getName(), higherChancePokemon.getGrade());
        	}
        	
        } else if (randomValue >= 0.60 && randomValue < 1.00) { // Randomly select a Pokémon from the lower chance list
        	boolean pExist = false;
        	Random random = new Random();
        	
        	int randomIndex = random.nextInt(lowerChancePokemon.size());
        	Pokemon rateDownPokemon = lowerChancePokemon.get(randomIndex);
        	
        	for (Pokemon p : selectedPokemon) {
        		if (p.getCollectionNumber().equals(rateDownPokemon.getCollectionNumber())) {
        			pExist = true;
        		}
        	}
        	
        	if (pExist == false) {
        		selectedPokemon.add(rateDownPokemon);
        		System.out.printf("%s %s \n", rateDownPokemon.getName(), rateDownPokemon.getGrade());
        	}
        }
    }
    
    public Pokemon getRoaredPokemon() {
    	return roaredPokemon;
    }
}

