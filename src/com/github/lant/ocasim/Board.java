package com.github.lant.ocasim;

import java.util.HashMap;
import java.util.Map;

public class Board {
  private Map<Integer, Position> positions;

  Board() {
    positions = new HashMap<>(63);

    for (int i = 1; i < 63; i++) {
      positions.put(i, new Position(i));
    }

    // oques (	5, 9, 14, 18, 23, 27, 32, 36, 41, 45, 50, 54 i 59 )
    positions.put(5,  new Position(5 ,0, 9, false, "OCA"));
    positions.put(9,  new Position(9, 0, 14, false, "OCA" ));
    positions.put(14, new Position(14, 0, 18, false, "OCA"));
    positions.put(18, new Position(18, 0, 23, false, "OCA"));
    positions.put(23, new Position(23, 0, 27, false, "OCA"));
    positions.put(27, new Position(27, 0, 32, false, "OCA"));
    positions.put(32, new Position(32, 0, 36, false, "OCA"));
    positions.put(36, new Position(36, 0, 41, false, "OCA"));
    positions.put(41, new Position(41, 0, 45, false, "OCA"));
    positions.put(45, new Position(45, 0, 50, false, "OCA"));
    positions.put(50, new Position(50, 0, 54, false, "OCA"));
    positions.put(54, new Position(54, 0, 59, false, "OCA"));
    positions.put(59, new Position(59, 0, 63, false, "OCA"));

    // daus ( 26 i 53 )
    positions.put(26, new Position(26, 0, 53, false, "DAU"));
    positions.put(53, new Position(53, 0, 26, false, "DAU"));

    // ponts ( 6 i 12 )
    positions.put(6, new Position(6, 0, 12, false, "PONT"));
    positions.put(12, new Position(12, 0, 6, false, "PONT"));

    // fonda ( 19 ) // 1 sense moure's
    positions.put(19, new Position(19, 1, 0, false, "FONDA"));

    // pou ( 31 )  // 2 sense moure's
    positions.put(31, new Position(31, 2, 0, false, "POU"));

    // laberint (42) es va a la 39
    positions.put(42, new Position(42, 1, 39, false, "LABYRINTH"));

    // presó (52) // 3 torns
    positions.put(52, new Position(52, 3, 0, false, "PRESO"));

    // mort (58) // es torna al començament
    positions.put(58, new Position(58, 1, 1, false, "MORT"));

    // final
    positions.put(63, new Position(63, 0, 0, true, "FINAL"));
  }

  public Position nextPosition(int position) {
    int positionToReturn;
    if (position > 63) {
      positionToReturn = (63 - ( position - 63));
    } else {
      positionToReturn = position;
    }
    return positions.get(positionToReturn);
  }

  class Position {
    int position;
    int nextTurn;
    int nextPosition;
    boolean finalPosition;
    String name;

    Position(int position) {
      this.position = position;
      this.nextTurn = 1;
      this.nextPosition = 0;
      this.finalPosition = false;
      this.name = " STD ";
    }

    Position(int position, int nextTurn, int nextPosition, boolean finalPosition, String name) {
      this.position = position;
      this.nextTurn = nextTurn;
      this.nextPosition = nextPosition;
      this.finalPosition = finalPosition;
      this.name = name;
    }
  }
}
