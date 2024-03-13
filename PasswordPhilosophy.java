import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class PasswordPhilosophy {
  public static void main(String[] args) throws IOException {
    // Scanner in = new Scanner(new FileReader("PasswordPhilosophy.in"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("PasswordPhilosophy.ans"));
    try (Scanner in = new Scanner(new FileReader("PasswordPhilosophy.in"))) {
      int count = 0;

      while (in.hasNextLine()) {
        String[] line = in.nextLine().split(" ");

        int diff = line[2].length() - line[2].replaceAll(line[1].substring(0, 1), "").length();

        String[] limits = line[0].split("-");
        int lower = Integer.parseInt(limits[0]);
        int upper = Integer.parseInt(limits[1]);

        if (lower <= diff && diff <= upper) {
          ++count;
        }
      }

      System.out.println(count);
      writer.write(count);
    }
  }
}