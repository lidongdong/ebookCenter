/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package ebookcenter;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Cursor;
import java.awt.Font;
import java.awt.GraphicsEnvironment;
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JColorChooser;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JScrollPane;
import javax.swing.JTextPane;

/**
 *
 * @author think
 */
public class makeWindow extends javax.swing.JFrame implements MouseListener {

    private Project currentProject;
    private PageArea pageArea;
    private JTextPane currentJtp;
    private PictureContainer pictureContainer;
    private BackgroundContainer backgroundContainer;
    private PageContainer pageContainer;

    public PageContainer getPageContainer() {
        return pageContainer;
    }

    public void setPageContainer(PageContainer pageContainer) {
        this.pageContainer = pageContainer;
    }

    public BackgroundContainer getBackgroundContainer() {
        return backgroundContainer;
    }

    public void setBackgroundContainer(BackgroundContainer backgroundContainer) {
        this.backgroundContainer = backgroundContainer;
    }

    /**
     * Get the value of pageArea
     *
     * @return the value of pageArea
     */
    public PageArea getPageArea() {
        return pageArea;
    }

    /**
     * Set the value of pageArea
     *
     * @param pageArea new value of pageArea
     */
    public void setPageArea(PageArea pageArea) {
        this.pageArea = pageArea;
    }

    /**
     * Get the value of currentProject
     *
     * @return the value of currentProject
     */
    public Project getCurrentProject() {
        return currentProject;
    }

    /**
     * Set the value of currentProject
     *
     * @param currentProject new value of currentProject
     */
    public void setCurrentProject(Project currentProject) {
        this.currentProject = currentProject;
    }

    public JTextPane getCurrentJtp() {
        return currentJtp;
    }

    public void setCurrentJtp(JTextPane currentJtp) {
        this.currentJtp = currentJtp;
    }

    /**
     * Get the value of pictureContainer
     *
     * @return the value of pictureContainer
     */
    public PictureContainer getPictureContainer() {
        return pictureContainer;
    }

    /**
     * Set the value of pictureContainer
     *
     * @param pictureContainer new value of pictureContainer
     */
    public void setPictureContainer(PictureContainer pictureContainer) {
        this.pictureContainer = pictureContainer;

    }

    /**
     * Creates new form makeWindow
     */
    public makeWindow() {
        initComponents();
        init();


    }

    public void init() {
        //this.setExtendedState(JFrame.MAXIMIZED_BOTH); //制作窗口初始最大化
        currentProject = null;
        pictureContainer = new PictureContainer(jPanel1);//图片预览区滚动条
        backgroundContainer = new BackgroundContainer();
        pageContainer = new PageContainer();
        JScrollPane pictureJsp = new JScrollPane(pictureContainer,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        pictureJsp.setOpaque(false);
        pictureJsp.getViewport().setOpaque(false);
        jPanel1.add(pictureJsp, BorderLayout.CENTER);
        pageArea = new PageArea(jPanel5);//页面编辑区滚动条
        JScrollPane pageJsp = new JScrollPane(pageArea,
                JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        pageJsp.setOpaque(false);
        pageJsp.getViewport().setOpaque(false);
        pageArea.setOpaque(false);
        jPanel5.add(pageJsp, BorderLayout.CENTER);
        JScrollPane backgroundJsp = new JScrollPane(backgroundContainer,//背景选择滚动条
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        backgroundJsp.setOpaque(false);
        backgroundJsp.getViewport().setOpaque(false);
        jPanel6.add(backgroundJsp, BorderLayout.CENTER);
        JScrollPane previewJsp = new JScrollPane(pageContainer,//页面预览滚动条
                JScrollPane.VERTICAL_SCROLLBAR_NEVER,
                JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        jPanel4.add(previewJsp, BorderLayout.CENTER);
        previewJsp.setOpaque(false);
        previewJsp.getViewport().setOpaque(false);

        GraphicsEnvironment ge = GraphicsEnvironment.getLocalGraphicsEnvironment();//字体载入
        Font[] fonts = ge.getAllFonts();
        for (int i = 0; i < fonts.length; i++) {
            selectFonts.addItem(fonts[i].getFontName());
        }
        fontSize.addItem("6");//字体大小
        fontSize.addItem("9");
        fontSize.addItem("10");
        fontSize.addItem("11");
        fontSize.addItem("12");
        fontSize.addItem("14");
        fontSize.addItem("16");
        fontSize.addItem("18");
        fontSize.addItem("20");
        fontSize.addItem("22");
        fontSize.addItem("24");
        fontSize.addItem("26");
        fontSize.addItem("28");
        fontSize.addItem("32");
        fontSize.addItem("48");
        fontSize.addItem("72");

        this.addMouseListener(this);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jPanel7 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jButton1 = new javax.swing.JButton();
        jPanel3 = new javax.swing.JPanel();
        jTabbedPane1 = new javax.swing.JTabbedPane();
        textSetting = new javax.swing.JPanel();
        selectFonts = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        fontSize = new javax.swing.JComboBox();
        boldButton = new javax.swing.JButton();
        italicButton = new javax.swing.JButton();
        underLineButton = new javax.swing.JButton();
        leftAlignmentButton = new javax.swing.JButton();
        midAlignmentButton = new javax.swing.JButton();
        rightAlignmentButton = new javax.swing.JButton();
        jLabel3 = new javax.swing.JLabel();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jTextField1 = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jTextField2 = new javax.swing.JTextField();
        jTextField3 = new javax.swing.JTextField();
        jTextField4 = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jTextField5 = new javax.swing.JTextField();
        jButton2 = new javax.swing.JButton();
        jPanel9 = new javax.swing.JPanel();
        jPanel2 = new javax.swing.JPanel();
        jPanel4 = new javax.swing.JPanel();
        jPanel6 = new javax.swing.JPanel();
        jPanel5 = new javax.swing.JPanel();
        jToolBar1 = new javax.swing.JToolBar();
        undoButton = new javax.swing.JButton();
        redoButton = new javax.swing.JButton();
        jMenuBar1 = new javax.swing.JMenuBar();
        jMenu1 = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenu2 = new javax.swing.JMenu();
        jMenu3 = new javax.swing.JMenu();
        jMenuItem1 = new javax.swing.JMenuItem();
        jMenuItem2 = new javax.swing.JMenuItem();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenu4 = new javax.swing.JMenu();
        jMenuItem6 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setMinimumSize(new java.awt.Dimension(800, 600));

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel1.setLayout(new java.awt.BorderLayout());

        jPanel7.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel1.setText("图片");

        jButton1.setText("添加");
        jButton1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton1MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 60, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 56, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jLabel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jButton1))
        );

        jPanel1.add(jPanel7, java.awt.BorderLayout.NORTH);

        getContentPane().add(jPanel1, java.awt.BorderLayout.LINE_START);

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jTabbedPane1.setPreferredSize(new java.awt.Dimension(140, 422));

        textSetting.setPreferredSize(new java.awt.Dimension(140, 393));

        selectFonts.setPreferredSize(new java.awt.Dimension(95, 21));
        selectFonts.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                selectFontsItemStateChanged(evt);
            }
        });

        jLabel2.setText("字体：");

        fontSize.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                fontSizeItemStateChanged(evt);
            }
        });

        boldButton.setFont(new java.awt.Font("宋体", 1, 14)); // NOI18N
        boldButton.setText("T");
        boldButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        boldButton.setMaximumSize(new java.awt.Dimension(81, 23));
        boldButton.setMinimumSize(new java.awt.Dimension(81, 23));
        boldButton.setPreferredSize(new java.awt.Dimension(81, 23));
        boldButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                boldButtonMouseClicked(evt);
            }
        });

        italicButton.setFont(new java.awt.Font("宋体", 2, 14)); // NOI18N
        italicButton.setText("T");
        italicButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        italicButton.setMaximumSize(new java.awt.Dimension(81, 23));
        italicButton.setMinimumSize(new java.awt.Dimension(81, 23));
        italicButton.setPreferredSize(new java.awt.Dimension(81, 23));
        italicButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                italicButtonMouseClicked(evt);
            }
        });

        underLineButton.setFont(new java.awt.Font("宋体", 0, 14)); // NOI18N
        underLineButton.setText("下划");
        underLineButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        underLineButton.setMaximumSize(new java.awt.Dimension(81, 23));
        underLineButton.setMinimumSize(new java.awt.Dimension(81, 23));
        underLineButton.setPreferredSize(new java.awt.Dimension(81, 23));
        underLineButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                underLineButtonMouseClicked(evt);
            }
        });

        leftAlignmentButton.setText("左");
        leftAlignmentButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        leftAlignmentButton.setMaximumSize(new java.awt.Dimension(81, 23));
        leftAlignmentButton.setMinimumSize(new java.awt.Dimension(81, 23));
        leftAlignmentButton.setPreferredSize(new java.awt.Dimension(81, 23));
        leftAlignmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                leftAlignmentButtonMouseClicked(evt);
            }
        });

        midAlignmentButton.setText("中");
        midAlignmentButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        midAlignmentButton.setMaximumSize(new java.awt.Dimension(81, 23));
        midAlignmentButton.setMinimumSize(new java.awt.Dimension(81, 23));
        midAlignmentButton.setPreferredSize(new java.awt.Dimension(81, 23));
        midAlignmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                midAlignmentButtonMouseClicked(evt);
            }
        });

        rightAlignmentButton.setText("右");
        rightAlignmentButton.setMargin(new java.awt.Insets(0, 0, 0, 0));
        rightAlignmentButton.setMaximumSize(new java.awt.Dimension(81, 23));
        rightAlignmentButton.setMinimumSize(new java.awt.Dimension(81, 23));
        rightAlignmentButton.setPreferredSize(new java.awt.Dimension(81, 23));
        rightAlignmentButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                rightAlignmentButtonMouseClicked(evt);
            }
        });

        jLabel3.setText("对齐方式：");

        jLabel4.setText("留白：");

        jLabel5.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel5.setText("上：");

        jTextField1.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField1KeyPressed(evt);
            }
        });

        jLabel6.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel6.setText("下：");

        jLabel7.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel7.setText("左：");

        jLabel8.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
        jLabel8.setText("右：");

        jTextField2.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField2KeyPressed(evt);
            }
        });

        jTextField3.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField3KeyPressed(evt);
            }
        });

        jTextField4.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField4KeyPressed(evt);
            }
        });

        jLabel9.setText("行距：");

        jTextField5.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jTextField5KeyPressed(evt);
            }
        });

        jButton2.setText("颜色");
        jButton2.setMargin(new java.awt.Insets(0, 0, 0, 0));
        jButton2.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jButton2MouseClicked(evt);
            }
        });

        javax.swing.GroupLayout textSettingLayout = new javax.swing.GroupLayout(textSetting);
        textSetting.setLayout(textSettingLayout);
        textSettingLayout.setHorizontalGroup(
            textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textSettingLayout.createSequentialGroup()
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                    .addComponent(jLabel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(selectFonts, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(0, 0, Short.MAX_VALUE))
            .addGroup(textSettingLayout.createSequentialGroup()
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel9, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, textSettingLayout.createSequentialGroup()
                        .addComponent(fontSize, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18)
                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 54, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(textSettingLayout.createSequentialGroup()
                        .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(textSettingLayout.createSequentialGroup()
                                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                    .addComponent(boldButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(leftAlignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(italicButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(midAlignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(2, 2, 2)
                                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(underLineButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)
                                    .addComponent(rightAlignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, 36, javax.swing.GroupLayout.PREFERRED_SIZE)))
                            .addGroup(textSettingLayout.createSequentialGroup()
                                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jLabel8, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 37, Short.MAX_VALUE)
                                    .addComponent(jLabel7, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel6, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                    .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addComponent(jTextField3, javax.swing.GroupLayout.DEFAULT_SIZE, 63, Short.MAX_VALUE)
                                    .addComponent(jTextField2, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField1, javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jTextField4)))
                            .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, 72, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        textSettingLayout.setVerticalGroup(
            textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(textSettingLayout.createSequentialGroup()
                .addComponent(jLabel2, javax.swing.GroupLayout.PREFERRED_SIZE, 17, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(selectFonts, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(fontSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(boldButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(italicButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(underLineButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(rightAlignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(leftAlignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(midAlignmentButton, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(textSettingLayout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel5)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 15, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(textSettingLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel8)
                    .addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel9)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jTextField5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(60, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("文本", textSetting);

        javax.swing.GroupLayout jPanel9Layout = new javax.swing.GroupLayout(jPanel9);
        jPanel9.setLayout(jPanel9Layout);
        jPanel9Layout.setHorizontalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 115, Short.MAX_VALUE)
        );
        jPanel9Layout.setVerticalGroup(
            jPanel9Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 393, Short.MAX_VALUE)
        );

        jTabbedPane1.addTab("tab2", jPanel9);

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel3Layout.createSequentialGroup()
                .addGap(0, 0, Short.MAX_VALUE)
                .addComponent(jTabbedPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 120, javax.swing.GroupLayout.PREFERRED_SIZE))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jTabbedPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 419, Short.MAX_VALUE)
        );

        getContentPane().add(jPanel3, java.awt.BorderLayout.LINE_END);

        jPanel2.setOpaque(false);
        jPanel2.setLayout(new java.awt.BorderLayout());

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel4.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel4.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel4, java.awt.BorderLayout.PAGE_START);

        jPanel6.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel6.setPreferredSize(new java.awt.Dimension(120, 120));
        jPanel6.setLayout(new java.awt.BorderLayout());
        jPanel2.add(jPanel6, java.awt.BorderLayout.PAGE_END);

        jPanel5.setBorder(javax.swing.BorderFactory.createEtchedBorder());
        jPanel5.setOpaque(false);
        jPanel5.setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);
        jToolBar1.setPreferredSize(new java.awt.Dimension(289, 32));

        undoButton.setText("撤销");
        undoButton.setFocusable(false);
        undoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        undoButton.setPreferredSize(new java.awt.Dimension(32, 32));
        undoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        undoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                undoButtonMouseClicked(evt);
            }
        });
        jToolBar1.add(undoButton);

        redoButton.setText("回退");
        redoButton.setFocusable(false);
        redoButton.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        redoButton.setPreferredSize(new java.awt.Dimension(32, 32));
        redoButton.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        redoButton.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                redoButtonMouseClicked(evt);
            }
        });
        jToolBar1.add(redoButton);

        jPanel5.add(jToolBar1, java.awt.BorderLayout.NORTH);

        jPanel2.add(jPanel5, java.awt.BorderLayout.CENTER);

        getContentPane().add(jPanel2, java.awt.BorderLayout.CENTER);

        jMenu1.setText("文件");

        jMenuItem4.setText("新建项目");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem4);

        jMenuItem5.setText("新建页面");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem5);

        jMenuItem8.setText("删除页面");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem8);

        jMenuItem7.setText("打开项目");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem7);

        jMenuItem9.setText("保存项目");
        jMenu1.add(jMenuItem9);

        jMenuItem10.setText("另存为...");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jMenu1.add(jMenuItem10);

        jMenuBar1.add(jMenu1);

        jMenu2.setText("编辑");
        jMenuBar1.add(jMenu2);

        jMenu3.setText("插入");

        jMenuItem1.setText("文本框");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem1);

        jMenuItem2.setText("图片框");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jMenu3.add(jMenuItem2);

        jMenuItem3.setText("复合框");
        jMenu3.add(jMenuItem3);

        jMenuBar1.add(jMenu3);

        jMenu4.setText("工具");

        jMenuItem6.setText("设置");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jMenu4.add(jMenuItem6);

        jMenuBar1.add(jMenu4);

        setJMenuBar(jMenuBar1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton1MouseClicked
        // TODO add your handling code here:
         /*
         * 图片文件过滤以及路径获取
         */
        JFileChooser dlg = new JFileChooser();
        dlg.setFileSelectionMode(JFileChooser.FILES_AND_DIRECTORIES);
        dlg.setMultiSelectionEnabled(true);
        dlg.setAcceptAllFileFilterUsed(false);
        dlg.setDialogTitle("选择图片文件");
        ImageFilter imageFilter = new ImageFilter();
        dlg.addChoosableFileFilter(imageFilter);
        int returnVal = dlg.showDialog(null, null);
        File file[] = dlg.getSelectedFiles();
        pictureContainer.addPicture(file);
        pictureContainer.showPicture();
        pictureContainer.updateUI();


    }//GEN-LAST:event_jButton1MouseClicked

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        // TODO add your handling code here:
        /*
         * 新建项目菜单
         */
        String str = evt.getActionCommand();
        if (str == "新建项目") {
            NewProjectWindow npw = new NewProjectWindow();
            npw.setVisible(true);
            npw.setAlwaysOnTop(true);
            this.setEnabled(false);
            npw.setParent(this);
        }

    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        // TODO add your handling code here:
        /*
         * 插入图片框
         */
        String str = evt.getActionCommand();
        if (str.equals("图片框")) {
            if (this.currentProject != null && this.currentProject.getCurrentPage() >= 0) {
                this.currentProject.getPage(this.currentProject.getCurrentPage()).setInsertStatus(Constant.ADD_PICTURE);
                this.currentProject.getPage(this.currentProject.getCurrentPage()).setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            }
        }
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        // TODO add your handling code here:
        //插入文本框
        String str = evt.getActionCommand();
        if (str.equals("文本框")) {
            if (this.currentProject != null && this.currentProject.getCurrentPage() >= 0) {
                this.currentProject.getPage(this.currentProject.getCurrentPage()).setInsertStatus(Constant.ADD_TEXT);
                this.currentProject.getPage(this.currentProject.getCurrentPage()).setCursor(new Cursor(Cursor.CROSSHAIR_CURSOR));
            }
        }
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        // TODO add your handling code here:
        //打开项目
        String str = evt.getActionCommand();
        if (str.equals("打开项目")) {
            if (this.currentProject == null) {
                JFileChooser dlg = new JFileChooser();
                dlg.setFileSelectionMode(JFileChooser.FILES_ONLY);
                dlg.setMultiSelectionEnabled(false);
                EbookFilter ebookFilter = new EbookFilter();
                dlg.addChoosableFileFilter(ebookFilter);
                dlg.setCurrentDirectory(new File(configWindow.readFile().getSaveDir()));
                dlg.setDialogTitle("选择要打开的文件");
                dlg.showOpenDialog(this);
                if(dlg.getSelectedFile()!=null)
                try {
                    this.openFile(dlg.getSelectedFile().getAbsolutePath());
                } catch (IOException ex) {
                    Logger.getLogger(makeWindow.class.getName()).log(Level.SEVERE, null, ex);
                }
            } else {
                //提醒是否保存当前项目
            }
        }
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void fontSizeItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_fontSizeItemStateChanged
        // TODO add your handling code here:
        //字体jcombobox被改变
        if (evt.getSource() == fontSize) {
            if (currentJtp == null) {
            } else {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    TextBox.setFontSize(currentJtp, Integer.parseInt(fontSize.getSelectedItem().toString()));
                }
            }
        }

    }//GEN-LAST:event_fontSizeItemStateChanged

    private void selectFontsItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_selectFontsItemStateChanged
        // TODO add your handling code here:
        //字体选择
        if (evt.getSource() == selectFonts) {
            if (currentJtp == null) {
            } else {
                if (evt.getStateChange() == ItemEvent.SELECTED) {
                    TextBox.chooseFont(currentJtp, selectFonts.getSelectedItem().toString());
                }
            }
        }
    }//GEN-LAST:event_selectFontsItemStateChanged

    private void boldButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_boldButtonMouseClicked
        // TODO add your handling code here:
        //粗体操作
        if (currentJtp == null) {
        } else {
            TextBox.setBold(currentJtp);
        }
    }//GEN-LAST:event_boldButtonMouseClicked

    private void italicButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_italicButtonMouseClicked
        // TODO add your handling code here:
        //斜体操作
        if (currentJtp == null) {
        } else {
            TextBox.setItalic(currentJtp);
        }
    }//GEN-LAST:event_italicButtonMouseClicked

    private void underLineButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_underLineButtonMouseClicked
        // TODO add your handling code here:
        //下划线操作
        if (currentJtp == null) {
        } else {
            TextBox.setUnderLine(currentJtp);
        }
    }//GEN-LAST:event_underLineButtonMouseClicked

    private void leftAlignmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_leftAlignmentButtonMouseClicked
        // TODO add your handling code here:
        //左对齐操作
        if (currentJtp == null) {
        } else {
            TextBox.setLeftAlignment(currentJtp);
        }
    }//GEN-LAST:event_leftAlignmentButtonMouseClicked

    private void midAlignmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_midAlignmentButtonMouseClicked
        // TODO add your handling code here:
        //居中对齐操作
        if (currentJtp == null) {
        } else {
            TextBox.setMidAlignment(currentJtp);
        }
    }//GEN-LAST:event_midAlignmentButtonMouseClicked

    private void rightAlignmentButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_rightAlignmentButtonMouseClicked
        // TODO add your handling code here:
        //右对齐操作
        if (currentJtp == null) {
        } else {
            TextBox.setRightAlignment(currentJtp);
        }
    }//GEN-LAST:event_rightAlignmentButtonMouseClicked

    private void jTextField1KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField1KeyPressed
        // TODO add your handling code here:
        //上留白
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = jTextField1.getText();
            if (TextBox.isDouble(value) || TextBox.isInteger(value)) {
                if (currentJtp != null) {
                    TextBox.setSpaceAbove(currentJtp, Float.valueOf(value));
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字!!!", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField1KeyPressed

    private void jTextField5KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField5KeyPressed
        // TODO add your handling code here:
        //行距
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = jTextField5.getText();
            if (TextBox.isDouble(value) || TextBox.isInteger(value)) {
                if (currentJtp != null) {
                    TextBox.setLineSpacing(currentJtp, Float.valueOf(value));
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字!!!", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField5KeyPressed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        // TODO add your handling code here:
        //新建页面
        String str = evt.getActionCommand();
        if (str.equals("新建页面")) {

            if (currentProject != null) {
                NewPageWindow newPageWindow = new NewPageWindow(this);
                newPageWindow.setVisible(true);
                newPageWindow.setAlwaysOnTop(true);
                this.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "当前无项目，请先新建项目！", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
        System.out.print(this.currentProject.getCurrentPage());
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        // TODO add your handling code here:
        //另存为
        if (this.currentProject != null) {
            JFileChooser dlg = new JFileChooser();
            dlg.setFileSelectionMode(JFileChooser.FILES_ONLY);
            dlg.setMultiSelectionEnabled(false);
            dlg.setCurrentDirectory(new File(configWindow.readFile().getSaveDir()));
            dlg.setDialogTitle("选择保存路径");
            dlg.showSaveDialog(this);
            this.saveFile(dlg.getSelectedFile().getAbsolutePath());
        } else {
            JOptionPane.showMessageDialog(null, "当前无项目，无法保存！", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    public void saveFile(String file) {
        try {
            FileOutputStream f = new FileOutputStream(file + ".ebf");
            ObjectOutputStream s = new ObjectOutputStream(f);
            this.currentProject.setDate();
            s.writeObject(this.currentProject);
            s.close();
        } catch (FileNotFoundException ex) {
            Logger.getLogger(makeWindow.class.getName()).log(Level.SEVERE, null, ex);
        } catch (IOException ex) {
            Logger.getLogger(makeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void openFile(String file) throws IOException {
        try {
            Project p = null;
            FileInputStream f = null;
            f = new FileInputStream(file);
            ObjectInputStream s =
                    new ObjectInputStream(f);
            p = (Project) s.readObject();//读对象
            this.setCurrentProject(p);
            if (!p.getPages().isEmpty()) {
                for (int i = 0; i < p.getPages().size(); i++) {
                    p.getPage(i).getUndoQueue().removeAll();
                }
                this.getCurrentProject().setCurrentPage(0);
                this.getPageArea().add(this.getCurrentProject().getPage(0));
                this.getPageArea().setScrollSize(210, 297);//设置滚动条
                this.pageContainer.fresh();
                this.getPageArea().refresh();
                this.getPageArea().updateUI();
            }
            s.close();
            f.close();
        } catch (ClassNotFoundException ex) {
            Logger.getLogger(makeWindow.class.getName()).log(Level.SEVERE, null, ex);
        }

    }

    private void jButton2MouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_jButton2MouseClicked
        // TODO add your handling code here:
        //字体颜色
        if (currentJtp == null) {
        } else {
            Color fontColor = JColorChooser.showDialog(rootPane, "请选择字体颜色", currentJtp.getForeground());
            if (fontColor != null) {
                TextBox.setFontColor(currentJtp, fontColor);
            }
        }
    }//GEN-LAST:event_jButton2MouseClicked

    private void jTextField2KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField2KeyPressed
        // TODO add your handling code here:
        //下留白
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = jTextField2.getText();
            if (TextBox.isDouble(value) || TextBox.isInteger(value)) {
                if (currentJtp != null) {
                    TextBox.setSpaceBelow(currentJtp, Float.valueOf(value));
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字!!!", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField2KeyPressed

    private void jTextField3KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField3KeyPressed
        // TODO add your handling code here:
        //左留白
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = jTextField3.getText();
            if (TextBox.isDouble(value) || TextBox.isInteger(value)) {
                if (currentJtp != null) {
                    TextBox.setLeftIndent(currentJtp, Float.valueOf(value));
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字!!!", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField3KeyPressed

    private void jTextField4KeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jTextField4KeyPressed
        // TODO add your handling code here:
        //右留白
        if (evt.getKeyCode() == KeyEvent.VK_ENTER) {
            String value = jTextField4.getText();
            if (TextBox.isDouble(value) || TextBox.isInteger(value)) {
                if (currentJtp != null) {
                    TextBox.setRightIndent(currentJtp, Float.valueOf(value));
                }
            } else {
                JOptionPane.showMessageDialog(null, "请输入数字!!!", "警告", JOptionPane.WARNING_MESSAGE);
            }
        }
    }//GEN-LAST:event_jTextField4KeyPressed

    private void undoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_undoButtonMouseClicked
        // TODO add your handling code here:
        //undo操作
        if (this.currentProject != null || this.currentProject.getCurrentPage() >= 0) {
            Page temp = this.currentProject.getPage(this.currentProject.getCurrentPage());
            OperationStruct os = temp.getUndoQueue().undo();
            if (os != null) {
                if (os.getBoxType() == Constant.TYPE_PICTURE_BOX) {
                    temp.getPictureBoxes().get(os.getBoxId()).setBounds(os.getStart());
                    temp.updateUI();
                    this.pageContainer.fresh();
                } else if (os.getBoxType() == Constant.TYPE_TEXT_BOX) {
                    temp.getTextBoxList().get(os.getBoxId()).setBounds(os.getStart());
                    temp.updateUI();
                }
            }
        }
    }//GEN-LAST:event_undoButtonMouseClicked

    private void redoButtonMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_redoButtonMouseClicked
        // TODO add your handling code here:
        //redo操作
        if (this.currentProject != null || this.currentProject.getCurrentPage() >= 0) {
            Page temp = this.currentProject.getPage(this.currentProject.getCurrentPage());
            OperationStruct os = temp.getUndoQueue().redo();
            if (os != null) {
                if (os.getBoxType() == Constant.TYPE_PICTURE_BOX) {
                    temp.getPictureBoxes().get(os.getBoxId()).setBounds(os.getEnd());
                    temp.updateUI();
                    this.pageContainer.fresh();
                } else if (os.getBoxType() == Constant.TYPE_TEXT_BOX) {
                    temp.getTextBoxList().get(os.getBoxId()).setBounds(os.getEnd());
                    temp.updateUI();
                }
            }
        }
    }//GEN-LAST:event_redoButtonMouseClicked

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:删除页面
        if (this.currentProject != null) {
            if (this.currentProject.getPages().size() > 0) {
                DeletePageWindow dpw = new DeletePageWindow(this);
                dpw.setVisible(true);
                dpw.setAlwaysOnTop(true);
                this.setEnabled(false);
            } else {
                JOptionPane.showMessageDialog(null, "当前页面可删除！", "警告", JOptionPane.WARNING_MESSAGE);
            }
        } else {
            JOptionPane.showMessageDialog(null, "当前无项目！", "警告", JOptionPane.WARNING_MESSAGE);
        }
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        // TODO add your handling code here:
        //设置

        // newPageWindow.setAlwaysOnTop(true);
        configWindow cw = new configWindow(this);
        
        cw.setVisible(true);
        this.setEnabled(false);
        cw.requestFocus();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {

        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(makeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(makeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(makeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(makeWindow.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new makeWindow().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton boldButton;
    private javax.swing.JComboBox fontSize;
    private javax.swing.JButton italicButton;
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton2;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JMenu jMenu1;
    private javax.swing.JMenu jMenu2;
    private javax.swing.JMenu jMenu3;
    private javax.swing.JMenu jMenu4;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JPanel jPanel9;
    private javax.swing.JTabbedPane jTabbedPane1;
    private javax.swing.JTextField jTextField1;
    private javax.swing.JTextField jTextField2;
    private javax.swing.JTextField jTextField3;
    private javax.swing.JTextField jTextField4;
    private javax.swing.JTextField jTextField5;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton leftAlignmentButton;
    private javax.swing.JButton midAlignmentButton;
    private javax.swing.JButton redoButton;
    private javax.swing.JButton rightAlignmentButton;
    private javax.swing.JComboBox selectFonts;
    private javax.swing.JPanel textSetting;
    private javax.swing.JButton underLineButton;
    private javax.swing.JButton undoButton;
    // End of variables declaration//GEN-END:variables

    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getButton() == MouseEvent.BUTTON1) {
            if (e.getClickCount() == 1) {
                this.requestFocus();

            }
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
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
