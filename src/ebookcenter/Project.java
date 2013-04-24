/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author think
 */
public class Project {

    private String name;
    private List<Page> pages;
    private int currentPage;
    private int pageWidth;
    private int pageHeight;

    public Project() {
        pages = new ArrayList<Page>();
        currentPage = -1;
    }

    public Project(String name, int pNumber, int pageWidth, int pageHeight) {
        this.name = name;
        pages = new ArrayList<Page>();
        for (int i = 0; i < pNumber; i++) {
            Page temp = new Page(pageWidth, pageHeight);
            //System.out.print(temp.getWidth());
            //System.out.print(temp.getHeight());
            pages.add(temp);
        }
        this.setPageWidth((int)(pageWidth*Toolkit.getDefaultToolkit().getScreenResolution()/25.4));
        this.setPageHeight((int)(pageHeight*Toolkit.getDefaultToolkit().getScreenResolution()/25.4));

        currentPage = 1;
    }

    public void addPage(Page page) {
        pages.add(page);
    }

    public void delPage(int index) {
        pages.remove(index);
    }

    public void fileOutput() {
    }

    public void fileRead() {
    }

    public Page getPage(int index) {
        return this.pages.get(index);
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Page> getPages() {
        return pages;
    }

    public void setPages(List<Page> pages) {
        this.pages = pages;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    public int getPageHeight() {
        return pageHeight;
    }

    public void setPageHeight(int pageHeight) {
        this.pageHeight = pageHeight;
    }
}
