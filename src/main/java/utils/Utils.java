package main.java.utils;

import main.java.board.Position;

public class Utils {

    public static boolean isOut(int index){
        if( index < 0 || index > 63 ){
            return true;
        }
        else {
            return false;
        }
    }

    public static int toIndex(int fileIndex, int rankIndex) {
        int index = ( rankIndex * 8 ) + fileIndex;
        return index;
    }

    public static int ICCFtoIndex(int coordinate){
        int rank = coordinate % 10;
        int file = coordinate / 10;
        int index = ( (rank-1)*8  ) + (file-1);
        return index;
    }

    public static int indextoICCF(int index){
        int rank = (index / 8) + 1;
        int file = (index % 8) + 1;
        return file*10 + rank;
    }

    public static void printPossibleMoves(Position pos, int index){
        if( pos.squares[index].getPiece() == null ){
            System.out.println("Empty Square.");
            return;
        }
        if( pos.squares[index].getPiece().possibleMoves(pos,index).size() == 0 ){
            System.out.println("No Possible Moves.");
            return;
        }
        for( int i = 0; i < pos.squares[index].getPiece().possibleMoves(pos,index).size(); i++ ){
            System.out.println( i+1 + "- " +
                    pos.squares[index].getPiece().possibleMoves(pos,index).get(i) );
        }
    }

    public static void printPossibleMovesICCF(Position pos, int index){
        if( pos.squares[index].getPiece() == null ){
            System.out.println("Empty Square.");
            return;
        }
        if( pos.squares[index].getPiece().possibleMoves(pos,index).size() == 0 ){
            System.out.println("No Possible Moves.");
            return;
        }
        for( int i = 0; i < pos.squares[index].getPiece().possibleMoves(pos,index).size(); i++ ){
            System.out.println( i+1 + "- " +
                    indextoICCF(pos.squares[index].getPiece().possibleMoves(pos,index).get(i) ));
        }
    }

}
