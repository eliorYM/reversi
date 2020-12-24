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
public class Tile {
    private Type type;

    public Tile() {
        this.type = Type.Empty;
    }

    public Tile(Type type) {
        this.type = type;
    }
    
    public Tile(int i) {
        switch(i){
            case 1: {
                this.type = type.White;
                break;
            }
            case 0: {
                this.type = type.Empty;
                break;
            }
            case -1: {
                this.type = type.Black;
                break;
            }
            default:{
                
            }
        }
    }
    

    public Type getType() {
        return type;
    }

    public void setType(Type type) {
        this.type = type;
    }
    
    
    
}
enum Type{
    Empty,
    White,
    Black
}