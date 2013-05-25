/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import javax.swing.JOptionPane;

/**
 *
 * @author think
 */
public class NewProjectWindow extends javax.swing.JFrame {

    /**
     * Creates new form NewProjectWindow
     */
    public NewProjectWindow() {
        initComponents();
        this.jRadioButton1.setSelected(true);
        this.pageHeight.setEnabled(false);
        this.pageWidth.setEnabled(false);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pageSize = new javax.swing.ButtonGroup();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jRadioButton1 = new javax.swing.JRadioButton();
        jRadioButton2 = new javax.swing.JRadioButton();
        jRadioButton3 = new javax.swing.JRadioButton();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        pageWidth = new javax.swing.JTextField();
        pageHeight = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        projectName = new javax.swing.JTextField();
        newPageNumber = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("电子书制作");

        jLabel1.setText("项目名称");

        jLabel2.setText("新增页数");

        jLabel3.setText("纸张大小");

        pageSize.add(jRadioButton1);
        jRadioButton1.setText("A4");
        jRadioButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton1ActionPerformed(evt);
            }
        });

        pageSize.add(jRadioButton2);
        jRadioButton2.setText("A3");
        jRadioButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton2ActionPerformed(evt);
            }
        });

        pageSize.add(jRadioButton3);
        jRadioButton3.setText("自定义");
        jRadioButton3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jRadioButton3ActionPerformed(evt);
            }
        });

        jLabel4.setText("宽（mm）");

        jLabel5.setText("高（mm）");

        pageWidth.setPreferredSize(new java.awt.Dimension(72, 25));

        pageHeight.setPreferredSize(new java.awt.Dimension(72, 25));

        jButton1.setText("确定");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        jButton2.setText("取消");
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        projectName.setFont(new java.awt.Font("宋体", 0, 18)); // NOI18N
        projectName.setPreferredSize(new java.awt.Dimension(72, 25));

        newPageNumber.setPreferredSize(new java.awt.Dimension(72, 25));

        jLabel6.setText("(不填默认为0)");
        jLabel6.setPreferredSize(new java.awt.Dimension(85, 15));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addGap(32, 32, 32)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jLabel2)
                                    .addComponent(jLabel3))
                                .addGap(18, 18, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jRadioButton1)
                                    .addComponent(jRadioButton2)
                                    .addComponent(jRadioButton3)
                                    .addComponent(newPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, 53, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(38, 38, 38)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel5)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pageHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                            .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(pageWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                    .addGroup(layout.createSequentialGroup()
                                        .addGap(18, 18, 18)
                                        .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(18, 18, 18)
                                .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(0, 0, Short.MAX_VALUE))))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(62, 62, 62)
                        .addComponent(jButton1))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jButton2)
                        .addGap(76, 76, 76)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(31, 31, 31)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(projectName, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(newPageNumber, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(27, 27, 27)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton1)
                    .addComponent(jLabel3))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jRadioButton2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jRadioButton3)
                    .addComponent(jLabel4)
                    .addComponent(pageWidth, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel5)
                    .addComponent(pageHeight, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 18, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1)
                    .addComponent(jButton2))
                .addGap(18, 18, 18))
        );

        jLabel6.getAccessibleContext().setAccessibleName("（不填默认为0）");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //取消按钮处理
        this.dispose();
        this.getParent().setEnabled(true);
        this.getParent().requestFocus();

    }//GEN-LAST:event_jButton2MouseClicked

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
        //确定按钮处理
        boolean flag = false;
        if (this.projectName.getText().toString().length() == 0) {
            JOptionPane.showMessageDialog(null, "用户名不能为空!!!", "警告", JOptionPane.WARNING_MESSAGE);
        } else {
            if (this.newPageNumber.getText().toString().length() == 0 || this.newPageNumber.getText().equals("0")) {
                //新建空项目
                Project project = new Project();
                project.setName(this.projectName.getText().toString());
                this.parent.setCurrentProject(project);
                flag = true;
            } else {
                if (this.newPageNumber.getText().toString().matches("[0-9]*")) {
                    if (Integer.valueOf(this.newPageNumber.getText()) != 0) {
                        if (this.jRadioButton1.isSelected()) {
                            this.pageHeight.setEditable(false);
                            this.pageWidth.setEditable(false);
                            //System.out.print("第一项");//A4纸
                            Project project = new Project(this.projectName.getText().toString(),
                                    Integer.parseInt(this.newPageNumber.getText().toString()),
                                    210,
                                    297);
                            project.setName(this.projectName.getText().toString());
                            this.parent.setCurrentProject(project);
                            this.parent.getCurrentProject().setCurrentPage(0);
                            this.parent.getCurrentProject().getPage(0).selectBounds(this.parent.getPageArea());
                            this.parent.getPageArea().add(this.parent.getCurrentProject().getPage(0));
                            this.parent.getPageArea().setScrollSize(210, 297);//设置滚动条
                            this.parent.getPageArea().updateUI();

                            flag = true;
                        } else {
                            if (this.jRadioButton2.isSelected()) {
                                //System.out.print("第二项");//A3纸
                                Project project = new Project(this.projectName.getText().toString(),
                                        Integer.parseInt(this.newPageNumber.getText().toString()),
                                        297, 420);
                                project.setName(this.projectName.getText().toString());
                                this.parent.setCurrentProject(project);
                                this.parent.getCurrentProject().setCurrentPage(0);
                                this.parent.getCurrentProject().getPage(0).selectBounds(this.parent.getPageArea());
                                this.parent.getPageArea().add(this.parent.getCurrentProject().getPage(0));
                                this.parent.getPageArea().setScrollSize(297, 420);//设置滚动条
                                this.parent.getPageArea().updateUI();
                                flag = true;
                            } else {
                                if (this.jRadioButton3.isSelected()) {
                                    // System.out.print("第三项");//自定义
                                    if (this.pageWidth.getText().toString().length() == 0
                                            || this.pageHeight.getText().toString().length() == 0
                                            || Integer.parseInt(this.pageHeight.getText().toString()) == 0
                                            || Integer.parseInt(this.pageWidth.getText().toString()) == 0) {
                                        JOptionPane.showMessageDialog(null, "自定义页面的宽和高不能为空!!!", "警告", JOptionPane.WARNING_MESSAGE);
                                    } else {
                                        if (this.pageWidth.getText().toString().matches("[0-9]*") && this.pageHeight.getText().toString().matches("[0-9]*")) {
                                            //建立自定义大小的页面
                                            Project project = new Project(this.projectName.getText().toString(),
                                                    Integer.parseInt(this.newPageNumber.getText().toString()),
                                                    Integer.parseInt(this.pageWidth.getText().toString()),
                                                    Integer.parseInt(this.pageHeight.getText().toString()));
                                            project.setName(this.projectName.getText().toString());
                                            this.parent.setCurrentProject(project);
                                            this.parent.getCurrentProject().setCurrentPage(0);
                                            this.parent.getCurrentProject().getPage(0).selectBounds(this.parent.getPageArea());
                                            this.parent.getPageArea().add(this.parent.getCurrentProject().getPage(0));
                                            this.parent.getPageArea().setScrollSize(Integer.parseInt(this.pageWidth.getText().toString()), Integer.parseInt(this.pageHeight.getText().toString()));//设置滚动条
                                            this.parent.getPageArea().updateUI();
                                            flag = true;
                                        }
                                    }
                                }
                            }
                        }
                    }
                } else {
                    JOptionPane.showMessageDialog(null, "新增页数必须为整数!!!", "警告", JOptionPane.WARNING_MESSAGE);
                }
            }
        }
        if (flag == true) {
            this.dispose();
            this.parent.getPageContainer().fresh();
            this.getParent().setEnabled(true);
            this.getParent().getPageArea().repaint();
            this.getParent().requestFocus();
            this.getParent().setAlwaysOnTop(flag);
            this.getParent().setAlwaysOnTop(false);
        }

        /*System.out.print(parent.getCurrentProject().getName());
         System.out.print(parent.getCurrentProject().getCurrentPage());
         System.out.print(parent.getCurrentProject().getPageHeight()+"\n");
         System.out.print(parent.getCurrentProject().getPageWidth());
         System.out.print(parent.getCurrentProject().getPages().size());
         */

    }//GEN-LAST:event_jButton1MouseClicked

    private void jRadioButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton1ActionPerformed
        // TODO add your handling code here:
        //只在自定义中允许填写纸张的高和宽
        if (evt.getActionCommand() == "A4") {
            this.pageHeight.setEnabled(false);
            this.pageWidth.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton1ActionPerformed

    private void jRadioButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton2ActionPerformed
        // TODO add your handling code here:
        //只在自定义中允许填写纸张的高和宽
        if (evt.getActionCommand() == "A3") {
            this.pageHeight.setEnabled(false);
            this.pageWidth.setEnabled(false);
        }
    }//GEN-LAST:event_jRadioButton2ActionPerformed

    private void jRadioButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jRadioButton3ActionPerformed
        // TODO add your handling code here:
        //只在自定义中允许填写纸张的高和宽
        if (evt.getActionCommand() == "自定义") {
            this.pageHeight.setEnabled(true);
            this.pageWidth.setEnabled(true);
        }
    }//GEN-LAST:event_jRadioButton3ActionPerformed
    /**
     * @param args the command line arguments
     */
    /*  public static void main(String args[]) {
     
        
     try {
     for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
     if ("Nimbus".equals(info.getName())) {
     javax.swing.UIManager.setLookAndFeel(info.getClassName());
     break;
     }
     }
     } catch (ClassNotFoundException ex) {
     java.util.logging.Logger.getLogger(NewProjectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (InstantiationException ex) {
     java.util.logging.Logger.getLogger(NewProjectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (IllegalAccessException ex) {
     java.util.logging.Logger.getLogger(NewProjectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     } catch (javax.swing.UnsupportedLookAndFeelException ex) {
     java.util.logging.Logger.getLogger(NewProjectWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
     }
    

       
     java.awt.EventQueue.invokeLater(new Runnable() {
     public void run() {
     new NewProjectWindow().setVisible(true);
     }
     });
     }*/
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JRadioButton jRadioButton1;
    private javax.swing.JRadioButton jRadioButton2;
    private javax.swing.JRadioButton jRadioButton3;
    private javax.swing.JTextField newPageNumber;
    private javax.swing.JTextField pageHeight;
    private javax.swing.ButtonGroup pageSize;
    private javax.swing.JTextField pageWidth;
    private javax.swing.JTextField projectName;
    // End of variables declaration//GEN-END:variables
    private makeWindow parent;

    /**
     * Get the value of parent
     *
     * @return the value of parent
     */
    public makeWindow getParent() {
        return parent;
    }

    /**
     * Set the value of parent
     *
     * @param parent new value of parent
     */
    public void setParent(makeWindow parent) {
        this.parent = parent;
    }
}
