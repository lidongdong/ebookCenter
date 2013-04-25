/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.Toolkit;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionAdapter;
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
    private int orgx, orgy, endx, endy, lastx, lasty;

    public Page(int width, int height) {//毫米转换为像素
        pictureBoxes = new ArrayList<>();
        this.setSize((int) (width * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4),
                (int) (height * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4));
        this.setBackground(Color.WHITE);
        this.setLayout(null);

        //鼠标监听
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mousePressed(MouseEvent e) {
                // throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                orgx = e.getX();
                orgy = e.getY();
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                super.mouseReleased(e); //To change body of generated methods, choose Tools | Templates.
                 endx = e.getX();
                endy = e.getY();
                //添加图片框
                 if (endx == orgx || endy == orgy) {
                } else {
                    if (endx < orgx) {
                        if (endy < orgy) {
                          pictureBoxes.add(new PictureBox(new Rectangle(endx, endy, orgx - endx, orgy - endy)));
                        } else {
                           pictureBoxes.add(new PictureBox(new Rectangle(endx, orgy, orgx - endx, endy - orgy)));
                        }
                    } else {
                        if (endy < orgy) {
                           pictureBoxes.add(new PictureBox(new Rectangle(orgx, endy, endx - orgx, orgy - endy)));
                        } else {
                           pictureBoxes.add(new PictureBox(new Rectangle(orgx, orgy, endx - orgx, endy - orgy)));
                        }
                    }
                }
            }
        });
        this.addMouseMotionListener(new MouseMotionAdapter() {
            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                
                 Graphics g = getGraphics();
                
                endx = e.getX();
                endy = e.getY();
               
                recovery();
                if (endx == orgx || endy == orgy) {
                } else {
                    if (endx < orgx) {
                        if (endy < orgy) {
                           g.drawRect(endx, endy, orgx - endx, orgy - endy);
                        
                        } else {
                            g.drawRect(endx, orgy, orgx - endx, endy - orgy);
                         
                        }
                    } else {
                        if (endy < orgy) {
                           g.drawRect(orgx, endy, endx - orgx, orgy - endy);
                          
                        } else {
                            g.drawRect(orgx, orgy, endx - orgx, endy - orgy);
                         
                        }
                    }
                }
               
            }
        });
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }
    
    public void recovery(){ //恢复page页面，主要用来擦出画矩形框时鼠标拖动过程中的框
        Graphics g = getGraphics();
        //添加背景(后期使用setBackground重写)
        g.setColor(Color.white);
        g.fillRect(0, 0, this.getWidth(), this.getHeight());
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
