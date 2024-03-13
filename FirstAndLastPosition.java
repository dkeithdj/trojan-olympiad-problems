import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//correct

class FirstAndLastPosition {
  /*
   * if x is present in arr[] then returns the index of
   * FIRST occurrence of x in arr[0..n-1], otherwise
   * returns -1
   */
  public static int first(int arr[], int low, int high,
      int x, int n) {
    if (arr.length == 0)
      return -1;

    if (high >= low) {
      int mid = low + (high - low) / 2;
      if ((mid == 0 || x > arr[mid - 1])
          && arr[mid] == x)
        return mid;
      else if (x > arr[mid])
        return first(arr, (mid + 1), high, x, n);
      else
        return first(arr, low, (mid - 1), x, n);
    }
    return -1;
  }

  /*
   * if x is present in arr[] then returns the index of
   * LAST occurrence of x in arr[0..n-1], otherwise
   * returns -1
   */
  public static int last(int arr[], int low, int high,
      int x, int n) {
    if (arr.length == 0)
      return -1;
    if (high >= low) {
      int mid = low + (high - low) / 2;
      if ((mid == n - 1 || x < arr[mid + 1])
          && arr[mid] == x)
        return mid;
      else if (x < arr[mid])
        return last(arr, low, (mid - 1), x, n);
      else
        return last(arr, (mid + 1), high, x, n);
    }
    return -1;
  }

  public static void main(String[] args) {

    Scanner sc = new Scanner(System.in);
    while (sc.hasNextLine()) {
      Pair<Integer, int[]> result = parseString(sc.nextLine());
      int x = result.getFirst();
      int arr[] = result.getSecond();
      int n = arr.length;
      List<Integer> ans = new ArrayList<>();
      ans.add(first(arr, 0, n - 1, x, n));
      ans.add(last(arr, 0, n - 1, x, n));
      System.out.println(ans);
      // System.out.printf("[%f, %f]\n", first(arr, 0, n - 1, x, n), last(arr, 0, n -
      // 1, x, n));
      // System.out.println("First Occurrence = "
      // + first(arr, 0, n - 1, x, n));
      // System.out.println("Last Occurrence = "
      // + last(arr, 0, n - 1, x, n));

    }

  }

  // parsing stuff
  public static Pair<Integer, int[]> parseString(String input) {
    // Define a regular expression pattern to match the input format
    Pattern pattern = Pattern.compile("(\\d+):(\\[.*\\])");

    // Match the pattern against the input string
    Matcher matcher = pattern.matcher(input);

    // Check if the pattern is found
    if (matcher.find()) {
      // Extract the integer and array parts
      int integerPart = Integer.parseInt(matcher.group(1));
      String arrayPart = matcher.group(2);

      // Convert the array part to an array of integers
      int[] array = parseArray(arrayPart);

      // Return a Pair containing the integer and the array
      return new Pair<>(integerPart, array);
    } else {
      // Handle the case where the input does not match the expected format
      throw new IllegalArgumentException("Invalid input format");
    }
  }

  public static int[] parseArray(String arrayPart) {
    // Remove square brackets
    arrayPart = arrayPart.substring(1, arrayPart.length() - 1).trim();

    // Check for an empty array
    if (arrayPart.isEmpty()) {
      return new int[0];
    }

    // Split the string into individual elements
    String[] elements = arrayPart.split(",");

    // Convert the elements to integers and add them to an array
    int[] array = new int[elements.length];
    for (int i = 0; i < elements.length; i++) {
      array[i] = Integer.parseInt(elements[i].trim());
    }

    return array;
  }

  // Simple Pair class to store two values
  static class Pair<A, B> {
    private final A first;
    private final B second;

    public Pair(A first, B second) {
      this.first = first;
      this.second = second;
    }

    public A getFirst() {
      return first;
    }

    public B getSecond() {
      return second;
    }
  }
}
