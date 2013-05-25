/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class PrePage extends JPanel implements MouseListener {

    private PrePictureBoxList list;
    private JLabel backLabel;
    private int index;
    private boolean isSelected;
    private makeWindow mw;

    public PrePage(Page page, int index) {
        this.index = index;
        isSelected = false;

        this.setBackground(Color.WHITE);
        double scale;
        scale = (((double) 80) / ((double) page.getHeight()));
        this.setSize((int) (page.getWidth() * scale), 80);
        this.setBounds(20 + index * (20 + this.getWidth()), 5, this.getWidth(), this.getHeight());
        this.setLayout(null);

        backLabel = new JLabel();
        backLabel.setBounds(0, 0, this.getBounds().width, this.getBounds().height);//缩略图背景设置
        if (page.getBackgroundLabel().getIcon() == null) {
            backLabel.setOpaque(false);
        } else {
            ImageIcon imageIcon = new ImageIcon(page.getBackIcon().getImage());
            imageIcon.setImage(imageIcon.getImage().getScaledInstance(
                    backLabel.getBounds().width,
                    backLabel.getBounds().height,
                    Image.SCALE_DEFAULT));
            backLabel.setOpaque(true);
            backLabel.setIcon(imageIcon);
        }
        this.add(backLabel);

        list = new PrePictureBoxList(page.getPictureBoxes(), scale);
        for (int i = 0; i < list.size(); i++) {
            this.add(list.get(i));
            this.setComponentZOrder(list.get(i), 0);
        }
        this.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == KeyEvent.VK_DELETE) {
                    if (isSelected == true) {
                        //删除页面
                        delPage();
                    }
                }
            }
        });
        this.addMouseListener(this);
    }

    public void delPage() {
        //页面删除算法
        if (index < (mw.getCurrentProject().getPages().size() - 1)) {
            mw.getCurrentProject().delPage(index);
            mw.getPageContainer().fresh();
            mw.getPageArea().refresh();
            mw.getPageArea().updateUI();
        } else {
            if (index != 0) {
                mw.getCurrentProject().delPage(index);
                mw.getCurrentProject().setCurrentPage(mw.getCurrentProject().getPages().size() - 1);
                mw.getPageContainer().fresh();
                mw.getPageArea().refresh();
                mw.getPageArea().updateUI();
            } else {
                mw.getCurrentProject().delPage(index);
                mw.getCurrentProject().setCurrentPage(-1);
                mw.getPageContainer().fresh();
                mw.getPageArea().refresh();
                mw.getPageArea().updateUI();
            }
        }
    }

    public makeWindow getMakeWindow() {
        return (makeWindow) this.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
    }

    public PrePictureBoxList getList() {
        return list;
    }

    public void setList(PrePictureBoxList list) {
        this.list = list;
    }

    public int getIndex() {
        return index;
    }

    public void setIndex(int index) {
        this.index = index;
    }

    public void setBorder() {
        this.setBorder(BorderFactory.createLineBorder(Color.blue));
        backLabel.setBorder(BorderFactory.createLineBorder(Color.blue));
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //页面转换
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (e.getClickCount() == 1) {
                ((PageContainer) this.getParent()).removeBorder();
                isSelected = true;
                this.setBorder();
                getMakeWindow().getCurrentProject().setCurrentPage(this.index);
                getMakeWindow().getCurrentProject().getPage(this.index).selectBounds(getMakeWindow().getPageArea());
                getMakeWindow().getPageArea().removeAll();
                getMakeWindow().getPageArea().add(getMakeWindow().getCurrentProject().getPage(this.index));
                getMakeWindow().getPageArea().updateUI();
                this.requestFocus();
            }
            if (e.getClickCount() == 2) {
            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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

    public makeWindow getMw() {
        return mw;
    }

    public void setMw(makeWindow mw) {
        this.mw = mw;
    }

    public JLabel getBackLabel() {
        return backLabel;
    }

    public void setBackLabel(JLabel backLabel) {
        this.backLabel = backLabel;
    }

    public boolean isIsSelected() {
        return isSelected;
    }

    public void setIsSelected(boolean isSelected) {
        this.isSelected = isSelected;
    }
}
