
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
		this.team = team;		// set later
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

	public int getMaxHp() {
		return maxHp;
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

    public int getCost() { // return the cost to save a particular pokemon
    	int tokenCost = 0;
    	switch(this.grade) {
    		case "★":
    			tokenCost = 1;
    			break;
    		case "★★":
    			tokenCost = 4;
    			break;
    		case "★★★":
    			tokenCost = 9;
    			break;
    		case "★★★★":
    			tokenCost = 16;
    			break;
    		case "★★★★★":
    			tokenCost = 25;	
    			break;
    	}
    	return tokenCost;
    }
    
    @Override
    public String toString() {
        // Calculate the percentage of HP
        double hpPercentage = (double) hp / maxHp * 100;
        
        // Determine the color based on HP percentage
        String hpColor;
        if (hpPercentage > 70) {
            hpColor = "\u001B[32m"; // Green
        } else if (hpPercentage > 30) {
            hpColor = "\u001B[33m"; // Yellow
        } else {
            hpColor = "\u001B[31m"; // Red
        }
        
        // Determine the color based on the Pokémon's type
        String typeColor;
        switch (type.toLowerCase()) {
            case "grass":
                typeColor = "\u001B[32m"; // Green for Grass type
                break;
            case "fire":
                typeColor = "\u001B[31m"; // Yellow for Fire type
                break;
            case "water":
                typeColor = "\u001B[36m"; // Blue for Water type
                break;
            case "normal":
                typeColor = "\u001B[37m"; // Dark Gray for Normal type
                break;
            default:
                typeColor = "\u001B[0m"; // Default color if no match (reset)
                break;
        }
        
        // Reset color to default
        String resetColor = "\u001B[0m";
        
        // Return the formatted string with colored HP
        return String.format("%s %s \n"
                    + "Type: %s%s%s \n"
                    + "HP: %s%d%s/%d \n"  // Show HP in currentHp/maxHp format
                    + "Attack: %s \n"
                    + "Defense: %s \n"
                    + "Speed: %s \n", 
                    name, grade, typeColor, type, resetColor, hpColor, hp, resetColor, maxHp, attack, defense, speed);
    }
	
}
