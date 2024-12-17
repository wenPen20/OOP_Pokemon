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
    
    @Override
    public String toString() {
        return ballName;
    }

}
