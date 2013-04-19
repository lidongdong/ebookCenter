/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author think
 */
public class PictureList {

    private List pictureList;

    public PictureList() {
        pictureList = new ArrayList<>();
    }

    public void add(File file) {
        pictureList.add(file);
    }

    public int getLength() {
        return pictureList.size();
    }
    public File getFile(int i){
        return (File) pictureList.get(i);
        
    }
    public List getPictureList() {
        return pictureList;
    }

    public void setPictureList(List pictureList) {
        this.pictureList = pictureList;
    }
}
