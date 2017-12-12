package com.github.lant.ocasim;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

public class Game {
  private final Board board;
  private final Random random = new Random();
  private int currentPosition = 1;
  private int currentTurn = 0;
  private int nextTurnToGo = 1;

  private List<Integer> rolls = new ArrayList<>();

  Game(Board board) {
    this.board = board;
  }

  private boolean nextTurn() {
    currentTurn++;
    if (currentTurn == nextTurnToGo) {
      boolean keepGoing = true;
      Board.Position position;
      while (keepGoing) {
        int diceRoll = nextDiceRoll();
        currentPosition = currentPosition + diceRoll;
        position = board.nextPosition(currentPosition);

        // it might have changed due to getting into the final position and going back
        currentPosition = position.position;

        if (position.nextPosition != 0) {
          currentPosition = position.nextPosition;
          position = board.nextPosition(currentPosition);
        }

        nextTurnToGo = nextTurnToGo + position.nextTurn;

        if (position.finalPosition) {
          return true;
        }

        keepGoing = (nextTurnToGo == currentTurn);
      }
    }
    return false;
  }

  public void logRolls() {
    System.out.println("Rolls: " + rolls.stream().map(it -> Integer.toString(it)).collect(Collectors.joining(",")));
  }

  private int nextDiceRoll() {
    int diceRoll = random.nextInt(6) + 1;
    rolls.add(diceRoll);
    return diceRoll;
  }

  public int run() {
    boolean finished = false;
    int turns = 0;
    while (!finished) {
      finished = nextTurn();
      turns++;
    }
    return turns;
  }
}
