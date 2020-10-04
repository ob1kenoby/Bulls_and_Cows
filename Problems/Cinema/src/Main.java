import java.util.Scanner;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        byte rows = scanner.nextByte();
        byte seats = scanner.nextByte();
        byte[][] theater = new byte[rows][seats];
        for (byte[] row: theater) {
            for (int i = 0; i < row.length; i++) {
                row[i] = scanner.nextByte();
            }
        }
        byte tickets = scanner.nextByte();
        int row = -1;
        for (int i = 0; i < theater.length; i++) {
            int consequentSeats = 0;
            for (int j = 0; j < seats; j++) {
                consequentSeats = (theater[i][j] == 0) ? consequentSeats + 1 : 0;
                if (consequentSeats >= tickets) {
                    row = i;
                    break;
                }
            }
            if (row >= 0) {
                break;
            }
        }
        System.out.println(++row);
    }
}