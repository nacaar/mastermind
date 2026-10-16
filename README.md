# Mastermind

A console-based Mastermind game in Java with single-player and multiplayer modes.

## How to play
- Choose single-player (random 4-digit secret number) or multiplayer (the other player enters the secret number).
- Set the number of attempts.
- After each guess you see which digits are in the correct place and how many digits are in the number but in the wrong place.

## Run
```bash
javac mastermind.java
java mastermind
```

## Notes
The duplicate-digit matching logic (secretMatched / guessMatched) was developed with help from an AI assistant, and the code was reviewed with AI assistance. The rest of the game was written by me.