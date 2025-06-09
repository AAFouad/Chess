package board;
import pieces.*;

public class Square {
    private final int INDEX;

    private final int FILE;
    private final int RANK;

    private final boolean isLight; //for later GUI
    private Piece piece;

    //Constructor
    public Square(int INDEX){
        this.INDEX = INDEX;

        FILE = INDEX % 8;
        RANK = INDEX / 8 + 1;

        if ( ( FILE + RANK ) % 2 == 0 ) { isLight = false; }
        else { isLight = true; }

    }
    public Square(int INDEX, Piece piece){
        this(INDEX);
        this.piece = piece;
    }

    //Getters
    public int getINDEX() { return INDEX; }
    public boolean isLight() { return isLight; }
    public Piece getPiece() { return piece; }

    //Setters
    public void setPiece(Piece piece) { this.piece = piece; }

    public boolean hasFriend(boolean white){
        if( this.piece == null ){
            return false;
        }
        if ( this.piece.isWhite() ){
            return white;
        } else {
            return !white;
        }
    }

    public boolean hasEnemy(boolean white){
        if( this.piece == null ){
            return false;
        }
        if( this.piece.isWhite() ){
            return !white;
        } else {
            return white;
        }
    }

    public boolean isEmpty(){
        return piece == null;
    }


}
