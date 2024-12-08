import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Probability {
	
	private String grade;
	
	public Probability() {
		
	}//
	
	public PokemonResult readRandomPokemon() {
        double randomValue = Math.random();
        randomValue = Math.round(randomValue * 100) / 100.0;
        String grade = "";
        String fileName = "Pokemons.txt";
        HashMap<String, String> pokemon = new HashMap<>();

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
            for (String line : lines) {
                if (line.trim().isEmpty()) {
                    continue;
                }

                String[] parts = line.split(", ");
                String lineGrade = "", name = "", type = "";

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
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return new PokemonResult(pokemon, grade);
    }
	
	public HashMap<String, String> selectRandomPokemon() {
		PokemonResult result = readRandomPokemon();
		HashMap<String, String> pokemons = result.getPokemon();
		HashMap<String, String> choice [] = new HashMap[4];
		
		
		int i = 0;
		for (Map.Entry<String, String> pokemon : pokemons.entrySet()) {
	        HashMap<String, String> temp = new HashMap<>();
	        temp.put(pokemon.getKey(), pokemon.getValue());
			choice[i] = temp;
			i++;
			}
		grade= result.getGrade();
		
		Random rand = new Random();
		int randomNumber = rand.nextInt(4);
		return choice[randomNumber];
		
		}
	
	public PokemonResult pokemonName() {
		HashMap<String, String> pokemon = selectRandomPokemon();
		String pokemonName = "", pokemonType = "";
		PokemonResult result = readRandomPokemon();
		
	    for (Map.Entry<String, String> entry : pokemon.entrySet()) {
	        pokemonName = entry.getKey();
	        pokemonType = entry.getValue();
	    }
	    return new PokemonResult(pokemonName,pokemonType, grade);
	}

	//
	public void getRandomPokemon() {
	    PokemonResult result = readRandomPokemon();
	    PokemonResult nameType = pokemonName();
	    
	    System.out.println(nameType.getName() + ": " + nameType.getType() + ", Grade: " + nameType.getGrade());
	}
}



