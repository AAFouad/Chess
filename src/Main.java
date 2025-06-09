import board.Position;
import gui.Board;

import static utils.Utils.*;

public class Main {
    public static void main(String[] args) {

        new Board();

        String ff = "k7/8/8/3r1b2/4P3/nBp5/1P4PP/K7 w";
        Position pos = new Position(ff);

        pos.boardRender();

        printPossibleMoves(pos, 9);
        printPossibleMoves(pos, 28);
        printPossibleMoves(pos, 14);
        printPossibleMoves(pos, 15);


    }
}