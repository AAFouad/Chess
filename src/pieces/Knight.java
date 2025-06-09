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
        switch(start % 8){
            case(7):
                destinations.removeAll(Arrays.asList( start + 17 , start + 10 , start - 6 , start - 15 ));
                break;
            case(6):
                destinations.removeAll(Arrays.asList( start + 10 , start - 6 ));
                break;
            case(1):
                destinations.removeAll(Arrays.asList( start + 6 , start - 10 ));
                break;
            case(0):
                destinations.removeAll(Arrays.asList( start + 15 , start + 6 , start - 10 , start - 17 ));
                break;
            default:
                break;
        }

        for ( Integer i : destinations ){
            if( !isOut(i) && !pos.squares[i].hasFriend( this.isWhite() ) ){
                moves.add(i);
            }
        }

        return moves;
    }

    @Override
    public Piece clone() {
        return new Knight(this.isWhite());
    }


}
