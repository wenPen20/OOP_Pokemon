import java.util.ArrayList;

public class top5Player extends Player {
	
	private int rank;

	public top5Player(String username, ArrayList<Pokemon> ownedDisks, int tokens, int rank) {
		super(username, ownedDisks, tokens);
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
