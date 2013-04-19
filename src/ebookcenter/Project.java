/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author think
 */
public class Project {
    private List<Page> pages;
    private int currentPage;
    private int pageWidth;
    private int pageHeight;
    public Project() {
        pages = new ArrayList<Page>();
    }
    public Project(int pNumber,int pageWidth, int pageHeight){
        for(int i = 0;i<pNumber;i++){
            pages.add(new Page(pageWidth, pageHeight));
        }
        currentPage =1;
    }
    public void addPage(Page page){
        pages.add(page);
    }
    public void delPage(int index){
        pages.remove(index);
    }
    public void fileOutput(){
        
    }
    public void fileRead(){
        
    }
}
