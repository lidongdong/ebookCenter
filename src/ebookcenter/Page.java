/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class Page extends JPanel{
    private double zoom;//缩放比例
   
    
    public Page(int width, int height) {//毫米转换为像素
        this.setSize((int)(width*Toolkit.getDefaultToolkit().getScreenResolution()/25.4), 
                (int)(height*Toolkit.getDefaultToolkit().getScreenResolution()/25.4));
        this.setBackground(Color.WHITE);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void setBackground(){//自定义设置背景
        
    }
    public void selectBounds(PageArea pageArea){
        if(this.getWidth()>=pageArea.getWidth()){
            this.setBounds(20, 20, this.getWidth(), this.getHeight());
        }else{
            this.setBounds((int)((pageArea.getWidth()-this.getWidth())/2), 20, this.getWidth(), this.getHeight());
        }
    }
    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
    
}
