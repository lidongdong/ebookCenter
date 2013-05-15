/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 * 本类为图片框类
 *
 * @author Administrator
 */
public class PictureBox extends JLabel implements MouseListener, MouseMotionListener {

    //private Rectangle rect;
    private File pictureFile;
    private int layer;
    private boolean isUsed;
    private boolean isSelected;
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
        //用于初始化绘图过程框
        layer = 2;
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setHorizontalAlignment(JLabel.CENTER);
        isUsed = false;
        isSelected = false;
    }

    public PictureBox(Rectangle rect) {
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        setHorizontalAlignment(JLabel.CENTER);
        this.setBounds(rect);
        layer = 2;
        isUsed = false;
        isSelected = true;
        this.requestFocus();
        this.addMouseListener(this);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (isSelected == true) {
                        delPictureBox();
  
                    }
                }
            }
        });
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
        if (e.getClickCount() == 1) {
            setBorder(BorderFactory.createLineBorder(Color.black));
            isSelected = true;
            this.requestFocus();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        orgx = e.getPoint().x;
        orgy = e.getPoint().y;
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        if (pictureFile != null) {
            draw();
        }
         ((Page)this.getParent()).getUndoQueue().push( 
                this.getBounds(), Constant.TYPE_PICTURE_BOX, 
                ((Page)this.getParent()).getPictureBoxes().indexOf(this));
         //System.out.print(this.getBounds()+"\n");
         //System.out.print(((Page)this.getParent()).getUndoQueue().get(((Page)this.getParent()).getUndoQueue().getFlag()).getStation()+"\n");
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

        int x = e.getX();
        int y = e.getY();
        int width = getBounds().width;
        int height = getBounds().height;
        int cursorType = Cursor.DEFAULT_CURSOR;
        isTopLeft = isTop = isTopRight = isRight = isBottomRight = isBottom = isBottomLeft = isLeft = move = false;
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
            } else if (x > RESIZE_WIDTH && x < width - RESIZE_WIDTH && y > RESIZE_WIDTH && y < width - RESIZE_WIDTH) {
                move = true;
                cursorType = Cursor.MOVE_CURSOR;
            }
        }
        setCursor(new Cursor(cursorType));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int width = getBounds().width;
        int height = getBounds().height;

        int nextX = getBounds().x;
        int nextY = getBounds().y;
        int nextWidth = width;
        int nextHeight = height;
        if (isTopLeft || isLeft || isBottomLeft) {
            nextX += x;
            nextWidth -= x;
            this.setBounds(nextX, nextY, nextWidth, nextHeight);
            if (pictureFile != null)draw();
        }
        if (isTopLeft || isTop || isTopRight) {
            nextY += y;
            nextHeight -= y;
            this.setBounds(nextX, nextY, nextWidth, nextHeight);
            if (pictureFile != null)draw();
        }
        if (isTopRight || isRight || isBottomRight) {
            nextWidth = x;
            this.setBounds(nextX, nextY, nextWidth, nextHeight);
            if (pictureFile != null)draw();
        }
        if (isBottomLeft || isBottom || isBottomRight) {
            nextHeight = y;
            this.setBounds(nextX, nextY, nextWidth, nextHeight);
           if (pictureFile != null) draw();
        }
        if (nextWidth <= MIN_WIDTH) {
            nextWidth = MIN_WIDTH;
            if (isTopLeft || isLeft || isBottomLeft) {
                nextX = getBounds().x + width - nextWidth;
                this.setBounds(nextX, nextY, nextWidth, nextHeight);
                if (pictureFile != null)draw();
            }
        }
        if (nextHeight <= MIN_HEIGHT) {
            nextHeight = MIN_HEIGHT;
            if (isTopLeft || isTop || isTopRight) {
                nextY = getBounds().y + height - nextHeight;
                this.setBounds(nextX, nextY, nextWidth, nextHeight);
                if (pictureFile != null)draw();
            }
        }
        if (move) {
            nextX = nextX + (x - orgx);
            nextY = nextY + (y - orgy);
            this.setBounds(nextX, nextY, nextWidth, nextHeight);
        }
        //this.setBounds(nextX, nextY, nextWidth, nextHeight);
       
    }

    public void draw() {
        //画图函数
        ImageIcon imgIcon = new ImageIcon(pictureFile.getAbsolutePath());
        int width = imgIcon.getIconWidth();
        int height = imgIcon.getIconHeight();
        int i = this.getBounds().width * height / width;
        int j = this.getBounds().height * width / height;
        if (i >= this.getBounds().height) {
            imgIcon.setImage(imgIcon.getImage().getScaledInstance(j, this.getBounds().height, Image.SCALE_SMOOTH));
        } else {
            imgIcon.setImage(imgIcon.getImage().getScaledInstance(this.getBounds().width, i, Image.SCALE_SMOOTH));
        }
        this.setIcon(imgIcon);
    }

    public void delPictureBox() {
        Page page = (Page) this.getParent();
        page.getPictureBoxes().remove(this);
        page.remove(this);
        page.updateUI();
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        //removeAll();
        // draw(g);
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
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

    public boolean getIsUsed() {
        return isUsed;
    }

    public void setIsUsed(boolean isUsed) {
        this.isUsed = isUsed;
    }
}
