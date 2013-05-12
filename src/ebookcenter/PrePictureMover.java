/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Cursor;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;

/**
 *
 * @author think
 */
public class PrePictureMover extends JFrame implements MouseListener, MouseMotionListener {

    private Image image;
    private int orgx, orgy;
    private PrePicture prePicture;

    public PrePictureMover(PrePicture prePicture) {
        this.prePicture = prePicture;
        try {
            image = ImageIO.read(prePicture.getFile().getAbsoluteFile()).getScaledInstance(80, 80, Image.SCALE_SMOOTH);
        } catch (IOException ex) {
            Logger.getLogger(PrePictureMover.class.getName()).log(Level.SEVERE, null, ex);
        }
        this.setUndecorated(true);
        this.setVisible(true);
        this.setAlwaysOnTop(true);

        setCursor(new Cursor(Cursor.MOVE_CURSOR));
        this.setSize(80, 80);
        Point point;
        point = new Point(prePicture.getBounds().x, prePicture.getBounds().y);
        SwingUtilities.convertPointToScreen(point, prePicture.getParent());
        this.setLocation(point.x, point.y);

        this.addMouseListener(this);
        this.addMouseMotionListener(this);
    }

    @Override
    public void paint(Graphics g) {
        //super.paint(g); //To change body of generated methods, choose Tools | Templates.
        g.drawImage(image, 0, 0, this);
    }

    @Override
    public void mouseDragged(MouseEvent e) {
        int x = e.getX();
        int y = e.getY();
        int nextX = getLocation().x;
        int nextY = getLocation().y;
        nextX = nextX + (x - orgx);
        nextY = nextY + (y - orgy);
        this.setLocation(nextX, nextY);
    }

    @Override
    public void mouseMoved(MouseEvent e) {
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        orgx = e.getX();
        orgy = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {
        //图片框填充图片
        Point point;
        point = e.getPoint();
        makeWindow mkWindow = (makeWindow) (prePicture.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent());
       
       if (mkWindow.getCurrentProject() != null) {//项目存在
            if (mkWindow.getCurrentProject().getCurrentPage() >= 0) {
                //项目中存在当前正在操作的页面
                //获取图片框列表
                PictureBoxList pbl;
                pbl = mkWindow.getCurrentProject().getPage(mkWindow.getCurrentProject().getCurrentPage()).getPictureBoxes();
                SwingUtilities.convertPointToScreen(point, this);
                if(pbl.findBox(point)!=null){
                pbl.findBox(point).setFile(prePicture.getFile());
                pbl.findBox(point).setIsUsed(true);
                pbl.findBox(point).draw();
                }

            }
        }
        this.dispose();
        mkWindow.requestFocus();
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setCursor(new Cursor(Cursor.MOVE_CURSOR));
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setCursor(new Cursor(Cursor.DEFAULT_CURSOR));
    }
}
