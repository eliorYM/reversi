/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.util.Scanner;
/**
 *
 * @author try
 */
public class Reversi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        play();
    }
    
    public static Location getTile (boolean turn){
        Location l = new Location();
        Scanner s = new Scanner(System.in);
        if(turn){
            System.out.println("White's turn");
            System.out.println("enter row");
            l.setRow(s.nextInt());
            System.out.println("enter column");
            l.setColumn(s.nextInt());            
        } else{
            System.out.println("black's turn");
            System.out.println("enter row");
            l.setRow(s.nextInt());
            System.out.println("enter column");
            l.setColumn(s.nextInt());  
        }        
        return l;
    }
    
    
    
    public static void play() {
        Board b = new Board();
        Location l = new Location();
        boolean turn = true;
        PrintBoard p = new PrintBoard();
        
        p.printBoard(b);
        while(true/*!b.isWon*/){
            Type t = turn ? Type.White : Type.Black;
            do {              
                l = getTile(turn);
            } while (!(b.validLocation(l.getRow(), l.getColumn()) && b.movIsLegal(l, t)));
            b.newPiece(l, t);
            p.printBoard(b);
            turn = !turn;
        }
        
    }
    
}
