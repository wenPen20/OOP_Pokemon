import java.util.Random;

public class Pokeball {
    private String ballName;
    private double catchRate;

    public Pokeball(String ballName, double catchRate) {
        this.ballName = ballName;
        this.catchRate = catchRate;
    }

    public String getBallName() {
        return ballName;
    }

    public double getCatchRate() {
        return catchRate;
    }
    
    public boolean tryToCatch(Pokemon pokemon) {
        double randomValue = Math.random();
        return randomValue <= this.catchRate;
    }
    
    // random pokeball generator 
    public static Pokeball getRandomPokeball() {
        Random random = new Random();
        int randomNumber = random.nextInt(4); // generate a number between 0 and 3

        switch (randomNumber) {
            case 0:
                return new NormalBall();
            case 1:
                return new GreatBall();
            case 2:
                return new UltraBall();
            case 3:
                return new MasterBall();
            default:
                return new NormalBall(); // 
        }
    }
    @Override
    public String toString() {
        return ballName;
    }

}