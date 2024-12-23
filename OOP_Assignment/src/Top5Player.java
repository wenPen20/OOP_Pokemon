
import java.util.ArrayList;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashSet;

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
		return String.format("\033[1m %d:\033[0m" + " %s" + " %d", rank, username , score);
	}
	
	// update top 5
	public ArrayList<Top5Player> updateScore(Top5Player player, Database db) {
		
		ArrayList<Top5Player> loadedTop5 = db.loadTopPlayer("top5Scores.txt");
		ArrayList<Top5Player> tempList = new ArrayList<>(loadedTop5);
		
		// Check if the player has a valid username
	    if (player.getUsername() == null || player.getUsername().isEmpty()) {
	        System.out.println("Player has no valid username. No score update will be made.\n");
	        System.out.println("\033[1m			Leaderboard\033[0m");
			for (int i = 0; i < loadedTop5.size(); i++) {
				System.out.println(loadedTop5.get(i));
			}
	        return db.loadTopPlayer("top5Scores.txt");  // Return the current top 5 without making changes
	    }
		
	    boolean changesMade = false;  // Track whether any changes were made
	   
	    

	    boolean scoreAdded = false;
	    
	 // Check if player already exists in the list and if their score is higher
	    for (int i = 0; i < loadedTop5.size(); i++) {
	        Top5Player currentPlayer = loadedTop5.get(i);

	        // If the player is found, check if their score has improved
	        if (currentPlayer.getUsername().equals(player.getUsername())) {
	            if (player.getScore() > currentPlayer.getScore()) {
	                // Update the score if it's improved
	                currentPlayer.setScore(player.getScore());
	                updateRanks(loadedTop5);
	                changesMade = true; // Mark that a change was made
	            }
	            scoreAdded = true;  // Mark that the score was updated (not added)
	            break;
	        }
	    }
	    
	    // Check if player already exists in the list and if their score is higher
	    if (!scoreAdded) {
		    for (int i = 0; i < loadedTop5.size(); i++) {
		        Top5Player currentPlayer = loadedTop5.get(i);
	
	
		        if (player.getScore() > currentPlayer.getScore()) {
		            // Add player in the appropriate position (higher score) and shift the others down
		            loadedTop5.add(i, player);
		            // Update the ranks
		            updateRanks(loadedTop5);
	
		            scoreAdded = true;
	                changesMade = true; // Mark that a change was made

		            break; // Exit the loop as the player is added
		        }
		    }
	    }
	    
	 // If the player's score wasn't greater than any of the top 5, we check if they should be added to the last position
	    if (!scoreAdded && loadedTop5.size() < 5) {
	        loadedTop5.add(player);
	        updateRanks(loadedTop5);
            changesMade = true; // Mark that a change was made

	    }

	 // Ensure there are no duplicate players (by name), and remove the one with the lower score if duplicates exist
	    HashSet<String> playerNames = new HashSet<>();
	    for (int i = 0; i < loadedTop5.size(); i++) {
	        Top5Player currentPlayer = loadedTop5.get(i);
	        if (playerNames.contains(currentPlayer.getUsername())) {
	            // Find the duplicate and remove the one with the lower score
	            int duplicateIndex = -1;
	            for (int j = i + 1; j < loadedTop5.size(); j++) {
	                if (loadedTop5.get(j).getUsername().equals(currentPlayer.getUsername())) {
	                    if (loadedTop5.get(j).getScore() < currentPlayer.getScore()) {
	                        duplicateIndex = j;
	                    } else {
	                        duplicateIndex = i;
	                    }
	                    break;
	                }
	            }

	            if (duplicateIndex != -1) {
	                loadedTop5.remove(duplicateIndex);
	                changesMade = true; // Mark that a change was made
	                i--; // Adjust the index to account for removal
	            }
	        } else {
	            playerNames.add(currentPlayer.getUsername());
	        }
	    }
	    
	    // Sort the list based on score in descending order
	    loadedTop5.sort((p1, p2) -> Integer.compare(p2.getScore(), p1.getScore()));
	    
	    // Reassign ranks based on the new order after sorting
        for (int i = 0; i < loadedTop5.size(); i++) {
            loadedTop5.get(i).setRank(i + 1); // Set rank to the position in the list (1-based index)
        }
	    
	    // If the list is now larger than 5 players, remove the lowest-ranked player
	    if (loadedTop5.size() > 5) {
	        loadedTop5.remove(loadedTop5.size() - 1); // Remove the player with the lowest score (last in the list)
            changesMade = true; // Mark that a change was made
	    }

	    // Return the updated list of top 5 players if changes were made
	    if (changesMade) {
	    	// old Leaderboard for testing
//	        System.out.println("\033[1mOld Top 5\033[0m");
//	        for (int i = 0; i < tempList.size(); i++) {
//	            System.out.println(tempList.get(i));
//	        }
	    	// new leaderboard
	        System.out.println("\033[1m			Leaderboard\033[0m");
	        for (int i = 0; i < loadedTop5.size(); i++) {
	            System.out.println(loadedTop5.get(i));
	        }
	    } else {
	        System.out.println("\033[1m			Leaderboard\033[0m");
	        for (int i = 0; i < tempList.size(); i++) {
	            System.out.println(tempList.get(i));
	        }
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
