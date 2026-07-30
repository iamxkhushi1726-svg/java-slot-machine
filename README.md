# 🎰 Java Slot Machine

**Project 18 of 100** — A terminal-based Java slot machine game built while learning Java fundamentals.

---

## 📌 Overview

A fully interactive console slot machine game. You start with **₹100** and bet **₹10 per spin**.
Three reels show random symbols. Match two to get your bet back, or match three for big multiplier payouts. The ultimate jackpot (💎💎💎) pays **50x** your bet!

---

## 💻 Output Demo

```
+---------------------------------+
|       🎰 JAVA SLOT MACHINE      |
+---------------------------------+
Starting balance:₹100
Bet per spin:₹10

PAYOUT TABLE
-----------------------------------
🍒 🍒 🍒   -> ₹20   (2x)
🍋 🍋 🍋   -> ₹30   (3x)
🍊 🍊 🍊   -> ₹40   (4x)
🍇 🍇 🍇   -> ₹50   (5x)
🔔 🔔 🔔   -> ₹100  (10x)
⭐ ⭐ ⭐   -> ₹200  (20x)
💎 💎 💎   -> ₹500  JACKPOT!
-----------------------------------

-----------------------------------
  Balance : ₹100
  Bet     : ₹10 per spin

  [S] Spin    [Q] Quit
  Your choice: s

  +-----------------------+
  |     SLOT MACHINE      |
  +-----------------------+
  |   🍇  |  🍋  |  🔔   |
  +-----------------------+

  😔 No win this time. Keep going!
-----------------------------------
  Balance : ₹90
  Bet     : ₹10 per spin

  [S] Spin    [Q] Quit
  Your choice: s

  +-----------------------+
  |     SLOT MACHINE      |
  +-----------------------+
  |   🍋  |  🍋  |  🍒   |
  +-----------------------+

  ✨ Two of a kind! You get your bet back.
  Payout: ₹10
-----------------------------------
  Balance : ₹90
  Bet     : ₹10 per spin

  [S] Spin    [Q] Quit
  Your choice: s

  +-----------------------+
  |     SLOT MACHINE      |
  +-----------------------+
  |   🔔  |  🔔  |  🍒   |
  +-----------------------+

  ✨ Two of a kind! You get your bet back.
  Payout: ₹10
-----------------------------------
  Balance : ₹90
  Bet     : ₹10 per spin

  [S] Spin    [Q] Quit
  Your choice: s

  +-----------------------+
  |     SLOT MACHINE      |
  +-----------------------+
  |   🍋  |  💎  |  ⭐   |
  +-----------------------+

  😔 No win this time. Keep going!
-----------------------------------
  Balance : ₹80
  Bet     : ₹10 per spin

  [S] Spin    [Q] Quit
  Your choice: s

  +-----------------------+
  |     SLOT MACHINE      |
  +-----------------------+
  |   🍒  |  🍋  |  🍇   |
  +-----------------------+

  😔 No win this time. Keep going!
-----------------------------------
  Balance : ₹70
  Bet     : ₹10 per spin

  [S] Spin    [Q] Quit
  Your choice: q

  You chose to walk away. Smart!

+---------------------------------+
|            GAME OVER            |
+---------------------------------+
|  Final balance :   ₹70          |
|  Total spins   :   5            |
|  Total won     :   ₹20          |
+---------------------------------+

  👋 Thanks for playing. Come back anytime.

```

---

## 🚀 How to Run

**Requirements:** Java 17 or higher

```powershell
# Clone the repository
git clone https://github.com/iamxkhushi1726-svg/java-slot-machine.git
cd java-slot-machine/src

# Compile the source files
javac Reel.java SlotMachine.java Game.java

# Run the game
java Game

```

**Controls:**

* `S` — Spin the reels
* `Q` — Quit the game

---

## 💰 Payout Table

| Symbols | Payout | Multiplier |
| --- | --- | --- |
| 🍒 🍒 🍒 | ₹20 | 2x |
| 🍋 🍋 🍋 | ₹30 | 3x |
| 🍊 🍊 🍊 | ₹40 | 4x |
| 🍇 🍇 🍇 | ₹50 | 5x |
| 🔔 🔔 🔔 | ₹100 | 10x |
| ⭐ ⭐ ⭐ | ₹200 | 20x |
| 💎 💎 💎 | ₹500 | **JACKPOT!** |
| Any two match | ₹10 | Bet Back |

---

## 📁 Project Structure

```text
java-slot-machine/
├── src/
│   ├── Reel.java          # Single reel — symbols & spin logic
│   ├── SlotMachine.java   # Three reels + win detection + payout calculations
│   └── Game.java          # Main game loop, player inputs, & UI rendering
├── .gitignore
└── README.md

```

---

## 🧠 Java Concepts Learned

| Concept | Usage |
| --- | --- |
| **Classes & Objects** | Object-Oriented design across `Reel`, `SlotMachine`, and `Game` |
| **Composition** | `SlotMachine` containing three `Reel` instances |
| **Encapsulation** | `private` variables with getter methods |
| **Switch Expressions** | Modern `switch` syntax (Java 14+) for payout logic |
| **Exception Handling** | Handling `InterruptedException` with `Thread.sleep()` |
| **ANSI Escape Formatting** | Terminal formatting & clean ASCII UI alignment |
| **String Comparison** | Using `.equals()` for string value checks |

---

## 🔮 Future Enhancements

* [ ] Save high scores to a file using Java `FileWriter`.
* [ ] Add configurable bet amounts (dynamic bets instead of fixed ₹10).
* [ ] Implement a **Double or Nothing** mini-game after winning spins.
* [ ] Package as an executable `.jar` file.

---

Part of my 100-project challenge to build a strong GitHub portfolio.

Follow my progress: [@iamxkhushi1726-svg](https://www.google.com/search?q=https://github.com/iamxkhushi1726-svg)
