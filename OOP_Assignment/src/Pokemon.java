
public class Pokemon {
	private String collectionNumber, name, type, moveName;
	private int grade, pokeEne, hp, attack, defense, speed;
	
	public Pokemon() {
		this.collectionNumber = "10-001";
		this.name = "New Pokemon";
		this.type = "Normal";
		this.moveName = "Basic Attack";
		this.grade = 1;
		this.pokeEne = 1000;
		this.hp = 25;
		this.attack = 25;
		this.defense = 25;
		this.speed = 25;
	}
	
	public Pokemon(String collectionNumber, String name, String type, String moveName, int grade, int pokeEne, int hp,
			int attack, int defense, int speed) {
		this.collectionNumber = collectionNumber;
		this.name = name;
		this.type = type;
		this.moveName = moveName;
		this.grade = grade;
		this.pokeEne = pokeEne;
		this.hp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
	}

	public String getCollectionNumber() {
		return collectionNumber;
	}

	public void setCollectionNumber(String collectionNumber) {
		this.collectionNumber = collectionNumber;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getMoveName() {
		return moveName;
	}

	public void setMoveName(String moveName) {
		this.moveName = moveName;
	}

	public int getGrade() {
		return grade;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getPokeEne() {
		return pokeEne;
	}

	public void setPokeEne(int pokeEne) {
		this.pokeEne = pokeEne;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getAttack() {
		return attack;
	}

	public void setAttack(int attack) {
		this.attack = attack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return String.format(
				"Pokemon [collectionNumber=%s, name=%s, type=%s, moveName=%s, grade=%s, pokeEne=%s, hp=%s, attack=%s, defense=%s, speed=%s]",
				collectionNumber, name, type, moveName, grade, pokeEne, hp, attack, defense, speed);
	}
	
	public void useMove(Pokemon target) {
		
	}
	
}
