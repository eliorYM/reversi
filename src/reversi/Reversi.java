/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

/**
 *
 * @author try
 */
public class Reversi {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        Board b = new Board();
        Location l = new Location(1, 1);
        
        PrintBoard p = new PrintBoard();
        p.printBoard(b);
        
        if(b.movIsLegal(l, Type.White)){
            b.newPiece(l, Type.White);
        }
        l.setColumn(5);
        if(b.movIsLegal(l, Type.White)){
            b.newPiece(l, Type.White);
        }
    }
    
}
