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

    public void push(Rectangle start, int boxType, int boxId) {
        for (int i = flag + 1; i < queue.size(); i++) {
            queue.remove(i);
        }
        queue.add(new OperationStruct(start, boxType, boxId));
        flag = queue.size() - 1;
    }
    
    public void append(Rectangle end){
        queue.get(flag).append(end);
    }

    public OperationStruct get(int index) {
        return this.queue.get(index);
    }

    public OperationStruct undo() {
       if(flag>=0){
           return queue.get(flag--);
       }else{
           return null;
       }
    }

    
    public OperationStruct redo() {
      if(flag < queue.size()-1){
          return queue.get(++flag);
      }else{
          return null;
      }
    }

    public int getFlag() {
        return flag;
    }

    public void setFlag(int flag) {
        this.flag = flag;
    }

    public List<OperationStruct> getQueue() {
        return queue;
    }

    public void setQueue(List<OperationStruct> queue) {
        this.queue = queue;
    }
}
