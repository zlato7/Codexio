import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class Words {

  public static int result = 0;

  public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);

    List<Character> wordOne = scanner.nextLine().replaceAll("\\s", "").chars()
        .mapToObj(x -> (char) x).collect(Collectors.toList());
    List<Character> wordTwo = scanner.nextLine().replaceAll("\\s", "").chars()
        .mapToObj(x -> (char) x).collect(Collectors.toList());

    removeUnmatchedCharacters(wordTwo, wordOne);
    removeUnmatchedCharacters(wordOne, wordTwo);

    System.out.println(wordOne);
    System.out.println(wordTwo);

    System.out.println("Result: " + result);
  }

  private static void removeUnmatchedCharacters(List<Character> wordOne, List<Character> wordTwo) {

    List<Character> temp = new ArrayList<>(wordTwo);

    Iterator<Character> iteratorWordOne = wordOne.iterator();
    Character currentLetter;
    while (iteratorWordOne.hasNext()) {
      currentLetter = iteratorWordOne.next();
      if (!temp.contains(currentLetter)) {
        iteratorWordOne.remove();
        result++;
      } else {
        temp.remove(currentLetter);
      }
    }
  }
}
