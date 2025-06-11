package main.java.pieces;

import main.java.board.Position;
import java.util.*;
import static main.java.utils.Utils.*;

public class King extends Piece {

    public King(boolean isWhite){
        super(isWhite);
        if(isWhite){this.type = 'K';}
        else{this.type = 'k';}
    }

    public boolean hasMoved(){ return hasMoved; }

    @Override
    public char getType(){
        return this.type;
    }

    @Override
    public ArrayList<Integer> possibleMoves(Position pos, int start) {
        if( isOut(start) ){ return null; }

        ArrayList<Integer> moves = new ArrayList<>();
        ArrayList<Integer> destinations = new ArrayList<>(
                Arrays.asList( start + 9 , start + 8 , start + 7 ,
                        start - 9 , start - 8 , start - 7 ,
                        start + 1 , start - 1 )
        );
        if( start % 8 == 7 ){
            destinations.removeAll(Arrays.asList( start + 9 , start + 1 , start - 7 ));
        } else if ( start % 8 == 0 ){
            destinations.removeAll(Arrays.asList( start + 7 , start - 1 , start - 9 ));
        }
        //int castlePath;

        for ( Integer i : destinations ){
            if( !isOut(i) && !pos.squares[i].hasFriend( this.isWhite() ) ){
                moves.add(i);
            }
        }


        return moves;
    }

    @Override
    public Piece clone() {
        return new King(this.isWhite());
    }

    public boolean validCastle(Position pos, int start, int end){
        if( isOut(start) || ! ( end == 2 || end == 6 || end == 58 || end == 62 ) ) { return false; }
        if( this.isWhite() ){
            if(start > 7) { return false; }

        } else {
            if(start < 56) { return false; }

        }
        return false;
    }

}
