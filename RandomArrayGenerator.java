import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Random;

public class RandomArrayGenerator {

  public static int[] generateRandomArray(int n) {
    if (n < 2 || n > 105) {
      throw new IllegalArgumentException("n must be between 2 and 105 (inclusive)");
    }

    int[] array = new int[n];
    Random random = new Random();

    for (int i = 0; i < n; i++) {
      array[i] = random.nextInt(105);
    }

    return array;
  }

  public static String formatArray(int[] array) {
    StringBuilder sb = new StringBuilder();
    sb.append("[");
    for (int i = 0; i < array.length; i++) {
      sb.append(array[i]);
      if (i < array.length - 1) {
        sb.append(",");
      }
    }
    sb.append("]");
    return sb.toString();
  }

  public static void writeArraysToFile(int numArrays, String filename) throws IOException {
    try (BufferedWriter writer = new BufferedWriter(new FileWriter(filename))) {
      for (int i = 0; i < numArrays; i++) {
        int n = (int) Math.floor(Math.random() * (104 - 2 + 1) + 2); // Random size between 2 and 105
        int[] randomArray = generateRandomArray(n);
        String formattedArray = formatArray(randomArray);
        writer.write(formattedArray);
        writer.newLine();
      }
    }
  }

  public static void main(String[] args) {
    int numArrays = 15;
    String filename = "ContainerWithMostWater.in";

    try {
      writeArraysToFile(numArrays, filename);
      System.out.println("Successfully wrote " + numArrays + " random arrays to file: " + filename);
    } catch (IllegalArgumentException e) {
      System.err.println("Error: Invalid array size: " + e.getMessage());
    } catch (IOException e) {
      System.err.println("Error writing to file: " + e.getMessage());
    }
  }
}