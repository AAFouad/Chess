package pieces;
import board.Position;

import java.util.ArrayList;

import static utils.Utils.*;

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
        int destination = start;

        if(this.isWhite()){
            if( start / 8  == 1 ){
                for( int i = 0 ; i < 2 ; i++ ){
                    destination += 8;
                    if( pos.squares[destination].isEmpty() ){
                        moves.add(destination);
                    }
                    else { break; }
                }
            }
            destination += 8;
            if( pos.squares[destination].isEmpty() ){
                moves.add(destination);
            }
            moves.add(destination);
        }
        else {
            if( start / 8  == 6 ){
                for( int i = 0 ; i < 2 ; i++ ){
                    destination -= 8;
                    if( pos.squares[destination].isEmpty() ){
                        moves.add(destination);
                    }
                    else { break; }
                }
            }
            destination -= 8;
            if( pos.squares[destination].isEmpty() ){
                moves.add(destination);
            }
            moves.add(destination);
        }


        return moves;
    }


}
