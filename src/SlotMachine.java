/**
 * Manages the three reels and determines win/loss after each spin.
 */
public class SlotMachine {

    // --- ANSI Color Codes ---
    private static final String RESET  = "\u001B[0m";
    private static final String BOLD   = "\u001B[1m";
    private static final String CYAN   = "\u001B[36m";
    private static final String YELLOW = "\u001B[33m";
    private static final String GREEN  = "\u001B[32m";
    private static final String PURPLE = "\u001B[35m";

    private final Reel reel1;
    private final Reel reel2;
    private final Reel reel3;

    private final int BET_AMOUNT = 10;

    public SlotMachine() {
        this.reel1 = new Reel();
        this.reel2 = new Reel();
        this.reel3 = new Reel();
    }

    public int spin() {
        reel1.spin();
        reel2.spin();
        reel3.spin();

        String s1 = reel1.getCurrentSymbol();
        String s2 = reel2.getCurrentSymbol();
        String s3 = reel3.getCurrentSymbol();

        displayReels(s1, s2, s3);
        return calculatePayout(s1, s2, s3);
    }

    private void displayReels(String s1, String s2, String s3) {
        System.out.println();
        System.out.println(CYAN + "  +-----------------------+" + RESET);
        System.out.println(CYAN + "  |     SLOT MACHINE      |" + RESET);
        System.out.println(CYAN + "  +-----------------------+" + RESET);
        System.out.printf( CYAN + "  |   " + RESET + "%s" + CYAN + "  |  " + RESET + "%s" + CYAN + "  |  " + RESET + "%s" + CYAN + "   |\n" + RESET, s1, s2, s3);
        System.out.println(CYAN + "  +-----------------------+" + RESET);
        System.out.println();
    }

    private int calculatePayout(String s1, String s2, String s3) {
        if (s1.equals(s2) && s2.equals(s3)) {
            return getThreeOfAKindPayout(s1);
        }

        if (s1.equals(s2) || s2.equals(s3) || s1.equals(s3)) {
            return getTwoOfAKindPayout();
        }

        return 0;
    }

    private int getThreeOfAKindPayout(String symbol) {
        int multiplier = switch (symbol) {
            case "🍒" -> 2;
            case "🍋" -> 3;
            case "🍊" -> 4;
            case "🍇" -> 5;
            case "🔔" -> 10;
            case "⭐" -> 20;
            case "💎" -> 50;
            default   -> 1;
        };

        int payout = BET_AMOUNT * multiplier;

        System.out.println(PURPLE + BOLD + "  🎉 THREE OF A KIND! " + symbol + " x" + multiplier + RESET);
        System.out.println(GREEN + BOLD + "  Payout: ₹" + payout + RESET);

        return payout;
    }

    private int getTwoOfAKindPayout() {
        int payout = BET_AMOUNT;
        System.out.println(YELLOW + "  ✨ Two of a kind! You get your bet back." + RESET);
        System.out.println(GREEN + BOLD + "  Payout: ₹" + payout + RESET);
        return payout;
    }

    public int getBetAmount() {
        return BET_AMOUNT;
    }
}