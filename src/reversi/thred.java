/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package reversi;

import com.sun.corba.se.impl.io.IIOPInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import static ser.Play.getTile;
import ser.Board;
import ser.Location;
import ser.Play;
import ser.PrintBoard;
import ser.Tile.Type;
import ser.Tile;

/**
 *
 * @author user
 */
public class thred extends Thread {

    public thred(Socket socket1, Socket socket2) {
        this.socket1 = socket1;
        this.socket2 = socket2;

    }

    private Socket socket1, socket2;
    private Board b = new Board();
    private PrintBoard pb = new PrintBoard();
    private Location l = new Location();
    //private static BufferedReader in1 = null;
    //private static BufferedReader in2 = null;
    //private Play pl = new Play();
    private Tile T = new Tile();
    private ObjectInputStream input1;
    private ObjectInputStream input2;
    Object obj1, obj2,obt;
    private ObjectOutputStream out1,out2; 
    
    
    @Override

    public void run() {

        try {
            playGame();

            //the first playr is false and the second is true
            //pl.playGame();
        } catch (IOException ex) {
            Logger.getLogger(thred.class.getName()).log(Level.SEVERE, null, ex);
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(thred.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    public Location getTile(boolean turn) throws IOException, ClassNotFoundException {
        Location l = new Location();
        Scanner s = new Scanner(System.in);
        if (turn) {
            System.out.println("White's turn");
            System.out.println("enter row");
            input1 = new ObjectInputStream(socket1.getInputStream());
            obj1 = input1.readObject();
            int S1 = (Integer) obj1;
            l.setRow(S1);
            System.out.println("enter column");
            input1 = new ObjectInputStream(socket1.getInputStream());
            obj1 = input1.readObject();
            int S2 = (Integer) obj1;
            l.setColumn(S2);
        } else {
            System.out.println("black's turn");
            System.out.println("enter row");
            input2 = new ObjectInputStream(socket2.getInputStream());
            obj2 = input2.readObject();
            int S1 = (Integer) obj2;
            l.setRow(S1);
            System.out.println("enter column");
            input2 = new ObjectInputStream(socket2.getInputStream());
            obj2 = input2.readObject();
            int S2 = (Integer) obj2;
            l.setColumn(S2);
        }
        return l;
    }

    public void playGame() throws IOException, ClassNotFoundException {

        Board b = new Board();
        Location l = new Location();
        boolean turn = false;
        PrintBoard p = new PrintBoard();

        do {

            turn = !turn;
            Type t = turn ? Type.White : Type.Black;

            p.printBoard(b);
            do {
                l = getTile(turn);
            } while (!(b.validLocation(l.getRow(), l.getColumn()) && b.movIsLegal(l, t)));
            
            b.newPiece(l, t);
            //p.printBoard(b);
            
        } while (b.isWon(b));
        {

            int wCount = 0, bCount = 0;

            for (int i = 0; i < 8; i++) {
                for (int j = 0; j < 8; j++) {
                    if (b.getBoard()[i][j].getType() == Type.Black) {
                        bCount++;
                    } else if (b.getBoard()[i][j].getType() == Type.White) {
                        wCount++;
                    }
                }
            }
            p.printBoard(b);
            if (wCount > bCount) {
                System.out.println("white is won !");
            } else {
                System.out.println("black is won !");
            }

        }
    }
}

/*boolean turn;
 int colume = 0;
            
 do {
 pb.printBoard(b);
            
 do {
 turn = false;
 Type t = turn ? Type.White : Type.Black;
            
 try {
            
 String S1 = in1.readLine();
 colume = Integer.parseInt(S1);
            
 b.newPiece(l, t);
 try {
 ObjectOutputStream obj = new ObjectOutputStream(socket1.getOutputStream());
 obj.writeObject(b);
 } catch (Exception e) {
 System.out.println("erorr obj");
 }
 //pb.printBoard(b);
 } catch (Exception e) {
 System.err.println("error");
 }
            
 } while (b.validLocation(colume, colume));
 if (b.isWon(b)) {
 break;
 }
            
 pb.printBoard(b);
 do {
 turn =  true;
 Type t = turn ? Type.White : Type.Black;
 try {
            
 String S2 = in2.readLine();
 colume = Integer.parseInt(S2);
            
 do {
 l = getTile(turn);
 } while (!(b.validLocation(l.getRow(), l.getColumn()) && b.movIsLegal(l, t)));
 b.newPiece(l, t);
 try {
 ObjectOutputStream obj = new ObjectOutputStream(socket1.getOutputStream());
 obj.writeObject(b);
 } catch (Exception e) {
 System.out.println("erorr obj");
 }
 //pb.printBoard(b);
 } catch (Exception e) {
 System.err.println("error");
 }
            
 } while (!b.validLocation(colume, colume));
 } while (!b.isWon(b));
            
 pb.printBoard(b);
 if (turn) {
 System.out.println("white is won !");
 } else {
 System.out.println("black is won !");
 }*/
