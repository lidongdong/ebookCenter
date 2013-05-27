/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

/**
 *
 * @author John
 */
import java.io.File;
import java.io.FileFilter;

public class ExtensionFileFilter implements FileFilter {

    private String extension;

    public ExtensionFileFilter(String extension) {
        this.extension = extension;
    }

    public boolean accept(File file) {
        if (file.isDirectory()) {
            return false;
        }

        String name = file.getName();
// find the last
        int index = name.lastIndexOf(".");
        if (index == -1) {
            return false;
        } else if (index == name.length() - 1) {
            return false;
        } else {
            return this.extension.equals(name.substring(index + 1));
        }
    }
}
