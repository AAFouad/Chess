package pieces;
import board.Position;

import java.util.ArrayList;

import static utils.Utils.*;


public class Rook extends Piece {

    private boolean hasMoved;

    public Rook(boolean isWhite){
        super(isWhite);
        hasMoved = false;
        if(isWhite){ this.type = 'R';}
        else {this.type = 'r';}
    }

    public boolean hasMoved(){ return hasMoved; }

    @Override
    public char getType(){
        return this.type;
    }

    @Override
    public ArrayList<Integer> possibleMoves(Position pos, int start) {
        if ( isOut(start) ){ return null; }

        ArrayList<Integer> moves = new ArrayList<>();
        int destination;

        //North
        destination = start + 8;
        while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
            if( pos.squares[destination].hasEnemy( this.isWhite() ) ){
                moves.add(destination);
                break;
            }
            else {
                moves.add(destination);
            }
            destination += 8;
        }

        //East
        destination = start + 1;
        while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
            if( pos.squares[destination].hasEnemy( this.isWhite() ) ){
                moves.add(destination);
                break;
            }
            else {
                moves.add(destination);
            }
            destination += 1;
        }

        //South
        destination = start - 8;
        while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
            if( pos.squares[destination].hasEnemy( this.isWhite() ) ){
                moves.add(destination);
                break;
            }
            else {
                moves.add(destination);
            }
            destination -= 8;
        }

        //West
        destination = start - 1;
        while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
            if( pos.squares[destination].hasEnemy( this.isWhite() ) ){
                moves.add(destination);
                break;
            }
            else {
                moves.add(destination);
            }
            destination -= 1;
        }

        return moves;
    }


}
