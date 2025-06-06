import java.sql.SQLOutput;
import java.util.Scanner;

import board.Position;
import board.Square;
import pieces.*;
import utils.Utils;


import static board.Square.*;
import static utils.Utils.*;

public class Main {
    public static void main(String[] args) {
       String ff = "rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR";
       Position pos = new Position(ff);
       pos.move(5254);
       pos.move(5755);
        pos.move(7163);
        pos.move(2836);
        pos.move(6125);
        pos.move(1716);
        pos.move(2514);
        pos.move(7866);
        pos.move(4244);
        pos.move(6857);
        pos.move(5857);



            pos.boardRender();

    }
}