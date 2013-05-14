/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.Rectangle;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.util.regex.Pattern;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
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
    private boolean isSelected;
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
        setOpaque(false);
        this.setEditable(false);
        this.isEditing = false;
        this.isSelected = true;
        requestFocus();

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (isSelected == true) {
                        delTextBox();
                    }
                }
            }
        });
    }


    
    
    public void addToPage(Page page) {
        setBorder(BorderFactory.createLineBorder(Color.black));
        page.add(this);
    }

    public void delTextBox() {
        Page page = (Page) this.getParent();
        page.getTextBoxList().remove(this);
        page.remove(this);
        page.updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getClickCount() == 1) {
            setBorder(BorderFactory.createLineBorder(Color.black));
            this.isSelected = true;
            requestFocus();
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
            ((Page)this.getParent()).getUndoQueue().push(
                new Rectangle(nextX, nextY, nextWidth, nextHeight), Constant.TYPE_TEXT_BOX, 
                ((Page)this.getParent()).getTextBoxList().indexOf(this));
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
        setParagraphAttributes(editor, attr, false);
    }

    public static void setRightIndent(JEditorPane editor, float indent) {
        //右空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setRightIndent(attr, indent);
        setParagraphAttributes(editor, attr, false);
    }

    public static void setSpaceAbove(JEditorPane editor, float indent) {
        //上空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setSpaceAbove(attr, indent);
        setParagraphAttributes(editor, attr, false);
    }

    public static void setSpaceBelow(JEditorPane editor, float indent) {
        //下空白
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setSpaceBelow(attr, indent);
        setParagraphAttributes(editor, attr, false);
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
        setParagraphAttributes(editor, attr, false);
    }

    public static void setRightAlignment(JEditorPane editor) {
        //右对齐
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setAlignment(attr, 2);
        setParagraphAttributes(editor, attr, false);
    }

    public static void setLineSpacing(JEditorPane editor, float space) {
        //行间距
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setLineSpacing(attr, space);
        setParagraphAttributes(editor, attr, false);
    }

    public static void setFontColor(JEditorPane editor, Color fg) {
        //字体颜色
        MutableAttributeSet attr = new SimpleAttributeSet();
        StyleConstants.setForeground(attr, fg);
        setCharacterAttributes(editor, attr, false);
    }

    public static void setFontSize(JEditorPane editor, int size) {
        //字体大小
        if (editor != null) {
            if ((size > 0) && (size < 512)) {
                MutableAttributeSet attr = new SimpleAttributeSet();
                StyleConstants.setFontSize(attr, size);
                setCharacterAttributes(editor, attr, false);
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

    /* 
     * 判断是否为整数  
     * @param str 传入的字符串  
     * @return 是整数返回true,否则返回false  
     */
    public static boolean isInteger(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[\\d]*$");
        return pattern.matcher(str).matches();
    }

    /*  
     * 判断是否为浮点数，包括double和float  
     * @param str 传入的字符串  
     * @return 是浮点数返回true,否则返回false  
     */
    public static boolean isDouble(String str) {
        Pattern pattern = Pattern.compile("^[-\\+]?[.\\d]*$");
        return pattern.matcher(str).matches();
    }

    public boolean isIsEditing() {
        return isEditing;
    }

    public void setIsEditing(boolean isEditing) {
        this.isEditing = isEditing;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
