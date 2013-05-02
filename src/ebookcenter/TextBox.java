/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JTextPane;

/**
 *
 * @author think
 */
public class TextBox extends JTextPane implements MouseListener, MouseMotionListener {

    String text;
    private int orgx, orgy, endx, endy;
    private boolean isEditing;
    private boolean isTopLeft;
    private boolean isTop;
    private boolean isTopRight;
    private boolean isRight;
    private boolean isBottomRight;
    private boolean isBottom;
    private boolean isBottomLeft;
    private boolean isLeft;
    private final static int RESIZE_WIDTH = 5;
    private final static int MIN_WIDTH = 20;
    private final static int MIN_HEIGHT = 20;
    private boolean move;

    public TextBox(Rectangle rect) {
        setBounds(rect);
        this.setEditable(false);
        this.isEditing = false;
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    public void setBackground() {
    }

    public void addToPage(Page page) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        page.add(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            setBorder(BorderFactory.createLineBorder(Color.black));
        }
        if (e.getClickCount() == 2) {
            setBorder(BorderFactory.createLineBorder(Color.black));
            setEditable(true);
            isEditing = true;
            grabFocus();
            getCaret().setVisible(true);
            setCursor(new Cursor(Cursor.TEXT_CURSOR));
            //updateUI();
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        orgx = e.getX();
        orgy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
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
        if (isEditing) {
        } else {
            if (isTopLeft || isLeft || isBottomLeft) {
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
                    nextX = getBounds().x + width - nextWidth;
                }
            }
            if (nextHeight <= MIN_HEIGHT) {
                nextHeight = MIN_HEIGHT;
                if (isTopLeft || isTop || isTopRight) {
                    nextY = getBounds().y + height - nextHeight;
                }
            }
            if(move){
                nextX = nextX + (x - orgx);
                nextY = nextY + (y - orgy);
            }
            this.setBounds(nextX, nextY, nextWidth, nextHeight);
        }
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int width = getBounds().width;
        int height = getBounds().height;
        int cursorType = Cursor.DEFAULT_CURSOR;
        isTopLeft = isTop = isTopRight = isRight = isBottomRight = isBottom = isBottomLeft = isLeft = move = false;
        if (isEditing) {
        } else {
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
    }

    public boolean isIsEditing() {
        return isEditing;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }
}
