package com.github.lant.ocasim;

public class Main {
  public static void main(String[] args) {
    Board board = new Board();
    int previousFinishedTurns = Integer.MAX_VALUE;

    for (int i = 0; i < 1000; i++) {
      Game game = new Game(board);
      int turns = game.run();
      if (turns < previousFinishedTurns) {
        System.out.println("Finished with " + turns + " turns");
        game.logRolls();
        previousFinishedTurns = turns;
      }
    }
  }
}
