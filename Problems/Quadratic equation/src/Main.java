import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double a = scanner.nextDouble();
        double b = scanner.nextDouble();
        double c = scanner.nextDouble();
        if (a == 0) {
            System.out.println((0.0 - c) / b);
        } else if (b == 0) {
            System.out.println(Math.sqrt((0 - c) / a));
        } else if (c == 0) {
            System.out.println(0.0);
            System.out.println((0 - b) / a);
        } else {
            double d = b * b - 4 * a * c;
            if (d < 0) {
                System.out.println("The equation doesn't have any rational solutions");
            } else if (d == 0) {
                System.out.println((0 - b) / (2 * a));
            } else {
                double x1 = ((0 - b) - Math.sqrt(d)) / (2 * a);
                double x2 = ((0 - b) + Math.sqrt(d)) / (2 * a);
                System.out.println(Math.min(x1, x2));
                System.out.println(Math.max(x1, x2));
            }
        }
    }
}
