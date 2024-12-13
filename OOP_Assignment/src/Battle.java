import java.util.HashMap;
import java.util.Map;
import java.lang.Math;

public class Battle {
    private Pokemon ally1, ally2, enemy1, enemy2;
    private Map<String, Double> typeEffectiveness;

	public Battle(Pokemon ally1, Pokemon ally2, Pokemon enemy1, Pokemon enemy2) {
		this.ally1 = ally1;
		this.ally2 = ally2;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
		
		startBattle();
		attack(ally1, enemy1, enemy2); // test in progress (DO NOT TOUCH)
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
	
	public boolean pokemonStart(Pokemon pok1, Pokemon pok2) { // test in progress (DO NOT TOUCH)
		boolean pokemonStart = true;
		if (pok1.getSpeed() > pok2.getSpeed()) {
			return pokemonStart; //(T) pokemon 1 is faster
		} else {
			return !pokemonStart; //(F) pokemon 2 is faster
		}
	}
	
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
	
	public double attack(Pokemon attacker, Pokemon enemy1, Pokemon enemy2) { // test in progress (DO NOT TOUCH)
	    effectiveness(); 
		
		String attackerType = attacker.getType();
	    String enemyType1 = enemy1.getType();
	    String enemyType2 = enemy2.getType();
	    String key1 = attackerType + "->" + enemyType1;
	    String key2 = attackerType + "->" + enemyType2;
	    
	    int enemyDef1 = enemy1.getDefense();
	    int enemyDef2 = enemy2.getDefense();
	    double totalDamage1 = 0, totalDamage2 = 0, baseDamage;
	    
        double effMult1 = typeEffectiveness.getOrDefault(key1, 1.0);
        double effMult2 = typeEffectiveness.getOrDefault(key2, 1.0);

	    baseDamage = attacker.getAttack();
	    
	    
	    if ((baseDamage * effMult1) < enemyDef1*1.2) {
	    	totalDamage1 += Math.ceil((baseDamage * effMult1)*0.2);
	    } else {
	    	totalDamage1 += baseDamage * effMult1;
	    	totalDamage1 -= enemyDef1;
	    }
	    
	    if ((baseDamage * effMult2) < enemyDef2*1.2) {
	    	totalDamage2 += Math.ceil((baseDamage * effMult2)*0.2);
	    } else {
	    	totalDamage2 += baseDamage * effMult2;
	    	totalDamage2 -= enemyDef2;
	    }  
	    
	    System.out.println(totalDamage1);
	    System.out.println(totalDamage2);
	    return totalDamage1; 
	}
	
}
