package main.java.chess;

import main.java.board.Position;
import main.java.gui.Board;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static main.java.move.Move.isLegal;
import static main.java.utils.Utils.*;

public class Main {
    public static void main(String[] args) {



        String ff = "rnbqkbnr/1ppppppp/p7/4P3/8/8/PPPP1PPP/RNBQKBNR b";
        Position pos = new Position(ff);






        pos.boardRender();



    }
}