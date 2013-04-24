/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class PageArea extends JPanel{

    public PageArea(JPanel jPanel) {
        this.setLayout(null);
        //this.setSize(jPanel.getSize());
        jPanel.add(this);
    }
    
    public void setScrollSize(int width, int height){
        //设定preferredSize使JScrollPane生效
        this.setPreferredSize(new Dimension((int)(width*Toolkit.getDefaultToolkit().getScreenResolution()/25.4)+40, 
                (int)(height*Toolkit.getDefaultToolkit().getScreenResolution()/25.4)+40));
    }
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
}
