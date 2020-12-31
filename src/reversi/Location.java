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
public class Location {
    private int Row;
    private int Column;

    public Location() {
    }
    
    public Location(int Row, int Column) {
        this.Row = Row;
        this.Column = Column;
    }

    public int getRow() {
        return Row;
    }

    public void setRow(int Row) {
        this.Row = Row;
    }

    public int getColumn() {
        return Column;
    }

    public void setColumn(int Column) {
        this.Column = Column;
    }
    
    
}
