package pieces;
import board.Position;

import java.util.*;

import static utils.Utils.*;

public class Knight extends Piece{

    public Knight(boolean isWhite){
        super(isWhite);
        if(isWhite){this.type = 'N';}
        else { this.type = 'n';}
    }

    @Override
    public char getType() {
        return this.type;
    }



    @Override
    public ArrayList<Integer> possibleMoves(Position pos, int start) {
        if( isOut(start) ) { return null; }

        ArrayList<Integer> moves = new ArrayList<>();
        ArrayList<Integer> destinations = new ArrayList<>(
                Arrays.asList( start + 17 , start + 15 , start + 6 , start - 10 ,
                        start - 17 , start - 15 , start - 6 , start + 10 )
        );

        for ( Integer i : destinations ){
            if( !isOut(i) && !pos.squares[i].hasFriend( this.isWhite() ) ){
                moves.add(i);
            }
        }

        return moves;
    }




}
