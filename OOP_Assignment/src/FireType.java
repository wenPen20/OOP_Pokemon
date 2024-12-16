import java.util.HashMap;

public class FireType extends Pokemon{
	private HashMap<String, Double> effectiveness;
	
	public FireType(String collectionNumber, String name, String type, String moveName, String grade, int pokeEne,
			int hp, int attack, int defense, int speed, HashMap<String, Double> effectiveness) {
		super(collectionNumber, name, type, moveName, grade, pokeEne, hp, attack, defense, speed);
		// Create a copy of the passed map to avoid modifying the original map
		this.effectiveness = new HashMap<>(effectiveness);
		// Assign effectiveness modifiers
		this.effectiveness.put("Fire", 1.0);
		this.effectiveness.put("Grass", 1.5);
		this.effectiveness.put("Water", 0.5);
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
