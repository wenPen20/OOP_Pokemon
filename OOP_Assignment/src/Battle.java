
public class Battle extends Probability{
	
	public void rentalPokemon() {
		getRandomPokemon();
	}
	
	public void enemyPokemon() {
		getRandomPokemon();
	}
	
	public void battleStart() {
		
		System.out.println("BATTLE STARTING!");
		System.out.println("===========================================================");
		System.out.println("Your Rental Pokemons:");
		rentalPokemon();
		rentalPokemon();
		System.out.println("===========================================================");
		System.out.println("The Enemy Pokemons:");
		enemyPokemon();
		enemyPokemon();
	}
	
}
