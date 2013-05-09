/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.AWTException;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author think
 */
public class PrePicture extends JLabel implements MouseListener, MouseMotionListener {

    private File file;
    private PrePicture iPicture;
    private PrePictureMover ppm;

    public PrePicture(File file) {
        this.addMouseListener(this);
        this.addMouseMotionListener(this);
        this.file = file;
        ImageIcon image = new ImageIcon(file.getAbsolutePath());
        image.setImage(image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        this.setIcon(image);
        this.setBorder(BorderFactory.createLineBorder(Color.black));

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public void mousePressed(MouseEvent e) {
        ppm = new PrePictureMover(this);
        try {
            Robot robot = new Robot();
            robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
            robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
        } catch (AWTException ex) {
            Logger.getLogger(PrePicture.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //ppm.dispose();
        //getParent().getParent().getParent().requestFocus();
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseDragged(MouseEvent e) {
    }

    @Override
    public void mouseMoved(MouseEvent e) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
}
