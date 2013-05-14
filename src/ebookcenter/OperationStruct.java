/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Dimension;
import java.awt.Rectangle;

/**
 *
 * @author think
 */
public class OperationStruct {

    private int operationType;
    private Rectangle station;
    private int boxType;
    private int boxId;

    public OperationStruct(Rectangle station, int boxType, int boxId) {
        this.station = station;
        this.boxType = boxType;
        this.boxId = boxId;
    }

    public int getOperationType() {
        return operationType;
    }

    public void setOperationType(int operationType) {
        this.operationType = operationType;
    }

    public Rectangle getStation() {
        return station;
    }

    public void setStation(Rectangle station) {
        this.station = station;
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
