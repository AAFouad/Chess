package gui;

import javax.swing.*;

public class Board {
    JFrame chess;

    public Board(){
        chess = new JFrame("FD Chess");
        chess.setSize(1000,1000);
        chess.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        chess.setVisible(true);
    }


}
