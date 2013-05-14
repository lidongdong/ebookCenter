/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Dimension;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author think
 */
public class UndoQueue {

    private int flag;
    private List<OperationStruct> queue;

    UndoQueue() {
        init();
    }

    public void init() {
        queue = new ArrayList<OperationStruct>();
        flag = -1;
    }

    public void push(Rectangle station, int boxType, int boxId) {
        for (int i = flag + 1; i < queue.size(); i++) {
            queue.remove(i);
        }
        queue.add(new OperationStruct(station, boxType, boxId));
        flag = queue.size() - 1;
    }

    public OperationStruct undo() {
        if (flag > 0) {
            flag--;
            return queue.get(flag);
        } else {
            return null;
        }
    }

    public OperationStruct ahead() {
        if (flag < queue.size() - 1) {
            flag++;
            return queue.get(flag);
        } else {
            return null;
        }
    }
}
