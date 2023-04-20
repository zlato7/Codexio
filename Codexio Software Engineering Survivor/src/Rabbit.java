
import java.util.Scanner;

public class Rabbit {

  private static final int[][] move = {
      {-1, 0},
      {1, 0},
      {0, 1},
      {0, -1}
  };

  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {

    int jumps = 0;
    int size = 0;

    System.out.println("Enter the size of the garden");

    while (size <= 0) {
      try {
        size = Integer.parseInt(scanner.nextLine());
        if (size <= 0) {
          System.out.println("Please enter a positive integer!");
        }
      } catch (Exception ex) {
        System.out.println("Please enter a positive integer!");
      }
    }

    int[][] garden = new int[size][size];

    fillTheGarden(garden);

    print(garden);

    jumps = findJumps(garden);

    System.out.println("Jumps = " + jumps);
  }

  private static int findJumps(int[][] garden) {

    int counter = 0;

    for (int row = 0; row < garden.length; row++) {
      for (int col = 0; col < garden.length; col++) {
        if (garden[row][col] == 1) {

          checkNeibhours(garden, row, col);
          counter++;
        }
      }
    }
    return counter;
  }

  private static void checkNeibhours(int[][] garden, int row, int col) {
    if (row < 0 || row >= garden.length || col < 0 || col >= garden.length || garden[row][col] <= 0) {
      return;
    }
    garden[row][col] = -1;

    for (int i = 0; i < move.length; i++) {
      checkNeibhours(garden, row + move[i][0], col + move[i][1]);
    }
  }

  private static void fillTheGarden(int[][] garden) {

    System.out.println("Enter 1 for carrot and 0 for empty field");

    for (int row = 0; row < garden.length; row++) {
      for (int col = 0; col < garden.length; col++) {
        System.out.printf("[%d][%d]", row, col);
        System.out.println();

        int currentField = -1;

        while (currentField != 0 && currentField != 1) {
          try {
            currentField = Integer.parseInt(scanner.nextLine());
            if (currentField != 0 && currentField != 1) {
              System.out.println("Wrong input! Enter 1 for carrot and 0 for empty field");
            }
          } catch (Exception ex) {
            System.out.println("Wrong input! Enter 1 for carrot and 0 for empty field");
          }
        }
        garden[row][col] = currentField;
      }
    }
  }

  private static void print(int[][] garden) {

    for (int[] row : garden) {
      for (int currentSymbol : row) {
        if (currentSymbol == 1) {

          System.out.print("\uD83E\uDD55" + " ");
        } else {
          System.out.print("_");
        }
      }
      System.out.println();
    }
  }
}
