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
import java.awt.Toolkit;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class Page extends JPanel implements MouseListener, MouseMotionListener {

    private File backgroundFile;
    private ImageIcon backIcon;
    private double zoom;//缩放比例
    private PictureBoxList pictureBoxes;
    private TextBoxList textBoxList;
    private int orgx, orgy, endx, endy;
    private int insertStatus;
    private PictureBox pb;
    private boolean isTopLeft;//改变大小所需标志
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
    private JLabel backgroundLabel;
    private UndoQueue undoQueue;

    public Page(int width, int height) {//毫米转换为像素
        this.setSize((int) (width * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4),
                (int) (height * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4));
        this.setBackground(Color.white);
        pictureBoxes = new PictureBoxList();
        pictureBoxes.setParentPage(this);
        textBoxList = new TextBoxList();
        backIcon = new ImageIcon();
        undoQueue = new UndoQueue();//操作队列
        
        backgroundLabel = new JLabel();//背景标签
        this.backgroundLabel.setBounds(0, 0, (int) (width * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4),
                (int) (height * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4));
        this.backgroundLabel.setOpaque(false);
        this.backgroundLabel.setFocusable(false);
        this.add(this.backgroundLabel);


        pb = new PictureBox();//过程框
        pb.setBorder(BorderFactory.createLineBorder(Color.black));
        pb.setOpaque(false);
        this.add(pb);
        this.setComponentZOrder(pb, 0);
        pb.setVisible(false);

        this.setLayout(null);
        insertStatus = Constant.NONE;
        //鼠标监听
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        Graphics g = getGraphics();
        if (getTextBox(e.getX(), e.getY()) == null && getPictureBox(e.getX(), e.getY()) == null) {
            endx = e.getX();
            endy = e.getY();
            if (insertStatus == Constant.ADD_PICTURE || insertStatus == Constant.ADD_TEXT || insertStatus == Constant.ADD_COMPLICATED) {
                if (endx == orgx || endy == orgy) {
                } else {
                    if (endx < orgx) {
                        if (endy < orgy) {
                            pb.setBounds(endx, endy, orgx - endx, orgy - endy);
                            updateUI();
                        } else {
                            pb.setBounds(endx, orgy, orgx - endx, endy - orgy);
                            updateUI();
                        }
                    } else {
                        if (endy < orgy) {
                            pb.setBounds(orgx, endy, endx - orgx, orgy - endy);
                            updateUI();
                        } else {
                            pb.setBounds(orgx, orgy, endx - orgx, endy - orgy);
                            updateUI();
                        }
                    }
                    pb.setVisible(true);
                }
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
        orgx = e.getX();
        orgy = e.getY();
        updateUI();
        if (e.getButton() == MouseEvent.BUTTON3) {
            insertStatus = Constant.NONE;
            setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        }
    }

    public void setBackgroundSize(){
        this.backgroundLabel.setSize(this.getSize());
    }
    
    @Override
    public void mouseReleased(MouseEvent e) {
        endx = e.getX();
        endy = e.getY();
        pb.setVisible(false);
        //添加图片框
        if (e.getButton() == MouseEvent.BUTTON1) {
            /*
             * 添加图片框
             */
            if (insertStatus == Constant.ADD_PICTURE) {
                if (endx == orgx || endy == orgy) {
                } else {
                    if (endx < orgx) {
                        if (endy < orgy) {
                            PictureBox pictureBox = new PictureBox(new Rectangle(endx, endy, orgx - endx, orgy - endy));
                            pb.setBounds(pictureBox.getBounds());
                            pictureBoxes.add(pictureBox);
                            //pictureBoxes.impact(pictureBoxes.getBoxList());
                            this.add(pictureBox);
                            this.setComponentZOrder(pictureBox, 0);
                            this.getMakeWindow().getPageContainer().fresh();
                        } else {
                            PictureBox pictureBox = new PictureBox(new Rectangle(endx, orgy, orgx - endx, endy - orgy));
                            pb.setBounds(pictureBox.getBounds());
                            pictureBoxes.add(pictureBox);
                            //pictureBoxes.impact(pictureBoxes.getBoxList());
                            this.add(pictureBox);
                            this.setComponentZOrder(pictureBox, 0);
                            this.getMakeWindow().getPageContainer().fresh();
                        }
                    } else {
                        if (endy < orgy) {
                            PictureBox pictureBox = new PictureBox(new Rectangle(orgx, endy, endx - orgx, orgy - endy));
                            pb.setBounds(pictureBox.getBounds());
                            pictureBoxes.add(pictureBox);
                            //pictureBoxes.impact(pictureBoxes.getBoxList());
                            this.add(pictureBox);
                            this.setComponentZOrder(pictureBox, 0);
                            this.getMakeWindow().getPageContainer().fresh();
                        } else {
                            PictureBox pictureBox = new PictureBox(new Rectangle(orgx, orgy, endx - orgx, endy - orgy));
                            pb.setBounds(pictureBox.getBounds());
                            pictureBoxes.add(pictureBox);
                            //pictureBoxes.impact(pictureBoxes.getBoxList());
                            this.add(pictureBox);
                            this.setComponentZOrder(pictureBox, 0);
                            this.getMakeWindow().getPageContainer().fresh();
                        }
                    }
                }
            } else if (insertStatus == Constant.ADD_TEXT) {
                if (endx == orgx || endy == orgy) {
                } else {
                    if (endx < orgx) {
                        if (endy < orgy) {
                            TextBox textBox = new TextBox(new Rectangle(endx, endy, orgx - endx, orgy - endy));
                            pb.setBounds(textBox.getBounds());
                            textBoxList.add(textBox);
                            textBox.addToPage(this);
                            this.setComponentZOrder(textBox, 0);
                        } else {
                            TextBox textBox = new TextBox(new Rectangle(endx, orgy, orgx - endx, endy - orgy));
                            pb.setBounds(textBox.getBounds());
                            textBoxList.add(textBox);
                            textBox.addToPage(this);
                            this.setComponentZOrder(textBox, 0);
                        }
                    } else {
                        if (endy < orgy) {
                            TextBox textBox = new TextBox(new Rectangle(orgx, endy, endx - orgx, orgy - endy));
                            pb.setBounds(textBox.getBounds());
                            textBoxList.add(textBox);
                            textBox.addToPage(this);
                            this.setComponentZOrder(textBox, 0);
                        } else {
                            TextBox textBox = new TextBox(new Rectangle(orgx, orgy, endx - orgx, endy - orgy));
                            pb.setBounds(textBox.getBounds());
                            textBoxList.add(textBox);
                            textBox.addToPage(this);
                            this.setComponentZOrder(textBox, 0);
                        }
                    }
                }
            }
        }
        insertStatus = Constant.NONE;
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
        updateUI();
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (getTextBox(e.getX(), e.getY()) == null && getPictureBox(e.getX(), e.getY()) == null) {
            for (int i = 0; i < textBoxList.size(); i++) {
                textBoxList.get(i).setEditable(false);
                textBoxList.get(i).setIsEditing(false);
                textBoxList.get(i).getCaret().setVisible(false);
                textBoxList.get(i).setIsSelected(false);
                if (!"".equals(textBoxList.get(i).getText())) {
                    textBoxList.get(i).setBorder(null);
                }
            }
            for (int j = 0; j < pictureBoxes.size(); j++) {
                if (pictureBoxes.get(j).getIsUsed()) {
                    pictureBoxes.get(j).setBorder(null);
                }
                pictureBoxes.get(j).setIsSelected(false);
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    public static void newImpact(){
        
    }
    
    public makeWindow getMakeWindow(){
        return (makeWindow)this.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
    }
    
    public PictureBox getPictureBox(int x, int y) {
        int topx, topy, width, height;
        int flag = 0;
        for (int i = 0; i < pictureBoxes.size(); i++) {
            topx = pictureBoxes.get(i).getBounds().x;
            topy = pictureBoxes.get(i).getBounds().y;
            width = pictureBoxes.get(i).getBounds().width;
            height = pictureBoxes.get(i).getBounds().height;
            if ((topx < x) && (x < topx + width) && (topy < y) && (y < topy + height)) {
                flag = i;
            }
        }
        if (flag == 0) {
            return null;
        } else {
            return pictureBoxes.get(flag);
        }
    }

    public TextBox getTextBox(int x, int y) {//判断该点在哪个框体内
        int topx, topy, width, height;
        for (int i = 0; i < textBoxList.size(); i++) {

            topx = textBoxList.get(i).getBounds().x;
            topy = textBoxList.get(i).getBounds().y;
            width = textBoxList.get(i).getBounds().width;
            height = textBoxList.get(i).getBounds().height;
            if ((topx < x) && (x < topx + width) && (topy < y) && (y < topy + height)) {
                return textBoxList.get(i);
            }
        }
        return null;
    }

    public void setBackground() {//自定义设置背景
        if (this.backgroundFile != null) {
            ImageIcon imgIcon = new ImageIcon(this.backgroundFile.getAbsolutePath());
            imgIcon.setImage(imgIcon.getImage().getScaledInstance(this.getBounds().width, this.getBounds().height, Image.SCALE_SMOOTH));
            this.backgroundLabel.setIcon(imgIcon);
            this.backIcon = imgIcon;
        } else {
            this.backgroundLabel.setIcon(null);
            this.backIcon = null;
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        selectBounds((PageArea) this.getParent());
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates
    }

    public void selectBounds(PageArea pageArea) {
        if (this.getWidth() >= pageArea.getWidth()) {
            this.setBounds(20, 20, this.getWidth(), this.getHeight());
        } else {
            this.setBounds((int) ((pageArea.getWidth() - this.getWidth()) / 2), 20, this.getWidth(), this.getHeight());
        }
    }

    public PictureBoxList getPictureBoxes() {
        return pictureBoxes;
    }

    public void setPictureBoxes(PictureBoxList pictureBoxes) {
        this.pictureBoxes = pictureBoxes;
    }

    public double getZoom() {
        return zoom;
    }

    public void setZoom(double zoom) {
        this.zoom = zoom;
    }

    /**
     * Get the value of insertStatus
     *
     * @return the value of insertStatus
     */
    public int getInsertStatus() {
        return insertStatus;
    }

    /**
     * Set the value of insertStatus
     *
     * @param insertStatus new value of insertStatus
     */
    public void setInsertStatus(int insertStatus) {
        this.insertStatus = insertStatus;
    }

    public TextBoxList getTextBoxList() {
        return textBoxList;
    }

    public void setTextBoxList(TextBoxList textBoxList) {
        this.textBoxList = textBoxList;
    }

    public File getBackgroundFile() {
        return backgroundFile;
    }

    public void setBackgroundFile(File backgroundFile) {
        this.backgroundFile = backgroundFile;
    }

    public UndoQueue getUndoQueue() {
        return undoQueue;
    }

    public void setUndoQueue(UndoQueue undoQueue) {
        this.undoQueue = undoQueue;
    }

    public ImageIcon getBackIcon() {
        return backIcon;
    }

    public void setBackIcon(ImageIcon backIcon) {
        this.backIcon = backIcon;
    }

    public JLabel getBackgroundLabel() {
        return backgroundLabel;
    }

    public void setBackgroundLabel(JLabel backgroundLabel) {
        this.backgroundLabel = backgroundLabel;
    }
    
    
}
