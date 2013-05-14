/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;

/**
 *
 * @author think
 */
public class BackgroundContainer extends JPanel implements MouseListener {

    private List<Background> backgroundList;
    private JPopupMenu jPopupMenu;

    public BackgroundContainer() {
        backgroundList = new ArrayList<Background>();
        addBackground(new Background());
        addBackground(new Background(new File("./src\\ebookcenter\\background\\background_1.jpg")));
        addBackground(new Background(new File("./src\\ebookcenter\\background\\background_2.jpg")));
        addBackground(new Background(new File("./src\\ebookcenter\\background\\background_3.jpg")));
        this.setPreferredSize(new Dimension(backgroundList.size() * 120 ,
                104));//jPanel6的高度
        this.setLayout(null);
        this.setLocation(0, 0);

        jPopupMenu = new JPopupMenu();
        JMenuItem jMenuItem = new JMenuItem("添加背景...");
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
        if ("添加背景...".equals(e.getActionCommand())) {
            JFileChooser jFileChooser = new JFileChooser();
            jFileChooser.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
            jFileChooser.setMultiSelectionEnabled(true);
            jFileChooser.setAcceptAllFileFilterUsed(false);
            jFileChooser.setDialogTitle("选择背景文件");
            ImageFilter imageFilter = new ImageFilter();
            jFileChooser.addChoosableFileFilter(imageFilter);
            int returnVal = jFileChooser.showDialog(null, null);
            File file[] = jFileChooser.getSelectedFiles();
           
            addPicture(file);
             
            
            this.removeAll();
            for(int i = 0;i<this.backgroundList.size();i++){
                this.backgroundList.get(i).setBounds(20 + 100 * i, 10, 80, 80);
                this.add(this.backgroundList.get(i));
            }
            updateUI();
        }
    }

    public void addBackground(Background bg) {
        backgroundList.add(bg);
        bg.setBounds(20 + 100 * (backgroundList.size() - 1), 10, 80, 80);
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
