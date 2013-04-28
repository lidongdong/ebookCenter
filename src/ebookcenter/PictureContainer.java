/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

/**
 *
 * @author think
 */
public class PictureContainer extends JPanel {

    private PictureList pictureList;
    private Image image;
    private int myWidth;

    public PictureList getPictureList() {
        return pictureList;
    }

    public void setPictureList(PictureList pictureList) {
        this.pictureList = pictureList;
    }

    public PictureContainer(JPanel jPanel) {
        pictureList = new PictureList();
        myWidth = jPanel.getWidth();
        this.setPreferredSize(new Dimension(jPanel.getWidth(), this.getPictureList().getLength() * 120 + 30));
        this.setLocation(0, 0);
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
        for (int i = 0; i < pictureList.getLength(); i++) {
            try {
                image = ImageIO.read(pictureList.getFile(i).getAbsoluteFile());

            } catch (IOException ex) {
                Logger.getLogger(PictureContainer.class.getName()).log(Level.SEVERE, null, ex);
            }
            
            g.drawImage(image, 20, 20 + 110 * i, 80, 80, this);
        }
    }

    public void addPicture(File file[]) {
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                pictureList.add(file[i]);
            } else {
                File f = new File(file[i].getAbsolutePath());
                File temp[] = f.listFiles();
                for (int h = 0; h < temp.length; h++) {
                    if (temp[h].getAbsolutePath().endsWith("PNG") || temp[h].getAbsolutePath().endsWith("png") || temp[h].getAbsolutePath().endsWith("jpg")) {
                        pictureList.add(temp[h]);
                    }
                }
            }
        }
this.setPreferredSize(new Dimension(myWidth, this.getPictureList().getLength() * 120 + 30));
    }
}
