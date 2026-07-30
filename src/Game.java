import java.util.Scanner;

/**
 * Main game loop — handles player input, balance, and game flow.
 */
public class Game {

    // --- Game Constants ---
    private static final int INITIAL_BALANCE = 100;
    private static final int SPIN_DELAY_MS   = 500;

    // --- ANSI Color Codes (Bright & Bold Palette) ---
    private static final String RESET        = "\u001B[0m";
    private static final String BOLD_WHITE   = "\u001B[1;37m";
    private static final String BRIGHT_YELLOW = "\u001B[1;93m";
    private static final String BRIGHT_RED    = "\u001B[1;91m";
    private static final String BRIGHT_GREEN  = "\u001B[1;92m";

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        SlotMachine machine = new SlotMachine();

        int balance  = INITIAL_BALANCE;
        int betCost  = machine.getBetAmount();
        int spins    = 0;
        int totalWon = 0;

        printWelcome();

        while (balance >= betCost) {
            displayStatus(balance, betCost);

            String input = scanner.nextLine().trim().toUpperCase();

            if (input.equals("Q")) {
                System.out.println(BRIGHT_YELLOW + "\n  You chose to walk away. Smart!" + RESET);
                break;
            }

            if (!input.equals("S")) {
                System.out.println(BRIGHT_RED + "  Invalid input. Press S to spin or Q to quit." + RESET);
                continue;
            }

            balance -= betCost;
            spins++;

            int payout = machine.spin();

            if (payout == 0) {
                System.out.println(BRIGHT_RED + "  😔 No win this time. Keep going!" + RESET);
            }

            balance  += payout;
            totalWon += payout;

            pause(SPIN_DELAY_MS);
        }

        printGameOver(balance, spins, totalWon);
        scanner.close();
    }

    private static void printWelcome() {
        System.out.println(BOLD_WHITE + """

            +---------------------------------+
            |      🎰 JAVA SLOT MACHINE       |
            +---------------------------------+""" + RESET + """

            Starting balance: """ + BRIGHT_GREEN + "₹100" + RESET + """

            Bet per spin:     """ + BRIGHT_YELLOW + "₹10" + RESET + """


            """ + BRIGHT_YELLOW + "PAYOUT TABLE" + RESET + BOLD_WHITE + """

            -----------------------------------""" + RESET + """

            🍒 🍒 🍒  ->  """ + BRIGHT_GREEN + " ₹20   (2x)" + RESET + """

            🍋 🍋 🍋  ->  """ + BRIGHT_GREEN + " ₹30   (3x)" + RESET + """

            🍊 🍊 🍊  ->  """ + BRIGHT_GREEN + " ₹40   (4x)" + RESET + """

            🍇 🍇 🍇  ->  """ + BRIGHT_GREEN + " ₹50   (5x)" + RESET + """

            🔔 🔔 🔔  ->  """ + BRIGHT_GREEN + " ₹100  (10x)" + RESET + """

            ⭐ ⭐ ⭐  ->  """ + BRIGHT_GREEN + " ₹200  (20x)" + RESET + """

            💎 💎 💎  ->  """ + BRIGHT_YELLOW + " ₹500  JACKPOT!" + RESET + BOLD_WHITE + """

            -----------------------------------""" + RESET + """

            """);
    }

    private static void displayStatus(int balance, int betCost) {
        System.out.println(BOLD_WHITE + "-----------------------------------" + RESET);
        System.out.println("  Balance : " + BRIGHT_GREEN + "₹" + balance + RESET);
        System.out.println("  Bet     : " + BRIGHT_YELLOW + "₹" + betCost + RESET + " per spin\n");
        System.out.println("  [" + BRIGHT_GREEN + "S" + RESET + "] Spin    [" + BRIGHT_RED + "Q" + RESET + "] Quit");
        System.out.print("  Your choice: ");
    }

    private static void printGameOver(int balance, int spins, int totalWon) {
        System.out.println(BOLD_WHITE + """

            +---------------------------------+
            |            GAME OVER            |
            +---------------------------------+""" + RESET);

        System.out.printf( BOLD_WHITE + "|" + RESET + "  Final balance : " + BRIGHT_GREEN + "  ₹%-12d" + RESET + BOLD_WHITE + "|\n" + RESET, balance);
        System.out.printf( BOLD_WHITE + "|" + RESET + "  Total spins   : " + BRIGHT_YELLOW + "  %-13d" + RESET + BOLD_WHITE + "|\n" + RESET, spins);
        System.out.printf( BOLD_WHITE + "|" + RESET + "  Total won     : " + BRIGHT_GREEN + "  ₹%-12d" + RESET + BOLD_WHITE + "|\n" + RESET, totalWon);
        System.out.println(BOLD_WHITE + "+---------------------------------+" + RESET);

        if (balance > INITIAL_BALANCE) {
            System.out.println(BRIGHT_GREEN + "\n  🏆 You beat the house! Nice work." + RESET);
        } else if (balance == 0) {
            System.out.println(BRIGHT_RED + "\n  💸 Broke. The house always wins eventually." + RESET);
        } else {
            System.out.println(BRIGHT_YELLOW + "\n  👋 Thanks for playing. Come back anytime." + RESET);
        }
    }

    private static void pause(int milliseconds) {
        try {
            Thread.sleep(milliseconds);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
    }
}