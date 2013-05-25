/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author think
 */
public class PrePictureBoxList {

    private List<PrePictureBox> preList;

    public PrePictureBoxList(PictureBoxList pictureBoxList, double scale) {
        preList = new ArrayList<PrePictureBox>();
        for(int i = 0; i< pictureBoxList.size(); i++){
            add(pictureBoxList.get(i), scale);
        }
    }
    
    public int size(){
        return preList.size();
    }
    
    public void add(PictureBox pictureBox, double scale){
        PrePictureBox ppb = new PrePictureBox(pictureBox, scale);
        preList.add(ppb);
    }
    
    public PrePictureBox get(int index){
        return preList.get(index);
    }

    public List<PrePictureBox> getPreList() {
        return preList;
    }

    public void setPreList(List<PrePictureBox> preList) {
        this.preList = preList;
    }
    
}
