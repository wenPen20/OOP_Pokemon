package defa;
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Top5Player {
	
	private String username;
	private int rank;
	private int score;
	
	public Top5Player(String username, int score) {
		this.username = username;
		this.score = score;
		this.rank = 0;
	}

	public int getRank() {
		return rank;
	}

	public void setRank(int rank) {
		this.rank = rank;
	}
	
	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public int getScore() {
		return score;
	}

	public void setScore(int score) {
		this.score = score;
	}
	
	@Override
	public String toString() {
		return String.format("\033[1mRank: %d\033[0m"
				+ "\nUsername: %s"
				+ "\nScore: %d", rank, username , score);
	}
	
	// update top 5
	public ArrayList<Top5Player> updateScore(Top5Player player, Database db) {
		ArrayList<Top5Player> loadedTop5 = db.loadTopPlayer("top5Scores.txt");
		System.out.println("\033[1mOld Top 5\033[0m");
		for (int i = 0; i < loadedTop5.size(); i++) {
			System.out.println(loadedTop5.get(i));
		}
		
		// Check if the player's score is greater than any of the current scores
	    boolean scoreAdded = false;
	    for (int i = 0; i < loadedTop5.size(); i++) {
	        Top5Player currentPlayer = loadedTop5.get(i);


	        if (player.getScore() > currentPlayer.getScore()) {
	            // Add player in the appropriate position (higher score) and shift the others down
	            loadedTop5.add(i, player);
	            // Update the ranks
	            updateRanks(loadedTop5);

	            scoreAdded = true;
	            break; // Exit the loop as the player is added
	        }
	    }
	    
	 // If the player's score wasn't greater than any of the top 5, we check if they should be added to the last position
	    if (!scoreAdded && loadedTop5.size() < 5) {
	        loadedTop5.add(player);
	        updateRanks(loadedTop5);
	    }

	    // If the list is now larger than 5 players, remove the lowest-ranked player
	    if (loadedTop5.size() > 5) {
	        loadedTop5.remove(loadedTop5.size() - 1); // Remove the player with the lowest score (last in the list)
	    }

	    // Return the updated list of top 5 players
	    System.out.println("\n\033[1mNew Top 5\033[0m");
		for (int i = 0; i < loadedTop5.size(); i++) { //print new top 5
			System.out.println(loadedTop5.get(i));
		} 
	    return loadedTop5;
	    
	}
	
	// Method to update the ranks of the players
	public void updateRanks(ArrayList<Top5Player> players) {
	    for (int i = 0; i < players.size(); i++) {
	        players.get(i).setRank(i + 1); // Set the rank based on position in the list
	    }
	}
	
	public void writeTop5ToFile(ArrayList<Top5Player> updatedTop5) {
	    // Path to the file
	    String filePath = "top5Scores.txt";

	    // Try-with-resources to ensure the file writer is closed properly
	    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filePath))) {
	        // Loop through the updated list and write each player's details in the specified format
	        for (Top5Player topPlayer : updatedTop5) {
	            writer.write("username=" + topPlayer.getUsername() + ", highscore=" + topPlayer.getScore() + ", rank=" + topPlayer.getRank());
	            writer.newLine(); // Write a newline after each entry
	        }
	    } catch (IOException e) {
	        System.out.println("An error occurred while writing to the file: " + e.getMessage());
	    }
	}
	
	public void updateScoreAndWriteToFile(Top5Player player, Database db) {
	    // Get the updated top 5 players list
	    ArrayList<Top5Player> updatedTop5 = updateScore(player, db);

	    // Write the updated top 5 list to the file
	    writeTop5ToFile(updatedTop5);
	}
	
}
