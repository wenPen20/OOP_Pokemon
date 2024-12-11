import java.util.*;

public class Probability {
	
	String grade;
	private ArrayList<Pokemon> pokemons;
	Database db = new Database();
	ArrayList<Pokemon> loadedPokemons = db.loadPokemons("Pokemons.txt");

	public Probability() {
		pokemons = new ArrayList<>();
	}

	// this function used to be readRandomPokemons()
	// select pokemons based on grade
	public ArrayList<Pokemon> getSameGradePokemons() {
		double randomValue = Math.random();
		randomValue = Math.round(randomValue * 100) / 100.0;
		String grade = "";

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
		
		// Loop through the pokemon ArrayList and filter by grade
		for (Pokemon p : loadedPokemons) {
			if (grade.equals(p.getGrade())) {
				pokemons.add(p);
			}
		}
		
		return pokemons;
	}
	
	// select a random pokemon, accounting for grade but ignoring type
    public Pokemon selectRandomPokemon() {
        ArrayList<Pokemon> randP = getSameGradePokemons();
        Random random = new Random();
        
        int randomIndex = random.nextInt(randP.size());
        Pokemon randomPokemon = randP.get(randomIndex);
        
        return randomPokemon;
        
    }
	
}
