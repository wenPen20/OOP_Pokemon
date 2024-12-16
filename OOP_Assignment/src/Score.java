

public class Score {
    private int score;
    private int allyAlive;
    private int enemyDefeated;
    private int damageBonus;
    private int effectiveAttackBonus;
    private int remainingHpBonus;
    private int turnScore;
    private int winBonus;

    public Score(int score) {
        this.score = 0;
        this.allyAlive = 0;
        this.enemyDefeated = 0;
        this.damageBonus = 0;
        this.effectiveAttackBonus = 0;
        this.remainingHpBonus = 0;
        this.turnScore = 0;
        this.winBonus = 0;
    }

    public Score() {
		
	}


    public int getScore() {
        return score;
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void allyAlive() {
    	score += 500;
    	allyAlive += 500;
    }
    
    public void enemyDefeated() {
    	score += 500;
    	enemyDefeated += 500;
    }
    
    public void damageBonus(int damage) {
    	int damageScore = damage * 10;
    	score += damageScore;
    	damageBonus += damageScore;
    }
    
    public void effectiveAttackBonus(String eff) {
    	if (eff == "Super Effective") {
    		score += 300;
    		effectiveAttackBonus += 400;
    	}
    	else if (eff == "Effective") {
    		score += 200;
    		effectiveAttackBonus += 250;
    	}
    	else if (eff == "Not Effective") {
    		score += 100;
    		effectiveAttackBonus += 100;
    	}
    }
    
    public void remainingHpBonus(int hp) {
    	int hpScore = hp * 15;
    	score += hpScore;
    	remainingHpBonus += hpScore;
    }
    
    public void turnScore(int turnCount) {
    	
        if (turnCount > 0 && turnCount <= 3) {
        	score += 1000;
        	turnScore += 1000;
        }
        else if (turnCount > 3 && turnCount <= 6) {
        	score += 500;
        	turnScore += 500;
        }
        else if (turnCount > 6 && turnCount <= 10) {
        	score += 250;
        	turnScore += 250;
        }
        else if (turnCount > 10) {
        	score += 100;
        	turnScore += 100;
        }
        
    }
    
    public void winBonus() {
    	score += 5000;
    	winBonus += 5000;
    }

    @Override
    public String toString() {
        return "\033[1mAlive Ally Bonus:\033[0m " + allyAlive + "\n"
             + "\033[1mDefeated Enemy Bonus:\033[0m " + enemyDefeated + "\n"
             + "\033[1mDamage Bonus:\033[0m " + damageBonus + "\n"
             + "\033[1mEffective Attack Bonus:\033[0m " + effectiveAttackBonus + "\n"
             + "\033[1mRemaining Hp Bonus:\033[0m " + remainingHpBonus + "\n"
             + "\033[1mTurn Bonus:\033[0m " + turnScore + "\n"
             + "\033[1mWin Bonus:\033[0m " + winBonus + "\n"
             + "\033[1mScore:\033[0m " + score + "\n";
    }
}

