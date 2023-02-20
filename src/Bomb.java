import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Scanner;

public class Bomb {
    public static void main(String[] args) {

       Scanner scanner = new Scanner(System.in);

            ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
            ArrayDeque <Integer> bombCasing = new ArrayDeque<>();

            Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).forEach(bombEffects::offer);
            Arrays.stream(scanner.nextLine().split(", "))
                    .mapToInt(Integer::parseInt).forEach(bombCasing::push);


            System.out.println();

    }
}
