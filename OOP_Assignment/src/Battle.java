public class Battle {
    private Pokemon ally1, ally2, enemy1, enemy2;

	public Battle(Pokemon ally1, Pokemon ally2, Pokemon enemy1, Pokemon enemy2) {
		this.ally1 = ally1;
		this.ally2 = ally2;
		this.enemy1 = enemy1;
		this.enemy2 = enemy2;
		
		startBattle();
	}
	
	public void startBattle() {
		Ascii.BattleStartMessage();
		System.out.println("\n\nTwo enemy Pokémons appeared! \n");
		System.out.println("Enemy 1 \n" + enemy1);
		System.out.println("Enemy 2 \n" + enemy2);
	}
	
}
