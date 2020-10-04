import java.util.*;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int seed1 = scanner.nextInt();
        int seed2 = scanner.nextInt();
        int number = scanner.nextInt();
        int range = scanner.nextInt();
        int[] seeds = new int[seed2 - seed1 + 1];
        int[] maxes = new int[seed2 - seed1 + 1];
        int min = 0;
        for (int i = 0; i < seeds.length; i++) {
            seeds[i] = seed1 + i;
            int[] set = new int[number];
            Random random = new Random(seeds[i]);
            for (int j = 0; j < number; j++) {
                set[j] = random.nextInt(range);
            }
            Arrays.sort(set);
            maxes[i] = set[set.length - 1];
            if (maxes[min] > maxes[i]) min = i;
        }
        System.out.println(seeds[min]);
        System.out.println(maxes[min]);
    }
}