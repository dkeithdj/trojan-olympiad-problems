import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;
// correct

public class NoSuchThingAsTooMuch {

  private List<Integer> inputNumbers;

  public NoSuchThingAsTooMuch(File input) {
    inputNumbers = fileToStringList(input).stream().map(s -> Integer.parseInt(s))
        .collect(Collectors.toList());
  }

  public NoSuchThingAsTooMuch(InputStream in) {
    Scanner sc = new Scanner(in);
    List<Integer> content = new ArrayList<>();

    while (sc.hasNextLine()) {
      content.add(Integer.parseInt(sc.nextLine()));
    }
    inputNumbers = content;

  }

  public int run1() {
    Counter counter = new Counter();
    count(0, 0, counter, inputNumbers, 0, new ArrayList<>());
    return counter.count();
  }

  public int run2() {
    List<Integer> filledContainers = new ArrayList<>();
    count(0, 0, new Counter(), inputNumbers, 0, filledContainers);
    int min = Collections.min(filledContainers);
    return (int) filledContainers.stream().filter(n -> n == min).count();
  }

  public void count(int index, int sum, Counter counter, List<Integer> numbers, int numOfContainers,
      List<Integer> filledContainers) {
    if (sum == 150) {
      filledContainers.add(numOfContainers);
      counter.increment();
      return;
    }

    if (index >= numbers.size()) {
      return;
    }

    count(index + 1, sum + numbers.get(index), counter, numbers, numOfContainers + 1, filledContainers);
    count(index + 1, sum, counter, numbers, numOfContainers, filledContainers);
  }

  public static void main(String[] args) {
    NoSuchThingAsTooMuch test = new NoSuchThingAsTooMuch(System.in);
    System.out.println(test.run1());
    // System.out.println(test.run2());
  }

  private static class Counter {
    private int count;

    public Counter() {
      count = 0;
    }

    public void increment() {
      count++;
    }

    public int count() {
      return count;
    }
  }

  public static List<String> fileToStringList(File file) {
    List<String> content = new ArrayList<>();
    try {
      // Scanner br = new Scanner(System.in);
      BufferedReader br = new BufferedReader(new FileReader(file));
      String line = "";
      while ((line = br.readLine()) != null) {
        content.add(line);
      }
      br.close();
    } catch (IOException e) {
      e.printStackTrace();
    }
    return content;
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