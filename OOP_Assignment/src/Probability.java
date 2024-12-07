import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class Probability {
	
	private int stage;
	
	public void setStage() {
		try {
			Scanner scanner = new Scanner(System.in);
	        System.out.println("Choose a stage:\n[1] Fire, [2] Water, [3] Grass");
	        int input = scanner.nextInt();
			this.stage = input;
		} catch (InputMismatchException e) {
			System.out.println("Incorrect input, please try again.");
		}
	}
	
	public Probability() {
        
    }

    public void Stage() {
        double randomValue = Math.random();
        randomValue = Math.round(randomValue * 100) / 100.0;
        String grade = "", fileName = "Pokemons.txt";

        if (randomValue >= 0.00 && randomValue < 0.40) {
            grade = "★";
        } else if (randomValue >= 0.40 && randomValue < 0.70) {
            grade = "★★";
        } else if (randomValue >= 0.70 && randomValue < 0.85) {
            grade = "★★★";
        } else if (randomValue >= 0.85 && randomValue < 0.95) {
            grade = "★★★★";
        } else if (randomValue >= 0.95 && randomValue <= 1.0) {
            grade = "★★★★★";
        }

        try {
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            HashMap<String, String> pokemon = new HashMap<>();

            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(", ");
                String lineGrade = "", name = "", type = "";


                // Extract the grade and name from the line
                for (String part : parts) {
                    if (part.startsWith("grade=")) {
                        lineGrade = part.substring(6);
                    }
                    if (part.startsWith("name=")) {
                        name = part.substring(5);
                    }
                    if (part.startsWith("type=")) {
                        type = part.substring(5);
                    }
                }
                if (lineGrade.equals(grade)) {
                    pokemon.put(name, type);
                }
            }
            System.out.println("The grade of the four pokemon are (test only) " + grade);
            System.out.println("(testing) " + pokemon);
            
            
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
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
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
            System.out.print("Selected *Pokémon with higher chance*: ");
            for (String result : results) {
                    System.out.println(result);
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
            

            System.out.println("Selected *Pokémon with lower chance*: " + randomKey + ": " + randomPokeType);
        }
    }


    public static void main(String[] args) {
        Probability stage = new Probability();
        stage.Stage();
    }
}