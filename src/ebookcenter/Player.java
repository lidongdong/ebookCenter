/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenuItem;
import javax.swing.JPopupMenu;

/**
 *
 * @author John
 */
public class Player extends JFrame implements MouseListener {

    private JPopupMenu jPopupMenu;
    public static double zoom;
    public static double scrZoom;

    public Player(Project project) {
        zoom = 1.00;
        Dimension scrSize = Toolkit.getDefaultToolkit().getScreenSize();
        this.setUndecorated(true);
        this.getContentPane().setBackground(Color.white);
        this.setVisible(true);
        init(project, scrSize);
        jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem("结束播放");
        jPopupMenu.add(jMenuItem);
        jMenuItem.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                jMenuItemActionPerformed(e);
            }
        });
        this.addMouseListener(this);
    }

    private void jMenuItemActionPerformed(ActionEvent e) {
        if ("结束播放".equals(e.getActionCommand())) {
            this.dispose();
        }
    }

    public void selectBounds(Project project, Dimension scrSize) {
        int width = project.getPageWidth();
        int height = project.getPageHeight();
        int i = scrSize.width * height / width;
        int j = scrSize.height * width / height;
        if (i >= scrSize.height) {
            this.setBounds((int) ((scrSize.width - zoom * j) / 2), (int) ((scrSize.height - zoom * scrSize.height) / 2), (int) (zoom * j), (int) (zoom * scrSize.height));
            scrZoom = (double) scrSize.height / (double) height;
        } else {
            this.setBounds((int) ((scrSize.width - zoom * scrSize.width) / 2), (int) (((scrSize.height - zoom * i) / 2)), (int) (zoom * scrSize.width), (int) (zoom * i));
            scrZoom = (double) scrSize.width / (double) width;
        }
    }

    public void init(Project project, Dimension scrSize) {
        this.selectBounds(project, scrSize);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mousePressed(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON3) {
            jPopupMenu.show(this, e.getX(), e.getY());
        }
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
