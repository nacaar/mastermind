import java.util.Scanner;

public class mastermind {
    public static void main(String[] args) {
        int multiplayer, attempt = 0, number = 9999, userGuess, success = 0, again = 0, exactCount = 0,
                wrongPlaceCount = 0;
        char[] geciciString = { '-', '-', '-', '-' };
        boolean[] secretMatched = new boolean[4];
        boolean[] guessMatched = new boolean[4];

        Scanner scanner = new Scanner(System.in);

        System.out.println("Welcome to the Mastermind Game!");
        do {
            geciciString = new char[] { '-', '-', '-', '-' };
            again = 0;
            success = 0;
            System.out.println("Do you want to play multiplayer? (1 for Yes, 0 for No)");
            multiplayer = scanner.nextInt();

            do {
                if (multiplayer == 1) {
                    System.out.println("Multiplayer mode selected.");

                    System.out.print("Enter the secret number for the other player to guess:");
                    number = scanner.nextInt();
                    String n1 = String.valueOf(number); // to use charAt(), int to string
                    if (number < 1000 || number > 9999) {
                        do {
                            System.out.println("Again enter the secret number for the other player to guess:");
                            number = scanner.nextInt();
                            n1 = String.valueOf(number); // to use charAt(), int to string
                            if (n1.length() == 4 && n1.charAt(0) != '0' && number > 999 && number < 10000)
                                success = 1;
                            else
                                success = 0;
                        } while (success == 0);
                    } else
                        success = 1;
                    System.out.println("\n".repeat(50));
                } else if (multiplayer == 0) {
                    System.out.println("Single player mode selected.");
                    number = 1000 + (int) (Math.random() * 9000); // Generate a random 4-digit number
                    success = 1;
                } else {
                    System.out.println("Invalid input. Again, please enter 1 for Yes or 0 for No.");
                    multiplayer = scanner.nextInt();
                    success = 0;
                }
            } while (success == 0);

            String n1 = String.valueOf(number); // to use charAt(), int to string
            success = 0;
            do {
                System.out.println("How many attempts would you like to have?");
                attempt = scanner.nextInt();
            } while (attempt <= 0);

            for (int k = 0; k < attempt; k++) {
                success = 0;
                exactCount = 0;
                secretMatched = new boolean[4];
                guessMatched = new boolean[4];
                wrongPlaceCount = 0;

                System.out.println(geciciString);
                System.out.println("attempts left: " + (attempt - k));

                System.out.println("Your guess: ");
                userGuess = scanner.nextInt();
                String n2 = String.valueOf(userGuess); // to use charAt(), int to string

                if (userGuess < 1000 || userGuess > 9999) {
                    success = 0;
                    do {
                        System.out.println("Again enter the number:");
                        userGuess = scanner.nextInt();
                        n2 = String.valueOf(userGuess); // to use charAt(), int to string
                        if (userGuess >= 1000 && userGuess <= 9999)
                            success = 1;
                    } while (success == 0);
                }

                for (int i = 0; i < 4; i++) {
                    if (n1.charAt(i) == n2.charAt(i)) {
                        geciciString[i] = n1.charAt(i);
                        secretMatched[i] = true;
                        guessMatched[i] = true;
                        exactCount++;
                    }
                }

                for (int i = 0; i < 4; i++) {
                    if (secretMatched[i])
                        continue;

                    for (int j = 0; j < 4; j++) {
                        if (guessMatched[j])
                            continue;

                        if (n1.charAt(i) == n2.charAt(j)) {
                            wrongPlaceCount++;
                            guessMatched[j] = true; // Tekrar kullanılmasın diye işaretle
                            break; // Bu gizli basamak eşleşti, sıradaki gizli basamağa geç
                        }
                    }
                }

                if (wrongPlaceCount > 0) {
                    System.out.println(wrongPlaceCount + " digit(s) in the number but in the WRONG place!");
                }

                if (exactCount == 4) {
                    System.out.println("Congratulations! You found it!!");
                    break;
                }

                if (k == attempt - 1) {
                    System.out.println("Game Over! You ran out of attempts. The secret number was: " + number);
                }
            }

            System.out.println("Do you want to play again? Please enter 1 for Yes or 0 for No.");
            again = scanner.nextInt();

        } while (again == 1);
        scanner.close();
    }
}