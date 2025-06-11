package main.java.pieces;
import main.java.board.Position;

import java.util.ArrayList;

import static main.java.utils.Utils.isOut;

public class Bishop extends Piece {

    public Bishop(boolean isWhite){
        super(isWhite);
        if(isWhite){this.type = 'B';}
        else { this.type = 'b';}
    }

    public char getType(){
        return this.type;
    }


    @Override
    public ArrayList<Integer> possibleMoves(Position pos, int start) {
        if ( isOut(start) ){ return null; }

        ArrayList<Integer> moves = new ArrayList<>();
        int destination;

        //East
        if( ! ( start % 8 == 7 ) ){
            //North East
            destination = start + 9;
            while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
                moves.add(destination);
                if( pos.squares[destination].hasEnemy(this.isWhite()) || destination % 8 == 7 ){
                    break;
                }
                destination += 9;
            }

            //South East
            destination = start - 7;
            while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
                moves.add(destination);
                if( pos.squares[destination].hasEnemy(this.isWhite()) || destination % 8 == 7 ){
                    break;
                }
                destination -= 7;
            }
        }

        //West
        if( ! ( start % 8 == 0 ) ){

            //North West
            destination = start + 7;
            while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
                moves.add(destination);
                if( pos.squares[destination].hasEnemy(this.isWhite()) || destination % 8 == 0 ){
                    break;
                }
                destination += 7;
            }

            //South West
            destination = start - 9;
            while( !isOut(destination) && !pos.squares[destination].hasFriend(this.isWhite()) ){
                moves.add(destination);
                if( pos.squares[destination].hasEnemy(this.isWhite()) || destination % 8 == 0 ){
                    break;
                }
                destination -= 9;
            }
        }

        return moves;
    }

    @Override
    public Piece clone() {
        return new Bishop(this.isWhite());
    }


}
