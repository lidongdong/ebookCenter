/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.Color;
import java.awt.Dimension;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JPanel;

/**
 *
 * @author think
 */
public class PageContainer extends JPanel {

    private List<PrePage> pageList;

    public PageContainer() {
        pageList = new ArrayList<PrePage>();
        this.setLayout(null);
    }

    public void setScrollSize() {
        if (pageList.size() > 0) {
            this.setPreferredSize(new Dimension(20 + pageList.size() * (pageList.get(0).getWidth() + 20), 120));
        }
    }

    public makeWindow getMakeWindow() {
        return (makeWindow) this.getParent().getParent().getParent().getParent().getParent().getParent().getParent().getParent();
    }

    public void fresh() {
        if(getMakeWindow().getCurrentProject()!=null){
            this.removeAll();
            pageList.removeAll(pageList);
            //System.out.print(getMakeWindow().getCurrentProject().getName());
            for (int i = 0; i < getMakeWindow().getCurrentProject().getPages().size(); i++) {
                PrePage pp = new PrePage(getMakeWindow().getCurrentProject().getPages().get(i),i);
                pp.setMw(getMakeWindow());
                pageList.add(pp);
                this.add(pp);
            }
            if(getMakeWindow().getCurrentProject().getCurrentPage() >= 0){
                pageList.get(getMakeWindow().getCurrentProject().getCurrentPage()).setBorder();
            }
        } 
        setScrollSize();
        updateUI();
    }
    
    public void removeBorder(){
        for(int i = 0;i<pageList.size();i++){
            pageList.get(i).setBorder(null);
            pageList.get(i).getBackLabel().setBorder(null);
        }
    }
}
