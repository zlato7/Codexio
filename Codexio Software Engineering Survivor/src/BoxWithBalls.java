import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BoxWithBalls {

  public static void main(String[] args) {

    Scanner scanner = new Scanner(System.in);

    int ballsToRemove;
    int allBalls = 0;
    int currentBallsInput = 0;
    List<String> colors = new ArrayList<>();
    //"Color: count"
    String line = scanner.nextLine().trim();

    while (!line.equals("End")) {

      String[] inputParams = line.split(" ");
      colors.add(inputParams[0]);

      int currentColorCount = 0;
      try {
        currentColorCount = Integer.parseInt(inputParams[1]);
      } catch (Exception ex) {
        System.out.println("Wrong input!");
      }
      if (currentColorCount > 0) {
        currentBallsInput++;
        allBalls += currentColorCount;
      } else {
        System.out.println("The balls should be positive number!");
      }

      line = scanner.nextLine().trim();
    }

    if (currentBallsInput <= 1 || colors.size() <= 1) {
      ballsToRemove = 0;
    } else {
      ballsToRemove = allBalls - 1;
    }
    System.out.printf("We need to remove %d", ballsToRemove);
  }
}
