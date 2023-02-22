import java.util.Scanner;

public class Snake {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int n = Integer.parseInt(scanner.nextLine());

        String[][] territory = new String[n][n];

        int rowSnake = -1;
        int collSnake = -1;
        int rowFirstBurrow = -1;
        int collFirstBurrow = -1;
        int rowSecondBurrow = -1;
        int collSecondBurrow = -1;

        int foodEaten = 0;

        boolean snakeIsInTerritory = true;

        for (int i = 0; i < n; i++) {
            String[] line = scanner.nextLine().split("");
            territory[i] = line;
            for (int j = 0; j < n; j++) {
                if (line[j].equals("S")) {
                    rowSnake = i;
                    collSnake = j;
                } else if (line[j].equals("B") && rowFirstBurrow < 0) {
                    rowFirstBurrow = i;
                    collFirstBurrow = j;
                } else if (line[j].equals("B") && rowSecondBurrow < 0) {
                    rowSecondBurrow = i;
                    collSecondBurrow = j;
                }
            }
        }

        String command = scanner.nextLine();
        while (foodEaten < 10 && snakeIsInTerritory) {
            switch (command) {
                case "up":
                    if (rowSnake -1 >= 0) {
                        territory[rowSnake][collSnake] = ".";
                        rowSnake -=1;
                        if (territory[rowSnake][collSnake].equals("*")) {
                            foodEaten += 1;
                            territory[rowSnake][collSnake] = "S";
                        }
                        if (territory[rowSnake][collSnake].equals("B") && rowFirstBurrow == rowSnake) {
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowSecondBurrow;
                            collSnake = collSecondBurrow;
                            territory[rowSnake][collSnake] = "S";
                        } else if (territory[rowSnake][collSnake].equals("B") && rowSecondBurrow == rowSnake){
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowFirstBurrow;
                            collSnake = collFirstBurrow;
                            territory[rowSnake][collSnake] = "S";
                        }
                    } else {
                        snakeIsInTerritory = false;
                    }
                    break;
                case "down":
                    if (rowSnake +1 < n) {
                        territory[rowSnake][collSnake] = ".";
                        rowSnake +=1;
                        if (territory[rowSnake][collSnake].equals("*")) {
                            foodEaten += 1;
                            territory[rowSnake][collSnake] = "S";
                        }
                        if (territory[rowSnake][collSnake].equals("B") && rowFirstBurrow == rowSnake) {
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowSecondBurrow;
                            collSnake = collSecondBurrow;
                            territory[rowSnake][collSnake] = "S";
                        } else if (territory[rowSnake][collSnake].equals("B") && rowSecondBurrow == rowSnake){
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowFirstBurrow;
                            collSnake = collFirstBurrow;
                            territory[rowSnake][collSnake] = "S";
                        }
                    }else {
                        snakeIsInTerritory = false;
                    }
                    break;
                case "left":
                    if (collSnake -1 >= 0) {
                        territory[rowSnake][collSnake] = ".";
                        collSnake -=1;
                        if (territory[rowSnake][collSnake].equals("*")) {
                            foodEaten += 1;
                            territory[rowSnake][collSnake] = "S";
                        }
                        if (territory[rowSnake][collSnake].equals("B") && rowFirstBurrow == rowSnake) {
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowSecondBurrow;
                            collSnake = collSecondBurrow;
                            territory[rowSnake][collSnake] = "S";
                        } else if (territory[rowSnake][collSnake].equals("B") && rowSecondBurrow == rowSnake){
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowFirstBurrow;
                            collSnake = collFirstBurrow;
                            territory[rowSnake][collSnake] = "S";
                        }
                    }else {
                        snakeIsInTerritory = false;
                    }
                    break;
                case "right":
                    if (collSnake +1 < n) {
                        territory[rowSnake][collSnake] = ".";
                        collSnake +=1;
                        if (territory[rowSnake][collSnake].equals("*")) {
                            foodEaten += 1;
                            territory[rowSnake][collSnake] = "S";
                        }
                        if (territory[rowSnake][collSnake].equals("B") && rowFirstBurrow == rowSnake) {
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowSecondBurrow;
                            collSnake = collSecondBurrow;
                            territory[rowSnake][collSnake] = "S";
                        } else if (territory[rowSnake][collSnake].equals("B") && rowSecondBurrow == rowSnake){
                            territory[rowSnake][collSnake] = ".";
                            rowSnake = rowFirstBurrow;
                            collSnake = collFirstBurrow;
                            territory[rowSnake][collSnake] = "S";
                        }
                    }else {
                        snakeIsInTerritory = false;
                    }
                    break;
            }
            if (foodEaten == 10) {
                break;
            }
            if (!snakeIsInTerritory) {
                break;
            }
            command = scanner.nextLine();
        }


        if (!snakeIsInTerritory || foodEaten != 10) {
            territory[rowSnake][collSnake] = ".";
            System.out.println("Game over!");
        } else if (foodEaten == 10){
            System.out.println("You won! You fed the snake.");
        }
        System.out.printf("Food eaten: %d%n", foodEaten);

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(territory[i][j]);
            }
            System.out.println();
        }

    }
}
