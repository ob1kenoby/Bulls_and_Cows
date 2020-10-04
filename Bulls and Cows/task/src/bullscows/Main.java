package bullscows;

import java.util.*;

public class Main {
    final static Scanner scanner = new Scanner(System.in);
    final static String[] SYMBOLS = {
            "0", "1", "2", "3", "4", "5", "6", "7", "8", "9",
            "a", "b", "c", "d", "e", "f", "g", "h", "k", "j",
            "k", "l", "m", "n", "o", "p", "q", "r", "s", "t",
            "u", "v", "w", "x", "y", "z"
    };

    public static void main(String[] args) {
        byte secretCodeLength = 0;
        byte numberOfSymbols = 0;
        System.out.println("Input the length of the secret code:");
        String rawInput = scanner.nextLine();
        boolean cont = true;
        try {
            secretCodeLength = Byte.parseByte(rawInput);
        } catch (NumberFormatException e) {
            System.out.printf("Error: \"%s\" isn't a valid number.", rawInput);
            cont = false;
        }
        if (cont) {
            System.out.println("Input the number of possible symbols in the code:");
            rawInput = scanner.nextLine();
            try {
                numberOfSymbols = Byte.parseByte(rawInput);
            } catch (NumberFormatException e) {
                System.out.printf("Error: \"%s\" isn't a valid number.", rawInput);
                cont = false;
            }
        }

        if (cont) {
            if (numberOfSymbols < secretCodeLength) {
                System.out.println("Error: not possible to generate a code with a length of 6 with 5 unique symbols.");
            } else if (numberOfSymbols > 36) {
                System.out.println("Error: maximum number of possible symbols in the code is 36 (0-9, a-z).");
            } else if (secretCodeLength > 0 && numberOfSymbols > 0) {
                String[] secretCode = generateSecretCode(secretCodeLength, numberOfSymbols);
                runGame(secretCode);
            } else {
                System.out.println("Error: the input should be greater than 0.");
            }
        }
    }

    private static void runGame(String[] secretCode) {
        System.out.println("Okay, let's start a game!");
        int turn = 1;
        boolean notWon = true;
        while (notWon) {
            System.out.printf("Turn %d:%n", turn);
            notWon = makeTurn(secretCode);
            turn++;
        }
    }

    private static boolean makeTurn(String[] secretCode) {
        String[] guess = scanner.nextLine().split("");
        int bulls = 0;
        int cows = 0;
        int guessLength = secretCode.length - Math.abs(secretCode.length - guess.length);
        for (int i = 0; i < guessLength; i++) {
            if (secretCode[i].equals(guess[i])) {
                bulls++;
            }
            for (int j = 0; j < guessLength; j++) {
                if (i != j && secretCode[i].equals(guess[j])) {
                    cows++;
                }
            }
        }
        return checkTurn(bulls, cows, secretCode.length);
    }

    private static boolean checkTurn(int bulls, int cows, int secretCodeLength) {
        StringBuilder output = new StringBuilder();
        if (bulls == 0 && cows == 0) {
            output.append("None");
        } else {
            if (bulls == 1) {
                output.append("1 bull");
            } else if (bulls > 1) {
                output.append(String.format("%d bulls", bulls));
            }
            if (bulls > 0 && cows > 0) {
                output.append(" and ");
            }
            if (cows == 1) {
                output.append("1 cow");
            } else if (cows > 1) {
                output.append(String.format("%d cows", cows));
            }
        }
        System.out.printf("Grade: %s\n", output.toString());
        if (bulls == secretCodeLength) {
            System.out.println("Congratulations! You guessed the secret code!");
            return false;
        }
        return true;
    }

    private static String[] generateSecretCode(byte length, byte number) {
        StringBuilder secretNumber = new StringBuilder();
        Random random = new Random();
        while (secretNumber.length() < length) {
            int randomDigit = random.nextInt(number);
            if (!secretNumber.toString().contains(SYMBOLS[randomDigit])) {
                secretNumber.append(SYMBOLS[randomDigit]);
            }
        }
        String asterisk = "*";
        String range = "";
        if (number > 10) {
            range = ", a-" + SYMBOLS[number - 1];
        }
        System.out.printf("The secret is prepared: %s (0-9%s).%n", asterisk.repeat(length), range);
        return secretNumber.toString().split("");
    }
}
