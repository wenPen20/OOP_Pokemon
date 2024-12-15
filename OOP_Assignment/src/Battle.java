
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.lang.Math;
import java.util.Scanner;

public class Battle {
    private Pokemon ally1, ally2, enemy1, enemy2;
    private Map<String, Double> typeEffectiveness;
    private ArrayList<String> faintedMessages = new ArrayList<>();

	public Battle(Pokemon ally1, Pokemon ally2, Pokemon enemy1, Pokemon enemy2) {
		this.ally1 = ally1;
		this.ally2 = ally2;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
		
	    effectiveness();
		startBattle();
		teamTurns();
		//Checks which team is faster then checks which pokemon is faster

	}
	
	public void startBattle() { // test in progress (DO NOT TOUCH)
		Ascii.BattleStartMessage();
		System.out.println("\n\nTwo enemy Pokémons appeared! \n");
		System.out.println("Enemy 1 \n" + enemy1);
		System.out.println("Enemy 2 \n" + enemy2);
	}
	
	public boolean startTurn() { // test in progress (DO NOT TOUCH)
		boolean team1Start = true;
		if ((ally1.getSpeed() + ally2.getSpeed()) > (enemy1.getSpeed() + enemy2.getSpeed())) {
			return team1Start; //(T) team 1 is faster
		} else {
			team1Start = false;
			return team1Start; //(F) team 2 is faster
		}	
	}
	
	public void teamTurns() {
	    boolean allyTeam = true;
	    boolean enemyTeam = true;
    	Scanner scanner = new Scanner(System.in);
    	
    	System.out.println("===========================================================");
    	System.out.print("Type anything to start the round: ");
    	String input = scanner.next();
    	//initialize turn counter for each team
    	int turnCount1 = getStart(ally1, ally2);
    	int turnCount2 = getStart(enemy1, enemy2);
	    
	    // Check which team starts first
	    if (startTurn()) {
	        System.out.println("Your team starts FIRST!");
	        attack(pokemonStart(ally1, ally2) ? ally1 : ally2, enemy1, enemy2);
	        turnCount1 += 1;

	        allyTeam = false;
	        enemyTeam = true;
	    } else {
	        System.out.println("Enemy team starts FIRST!");
	        attack(pokemonStart(enemy1, enemy2) ? enemy1 : enemy2, ally1, ally2);
	        turnCount2 += 1;
	        
	        enemyTeam = false;
	        allyTeam = true;
	    }
	    if (!faintedMessages.isEmpty()) {
	        System.out.println(faintedMessages);
	    }
	    printTeams();

	    while (true) {
	    	System.out.println("===========================================================");
	    	System.out.print("Type anything to start the next round: ");
	    	String input1 = scanner.next();
	    	
	    	while(true) {
		        if (allyTeam) { // Ally's turn
		            if (turnCount1 % 2 == 0) { // Ally1's turn
		                if (ally1.getHp() > 0) {
		                	System.out.println("\nYour team's turn!");
		                    System.out.println(ally1.getName() + " attacks using " + ally1.getMoveName() + "!");
		                    attack(ally1, enemy1, enemy2);
		                } else {
		                    turnCount1++; // Increment to switch to Ally2
		                    continue;
		                }
		            } else { // Ally2's turn
		                if (ally2.getHp() > 0) {
		                	System.out.println("\nYour team's turn!");
		                    System.out.println(ally2.getName() + " attacks using " + ally2.getMoveName() + "!");
		                    attack(ally2, enemy1, enemy2);
		                } else {
		                    turnCount1++; // Increment to switch back to Ally1
		                    continue;
		                }
		            }
		            turnCount1++;
		            allyTeam = false;
		            enemyTeam = true;
		            break;
		        } 
		        
		        else if (enemyTeam){ // Enemy's turn
		            if (turnCount2 % 2 == 0) { // Enemy1's turn
		                if (enemy1.getHp() > 0) {
		                	System.out.println("\nEnemy team's turn!");
		                    System.out.println(enemy1.getName() + " attacks using " + enemy1.getMoveName() + "!");
		                    attack(enemy1, ally1, ally2);
		                } else {
		                    turnCount2++; // Increment to switch to Enemy2
		                    continue;
		                }
		            } else { // Enemy2's turn
		                if (enemy2.getHp() > 0) {
		                	System.out.println("\nEnemy team's turn!");
		                    System.out.println(enemy2.getName() + " attacks using " + enemy2.getMoveName() + "!");
		                    attack(enemy2, ally1, ally2);
		                } else {
		                	turnCount2++; // Increment to switch back to Enemy1
		                    continue;
		                }
		            }
		            turnCount2++;
		            allyTeam = true; 
		            enemyTeam = false;
		            break;
		        }
	    	}


		    if (!faintedMessages.isEmpty()) {
		        System.out.println(faintedMessages);
		    }
	        

	        if (ally1.getHp() < 0 && ally2.getHp() < 0) {
	        	Ascii.GameOverMessage();
	        	break;
	        }
	        if (enemy1.getHp() < 0 && enemy2.getHp() < 0) {
	        	Ascii.YouWonMessage();
	        	break;
	        }
	        
	        printTeams();
	    }
	}
	
	private void printTeams() {
	    System.out.println("\nAlly Team:");
	    if (ally1.getHp() > 0) {
	        System.out.println(ally1);
	    }
	    if (ally2.getHp() > 0) {
	        System.out.println(ally2);
	    }

	    System.out.println("\nEnemy Team:");
	    if (enemy1.getHp() > 0) {
	        System.out.println(enemy1);
	    }
	    if (enemy2.getHp() > 0) {
	        System.out.println(enemy2);
	    }
	}
	
	//determine which pokemon has the higher speed to start first turn
	public boolean pokemonStart(Pokemon pok1, Pokemon pok2) { // test in progress (DO NOT TOUCH)
		boolean pokemonStart = true;
		if (pok1.getSpeed() > pok2.getSpeed()) {
			System.out.println(pok1.getName() + " attacks first using " + pok1.getMoveName() + "!");
			return pokemonStart; //(T) pokemon 1 is faster
		} else {
			System.out.println(pok2.getName() + " attacks first using " + pok2.getMoveName() + "!");
			return !pokemonStart; //(F) pokemon 2 is faster
		}
	}
	
	//save a hashmap of counter values, use them for comparison later
	public void effectiveness() { // test in progress (DO NOT TOUCH)
        typeEffectiveness = new HashMap<>();

        // Populate the effectiveness values
        typeEffectiveness.put("Water->Fire", 1.5);
        typeEffectiveness.put("Water->Grass", 0.5);
        typeEffectiveness.put("Water->Water", 1.0);

        typeEffectiveness.put("Fire->Grass", 1.5);
        typeEffectiveness.put("Fire->Water", 0.5);
        typeEffectiveness.put("Fire->Fire", 1.0);

        typeEffectiveness.put("Grass->Water", 1.5);
        typeEffectiveness.put("Grass->Fire", 0.5);
        typeEffectiveness.put("Grass->Grass", 1.0);
    }
	
	//get effectiveness message
    private String getEffectivenessStatus(double effMult) {
        if (effMult == 1.5) {
            return "Super Effective";
        } else if (effMult == 1.0) {
            return "Effective";
        } else if (effMult == 0.5) {
            return "Not Effective";
        }
        return "";
    }
	
	public void attack(Pokemon attacker, Pokemon enemy1, Pokemon enemy2) { // test in progress (DO NOT TOUCH)
		
		String attackerType = attacker.getType();
	    String enemyType1 = enemy1.getType();
	    String enemyType2 = enemy2.getType();
	    String key1 = attackerType + "->" + enemyType1;
	    String key2 = attackerType + "->" + enemyType2;
	    
	    double maxHp1 = enemy1.getHp();
	    double maxHp2 = enemy2.getHp();
	    int newHp1 = 0, newHp2 = 0;
	    
	    int enemyDef1 = enemy1.getDefense();
	    int enemyDef2 = enemy2.getDefense();
	    double totalDamage1 = 0, totalDamage2 = 0, baseDamage;
	    
	    // look for effectiveness in hashmap
        double effMult1 = typeEffectiveness.getOrDefault(key1, 1.0);
        double effMult2 = typeEffectiveness.getOrDefault(key2, 1.0);
	    String effectStatus1 = getEffectivenessStatus(effMult1);
	    String effectStatus2 = getEffectivenessStatus(effMult2);

	    baseDamage = attacker.getAttack();
	    
	    //Damage calculations
	    if ((baseDamage * effMult1) < enemyDef1*1.2) {
	    	totalDamage1 = Math.ceil((baseDamage * effMult1)*0.2);
	    } else {
	    	totalDamage1 = baseDamage * effMult1 - enemyDef1;
	    }
	    
	    if ((baseDamage * effMult2) < enemyDef2*1.2) {
	    	totalDamage2 = Math.ceil((baseDamage * effMult2)*0.2);
	    } else {
	    	totalDamage2 = baseDamage * effMult2 - enemyDef2;
	    }
	    
	    if (enemy1.getHp() > 0) {
	    	System.out.println(String.format("\nIt's %s against %s dealing \u001B[1m%.2f\u001B[0m damage!", effectStatus1, enemy1.getName(),  Math.ceil(totalDamage1)));
	    }
	    if (enemy2.getHp() > 0) {
	    	System.out.println(String.format("It's %s against %s dealing \u001B[1m%.2f\u001B[0m damage!", effectStatus2, enemy2.getName(),  Math.ceil(totalDamage2)));
	    }
  
		newHp1 = (int) (maxHp1 - totalDamage1);
		newHp2 = (int) (maxHp2 - totalDamage2);
	    
	    enemy1.setHp(newHp1);
	    enemy2.setHp(newHp2);
	    hpCheck(enemy1);
	    hpCheck(enemy2);
	    
	}
	
	// check if hp of pokemon < 0
	public void hpCheck(Pokemon pokemon) {
	    if (pokemon.getHp() < 0) {
	        String message = "Fainted: " + pokemon.getName();

	        if (!faintedMessages.contains(message)) {
	            faintedMessages.add(message);
	        }
	    }
	}
	
	public int skipPokemon(Pokemon pok) {
		int turnCount = 0;
		if (pok.getHp() < 0) {
			turnCount = 1;
		}
		else {
			turnCount = 0;
		}
		return turnCount;
	}
	
	// get starting pokemon thru getting their speeds first
	public int getStart(Pokemon pok1, Pokemon pok2) {
		if (pok1.getSpeed() > pok2.getSpeed()) {
			return 0; //pokemon 1 can cycle at even indexes
		}else {
			return 1; //pokemon 2 can cycle at odd indexes
		}
	}
	
}


