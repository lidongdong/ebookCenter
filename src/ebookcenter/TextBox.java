/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.BorderFactory;
import javax.swing.JEditorPane;
import javax.swing.JTextPane;
import javax.swing.UIManager;
import javax.swing.text.AttributeSet;
import javax.swing.text.Document;
import javax.swing.text.EditorKit;
import javax.swing.text.MutableAttributeSet;
import javax.swing.text.SimpleAttributeSet;
import javax.swing.text.StyleConstants;
import javax.swing.text.StyledDocument;
import javax.swing.text.StyledEditorKit;

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
        this.setOpaque(false);//透明度100
        this.setLayout(null);
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
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
            getRootWindow().setCurrentJtp(this);
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
            if (move) {
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

    public makeWindow getRootWindow() {
        return ((makeWindow) getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent());
    }

    public static void chooseFont(JEditorPane editor, String family) {
        //改变字体
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setFontFamily(attr, family);
        setCharacterAttributes(editor, attr, false);
    }
    
    public static void setLeftIndent(JEditorPane editor, float indent) {
        //左空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setLeftIndent(attr, indent);
        setCharacterAttributes(editor, attr, false);
    }
    
    public static void setRightIndent(JEditorPane editor, float indent) {
        //右空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setRightIndent(attr, indent);
        setCharacterAttributes(editor, attr, false);
    }
    
    public static void setSpaceAbove(JEditorPane editor, float indent) {
        //上空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setSpaceAbove(attr, indent);
        setCharacterAttributes(editor, attr, false);
    }
    
    public static void setSpaceBelow(JEditorPane editor, float indent) {
        //下空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setSpaceBelow(attr, indent);
        setCharacterAttributes(editor, attr, false);
    }

    public static void setBold(JEditorPane editor) {
        //粗体设置
        StyledEditorKit kit = getStyledEditorKit(editor);
        MutableAttributeSet attr = kit.getInputAttributes();
        boolean bold = (StyleConstants.isBold(attr)) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setBold(sas, bold);
        setCharacterAttributes(editor, sas, false);
    }

    public static void setItalic(JEditorPane editor) {
        //斜体设置
        StyledEditorKit kit = getStyledEditorKit(editor);
        MutableAttributeSet attr = kit.getInputAttributes();
        boolean italic = (StyleConstants.isItalic(attr)) ? false : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setItalic(sas, italic);
        setCharacterAttributes(editor, sas, false);
    }

    public static void setUnderLine(JEditorPane editor) {
        //下划线
        StyledEditorKit kit = getStyledEditorKit(editor);
        MutableAttributeSet attr = kit.getInputAttributes();
        boolean underline = (StyleConstants.isUnderline(attr)) ? false
                : true;
        SimpleAttributeSet sas = new SimpleAttributeSet();
        StyleConstants.setUnderline(sas, underline);
        setCharacterAttributes(editor, sas,
                false);
    }

    public static void setLeftAlignment(JEditorPane editor) {
        //左对齐
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, 0);
        setParagraphAttributes(editor, attr, false);
    }

    public static void setMidAlignment(JEditorPane editor) {
        //中对齐
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, 1);
        setParagraphAttributes(editor, attr,false);
    }

    public static void setRightAlignment(JEditorPane editor) {
        //右对齐
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, 2);
        setParagraphAttributes(editor, attr, false);
    }

    public static void setFontColor(JEditorPane editor, float space) {
        //行间距
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(attr, space);
        setCharacterAttributes(editor, attr, true);
    }
    
    public static void setFontColor(JEditorPane editor, Color fg) {
        //字体颜色
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, fg);
        setCharacterAttributes(editor, attr, true);
    }

    public static void setFontSize(JEditorPane editor, int size) {
        //字体大小
        if (editor != null) {
            if ((size > 0) && (size < 512)) {
                MutableAttributeSet attr = new SimpleAttributeSet();
                StyleConstants.setFontSize(attr, size);
                setCharacterAttributes(editor, attr, true);
            } else {
                UIManager.getLookAndFeel().provideErrorFeedback(editor);
            }
        }
    }

    public static final void setParagraphAttributes(JEditorPane editor,
            AttributeSet attr, boolean replace) {
        int p0 = editor.getSelectionStart();
        int p1 = editor.getSelectionEnd();
        StyledDocument doc = getStyledDocument(editor);
        doc.setParagraphAttributes(p0, p1 - p0, attr, replace);
    }

    public static final void setCharacterAttributes(JEditorPane editor,
            AttributeSet attr, boolean replace) {
        int p0 = editor.getSelectionStart();
        int p1 = editor.getSelectionEnd();
        if (p0 != p1) {
            StyledDocument doc = getStyledDocument(editor);
            doc.setCharacterAttributes(p0, p1 - p0, attr, replace);
        }
        StyledEditorKit k = getStyledEditorKit(editor);
        MutableAttributeSet inputAttributes = k.getInputAttributes();
        if (replace) {
            inputAttributes.removeAttributes(inputAttributes);
        }
        inputAttributes.addAttributes(attr);
    }

    protected static final StyledDocument getStyledDocument(JEditorPane e) {
        Document d = e.getDocument();
        if (d instanceof StyledDocument) {
            return (StyledDocument) d;
        }
        throw new IllegalArgumentException("document must be StyledDocument");
    }

    protected static final StyledEditorKit getStyledEditorKit(JEditorPane e) {
        EditorKit k = e.getEditorKit();
        if (k instanceof StyledEditorKit) {
            return (StyledEditorKit) k;
        }
        throw new IllegalArgumentException("EditorKit must be StyledEditorKit");
    }

    public boolean isIsEditing() {
        return isEditing;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }
}
