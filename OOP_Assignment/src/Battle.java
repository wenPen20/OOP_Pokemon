public class Battle extends Probability{
    
    // gets both of our rental pokemons with one being the user's selected pokemon and the other is a random pokemon.
    public void rentalPokemon() {
        StageSelector roaredPokemon = new StageSelector();
        
        //selects the roared pokemon's attributes
        roaredPokemon.roar();
        
        // Get the name of the roared pokemon
        String nameRental1 = roaredPokemon.getRoaredPokemon();
        
        // Get a random pokemon
        String rental2 = selectRandomPokemon();
        
        // Gets the name, type and grade of the pokemons
        int colonIndex = rental2.indexOf(":");
        int commaIndex = rental2.indexOf(",");
        int gradeIndex = rental2.indexOf("Grade:");
        String nameRental2 = rental2.substring(0, colonIndex).trim();
        String typeRental2 = rental2.substring(colonIndex + 1, commaIndex).trim();
        String gradeRental2 = rental2.substring(gradeIndex + 6).trim();
        
        System.out.println("BATTLE STARTING!");
        System.out.println("===========================================================");
        System.out.println("Your Rental Pokemons:");
        System.out.println(nameRental1 + ": " + roaredPokemon.getRoaredPokemonType() + ", Grade:" + roaredPokemon.getRoaredPokemonGrade()); 
        
        noDuplicate(nameRental1,nameRental2); 
        System.out.println(nameRental2 + ": " + typeRental2 + ", Grade:" + gradeRental2);
    }
    
    public void enemyPokemon() {
        String enemy1 = "", enemy2 = "";
        
        // Get two random pokemon for the enemy.
        enemy1 = selectRandomPokemon();
        enemy2 = selectRandomPokemon();
        
        noDuplicate(enemy1,enemy2);
        System.out.println(enemy1 + "\n" + enemy2);
    }
    
    public void battleStart() {
        rentalPokemon();
        System.out.println("===========================================================");
        System.out.println("The Enemy Pokemons:");
        enemyPokemon();
    }
}
