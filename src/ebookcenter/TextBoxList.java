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
public class TextBoxList {
    private List<TextBox> textBoxList;

    public TextBoxList() {
        textBoxList = new ArrayList<TextBox>();
    }
    
    
    public int size(){
        return textBoxList.size();
    }
    
    public boolean remove(TextBox tb){
        return textBoxList.remove(tb);
    }
    
    public TextBox get(int index){
        return textBoxList.get(index);
    }
    
    public void add(TextBox textBox){
        textBoxList.add(textBox);
    }

    
    public List<TextBox> getTextBoxList() {
        return textBoxList;
    }

    public void setTextBoxList(List<TextBox> textBoxList) {
        this.textBoxList = textBoxList;
    }
    
    
}
