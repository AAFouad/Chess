package main.java.move;

import main.java.board.Position;

public class Move {

    public static boolean isLegal(Position pos, int start, int end){
        Position branch = new Position(pos);
        boolean illegal;
        if( branch.simMove(start,end) ){
            if( branch.whiteTurn ){
                illegal = branch.allPossibleMoves(branch.whiteTurn).contains(branch.bK);
            } else {
                illegal = branch.allPossibleMoves(branch.whiteTurn).contains(branch.wK);
            }
        }
        else {
            illegal = true;
        }

        return !illegal;
    }

}
