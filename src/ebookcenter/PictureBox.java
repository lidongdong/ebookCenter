/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.Stroke;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 * 本类为图片框类
 *
 * @author Administrator
 */
public class PictureBox extends JPanel implements MouseListener, MouseMotionListener {

    private Rectangle rect;
    private File pictureFile;
    private int layer;
    private boolean isUsed;
    private Image image;

    public PictureBox(Rectangle rect) {
        this.rect = rect;
        this.setBounds(this.rect);
        this.setBackground(Color.red);
        layer = 2;
        isUsed = false;
        this.setLayout(null);
    }

    public Boolean isInner(Point point) {
        return ((rect.x < point.x) && (point.x < (rect.x + rect.width)) && (rect.y < point.y) && (point.y < (rect.y + rect.height)));
    }

    public Boolean isTopBorder(Point point) {//是否有必要加大范围以便操作
        return ((rect.x < point.x) && (point.x < (rect.x + rect.width)) && (point.y == rect.y));
    }

    public Boolean isBotBorder(Point point) {
        return ((rect.x < point.x) && (point.x < (rect.x + rect.width)) && (point.y == rect.y + rect.height));
    }

    public Boolean isLeftBorder(Point point) {
        return ((rect.y < point.y) && (point.y < (rect.y + rect.height)) && point.x == rect.x);
    }

    public Boolean isRightBorder(Point point) {
        return ((rect.y < point.y) && (point.y < (rect.y + rect.height)) && (point.x == rect.x + rect.width));
    }

    public Boolean isLeftTopCorner(Point point) {
        return ((point.x == rect.x) && (point.y == rect.y));
    }

    public Boolean isRightTopCorner(Point point) {
        return ((point.x == (rect.x + rect.width)) && (point.y == rect.y));
    }

    public Boolean isLeftBotCorner(Point point) {
        return ((point.x == rect.x) && (point.y == (rect.y + rect.height)));
    }

    public Boolean isRightBotCorner(Point point) {
        return ((point.x == (rect.x + rect.width)) && (point.y == (rect.y + rect.height)));
    }

    public void loadImage() {
        try {
            image = ImageIO.read(pictureFile);
            System.out.print(image.getHeight(this));
            System.out.print(image.getWidth(this));
        } catch (IOException ex) {
            Logger.getLogger(PictureBox.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        g.drawRect(rect.x, rect.y, rect.width, rect.height);
    }

    public void setRect(int x, int y, int width, int height) {
        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = width;
        this.rect.height = height;
        this.setBounds(this.rect);
    }

    public Rectangle getRect() {
        return rect;
    }

    public void setRect(Rectangle rect) {
        this.rect = rect;
    }

    public File getFile() {
        return pictureFile;
    }

    public void setFile(File file) {
        this.pictureFile = file;
    }

    public int getLayer() {
        return layer;
    }

    public void setLayer(int layer) {
        this.layer = layer;
    }

    public boolean isIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseExited(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
