import java.math.BigInteger;
import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        BigInteger numberToCompare = new BigInteger(scanner.nextLine());
        for (int i = 0; i < 1000; i++) {
            BigInteger fact = factorial(i);
            if (fact.compareTo(numberToCompare) >= 0) {
                System.out.println(i);
                break;
            }
        }
    }

    private static BigInteger factorial(int i) {
        if (i == 0) {
            return BigInteger.ONE;
        } else {
            return factorial(i - 1).multiply(BigInteger.valueOf(i));
        }
    }
}