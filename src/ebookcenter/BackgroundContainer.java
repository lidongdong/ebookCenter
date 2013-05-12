/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class BackgroundContainer extends JPanel {

    private List<Background> backgroundList;

    public BackgroundContainer() {
        backgroundList = new ArrayList<Background>();
        addBackground(new Background());
        addBackground(new Background(new File("./src\\ebookcenter\\background\\background_1.jpg")));
        addBackground(new Background(new File("./src\\ebookcenter\\background\\background_2.jpg")));
        addBackground(new Background(new File("./src\\ebookcenter\\background\\background_3.jpg")));
        this.setPreferredSize(new Dimension(backgroundList.size() * 120 + 30,
                104));//jPanel6的高度
        this.setLayout(null);
        this.setLocation(0, 0);
        //showPicture();

    }


    public void addBackground(Background bg) {
        backgroundList.add(bg);
        bg.setBounds(20+100*(backgroundList.size()-1), 10, 80, 80);
        add(bg);
    }

    public void addPicture(File file[]) {
        for (int i = 0; i < file.length; i++) {
            if (file[i].isFile()) {
                backgroundList.add(new Background(file[i]));
            } else {
                File f = new File(file[i].getAbsolutePath());
                File temp[] = f.listFiles();
                for (int h = 0; h < temp.length; h++) {
                    if (temp[h].getAbsolutePath().endsWith("PNG") || temp[h].getAbsolutePath().endsWith("png") || temp[h].getAbsolutePath().endsWith("jpg")) {
                        backgroundList.add(new Background(temp[h]));
                    }
                }
            }
        }
        this.setPreferredSize(new Dimension(backgroundList.size() * 120 + 30, 104));
    }

    public void get(int index) {
        backgroundList.get(index);
    }

    public int backgroundSize() {
        return backgroundList.size();
    }

    public List<Background> getBackgroundList() {
        return backgroundList;
    }

    public void setBackgroundList(List<Background> backgroundList) {
        this.backgroundList = backgroundList;
    }
}
