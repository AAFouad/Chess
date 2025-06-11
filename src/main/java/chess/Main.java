package main.java.chess;

import main.java.board.Position;

import static main.java.move.Move.isLegal;
import static main.java.utils.Utils.*;

public class Main {
    public static void main(String[] args) {

        String ff = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w ";
        Position pos = new Position(ff);


        pos.boardRender();

    }
}