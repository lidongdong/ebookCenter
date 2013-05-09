/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Dimension;
import java.awt.Image;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class PictureContainer extends JPanel {
    
    private List<PrePicture> pictureList; 
    private Image image;
    private int myWidth;

    

    public PictureContainer(JPanel jPanel) {
        pictureList = new ArrayList<PrePicture>();
        myWidth = jPanel.getWidth();
        this.setPreferredSize(new Dimension(jPanel.getWidth(), pictureList.size() * 120 + 30));
        this.setLayout(null);
        this.setLocation(0, 0);
    }

    public void showPicture(){
        for(int i = 0; i<pictureList.size(); i++){
            pictureList.get(i).setBounds(20, 20 + 110 * i, 80, 80);
            this.add(pictureList.get(i));
        }
    }
   

    public void addPicture(File file[]) {
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                pictureList.add(new PrePicture(file[i]));
            } else {
                File f = new File(file[i].getAbsolutePath());
                File temp[] = f.listFiles();
                for (int h = 0; h < temp.length; h++) {
                    if (temp[h].getAbsolutePath().endsWith("PNG") || temp[h].getAbsolutePath().endsWith("png") || temp[h].getAbsolutePath().endsWith("jpg")) {
                        pictureList.add(new PrePicture(temp[h]));
                    }
                }
            }
        }
        this.setPreferredSize(new Dimension(myWidth, pictureList.size() * 120 + 30));
    }

    public List<PrePicture> getPictureList() {
        return pictureList;
    }

    public void setPictureList(List<PrePicture> pictureList) {
        this.pictureList = pictureList;
    }
    
    
}
