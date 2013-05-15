/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Rectangle;

/**
 *
 * @author think
 */
public class OperationStruct {

    private Rectangle start;
    private Rectangle end;
    private int boxType;
    private int boxId;

    public OperationStruct(Rectangle start, int boxType, int boxId) {
        this.start = start;
        this.boxType = boxType;
        this.boxId = boxId;
    }  
    
    public void append(Rectangle end){
        this.end = end;
    }

    public Rectangle getStart() {
        return start;
    }

    public void setStart(Rectangle start) {
        this.start = start;
    }

    public Rectangle getEnd() {
        return end;
    }

    public void setEnd(Rectangle end) {
        this.end = end;
    } 

    public int getBoxType() {
        return boxType;
    }

    public void setBoxType(int boxType) {
        this.boxType = boxType;
    }

    public int getBoxId() {
        return boxId;
    }

    public void setBoxId(int boxId) {
        this.boxId = boxId;
    }
}
