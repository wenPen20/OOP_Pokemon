
public class Pokemon {
	private String collectionNumber, grade, name, type, moveName, team;
	private int pokeEne, maxHp, hp, attack, defense, speed;
	private double probability;
	
	public Pokemon() {
		this.collectionNumber = "10-001";
		this.name = "New Pokemon";
		this.type = "Normal";
		this.moveName = "Basic Attack";
		this.grade = "★";
		this.pokeEne = 1000;
		this.hp = 25;
		this.maxHp = 25;
		this.attack = 25;
		this.defense = 25;
		this.speed = 25;
		this.team = "No team";
		this.probability = 0.0;
	}
	
	public Pokemon(String collectionNumber, String name, String type, String moveName, String grade, int pokeEne, int hp,
			int attack, int defense, int speed) {
		this.collectionNumber = collectionNumber;
		this.name = name;
		this.type = type;
		this.moveName = moveName;
		this.grade = grade;
		this.pokeEne = pokeEne;
		this.hp = hp;
		this.maxHp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.team = team;
		this.probability = 0.0;
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

	public String getGrade() {
		return grade;
	}

	public void setGrade(String grade) {
		this.grade = grade;
	}

	public int getPokeEne() {
		return pokeEne;
	}

	public void setPokeEne(int pokeEne) {
		this.pokeEne = pokeEne;
	}
	
    public int getMaxHp() {
        return maxHp;
    }

    public void setMaxHp(int maxHp) {
        this.maxHp = maxHp;
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
	
	public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }
	
	public double getProbability() {
        return probability;
    }

    public void setProbability(double probability) {
        this.probability = probability;
    }

	@Override
    public String toString() {
        return String.format("%s %s \n"
                + "Type: %s \n"
                + "HP: %d/%d \n" // Show HP in currentHp/maxHp format
                + "Attack: %s \n"
                + "Defense: %s \n"
                + "Speed: %s \n", name, grade, type, hp, maxHp, attack, defense, speed);
<<<<<<< HEAD
    
		
//		return String.format(
//				"Pokemon [collectionNumber=%s, name=%s, type=%s, moveName=%s, grade=%s, pokeEne=%s, hp=%s, attack=%s, defense=%s, speed=%s, probability=%f]",
//				collectionNumber, name, type, moveName, grade, pokeEne, hp, attack, defense, speed, probability);
=======
>>>>>>> 704e428260e76dae8645ccd7ca2e888749b958cb
	}
	
	public void useMove(Pokemon target) {
		
	}
	
}