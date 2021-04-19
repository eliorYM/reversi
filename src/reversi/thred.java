/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import static reversi.Play.getTile;


/**
 *
 * @author user
 */
public class thred extends Thread {

    public thred(){
        
    }
    public thred(Socket socket1, Socket socket2) {
        this.socket1 = socket1;
        this.socket2 = socket2;

        try {
         //   out = new PrintWriter(Mysocke.getOutputStream());
            //   System.out.println("PrintWriter was created");
            InputStreamReader input1 = new InputStreamReader(socket1.getInputStream());
            in1 = new BufferedReader(input1);
            InputStreamReader input2 = new InputStreamReader(socket2.getInputStream());
            in2 = new BufferedReader(input2);

        } catch (Exception e) {
        }
    }

    private Socket socket1, socket2;
    private Board b = new Board();
    private PrintBoard pb = new PrintBoard();
    private Location l = new Location();
    private BufferedReader in1 = null;
    private BufferedReader in2 = null;
    private Play pl = new Play();
    @Override
    public void run() {

        //the first playr is false and the second is true
        boolean turn = false;
        
              pb.printBoard(b);
                   
            do {
                try {
                    
                turn = !turn;                
                String s1 = in1.readLine();
                Type t = turn ? Type.White : Type.Black;
                
                pl.getTile(turn);
                while(!(b.validLocation(l.getRow(), l.getColumn()) && b.movIsLegal(l, t)));                 
                b.newPiece(l, t);
                pb.printBoard(b);
                
                 } catch (Exception e) {
                     System.err.println("error");
                }
                                               
            } while (!b.isWon(b));{              
            }
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
