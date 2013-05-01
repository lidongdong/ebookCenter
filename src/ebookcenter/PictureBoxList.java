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
public class PictureBoxList {

    private List<PictureBox> boxList;
    private Page parentPage;

    public PictureBoxList() {
        boxList = new ArrayList<PictureBox>();
    }

    public PictureBox get(int index) {
        return boxList.get(index);
    }

    public int size() {
        return boxList.size();
    }

    public void add(PictureBox pictureBox) {
        boxList.add(pictureBox);
    }

    public void impact(List<PictureBox> list) {
        int rCenterx = list.get(list.size()-1).getBounds().x + list.get(list.size()-1).getBounds().width / 2;
        int rCentery = list.get(list.size()-1).getBounds().y + list.get(list.size()-1).getBounds().height / 2;
        int lCenterx, lCentery, temp1, temp2;
        for (int i = list.size()-2; i >=0; i--) {
            lCenterx = list.get(i).getBounds().x + list.get(i).getBounds().width / 2;
            lCentery = list.get(i).getBounds().y + list.get(i).getBounds().height / 2;
            if (Math.abs(rCentery - lCentery) <= list.get(i).getBounds().height / 2 + list.get(list.size()-1).getBounds().height / 2
                    && Math.abs(rCenterx - lCenterx) <= list.get(i).getBounds().width / 2 + list.get(list.size()-1).getBounds().width / 2) {
                temp1 = list.get(i).getBounds().height / 2 + list.get(list.size()-1).getBounds().height / 2 - Math.abs(rCentery - lCentery);
                temp2 = list.get(i).getBounds().width / 2 + list.get(list.size()-1).getBounds().width / 2 - Math.abs(rCenterx - lCenterx);
                int x = list.get(list.size()-1).getBounds().x;
                int y = list.get(list.size()-1).getBounds().y;
                int height = list.get(list.size()-1).getBounds().height;
                int width = list.get(list.size()-1).getBounds().width;
                if(temp1<=temp2){
                    if(lCentery >= rCentery){
                        list.get(list.size()-1).setBounds(x,y,width,height - temp1);
                        list.get(list.size()-1).setRect(x, y, width, height - temp1);
                    }
                    else {
                        list.get(list.size()-1).setBounds(x,y+temp1,width,height - temp1);
                        list.get(list.size()-1).setRect(x,y+temp1,width,height - temp1);
                    }
                }else{
                    if(lCenterx >= rCenterx){
                        list.get(list.size()-1).setBounds(x,y,width - temp2,height);
                        list.get(list.size()-1).setRect(x,y,width - temp2,height);
                    }
                    else {
                        list.get(list.size()-1).setBounds(x+temp2,y,width-temp2,height);
                        list.get(list.size()-1).setRect(x+temp2,y,width-temp2,height);
                    }
                }
            }
        }
        if(list.size()-2>0)
        impact(list.subList(0, list.size()-2));
    }

    public List<PictureBox> getBoxList() {
        return boxList;
    }

    public void setBoxList(List<PictureBox> boxList) {
        this.boxList = boxList;
    }

    public Page getParentPage() {
        return parentPage;
    }

    public void setParentPage(Page parentPage) {
        this.parentPage = parentPage;
    }
}
