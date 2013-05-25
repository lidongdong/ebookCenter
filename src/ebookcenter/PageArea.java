/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;

/**
 *
 * @author think
 */
public class PageArea extends JPanel{

    public PageArea(JPanel jPanel) {
        this.setLayout(null);
        setOpaque(false);
        jPanel.add(this);
    }
    
    public void setScrollSize(int width, int height){
        //设定preferredSize使JScrollPane生效
        this.setPreferredSize(new Dimension((int)(width*Toolkit.getDefaultToolkit().getScreenResolution()/25.4)+40, 
                (int)(height*Toolkit.getDefaultToolkit().getScreenResolution()/25.4)+40));
    }
    
    public makeWindow getMakeWindow(){
        return (makeWindow)getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
    }
    
    public void refresh(){
        this.removeAll();
        if(getMakeWindow().getCurrentProject().getCurrentPage() >= 0){
        getMakeWindow().getCurrentProject().getPage(getMakeWindow().getCurrentProject().getCurrentPage()).selectBounds(this);
        this.add(getMakeWindow().getCurrentProject().getPage(getMakeWindow().getCurrentProject().getCurrentPage()));
        }
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
}
