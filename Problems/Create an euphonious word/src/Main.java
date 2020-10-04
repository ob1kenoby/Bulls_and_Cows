import java.util.*;

public class Main {
    public static void main(String[] args) {
        Set<String> vowels = new HashSet<>(Arrays.asList("a", "e", "i", "o", "u", "y"));
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("");
        List<String> word = new LinkedList<>(Arrays.asList(input));
        int i = 1;
        int count = 0;
        while (i < word.size() - 1) {
            if (vowels.contains(word.get(i - 1)) && vowels.contains(word.get(i)) && vowels.contains(word.get(i + 1))) {
                word.add(i + 1, "x");
                count++;
            }
            if (!(vowels.contains(word.get(i - 1)) || vowels.contains(word.get(i)) || vowels.contains(word.get(i + 1)))) {
                word.add(i + 1, "y");
                count++;
            }
            i++;
        }
        System.out.println(count);
    }
}