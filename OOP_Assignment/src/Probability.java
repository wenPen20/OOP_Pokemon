import java.io.IOException;
import java.nio.file.*;
import java.util.*;

public class Probability {

    private String grade;

    public Probability() {
        
    }
    
    // This method reads random pokemon data from the "Pokemons.txt" file and assigns a grade to the pokemon based on a random value.
    // It returns a PokemonResult object that contains a dictionary of pokemon and their types, along with the assigned grade.
    public PokemonResult readRandomPokemon() {
        double randomValue = Math.random();
        randomValue = Math.round(randomValue * 100) / 100.0;
        String grade = "";
        String fileName = "Pokemons.txt";
        HashMap<String, String> pokemon = new HashMap<>();

        // Determine the grade based on random value
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

        // Read the pokemon data from the file and filter by grade
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

                // If the pokemon's grade matches, add it to the list of possible pokemon
                if (lineGrade.equals(grade)) {
                    pokemon.put(name, type);
                }
            }
        } catch (IOException e) {
            System.out.println("An error occurred while reading the file: " + e.getMessage());
        }

        return new PokemonResult(pokemon, grade);
    }

    // This method selects a random pokemon from the available options returned by readRandomPokemon.
    // It returns a random pokemon choice as a dictionary.
    public HashMap<String, String> selectRandomPokemon() {
        PokemonResult result = readRandomPokemon();
        HashMap<String, String> pokemons = result.getPokemon();
        HashMap<String, String> choice [] = new HashMap[4];
        
        int i = 0;
        // Stores up to 4 random pokemon choices
        for (Map.Entry<String, String> pokemon : pokemons.entrySet()) {
            HashMap<String, String> temp = new HashMap<>();
            temp.put(pokemon.getKey(), pokemon.getValue());
            choice[i] = temp;
            i++;
        }
        
        grade = result.getGrade();
        
        // Randomly select one of the chices of pokemon from the list
        Random rand = new Random();
        int randomNumber = rand.nextInt(4);
        return choice[randomNumber];
    }

    // This method retrieves a random pokemon from the list and returns it in a PokemonResult object containing name, type, and grade.
    public PokemonResult pokemonName() {
        HashMap<String, String> pokemon = selectRandomPokemon();
        String pokemonName = "", pokemonType = "";
        PokemonResult result = readRandomPokemon();
        
        // Extract the name and type from the selected pokemon
        for (Map.Entry<String, String> entry : pokemon.entrySet()) {
            pokemonName = entry.getKey();
            pokemonType = entry.getValue();
        }
        
        return new PokemonResult(pokemonName, pokemonType, grade);
    }

    // This method returns a string of a random pokemon's name, type, and grade.
    public String getRandomPokemon() {
        PokemonResult nameType = pokemonName();
        return nameType.getName() + ": " + nameType.getType() + ", Grade: " + nameType.getGrade();
    }

    // This method ensures that two randomly selected pokemon choices are not the same.
    public void noDuplicate(String choice1, String choice2) {
        while(true) {
            if (choice1.equals(choice2)) {
                choice2 = getRandomPokemon();
            }
            else {
                break;
            }
        }
    }
}




