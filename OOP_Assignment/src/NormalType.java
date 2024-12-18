public class NormalType extends Pokemon{
	
	public NormalType(String collectionNumber, String name, String type, String moveName, String grade,
			int hp, int attack, int defense, int speed) {
		super(collectionNumber, name, type, moveName, grade, hp, attack, defense, speed);
		// no effectiveness modifiers for NormalTypes
		
	}

	@Override
	public String toString() {
		return String.format(super.toString());	
	}
}
