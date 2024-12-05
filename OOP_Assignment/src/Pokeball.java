
public class Pokeball {
	private String ballName;
	private double catchRate;
	
	public Pokeball() {
		this.ballName = "Unknown Ball";
		this.catchRate = 0.0;
	}
	
	public Pokeball(String ballName, double catchRate) {
		this.ballName = ballName;
		this.catchRate = catchRate;
	}

	public String getBallName() {
		return ballName;
	}

	public void setBallName(String ballName) {
		this.ballName = ballName;
	}

	public double getCatchRate() {
		return catchRate;
	}

	public void setCatchRate(double catchRate) {
		this.catchRate = catchRate;
	}

	@Override
	public String toString() {
		return String.format("Pokeball [ballName=%s, catchRate=%s]", ballName, catchRate);
	}
	
	
}
