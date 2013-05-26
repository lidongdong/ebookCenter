/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.io.File;
import javax.swing.filechooser.FileFilter;

/**
 *
 * @author think
 */
public class EbookFilter extends FileFilter {

    @Override
    public boolean accept(File f) {
        String name = f.getName();
        return name.toLowerCase().endsWith(".ebf");
    }

    @Override
    public String getDescription() {
        return "电子书文件(*.ebf)";
    }
}
