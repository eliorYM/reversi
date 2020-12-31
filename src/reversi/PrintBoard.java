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
public class PrintBoard {
    
    public void printBoard(Board board){
        System.out.printf("%-3s", " ");
        for (int i = 0; i < 8; i++) {
            System.out.printf("%-3d", i);
        }
        System.out.println("");
        
         for (int i = 0; i < 8; i++) {
             System.out.printf("%-3d", i);
             for (int j = 0; j < 8; j++) {
                 if(board.board[i][j].getType() == Type.Empty){
                     System.out.printf("%-3s", "[]");
                 } else if(board.board[i][j].getType() == Type.Black) {
                     System.out.printf("%-3d", 8);
                 } else if(board.board[i][j].getType() == Type.White){
                     System.out.printf("%-3d", 0);
                 }
             }
             System.out.println("");
         }
         System.out.println("");
     }
}
