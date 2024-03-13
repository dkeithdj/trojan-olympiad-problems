import java.io.*;
import java.util.*;

// correct
public class ChronalCalibration {

  public static void main(String[] args) throws FileNotFoundException {

    int frequency = 0;

    // Scanner infile = new Scanner(new FileReader("ChronalCalibration.in"));
    Scanner infile = new Scanner(System.in);
    while (infile.hasNext()) {
      frequency = frequency + infile.nextInt();
    }

    System.out.println(frequency);
  }
}
