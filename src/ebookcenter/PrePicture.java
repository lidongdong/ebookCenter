/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author think
 */
public class PrePicture extends JLabel {
    private File file;
    private PrePicture iPicture;
    
    public PrePicture(File file) {
         this.file = file;
        ImageIcon image  = new ImageIcon(file.getAbsolutePath());
        image.setImage(image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        this.setIcon(image);
        this.addMouseListener(new MouseListener(){

            @Override
            public void mouseClicked(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }

            @Override
            public void mousePressed(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            value(iPicture);
            }

            @Override
            public void mouseReleased(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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
            
        });
        this.addMouseMotionListener(new MouseMotionListener(){

            @Override
            public void mouseDragged(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            
            }

            @Override
            public void mouseMoved(MouseEvent e) {
                //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
            }
        });
    }
    
   
    public void value(PrePicture prePicture){
        prePicture.file = this.file;
        ImageIcon image  = new ImageIcon(prePicture.file.getAbsolutePath());
        image.setImage(image.getImage().getScaledInstance(80, 80, Image.SCALE_SMOOTH));
        prePicture.setIcon(image);
        prePicture.setBounds(0,0,80,80);
        
        
    }
    
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        
    }
    
   
    public File getFile() {
        return file;
    }

    public void setFile(File file) {
        this.file = file;
    }
    
}
