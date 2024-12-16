import java.util.HashMap;

public class GrassType extends Pokemon{
	private HashMap<String, Double> effectiveness;
	
	public GrassType(String collectionNumber, String name, String type, String moveName, String grade, int pokeEne,
			int hp, int attack, int defense, int speed, HashMap<String, Double> effectiveness) {
		super(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack, defense, speed);
		// Create a copy of the passed map to avoid modifying the original map
		this.effectiveness = new HashMap<>(effectiveness);
		// Assign effectiveness modifiers
		this.effectiveness.put("Fire", 0.5);
		this.effectiveness.put("Grass", 1.0);
		this.effectiveness.put("Water", 1.5);
		;
	}
	
	public HashMap<String, Double> getEffectiveness() {
		return effectiveness;
	}

	@Override
	public String toString() {
		return String.format(super.toString());	
	}
}
