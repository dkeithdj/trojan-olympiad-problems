import java.util.Scanner;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

public class PrimePalindrome {
  public static int primePalindrome(int N) {
    for (int i = 1; i <= 5; i++) {
      for (int root = (int) Math.pow(10, i - 1); root < (int) Math.pow(10, i); root++) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int j = i - 2; j >= 0; j--) {
          sb.append(sb.charAt(j));
        }
        int num = Integer.valueOf(sb.toString());
        if (num >= N && isPrime(num)) {
          return num;
        }
      }
      for (int root = (int) Math.pow(10, i - 1); root < (int) Math.pow(10, i); root++) {
        StringBuilder sb = new StringBuilder(Integer.toString(root));
        for (int j = i - 1; j >= 0; j--) {
          sb.append(sb.charAt(j));
        }
        int num = Integer.parseInt(sb.toString());
        if (num >= N && isPrime(num)) {
          return num;
        }
      }
    }
    return -1;
  }

  private static boolean isPrime(int n) {
    if (n < 2) {
      return false;
    }
    for (int j = 2; j <= (int) Math.sqrt(n); j++) {
      if (n % j == 0) {
        return false;
      }
    }
    return true;
  }

  public static void main(String[] args) throws IOException {
    Scanner sc = new Scanner(System.in);
    // Scanner sc = new Scanner(new FileReader("PrimePalindrome.in"));

    // BufferedWriter writer = new BufferedWriter(new
    // FileWriter("PrimePalindrome.ans"));
    while (sc.hasNextLine()) {
      System.out.println(primePalindrome(Integer.parseInt(sc.nextLine())));
      // writer.write(primePalindrome(Integer.parseInt(sc.nextLine())));
    }
  }
}

// public class PrimePalindrome {
// public static void main(String[] args) {
// // ArrayList<Integer> numberList = generateRandomNumbers(20, 1, (int)
// // Math.pow(10, 8));
// ArrayList<Integer> numberList = generateRandomNumbers(10, 1000, 10000);

// // Print the generated numbers per line
// System.out.println("Generated Numbers:");
// for (Integer number : numberList) {
// System.out.println(number);
// }
// }

// public static ArrayList<Integer> generateRandomNumbers(int count, int min,
// int max) {
// if (count <= 0 || max <= min) {
// throw new IllegalArgumentException("Invalid parameters");
// }

// ArrayList<Integer> numbers = new ArrayList<>();
// Random random = new Random();

// for (int i = 0; i < count; i++) {
// int randomNumber = random.nextInt((max - min) + 1) + min;
// numbers.add(randomNumber);
// }

// return numbers;
// }
// }
