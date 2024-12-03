
public class Stats {
	private int hp;
	private int specialAttack;
	private int defense;
	private int specialDefense;
	private int speed;
	
	// if not specified
	public Stats() {
		this.hp = 50;
		this.specialAttack = 50;
		this.defense = 50;
		this.specialDefense = 50;
		this.speed = 50;
	}

	// if specified 
	public Stats(int hp, int specialAttack, int defense, int specialDefense, int speed) {
		this.hp = hp;
		this.specialAttack = specialAttack;
		this.defense = defense;
		this.specialDefense = specialDefense;
		this.speed = speed;
	}

	public int getHp() {
		return hp;
	}

	public void setHp(int hp) {
		this.hp = hp;
	}

	public int getSpecialAttack() {
		return specialAttack;
	}

	public void setSpecialAttack(int specialAttack) {
		this.specialAttack = specialAttack;
	}

	public int getDefense() {
		return defense;
	}

	public void setDefense(int defense) {
		this.defense = defense;
	}

	public int getSpecialDefense() {
		return specialDefense;
	}

	public void setSpecialDefense(int specialDefense) {
		this.specialDefense = specialDefense;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	@Override
	public String toString() {
		return String.format("Stats [hp=%s, specialAttack=%s, defense=%s, specialDefense=%s, speed=%s]", hp,
				specialAttack, defense, specialDefense, speed);
	}	
}
