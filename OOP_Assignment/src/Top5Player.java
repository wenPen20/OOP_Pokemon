import java.util.ArrayList;

public class Top5Player extends Player {
	
	private int rank;

	public Top5Player(String username, Score playerScore, int rank) {
		super(username, playerScore);
		this.rank = rank;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}

	@Override
	public String toString() {
		return String.format(super.toString() 
				+ "Rank: %d \n", rank);
	}

}
