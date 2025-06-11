package main.java.pieces;
import main.java.board.Position;

import java.util.ArrayList;

import static main.java.utils.Utils.*;

public class Queen extends Piece {


    public Queen(boolean isWhite){
        super(isWhite);
        if(isWhite){ this.type = 'Q';}
        else { this.type = 'q';}
    }

    public char getType(){
        return this.type;
    }

    @Override
    public ArrayList<Integer> possibleMoves(Position pos, int start) {
        if( isOut(start) ){ return null; }

        ArrayList<Integer> moves = new ArrayList<>();

        Rook rook = new Rook(this.isWhite());
        Bishop bishop = new Bishop(this.isWhite());

        moves.addAll(rook.possibleMoves(pos,start));
        moves.addAll(bishop.possibleMoves(pos,start));

        return moves;
    }

    @Override
    public Piece clone() {
        return new Queen(this.isWhite());
    }


}
