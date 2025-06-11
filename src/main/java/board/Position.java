package main.java.board;
import main.java.pieces.*;

import java.util.HashSet;

import static main.java.utils.Utils.*;
import static main.java.move.Move.*;

public class Position {
    public static final int SIZE = 64;
    public static final int WIDTH = 8;

    public Square[] squares = new Square[SIZE];

    public boolean K = false; //White Kingside Castle
    public boolean Q = false; //White Queenside Castle
    public boolean k = false; //Black Kingside Castle
    public boolean q = false; //Black Queenside Castle

    public int ep = -1;

    public boolean whiteTurn;

    public int wK; //White King's Index
    public int bK; //Black King's Index

    //Constructors
    public Position(){
        for(int i = 0; i < SIZE; i++){
            this.squares[i] = new Square(i);
        }
    }

    public Position(String FEN){
        this();
        fromFEN(FEN);
    }

    public Position(Position another) {
        this.whiteTurn = another.whiteTurn;
        this.wK = another.wK;
        this.bK = another.bK;
        this.ep = another.ep;

        this.squares = new Square[SIZE];
        for (int i = 0; i < SIZE; i++) {
            Piece p = null;
            if (another.squares[i].getPiece() != null) {
                p = another.squares[i].getPiece().clone();
            }
            this.squares[i] = new Square(i,p);
        }
    }

    //Methods
    private void fromFEN(String FEN){

        String[] fenElements = FEN.split(" ");

        switch(fenElements[1]){
            case("w") :  this.whiteTurn = true; break;
            case("b") :  this.whiteTurn = false; break;
            default : System.out.println("Invalid FEN");
        }

        String[] fenRanks = fenElements[0].split("/");
        for( int i = 0; i < fenRanks.length; i++ ){
            int fldSqrs = 0; //filled squares count
            for(int j = 0; j < fenRanks[i].length(); j++ ) {
                char pieceChar = fenRanks[i].charAt(j);
                switch (pieceChar) {
                    case 'P' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Pawn(true));
                        fldSqrs++;
                        break;
                    case 'p' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Pawn(false));
                        fldSqrs++;
                        break;
                    case 'R' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Rook(true));
                        fldSqrs++;
                        break;
                    case 'r' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Rook(false));
                        fldSqrs++;
                        break;
                    case 'N' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Knight(true));
                        fldSqrs++;
                        break;
                    case 'n' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Knight(false));
                        fldSqrs++;
                        break;
                    case 'B' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Bishop(true));
                        fldSqrs++;
                        break;
                    case 'b' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Bishop(false));
                        fldSqrs++;
                        break;
                    case 'Q' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Queen(true));
                        fldSqrs++;
                        break;
                    case 'q' :
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new Queen(false));
                        fldSqrs++;
                        break;
                    case 'K' :
                        wK = toIndex(fldSqrs,7-i);
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new King(true));
                        fldSqrs++;
                        break;
                    case 'k' :
                        bK = toIndex(fldSqrs,7-i);
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new King(false));
                        fldSqrs++;
                        break;
                    case '1' : case '2' : case '3' : case '4' :
                    case '5' : case '6' : case '7' : case '8' :
                        for(int k = 0; k < pieceChar - '0'; k++){
                            this.squares[toIndex(fldSqrs,7-i)].setPiece(null);
                            fldSqrs++;
                        }
                        break;
                    default :
                        System.out.println("Invalid FEN");
                        break;
                }
            }
        }
    }

    public void boardRender(){
        for ( int i = 0; i < WIDTH; i++){
            for ( int j = 0; j < WIDTH; j++){
                if(squares[toIndex(j,7-i)].getPiece()!=null){
                    char c = squares[toIndex(j,7-i)].getPiece().getType();
                    System.out.print(" " + c + " |" );
                }
                else{
                    System.out.print( " . |" );
                }
            }
            System.out.println();
        }
    }

    public boolean simMove(int start, int end, int promoType){
        if( isOut(start) || isOut(end) || squares[start].getPiece() == null ){
            return false;
        }
        Piece p = squares[start].getPiece();
        if( p.isWhite() == whiteTurn && p.validMove(this, start, end ) ){

            this.ep = -1;

            //if pawn for en passant and promotion
            if( Character.toLowerCase( p.getType() ) == 'p' ){
                int dir = Math.abs(start - end);

                //set new en passant square
                if( dir == 16 ){
                    this.ep = p.isWhite() ? end - 8 : end + 8;
                }

                //do en passant
                boolean isCapture = dir == 9 || dir == 7;
                int target = p.isWhite() ? end - 8 : end + 8;
                if( isCapture && squares[end].isEmpty() ){
                    this.squares[end].setPiece( p );
                    this.squares[start].setPiece(null);
                    this.squares[target].setPiece(null);
                    return true;
                }

                //do promotion
                int lastRank = p.isWhite() ? 7 : 0;
                int endRank = end / 8;
                if( lastRank == endRank ){
                    switch(promoType){
                        case(1):
                            this.squares[end].setPiece( new Queen(p.isWhite()) ); break;
                        case(2):
                            this.squares[end].setPiece( new Rook(p.isWhite()) ); break;
                        case(3):
                            this.squares[end].setPiece( new Bishop(p.isWhite()) ); break;
                        case(4):
                            this.squares[end].setPiece( new Knight(p.isWhite()) ); break;
                        default:
                            return false;
                    }
                    this.squares[start].setPiece(null);
                    this.whiteTurn = !this.whiteTurn;
                    return true;
                }
            }

            //if king for updating king's index
            if( p.getType() == 'K' ){
                wK = end;
            } else if ( p.getType() == 'k'){
                bK = end;
            }

            this.squares[end].setPiece( p );
            this.squares[start].setPiece(null);

            this.whiteTurn = !this.whiteTurn;

            return true;
        }
        else {
            return false;
        }
    }
    public boolean simMove(int start, int end){
        return simMove(start, end, 1);
    }

    public void move(int start, int end, int promoType){
        if( isLegal(this, start, end) ){
            this.simMove(start, end, promoType);
            System.out.println("Moved!!");
            if( this.isCheckMate() ){
                System.out.println("CheckMate!!");
            }
            if( this.isStaleMate() ){
                System.out.println("StaleMate!!");
            }
        }
        else {
            System.out.println("Invalid Move.");
        }
    }
    public void move(int start, int end){
        move(start, end, 1);
    }
    public void move(int iccf){
        if( iccf >= 1000 && iccf <= 9999 ){
            int start = iccf / 100;
            int end = iccf % 100;
            move( ICCFtoIndex(start), ICCFtoIndex(end) );
        }
        else if ( iccf >= 10000 && iccf <= 99999 ){
            int start = iccf / 1000;
            int end = ( iccf % 1000 ) / 10;
            int promoType = iccf % 10;
            move ( ICCFtoIndex(start), ICCFtoIndex(end), promoType );
        }
    }

    public HashSet<Integer> allPossibleMoves(boolean white){
        HashSet<Integer> moves = new HashSet<Integer>();
        for(int i = 0; i < SIZE; i ++){
            if( squares[i].getPiece() != null &&
                    squares[i].getPiece().isWhite() == white ){
                moves.addAll( squares[i].getPiece().possibleMoves(this, i) );
            }
        }
        return moves;
    }

    public boolean isCheckMate(){
        for(int i = 0; i < SIZE; i++){
            if( !squares[i].isEmpty() &&
                    squares[i].getPiece().isWhite() == this.whiteTurn ){
                if(squares[i].getPiece().possibleMoves(this,i) != null){
                    for( Integer j : squares[i].getPiece().possibleMoves(this,i) ){
                        if( isLegal(this,i,j) ){ return false; }
                    }
                }
            }
        }

        if( whiteTurn ){
            return allPossibleMoves( !whiteTurn ).contains( wK );
        } else {
            return allPossibleMoves( !whiteTurn ).contains( bK );
        }
    }
    public boolean isStaleMate(){
        for(int i = 0; i < SIZE; i++){
            if( !squares[i].isEmpty() &&
                    squares[i].getPiece().isWhite() == this.whiteTurn ){
                if(squares[i].getPiece().possibleMoves(this,i) != null){
                    for( Integer j : squares[i].getPiece().possibleMoves(this,i) ){
                        if( isLegal(this,i,j) ){ return false; }
                    }
                }
            }
        }

        if( whiteTurn ){
            return !allPossibleMoves( !whiteTurn ).contains( wK );
        } else {
            return !allPossibleMoves( !whiteTurn ).contains( bK );
        }
    }


}
