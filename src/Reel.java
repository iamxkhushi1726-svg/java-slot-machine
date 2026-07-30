import java.util.Random;

/**
 * Represents one reel in the slot machine.
 * Each reel has a set of possible symbols and spins to show one.
 *
 * Java concept: A class is a blueprint. Each Reel object
 * is a separate instance with its own current symbol.
 */
public class Reel {

    // The possible symbols this reel can show
    // Java concept: arrays use type[] syntax, fixed size
    private String[] symbols;

    // The symbol currently showing after a spin
    private String currentSymbol;

    // Java concept: Random is a built-in class for generating
    // random numbers — similar to Python's random module
    private Random random;

    /**
     * Constructor — runs when you create: new Reel()
     * Java concept: constructors have the same name as the class
     * and no return type
     */
    public Reel() {
        this.random = new Random();

        // Define the symbols and their weights
        // More 🍋 than 💎 = 💎 is rarer = harder to win
        this.symbols = new String[]{
                "🍒", "🍒", "🍒",   // Cherry — common
                "🍋", "🍋", "🍋",   // Lemon — common
                "🍊", "🍊",         // Orange — uncommon
                "🍇", "🍇",         // Grape — uncommon
                "🔔", "🔔",         // Bell — rare
                "⭐",               // Star — very rare
                "💎"                // Diamond — jackpot
        };

        // Start with a default symbol
        this.currentSymbol = symbols[0];
    }

    /**
     * Spin this reel — pick a random symbol from the array.
     *
     * Java concept: void means the method returns nothing.
     * random.nextInt(n) gives a random int from 0 to n-1.
     */
    public void spin() {
        int index = random.nextInt(symbols.length);
        this.currentSymbol = symbols[index];
    }

    /**
     * Get the symbol currently showing.
     *
     * Java concept: getter method — a common pattern for
     * accessing private variables safely from outside the class.
     * This is called encapsulation.
     */
    public String getCurrentSymbol() {
        return currentSymbol;
    }
}