package main.java.pieces;
import main.java.board.Position;

import java.util.ArrayList;

import static main.java.utils.Utils.*;


public class Rook extends Piece {

    private boolean hasMoved;

    public Rook(boolean isWhite){
        super(isWhite);
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
            moves.add(destination);
            if( pos.squares[destination].hasEnemy(this.isWhite()) ){
                break;
            }
            destination += 8;
        }

        //East
        if( ! ( start % 8 == 7 ) ){
            destination = start + 1;
            while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
                moves.add(destination);
                if( pos.squares[destination].hasEnemy(this.isWhite()) || destination % 8 == 7 ){
                    break;
                }
                destination += 1;
            }
        }

        //South
        destination = start - 8;
        while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
            moves.add(destination);
            if( pos.squares[destination].hasEnemy(this.isWhite()) ){
                break;
            }
            destination -= 8;
        }

        //West
        if( ! ( start % 8 == 0 ) ){
            destination = start - 1;
            while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
                moves.add(destination);
                if( pos.squares[destination].hasEnemy(this.isWhite()) || destination % 8 == 0 ){
                    break;
                }
                destination -= 1;
            }
        }

        return moves;
    }

    @Override
    public Piece clone() {
        return new Rook(this.isWhite());
    }


}
