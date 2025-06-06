package board;
import pieces.*;

import static board.Square.*;
import static utils.Utils.*;

public class Position {
    public static final int SIZE = 64;
    public static final int WIDTH = 8;

    public Square[] squares = new Square[SIZE];

    public boolean K = false; //White Kingside Castle
    public boolean Q = false; //White Queenside Castle
    public boolean k = false; //Black Kingside Castle
    public boolean q = false; //Black Queenside Castle

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

    private void fromFEN(String FEN){

        String[] fenRanks = FEN.split("/");
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
                        this.squares[toIndex(fldSqrs,7-i)].setPiece(new King(true));
                        fldSqrs++;
                        break;
                    case 'k' :
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

    public void move(int start, int end){
        if( isOut(start) || isOut(end) || squares[start].getPiece() == null ){
            System.out.println("Invalid Square");
            return;
        }
        if( this.squares[start].getPiece().validMove(this, start, end ) ){
            this.squares[end].setPiece( this.squares[start].getPiece() );
            this.squares[start].setPiece(null);
            System.out.println("Moved!!");
        }
        else {
            System.out.println("Invalid Move");
        }
    }
    public void move(int iccf){
        int start = iccf / 100;
        int end = iccf % 100;
        move( ICCFtoIndex(start), ICCFtoIndex(end) );
    }


}
