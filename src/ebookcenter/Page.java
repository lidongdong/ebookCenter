/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class Page extends JPanel {

    private double zoom;//缩放比例
    private ArrayList pictureBoxes;

    public Page(int width, int height) {//毫米转换为像素
        pictureBoxes = new ArrayList<>();
        this.setSize((int) (width * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4),
                (int) (height * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4));
        this.setBackground(Color.WHITE);
        this.setLayout(null);
        //鼠标监听
        this.addMouseListener(new MouseListener() {
            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseEntered(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mouseExited(MouseEvent e) {
               // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
        this.addMouseMotionListener(new MouseMotionListener() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                   System.out.print("x:");
                   System.out.print(e.getPoint().x);
                   System.out.print("y:");
                   System.out.print(e.getPoint().y);
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    public void setBackground() {//自定义设置背景
    }

    public void selectBounds(PageArea pageArea) {
        if (this.getWidth() >= pageArea.getWidth()) {
            this.setBounds(20, 20, this.getWidth(), this.getHeight());
        } else {
            this.setBounds((int) ((pageArea.getWidth() - this.getWidth()) / 2), 20, this.getWidth(), this.getHeight());
        }
    }

    public ArrayList getPictureBoxes() {
        return pictureBoxes;
    }

    public void setPictureBoxes(ArrayList pictureBoxes) {
        this.pictureBoxes = pictureBoxes;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }
}
