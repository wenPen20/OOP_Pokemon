import java.io.*;
import java.nio.file.*;
import java.util.*;

public class testprob {

    public void stageType() {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Choose a stage:\n[1] Fire, [2] Water, [3] Grass");
        int input = scanner.nextInt();

        switch (input) {
            case 1 -> adjustProbabilities("Fire", 0.1);
            case 2 -> adjustProbabilities("Water", 0.1);
            case 3 -> adjustProbabilities("Grass", 0.1);
            default -> System.out.println("Incorrect input, please try again.");
        }
    }

    private void adjustProbabilities(String targetType, double increaseAmount) {
        String fileName = "C:\\Users\\seand\\OneDrive\\Desktop\\Programming\\code2024\\AssignmentTestV2\\src\\Pokemons.txt";

        try {
            // Read all lines from the file
            List<String> lines = Files.readAllLines(Paths.get(fileName));
            List<String> updatedLines = new ArrayList<>();

            for (String line : lines) {
                // Skip empty lines
                if (line.trim().isEmpty()) {
                    updatedLines.add(line);
                    continue;
                }

                if (line.contains("type=" + targetType)) {
                    // ties to the below function in order to increaes the probability
                    line = adjustField(line, "probability", increaseAmount);
                }
                updatedLines.add(line);
            }

            Files.write(Paths.get(fileName), updatedLines);

            System.out.println("Probabilities increased for type: " + targetType); // jusst to test if code reached here

        } catch (IOException e) {
            System.err.println("An error occurred while adjusting probabilities: " + e.getMessage());
        }
    }

    private String adjustField(String line, String field, double increaseAmount) {
        String[] parts = line.split(", ");

        for (int i = 0; i < parts.length; i++) {
            if (parts[i].startsWith(field + "=")) {
                double currentProbability = Double.parseDouble(parts[i].split("=")[1]);
                double newProbability = currentProbability + increaseAmount;
                // Ensure probability doesn't exceed 1.0
                if (newProbability > 1.0) {
                    newProbability = 1.0;
                }
                parts[i] = field + "=" + String.format("%.1f", newProbability);
            }
        }

        return String.join(", ", parts);
    }

    public static void main(String[] args) {
    	testprob updater = new testprob();
        updater.stageType();
    }
}

//WE should make it so once the pokemon are then generated the increaesd probability is reset down by how much it has been increased


