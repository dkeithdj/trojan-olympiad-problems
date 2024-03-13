import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContainerWithMostWater {

  public static int maxArea(List<Integer> A) {
    int l = 0;
    int r = A.size() - 1;
    int area = 0;

    while (l < r) {
      // Calculating the max area
      area = Math.max(area, Math.min(A.get(l), A.get(r)) * (r - l));

      if (A.get(l) < A.get(r))
        l += 1;

      else
        r -= 1;
    }
    return area;
  }

  public static void main(String[] args) throws IOException {
    Scanner infile = new Scanner(new FileReader("ContainerWithMostWater.in"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("ContainerWithMostWater.ans"));
    while (infile.hasNext()) {
      List<Integer> parsedArray = parseStringToIntArray(infile.nextLine());
      // System.out.println(maxArea(parsedArray));
      writer.write(maxArea(parsedArray));
      writer.newLine();
      // System.out.println(maxArea(parsedArray));
      // System.out.println(parsedArray.toString());
    }
    // int a[] = { 1, 5, 4, 3 };
    // int b[] = { 3, 1, 2, 4, 5 };

    // int len1 = 4;
    // System.out.print(maxArea(a, a.length) + "\n");

    // int len2 = 5;
    // System.out.print(maxArea(b, b.length));
  }

  public static List<Integer> parseStringToIntArray(String inputString) {
    if (inputString.isEmpty() || !inputString.startsWith("[") || !inputString.endsWith("]")) {
      throw new IllegalArgumentException("Invalid input format. Expected: [element1, element2, ...] ");
    }

    String[] stringArray = inputString.substring(1, inputString.length() - 1).split(","); // Remove brackets and split
                                                                                          // by comma

    List<Integer> parsedArray = new ArrayList<>();
    for (int i = 0; i < stringArray.length; i++) {
      try {
        parsedArray.add(Integer.parseInt(stringArray[i].trim()));
        // parsedArray[i] = Integer.parseInt(stringArray[i].trim()); // Remove
        // leading/trailing spaces and parse to int
      } catch (NumberFormatException e) {
        throw new IllegalArgumentException("Invalid element format. Expected integers only: " + e.getMessage());
      }
    }

    return parsedArray;
  }
}
