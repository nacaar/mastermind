# Mastermind

A console-based Mastermind game written in Java. It supports single-player and multiplayer modes.

## How to play

- Choose **single-player** (the game picks a random 4-digit secret number) or **multiplayer** (the other player enters the secret number, and the screen is cleared so it stays hidden).
- Choose how many attempts you want.
- After each guess, the game shows which digits are in the correct place and how many digits are in the number but in the wrong place.
- Find the secret number before you run out of attempts.

## Run

```bash
javac mastermind.java
java mastermind
```

Requires Java 11 or later.

## AI assistance

I wrote the game myself, but I used an AI assistant (Claude) for some parts:

- The logic that matches digits and handles duplicate digits correctly (the `secretMatched` / `guessMatched` boolean arrays).
- Reviewing the code and suggesting fixes, such as rejecting negative guesses and hiding the secret number in multiplayer mode.

I reviewed and tested the final code myself.
