/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author think
 */
public class TextBoxList implements Serializable{
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

    public int indexOf(TextBox textBox){
        return textBoxList.indexOf(textBox);
    }
    public List<TextBox> getTextBoxList() {
        return textBoxList;
    }

    public void setTextBoxList(List<TextBox> textBoxList) {
        this.textBoxList = textBoxList;
    }
    
    
}
