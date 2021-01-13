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
public class Board {
   Tile[][] board;

    public Board() {
        board = new Tile[8][8];
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                board[i][j] = new Tile();
            }
        }
        init();
    }

    public Board(Tile[][] board) {
        this.board = board;
    }
    
    public Tile[][] getBoard(){
        return this.board;
    }
    
    public void init() {
        board[3][3].setType(Type.White);
        board[3][4].setType(Type.Black);
        board[4][3].setType(Type.Black);
        board[4][4].setType(Type.White);
    }
        
         
    
    public boolean movIsLegal(Location l, Type color){        
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0  && j == 0) {
                    continue;
                }
                if(checkDir(l, color, i, j)){
                    return true;
                }
            }
        }
        return false;
    }
    
    public boolean checkDir(Location l, Type t, int i, int j){
        int k = 1;
        
        if(!validLocation(l.getRow() + i * k, l.getColumn() + j * k)){
            return false;
        }
        if(board[l.getRow() + i * k][l.getColumn() + j * k].getType() == t){
            return false;
        }
        if(board[l.getRow() + i * k][l.getColumn() + j * k].getType() == Type.Empty){
            return false;
        }
        
        while (true) {            
            k++;
            if (!validLocation(l.getRow() + i * k, l.getColumn() + j * k)) {
                return false;
            }
            if (board[l.getRow() + i * k][l.getColumn() + j * k].getType() == t) {
                return true;
            }
            if (board[l.getRow() + i * k][l.getColumn() + j * k].getType() == Type.Empty) {
                return false;
            }
        }
    }
    
    public boolean validLocation(int i, int j){
        return i >= 0 && i < 8 && j >= 0 && j < 8;
    }
    
    public void newPiece(Location l, Type t){
        for (int i = -1; i < 2; i++) {
            for (int j = -1; j < 2; j++) {
                if (i == 0  && j == 0) {
                    continue;
                }
                if(checkDir(l, t, i, j)){
                    fill(l, t, i, j);
                }
            }
        }
    }
    
    public void fill(Location l, Type t, int i, int j){
        board[l.getRow()][l.getColumn()].setType(t);
        for(int k = 1; board[l.getRow() + i * k][l.getColumn() + j * k].getType() != t; k++){
            board[l.getRow() + i * k][l.getColumn() + j * k].setType(t);
        }
    }
    
    public boolean isWon(Board b){
       
        int wCount = 0, bCount = 0, eCount = 0;
        
        for (int i = 0; i < 8; i++) {
            for (int j = 0; j < 8; j++) {
                if(board[i][j].getType() == Type.Black){
                    bCount++;
                }else if(board[i][j].getType() == Type.White){
                    wCount++;
                }else {
                    eCount++;
                }
            }            
        }
            if (wCount == 0 || bCount == 0 || eCount == 0) {
                return false;                       
            }
       return true;        
}
}