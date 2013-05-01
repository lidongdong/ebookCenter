/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Image;
import java.awt.Point;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * 本类为图片框类
 *
 * @author Administrator
 */
public class PictureBox extends JLabel implements MouseListener, MouseMotionListener {

    private Rectangle rect;
    private File pictureFile;
    private int layer;
    private boolean isUsed;
    private Image image;
    private int orgx, orgy, endx, endy;
    private boolean isTopLeft;
    private boolean isTop;
    private boolean isTopRight;
    private boolean isRight;
    private boolean isBottomRight;
    private boolean isBottom;
    private boolean isBottomLeft;
    private boolean isLeft;
    private boolean move;
    private final static int RESIZE_WIDTH = 5;
    private final static int MIN_WIDTH = 20;
    private final static int MIN_HEIGHT = 20;

    public PictureBox() {
        layer = 2;
        isUsed = false;
    }

    public PictureBox(Rectangle rect) {
        this.rect = rect;
        this.setBounds(rect);
        layer = 2;
        isUsed = false;

        this.addMouseListener(this);

        this.addMouseMotionListener(this);
    }

    public Boolean canMoved(int insertStatus) {

        if (insertStatus == Constant.NONE) {
            return true;
        } else {
            return false;
        }

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        orgx = e.getPoint().x;
        orgy = e.getPoint().y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mouseEntered(MouseEvent e) {
       // setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
       // setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

   

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
       /* int x = e.getX() - rect.x;
        int y = e.getY() - rect.y;
        int width = rect.width;
        int height = rect.height;
        int cursorType = Cursor.DEFAULT_CURSOR;
        isTopLeft = isTop = isTopRight = isRight = isBottomRight = isBottom = isBottomLeft = isLeft = false;
        if (x > 0 && y > 0 && x < width && y < height) {
            if (y <= RESIZE_WIDTH) {
                if (x <= RESIZE_WIDTH) {
                    isTopLeft = true;
                    cursorType = Cursor.NW_RESIZE_CURSOR;
                } else if (x >= width - RESIZE_WIDTH) {
                    isTopRight = true;
                    cursorType = Cursor.NE_RESIZE_CURSOR;
                } else {
                    isTop = true;
                    cursorType = Cursor.N_RESIZE_CURSOR;
                }
            } else if (y >= height - RESIZE_WIDTH) {
                if (x <= RESIZE_WIDTH) {
                    isBottomLeft = true;
                    cursorType = Cursor.SW_RESIZE_CURSOR;
                } else if (x >= width - RESIZE_WIDTH) {
                    isBottomRight = true;
                    cursorType = Cursor.SE_RESIZE_CURSOR;
                } else {
                    isBottom = true;
                    cursorType = Cursor.S_RESIZE_CURSOR;
                }
            } else if (x <= RESIZE_WIDTH) {
                isLeft = true;
                cursorType = Cursor.W_RESIZE_CURSOR;
            } else if (x >= width - RESIZE_WIDTH) {
                isRight = true;
                cursorType = Cursor.E_RESIZE_CURSOR;
            }//else if(x > RESIZE_WIDTH && x<width - RESIZE_WIDTH && y > RESIZE_WIDTH && y < width - RESIZE_WIDTH){
              //  move = true;
             //   cursorType = Cursor.MOVE_CURSOR;
          //  }
        }
        setCursor(new Cursor(cursorType));*/
    }
    
     @Override
    public void mouseDragged(MouseEvent e) {
       /* int x = e.getX() - rect.x;
        int y = e.getY() - rect.y;
        int width = rect.width;
        int height = rect.height;
        
        int nextX = rect.x;
        int nextY = rect.y;
        int nextWidth = width;
        int nextHeight = height;
        //endx = e.getPoint().x;
       // endy = e.getPoint().y;
       // if(move){
       // move(orgx, orgy, endx, endy);
       // }
        if(isTopLeft || isLeft || isBottomLeft) {
            nextX += x;
            nextWidth -= x;
        }
        if (isTopLeft || isTop || isTopRight) {
            nextY += y;
            nextHeight -= y;
        }
        if (isTopRight || isRight || isBottomRight) {
            nextWidth = x;
        }
        if (isBottomLeft || isBottom || isBottomRight) {
            nextHeight = y;
        }
        if (nextWidth <= MIN_WIDTH) {
            nextWidth = MIN_WIDTH;
            if (isTopLeft || isLeft || isBottomLeft) {
                nextX = rect.x + width - nextWidth;
            }
        }
        if (nextHeight <= MIN_HEIGHT) {
            nextHeight = MIN_HEIGHT;
            if (isTopLeft || isTop || isTopRight) {
                nextY = rect.y + height - nextHeight;
            }
        }
        rect.setRect(nextX, nextY, nextWidth, nextHeight);
        this.setBounds(nextX, nextY, nextWidth, nextHeight);
        */
    }

    public void move(int orgx, int orgy, int endx, int endy) {
        if (rect.x + endx - orgx >= 0 && rect.y + endy - orgx >= 0) {
            this.setRect(rect.x + endx - orgx, rect.y + endy - orgx, rect.width, rect.height);
            this.setBounds(rect);
        }
        updateUI();
        //this.setLocation(rect.x+endx-orgx, rect.y+endy-orgx);
    }

    public void drawSelf(Page page) {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        page.add(this);
    }

    public void setRect(int x, int y, int width, int height) {
        this.rect.x = x;
        this.rect.y = y;
        this.rect.width = width;
        this.rect.height = height;
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
}
