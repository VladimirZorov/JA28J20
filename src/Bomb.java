import java.util.*;

public class Bomb {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        ArrayDeque<Integer> bombEffects = new ArrayDeque<>();
        ArrayDeque<Integer> bombCasing = new ArrayDeque<>();

        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(bombEffects::offer);
        Arrays.stream(scanner.nextLine().split(", "))
                .mapToInt(Integer::parseInt).forEach(bombCasing::push);

        Map<String, Integer> bombTypes = new HashMap<>();
        bombTypes.put("Datura Bombs", 0);
        bombTypes.put("Cherry Bombs", 0);
        bombTypes.put("Smoke Decoy Bombs", 0);

        boolean havThreeOfEach = false;

        int count1 = 0;
        int count2 = 0;
        int count3 = 0;

        while (!bombEffects.isEmpty() && !bombCasing.isEmpty() && !havThreeOfEach) {

            int tempBombEffects = bombEffects.peek();
            int tempBombCasing = bombCasing.peek();
            int sumComponents = tempBombEffects + tempBombCasing;

            if (sumComponents == 40) {
                bombTypes.get("Datura Bombs");
                bombTypes.compute("Datura Bombs", (s, integer) -> +1);
                bombEffects.poll();
                bombCasing.pop();
                count1 += 1;
            } else if (sumComponents == 60) {
                bombTypes.get("Cherry Bombs");
                bombTypes.compute("Cherry Bombs", (s, integer) -> +1);
                bombEffects.poll();
                bombCasing.pop();
                count2 += 1;
            } else if (sumComponents == 120) {
                bombTypes.get("Smoke Decoy Bombs");
                bombTypes.compute("Smoke Decoy Bombs", (s, integer) -> +1);
                bombEffects.poll();
                bombCasing.pop();
                count3 += 1;
            } else {
                int redusedBombCasing = tempBombCasing - 5;
                bombCasing.poll();
                bombCasing.addFirst(redusedBombCasing);
            }

            if (count1 >= 3 && count2 >= 3 && count3 >= 3) {
                havThreeOfEach = true;
            }
        }

        if (havThreeOfEach) {
            System.out.println("Bene! You have successfully filled the bomb pouch!");
        } else {
            System.out.println("You don't have enough materials to fill the bomb pouch.");
        }

        if (bombEffects.size() == 0) {
            System.out.println("Bomb Effects: empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bomb Effects: ").append("");

            for (int i = 0; i < bombEffects.size() - 1; i++) {
                sb.append(bombEffects.poll()).append(", ");
            }
            sb.append(bombEffects.poll()).append("");

            System.out.println(sb.toString().trim());
        }

        if (bombCasing.size() == 0) {
            System.out.println("Bomb Casings: empty");
        } else {
            StringBuilder sb = new StringBuilder();
            sb.append("Bomb Casings: ").append("");
            for (int i = 0; i < bombCasing.size() - 1; i++) {
                sb.append(bombCasing.pop()).append(", ");
            }
            sb.append(bombCasing.pop()).append("");
            System.out.println(sb.toString().trim());
        }

        System.out.printf("Cherry Bombs: %d%n", count2);
        System.out.printf("Datura Bombs: %d%n", count1);
        System.out.printf("Smoke Decoy Bombs: %d", count3);
    }
}
