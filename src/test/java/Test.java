package test.java;

import main.java.board.Position;

import java.util.Scanner;

import static main.java.utils.Utils.*;

public class Test {
    public static void main(String[] args){

            Position pos = null;
            Scanner input = new Scanner(System.in);

            boolean invalid = true;
            while(invalid){
                System.out.println("1. Custom Position.");
                System.out.println("2. Standard Starting Position.");
                String choice1 = input.nextLine();
                switch(choice1){
                    case("1"):
                        invalid = false;
                        System.out.println("FEN : ");
                        String fen = input.nextLine();
                        pos = new Position(fen);
                        break;
                    case("2"):
                        invalid = false;
                        pos = new Position("rnbqkbnr/pppppppp/8/8/8/8/PPPPPPPP/RNBQKBNR w");
                        break;
                    default:
                        System.out.println("Invalid Input, Enter ( 1 or 2 ).");
                        break;
                }
            }

            commandList();

        boolean cont = true;
        while(cont) {

            String com = input.nextLine();
            Scanner command = new Scanner(com);

            if (com.equals("Render")) {
                pos.boardRender();
                continue;
            } else if (command.hasNextInt()) {
                pos.move(command.nextInt());
                continue;
            } else if (com.matches("Moves for \\d+")) {
                String[] parts = com.split(" ");
                int index = ICCFtoIndex(Integer.parseInt(parts[2]));
                printPossibleMovesICCF(pos, index);
                continue;
            } else if (com.equals("Exit")) {
                cont = false;
                break;
            }

        }
    }

    public static void commandList(){
        System.out.println("List of Commands: ");
        System.out.println("1.\"Render\" For rendering the board.");
        System.out.println("2.Any ICCF notation to make a move.");
        System.out.println("3.\"Moves for <index>\" To print all possible moves for piece at <index>.");
        System.out.println("4.\"Exit\" To exit.");
    }
}
