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
public class Play {
    
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
        boolean turn = false;
        PrintBoard p = new PrintBoard();
        
        p.printBoard(b);
        
        do {      
            
            turn = !turn;
            Type t = turn ? Type.White : Type.Black;
            
            do {              
                l = getTile(turn);
            } while (!(b.validLocation(l.getRow(), l.getColumn()) && b.movIsLegal(l, t)));
            
            b.newPiece(l, t);
            p.printBoard(b);
            
        } while (b.isWon(b));
        {
        int wCount = 0, bCount = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(b.getBoard()[i][j].getType() == Type.Black){
                    bCount++;
                }else if(b.getBoard()[i][j].getType() == Type.White){
                    wCount++;
                }
            }
        }   
            if(wCount > bCount){
                System.out.println("white is won !");
            }else{
                System.out.println("black is won !");
            }
        
        }
    }
    
}
