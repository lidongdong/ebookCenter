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
public class ImageFilter extends FileFilter{
/*
 * 图片文件过滤器
 */
    @Override
    public boolean accept(File f) {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        if(f.getAbsolutePath().endsWith("PNG")||f.getAbsolutePath().endsWith("png")||f.getAbsolutePath().endsWith("jpg")||f.isDirectory())return true;//文件过滤
        else return false;     
    }

    @Override
    public String getDescription() {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
        return "图像文件";
    }
    
}
