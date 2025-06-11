package main.java.pieces;
import main.java.board.Position;

import java.util.ArrayList;

import static main.java.utils.Utils.*;

public class Pawn extends Piece {


    public Pawn(boolean isWhite){
        super(isWhite);
        if(isWhite){ this.type = 'P'; }
        else { this.type = 'p'; }
    }

    public char getType(){
        return this.type;
    }


    @Override
    public ArrayList<Integer> possibleMoves(Position pos, int start) {
        if( isOut(start) ) { return null; }
        ArrayList<Integer> moves = new ArrayList<>();
        int rank = start / 8;
        int file = start % 8;
        int direction = isWhite() ? 8 : -8;
        int destination = start + direction;
        if( pos.squares[destination].isEmpty() ){
            moves.add(destination);

            boolean atSecond = isWhite() ? (rank == 1) : (rank == 6);
            destination = start + 2*direction;
            if( atSecond && pos.squares[destination].isEmpty() ){
                moves.add(destination);
            }
        }

        int[] dirs = { direction + 1 , direction - 1 };
        for( int dir : dirs ){
            destination = start + dir;
            int destFile = destination % 8;
            if( !isOut(destination) && Math.abs(destFile - file) == 1 ){
                if( pos.squares[destination].hasEnemy(isWhite()) || destination == pos.ep ){
                    moves.add(destination);
                }
            }
        }

        return moves;
    }

    @Override
    public Piece clone() {
        return new Pawn(this.isWhite());
    }


}
