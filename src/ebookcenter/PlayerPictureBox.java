/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JLabel;

/**
 *
 * @author John
 */
public class PlayerPictureBox extends JLabel {

    public PlayerPictureBox(PictureBox pictureBox) {
        init(pictureBox);
    }

    public void init(PictureBox pictureBox) {
        setHorizontalAlignment(JLabel.CENTER);
        this.setBounds((int) (pictureBox.getBounds().x * Player.scrZoom * Player.zoom),
                (int) (pictureBox.getBounds().y * Player.scrZoom * Player.zoom),
                (int) (pictureBox.getBounds().width * Player.scrZoom * Player.zoom),
                (int) (pictureBox.getBounds().height * Player.scrZoom * Player.zoom));
        if (pictureBox.getImageIcon() != null) {
            ImageIcon imgIcon = new ImageIcon(pictureBox.getImageIcon().getImage());
            imgIcon.setImage(imgIcon.getImage().getScaledInstance((int) (pictureBox.getImageIcon().getIconWidth() * Player.scrZoom * Player.zoom),
                    (int) (pictureBox.getImageIcon().getIconHeight() * Player.scrZoom * Player.zoom), Image.SCALE_SMOOTH));
            this.setIcon(imgIcon);
        }
    }
}
