
public class Pokemon {
	private String collectionNumber, grade, name, type, moveName, team;
	private int maxHp, hp, attack, defense, speed;
	
	public Pokemon() {
		this.collectionNumber = "10-001";
		this.name = "New Pokemon";
		this.type = "Normal";
		this.moveName = "Basic Attack";
		this.grade = "★";
		this.hp = 25;
		this.maxHp = 25;
		this.attack = 25;
		this.defense = 25;
		this.speed = 25;
		this.team = "No team";
	}
	
	public Pokemon(String collectionNumber, String name, String type, String moveName, String grade, int hp,
			int attack, int defense, int speed) {
		this.collectionNumber = collectionNumber;
		this.name = name;
		this.type = type;
		this.moveName = moveName;
		this.grade = grade;
		this.hp = hp;
		this.maxHp = hp;
		this.attack = attack;
		this.defense = defense;
		this.speed = speed;
		this.team = team;
	}

	public String getCollectionNumber() {
		return collectionNumber;
	}

	public String getName() {
		return name;
	}

	public String getType() {
		return type;
	}

	public String getMoveName() {
		return moveName;
	}

	public String getGrade() {
		return grade;
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

	public int getDefense() {
		return defense;
	}

	public int getSpeed() {
		return speed;
	}
	
	public String getTeam() {
        return team;
    }

    public void setTeam(String team) {
        this.team = team;
    }

	@Override
    public String toString() {
        return String.format("%s %s \n"
                + "Type: %s \n"
                + "HP: %d/%d \n" // Show HP in currentHp/maxHp format
                + "Attack: %s \n"
                + "Defense: %s \n"
                + "Speed: %s \n", name, grade, type, hp, maxHp, attack, defense, speed);
	}
	
}
