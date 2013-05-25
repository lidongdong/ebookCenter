/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author think
 */
public class Background extends JLabel implements MouseListener {

    private File backgroundFile;

    public Background(File backgroundFile) {
        this.setOpaque(true);
        this.backgroundFile = backgroundFile;
        ImageIcon image = new ImageIcon(backgroundFile.getAbsolutePath());
        image.setImage(image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        this.setIcon(image);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(this);
    }

    public Background() {
        this.backgroundFile = null;
        this.setPreferredSize(new Dimension(80, 80));
        this.setSize(80, 80);
        this.setBackground(Color.WHITE);
        this.setOpaque(true);
        this.setBorder(BorderFactory.createLineBorder(Color.black));
        this.addMouseListener(this);
    }

    public File getBackgroundFile() {
        return backgroundFile;
    }

    public void setBackgroundFile(File backgroundFile) {
        this.backgroundFile = backgroundFile;
    }

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (e.getClickCount() == 2) {
                //替换背景
                if (getMakeWindow().getCurrentProject() != null && getMakeWindow().getCurrentProject().getPages().size() > 0) {
                    getMakeWindow().getCurrentProject().getPage(getMakeWindow().getCurrentProject().getCurrentPage()).setBackgroundFile(this.backgroundFile);
                    getMakeWindow().getCurrentProject().getPage(getMakeWindow().getCurrentProject().getCurrentPage()).setBackground();
                    getMakeWindow().getPageContainer().fresh();
                    //getMakeWindow().getCurrentProject().getPage(getMakeWindow().getCurrentProject().getCurrentPage()).updateUI();
                }
            }
        }
    }

    public makeWindow getMakeWindow() {
        return (makeWindow) this.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
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
}
