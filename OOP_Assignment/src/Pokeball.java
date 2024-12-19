import java.util.HashMap;
import java.util.ArrayList;
import java.util.Random;	

public class Pokeball {
    private String ballName;
    private HashMap<String, Double> gradeCatchRates;

    public Pokeball(String ballName) {
        this.ballName = ballName;
        this.gradeCatchRates = new HashMap<>();
    }

    public String getBallName() {
        return ballName;
    }

    public void setCatchRates(HashMap<String, Double> rates) {
        this.gradeCatchRates = rates;
    }

    public double getCatchRate(String grade) {
        return gradeCatchRates.getOrDefault(grade, 0.0);
    }

    public boolean tryToCatch(Pokemon pokemon) {
        String grade = pokemon.getGrade();
        double catchRate = getCatchRate(grade);
        double randomValue = Math.random();
        return randomValue <= catchRate;
    }

    public static Pokeball getRandomPokeball() {
        ArrayList<Pokeball> availablePokeballs = new ArrayList<>();

        // Add specific pokeball types to the list
        availablePokeballs.add(new NormalBall());
        availablePokeballs.add(new GreatBall());
        availablePokeballs.add(new UltraBall());

        // random pick a pokeball
        Random rand = new Random();
        int index = rand.nextInt(availablePokeballs.size());
        return availablePokeballs.get(index);
    }
    
    @Override
    public String toString() {
        return ballName;
    }
}
