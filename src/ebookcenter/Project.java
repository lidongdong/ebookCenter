/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Toolkit;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 *
 * @author think
 */
public class Project implements Serializable {

    private String name;
    private List<Page> pages;
    private transient int currentPage;
    private int pageWidth;
    private int pageHeight;
    private int trueWidth, trueHeight;
    private Date date;

    public Project() {
        pages = new ArrayList<Page>();
        trueWidth = 0;
        trueHeight = 0;
        currentPage = -1;
    }

    public Project(String name, int pNumber, int pageWidth, int pageHeight) {
        this.name = name;
        pages = new ArrayList<Page>();
        for (int i = 0; i < pNumber; i++) {
            Page temp = new Page(pageWidth, pageHeight);
            pages.add(temp);
        }
        this.setPageWidth((int) (pageWidth * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4));
        this.setPageHeight((int) (pageHeight * Toolkit.getDefaultToolkit().getScreenResolution() / 25.4));
        trueWidth = pageWidth;
        trueHeight = pageHeight;
        currentPage = 0;
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

    public void setDate() {
        //SimpleDateFormat sf = new SimpleDateFormat("yyyy-MM-dd");
        date = new Date();
    }

    public Date getDate() {
        return date;
    }

    public int getTrueWidth() {
        return trueWidth;
    }

    public void setTrueWidth(int trueWidth) {
        this.trueWidth = trueWidth;
    }

    public int getTrueHeight() {
        return trueHeight;
    }

    public void setTrueHeight(int trueHeight) {
        this.trueHeight = trueHeight;
    }
    
}
