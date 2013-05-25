/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author think
 */
public class PrePictureBox extends JLabel {

    private ImageIcon imageIcon;

    public PrePictureBox(PictureBox pictureBox, double scale) {
        setHorizontalAlignment(JLabel.CENTER);
        fresh(pictureBox, scale);
    }

    public void fresh(PictureBox pictureBox, double scale) {
        this.setBounds((int) (pictureBox.getBounds().x * scale),
                (int) (pictureBox.getBounds().y * scale),
                (int) (pictureBox.getBounds().width * scale),
                (int) (pictureBox.getBounds().height * scale));
        if (pictureBox.getIcon() == null) {
            this.setIcon(null);
        } else {
            this.imageIcon = new ImageIcon(pictureBox.getImageIcon().getImage());
            int width = imageIcon.getIconWidth();
            int height = imageIcon.getIconHeight();
            int i = this.getBounds().width * height / width;
            int j = this.getBounds().height * width / height;
            if (i >= this.getBounds().height) {
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(j, this.getBounds().height, Image.SCALE_SMOOTH));
            } else {
                imageIcon.setImage(imageIcon.getImage().getScaledInstance(this.getBounds().width, i, Image.SCALE_SMOOTH));
            }
            this.setIcon(imageIcon);
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g); //To change body of generated methods, choose Tools | Templates.
    }

    public ImageIcon getImageIcon() {
        return imageIcon;
    }

    public void setImageIcon(ImageIcon imageIcon) {
        this.imageIcon = imageIcon;
    }
}
