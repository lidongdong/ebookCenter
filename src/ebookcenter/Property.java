/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.io.Serializable;

/**
 *
 * @author John
 */
public class Property implements Serializable{
    private String saveDir;

    public Property(String saveDir) {
        this.saveDir = saveDir;
    }

    public String getSaveDir() {
        return saveDir;
    }

    public void setSaveDir(String saveDir) {
        this.saveDir = saveDir;
    }
    
    
    
}
