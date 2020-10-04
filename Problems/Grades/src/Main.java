import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = scanner.nextInt();
        byte[] grades = new byte[6];
        for (int i = 0; i < n; i++) {
            byte grade = scanner.nextByte();
            grades[grade]++;
        }
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = 2; i < grades.length; i++) {
            stringBuilder.append(grades[i] + " ");
        }
        System.out.println(stringBuilder.toString());
    }
}