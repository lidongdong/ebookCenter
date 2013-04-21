/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class PageArea extends JPanel{

    public PageArea(JPanel jPanel) {
        this.setLayout(null);
        this.setSize(jPanel.getSize());
        jPanel.add(this);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
}
