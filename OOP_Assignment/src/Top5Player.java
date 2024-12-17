import java.util.ArrayList;

public class Top5Player {
	
	private int rank;
	private String username;
	
	public Top5Player(int rank, String username) {
		this.rank = rank;
		this.username = username;
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
