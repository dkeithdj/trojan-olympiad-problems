import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.*;

public class GenerateParentheses {

  // Function to generate all the combinations of
  // balanced parenthesis
  static void generateParenthesis(int left, int right,
      String s,
      List<String> answer) {

    // terminate
    if (left == 0 && right == 0) {
      answer.add(s);
    }

    if (left > right || left < 0 || right < 0) {
      // wrong
      return;
    }

    s += "(";
    generateParenthesis(left - 1, right, s, answer);
    s = s.substring(0, s.length() - 1);

    s += ")";
    generateParenthesis(left, right - 1, s, answer);
    s = s.substring(0, s.length() - 1);
  }

  public static void main(String[] args) throws IOException {
    Scanner infile = new Scanner(new FileReader("GenerateParentheses.in"));
    BufferedWriter writer = new BufferedWriter(new FileWriter("GenerateParentheses.ans"));
    while (infile.hasNext()) {
      int num = Integer.parseInt(infile.nextLine());
      // System.out.println(infile.nextLine());
      List<String> ans = new ArrayList<>();
      String s = "";
      generateParenthesis(num, num, s, ans);
      // writer.write(ans.toString());
      // writer.newLine();

      // System.out.println(ans);
    }
  }
}
