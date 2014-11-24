package project;

import javax.swing.DefaultListModel;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author chittle
 */
public class BillPanel extends javax.swing.JPanel {

  private MainFrame mainFrame;
  private Bill bill;
  private Menu menu;
  
  private DefaultListModel<Category> categoriesListModel;
  private DefaultListModel<MenuItem> menuItemsListModel;
  private DefaultListModel<BillMenuItem> billItemsListModel;

  /**
   * Creates new form BillPanel
   */
  public BillPanel(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
    initComponents();
    categoriesListModel = new DefaultListModel<Category>();
    menuItemsListModel = new DefaultListModel<MenuItem>();
    billItemsListModel = new DefaultListModel<BillMenuItem>();
    categoriesList.setModel(categoriesListModel);
    menuItemsList.setModel(menuItemsListModel);
    billItemsList.setModel(billItemsListModel);
  }

  public BillPanel() {
    initComponents();
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    jScrollPane4 = new javax.swing.JScrollPane();
    jTextArea1 = new javax.swing.JTextArea();
    titleLabel = new javax.swing.JLabel();
    viewReceiptButton = new javax.swing.JButton();
    backButton = new javax.swing.JButton();
    billItemsPanel = new javax.swing.JPanel();
    billItemsLabel = new javax.swing.JLabel();
    jScrollPane3 = new javax.swing.JScrollPane();
    billItemsList = new javax.swing.JList();
    minusQuantityButton = new javax.swing.JButton();
    increaseQuantityButton = new javax.swing.JButton();
    categoriesPanel = new javax.swing.JPanel();
    categoryLabel = new javax.swing.JLabel();
    jScrollPane1 = new javax.swing.JScrollPane();
    categoriesList = new javax.swing.JList();
    menuItemsPanel = new javax.swing.JPanel();
    jScrollPane2 = new javax.swing.JScrollPane();
    menuItemsList = new javax.swing.JList();
    menuItemsLabel = new javax.swing.JLabel();
    tipPanel = new javax.swing.JPanel();
    tipLabel = new javax.swing.JLabel();
    tipButton1 = new javax.swing.JButton();
    tipButton2 = new javax.swing.JButton();
    tipButton3 = new javax.swing.JButton();
    tipButton4 = new javax.swing.JButton();
    tipAmountTextField = new javax.swing.JTextField();
    jLabel1 = new javax.swing.JLabel();
    jPanel1 = new javax.swing.JPanel();
    descriptionLabel = new javax.swing.JLabel();
    jScrollPane5 = new javax.swing.JScrollPane();
    descriptionTextPane = new javax.swing.JTextPane();

    jTextArea1.setColumns(20);
    jTextArea1.setRows(5);
    jScrollPane4.setViewportView(jTextArea1);

    setPreferredSize(new java.awt.Dimension(800, 600));

    titleLabel.setFont(new java.awt.Font("Ubuntu", 1, 24)); // NOI18N
    titleLabel.setText("Bill");

    viewReceiptButton.setText("View Receipt");
    viewReceiptButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        viewReceiptButtonActionPerformed(evt);
      }
    });

    backButton.setText("Back");
    backButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        backButtonActionPerformed(evt);
      }
    });

    billItemsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    billItemsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    billItemsLabel.setText("Bill Items");

    billItemsList.setModel(new DefaultListModel());
    jScrollPane3.setViewportView(billItemsList);

    minusQuantityButton.setText("One Less");
    minusQuantityButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        minusQuantityButtonActionPerformed(evt);
      }
    });

    increaseQuantityButton.setText("One More");
    increaseQuantityButton.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        increaseQuantityButtonActionPerformed(evt);
      }
    });

    javax.swing.GroupLayout billItemsPanelLayout = new javax.swing.GroupLayout(billItemsPanel);
    billItemsPanel.setLayout(billItemsPanelLayout);
    billItemsPanelLayout.setHorizontalGroup(
      billItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billItemsPanelLayout.createSequentialGroup()
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        .addComponent(billItemsLabel)
        .addGap(107, 107, 107))
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, billItemsPanelLayout.createSequentialGroup()
        .addGap(24, 24, 24)
        .addComponent(minusQuantityButton)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 82, Short.MAX_VALUE)
        .addComponent(increaseQuantityButton)
        .addGap(24, 24, 24))
      .addGroup(billItemsPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addContainerGap())
    );
    billItemsPanelLayout.setVerticalGroup(
      billItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(billItemsPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(billItemsLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane3)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(billItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(minusQuantityButton)
          .addComponent(increaseQuantityButton))
        .addGap(6, 6, 6))
    );

    categoriesPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    categoryLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    categoryLabel.setText("Categories");

    categoriesList.setModel(new DefaultListModel());
    categoriesList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        categoriesListValueChanged(evt);
      }
    });
    jScrollPane1.setViewportView(categoriesList);

    javax.swing.GroupLayout categoriesPanelLayout = new javax.swing.GroupLayout(categoriesPanel);
    categoriesPanel.setLayout(categoriesPanelLayout);
    categoriesPanelLayout.setHorizontalGroup(
      categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(categoriesPanelLayout.createSequentialGroup()
        .addGroup(categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(categoriesPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 237, javax.swing.GroupLayout.PREFERRED_SIZE))
          .addGroup(categoriesPanelLayout.createSequentialGroup()
            .addGap(83, 83, 83)
            .addComponent(categoryLabel)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    categoriesPanelLayout.setVerticalGroup(
      categoriesPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(categoriesPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(categoryLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 155, javax.swing.GroupLayout.PREFERRED_SIZE)
        .addContainerGap(18, Short.MAX_VALUE))
    );

    menuItemsPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    menuItemsList.setModel(new DefaultListModel());
    menuItemsList.addMouseListener(new java.awt.event.MouseAdapter() {
      public void mouseClicked(java.awt.event.MouseEvent evt) {
        menuItemsListMouseClicked(evt);
      }
    });
    menuItemsList.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
      public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
        menuItemsListValueChanged(evt);
      }
    });
    jScrollPane2.setViewportView(menuItemsList);

    menuItemsLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    menuItemsLabel.setText("Menu Items");

    javax.swing.GroupLayout menuItemsPanelLayout = new javax.swing.GroupLayout(menuItemsPanel);
    menuItemsPanel.setLayout(menuItemsPanelLayout);
    menuItemsPanelLayout.setHorizontalGroup(
      menuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(menuItemsPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)
        .addContainerGap())
      .addGroup(menuItemsPanelLayout.createSequentialGroup()
        .addGap(86, 86, 86)
        .addComponent(menuItemsLabel)
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    menuItemsPanelLayout.setVerticalGroup(
      menuItemsPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, menuItemsPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(menuItemsLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addComponent(jScrollPane2, javax.swing.GroupLayout.DEFAULT_SIZE, 120, Short.MAX_VALUE)
        .addContainerGap())
    );

    tipPanel.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    tipLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    tipLabel.setText("Tip");

    tipButton1.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
    tipButton1.setText("10%");
    tipButton1.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipButton1ActionPerformed(evt);
      }
    });

    tipButton2.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
    tipButton2.setText("15%");
    tipButton2.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipButton2ActionPerformed(evt);
      }
    });

    tipButton3.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
    tipButton3.setText("20%");
    tipButton3.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipButton3ActionPerformed(evt);
      }
    });

    tipButton4.setFont(new java.awt.Font("DejaVu Sans", 0, 12)); // NOI18N
    tipButton4.setText("25%");
    tipButton4.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipButton4ActionPerformed(evt);
      }
    });

    tipAmountTextField.setText("0");
    tipAmountTextField.addActionListener(new java.awt.event.ActionListener() {
      public void actionPerformed(java.awt.event.ActionEvent evt) {
        tipAmountTextFieldActionPerformed(evt);
      }
    });
    tipAmountTextField.addFocusListener(new java.awt.event.FocusAdapter() {
      public void focusLost(java.awt.event.FocusEvent evt) {
        tipAmountTextFieldFocusLost(evt);
      }
    });

    jLabel1.setText("$");

    javax.swing.GroupLayout tipPanelLayout = new javax.swing.GroupLayout(tipPanel);
    tipPanel.setLayout(tipPanelLayout);
    tipPanelLayout.setHorizontalGroup(
      tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tipPanelLayout.createSequentialGroup()
        .addGroup(tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(tipPanelLayout.createSequentialGroup()
            .addContainerGap()
            .addGroup(tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tipButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
              .addComponent(tipButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
            .addGroup(tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
              .addComponent(tipButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 58, Short.MAX_VALUE)
              .addComponent(tipButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
          .addGroup(tipPanelLayout.createSequentialGroup()
            .addGap(50, 50, 50)
            .addComponent(tipLabel))
          .addGroup(tipPanelLayout.createSequentialGroup()
            .addGap(28, 28, 28)
            .addComponent(jLabel1)
            .addGap(4, 4, 4)
            .addComponent(tipAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, 69, javax.swing.GroupLayout.PREFERRED_SIZE)))
        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
    );
    tipPanelLayout.setVerticalGroup(
      tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(tipPanelLayout.createSequentialGroup()
        .addContainerGap()
        .addComponent(tipLabel)
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
        .addGroup(tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tipButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
          .addComponent(tipButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addComponent(tipButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 56, Short.MAX_VALUE)
          .addComponent(tipButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addGap(18, 18, 18)
        .addGroup(tipPanelLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(tipAmountTextField, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
          .addComponent(jLabel1))
        .addContainerGap())
    );

    jPanel1.setBorder(new javax.swing.border.SoftBevelBorder(javax.swing.border.BevelBorder.RAISED));

    descriptionLabel.setFont(new java.awt.Font("Ubuntu", 1, 15)); // NOI18N
    descriptionLabel.setText("Description");

    jScrollPane5.setViewportView(descriptionTextPane);

    javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
    jPanel1.setLayout(jPanel1Layout);
    jPanel1Layout.setHorizontalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(jScrollPane5)
        .addContainerGap())
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addGap(33, 33, 33)
        .addComponent(descriptionLabel)
        .addContainerGap(30, Short.MAX_VALUE))
    );
    jPanel1Layout.setVerticalGroup(
      jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(jPanel1Layout.createSequentialGroup()
        .addContainerGap()
        .addComponent(descriptionLabel)
        .addGap(12, 12, 12)
        .addComponent(jScrollPane5, javax.swing.GroupLayout.DEFAULT_SIZE, 113, Short.MAX_VALUE)
        .addContainerGap())
    );

    javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
    this.setLayout(layout);
    layout.setHorizontalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(126, 126, 126)
                .addComponent(backButton))
              .addGroup(layout.createSequentialGroup()
                .addGap(46, 46, 46)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(categoriesPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(menuItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addGroup(layout.createSequentialGroup()
                .addGap(317, 317, 317)
                .addComponent(viewReceiptButton))
              .addGroup(layout.createSequentialGroup()
                .addGap(43, 43, 43)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                  .addComponent(tipPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                  .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(42, 42, 42)
                .addComponent(billItemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))))
          .addGroup(layout.createSequentialGroup()
            .addGap(401, 401, 401)
            .addComponent(titleLabel)))
        .addContainerGap(21, Short.MAX_VALUE))
    );
    layout.setVerticalGroup(
      layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
      .addGroup(layout.createSequentialGroup()
        .addGap(29, 29, 29)
        .addComponent(titleLabel)
        .addGap(18, 18, 18)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
          .addGroup(layout.createSequentialGroup()
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
              .addComponent(categoriesPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(tipPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
            .addGap(22, 22, 22)
            .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
              .addComponent(menuItemsPanel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
              .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
          .addComponent(billItemsPanel, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
          .addComponent(backButton)
          .addComponent(viewReceiptButton))
        .addContainerGap(72, Short.MAX_VALUE))
    );
  }// </editor-fold>//GEN-END:initComponents

  private void backButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_backButtonActionPerformed
    mainFrame.showMainPanel();
  }//GEN-LAST:event_backButtonActionPerformed

  private void viewReceiptButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_viewReceiptButtonActionPerformed
    mainFrame.openReceiptForCurrentBill();
  }//GEN-LAST:event_viewReceiptButtonActionPerformed

  private void tipButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipButton1ActionPerformed
    this.updateTipPercent(0.10);
  }//GEN-LAST:event_tipButton1ActionPerformed

  private void tipButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipButton2ActionPerformed
    this.updateTipPercent(0.15);
  }//GEN-LAST:event_tipButton2ActionPerformed

  private void tipButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipButton3ActionPerformed
    this.updateTipPercent(0.20);
  }//GEN-LAST:event_tipButton3ActionPerformed

  private void tipAmountTextFieldActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipAmountTextFieldActionPerformed

  }//GEN-LAST:event_tipAmountTextFieldActionPerformed
  private void tipButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_tipButton4ActionPerformed
    this.updateTipPercent(0.25);
  }//GEN-LAST:event_tipButton4ActionPerformed

  private void minusQuantityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_minusQuantityButtonActionPerformed
    int index = billItemsList.getSelectedIndex();
    if (index != -1) {
      BillMenuItem item = billItemsListModel.getElementAt(index);
      item.minusQuantity();
      revalidateBillItemsList();
      updateTipField();
    }
  }//GEN-LAST:event_minusQuantityButtonActionPerformed

  private void increaseQuantityButtonActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_increaseQuantityButtonActionPerformed
    int index = billItemsList.getSelectedIndex();
    if (index != -1) {
      BillMenuItem item = billItemsListModel.getElementAt(index);
      item.plusQuantity();
      revalidateBillItemsList();
      updateTipField();
    }
  }//GEN-LAST:event_increaseQuantityButtonActionPerformed

  private void categoriesListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_categoriesListValueChanged
    if (evt.getValueIsAdjusting() == false) {
      int index = categoriesList.getSelectedIndex();
      if (index != -1) {
        Category category = categoriesListModel.getElementAt(index);
        setCategorySelected(category);
      } 
    }
  }//GEN-LAST:event_categoriesListValueChanged

  private void menuItemsListValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_menuItemsListValueChanged

  }//GEN-LAST:event_menuItemsListValueChanged

  private void menuItemsListMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_menuItemsListMouseClicked
    int index = menuItemsList.getSelectedIndex();
    if (index != -1) {
      MenuItem item = menuItemsListModel.getElementAt(index);
      descriptionTextPane.setText(item.getDescription());
      if (evt.getClickCount() == 2) {
        addMenuItem(item);
      }
    }
    
  }//GEN-LAST:event_menuItemsListMouseClicked

  private void tipAmountTextFieldFocusLost(java.awt.event.FocusEvent evt) {//GEN-FIRST:event_tipAmountTextFieldFocusLost
    String text = tipAmountTextField.getText();
    try {
      double amount = Double.valueOf(text);
      this.updateTipAmount(amount);
    } catch (NumberFormatException e) {
      System.out.println("Number Format Exception on Tip: " + e);
      this.updateTipAmount(0);
    }
  }//GEN-LAST:event_tipAmountTextFieldFocusLost

  private void revalidateCategoriesList() {
    categoriesList.invalidate();
    categoriesList.validate();
    categoriesList.repaint();
  }
  
  private void revalidateMenuItemsList() {
    menuItemsList.invalidate();
    menuItemsList.validate();
    menuItemsList.repaint();
  }
  
  private void revalidateBillItemsList() {
    billItemsList.invalidate();
    billItemsList.validate();
    billItemsList.repaint();
  }
  
  private void revalidateLists() {
    revalidateCategoriesList();
    revalidateMenuItemsList();
    revalidateBillItemsList();
  }
  
  private void clearCategoryList() {
    categoriesListModel.clear();
  }
  
  private void addCategory(Category category) {
    categoriesListModel.addElement(category);
  }
  
  private void clearMenuItemsList() {
    menuItemsListModel.clear();
  }
  
  private void setCategorySelected(Category category) {
    clearMenuItemsList();
    for (MenuItem i : category.getMenuItems()) {
      menuItemsListModel.addElement(i);
    }
  }
  
  public void setMenu(Menu m) {
    clearCategoryList();
    clearMenuItemsList();

    this.menu = m;
    for (Category category : menu.getCategoriesList()) {
      addCategory(category);
    }
  }
  
  private void addMenuItem(MenuItem item) {
    if (bill.doesBillHaveMenuItem(item)) {
      BillMenuItem i = bill.getBillMenuItemFromMenuItem(item);
      i.plusQuantity();
    } else {
      BillMenuItem bmi = new BillMenuItem(item);
      addBillMenuItem(bmi);
    }
    revalidateBillItemsList();
    updateTipField();
  }
  
  private void addBillMenuItem(BillMenuItem item) {
    bill.addBillMenuItem(item);
    addBillMenuItemToList(item);
  }
  
  private void addBillMenuItemToList(BillMenuItem item) {
    billItemsListModel.addElement(item);
  }
  
  private void clearBillItemsList() {
    billItemsListModel.clear();
  }
  
  public void setBill(Bill b) {
    clearBillItemsList();
    this.bill = b;
    for (BillMenuItem item : bill.getBillMenuItems()) {
      addBillMenuItemToList(item);
    }
    updateTipField();
  }
  
  public void updateTipAmount(double amount) {
    this.bill.getTip().setTipAmount(amount);
    updateTipField();
  }
  
  public void updateTipPercent(double percent) {
    this.bill.getTip().setTipPercent(percent);
    updateTipField();
  }
  
  public void updateTipField() {
    Tip tip = this.bill.getTip();
    String text = tip.getTipString(this.bill.getTotalWithoutTip());
    this.tipAmountTextField.setText(text);
    mainFrame.update(); // Update Tax Label
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private javax.swing.JButton backButton;
  private javax.swing.JLabel billItemsLabel;
  private javax.swing.JList billItemsList;
  private javax.swing.JPanel billItemsPanel;
  private javax.swing.JList categoriesList;
  private javax.swing.JPanel categoriesPanel;
  private javax.swing.JLabel categoryLabel;
  private javax.swing.JLabel descriptionLabel;
  private javax.swing.JTextPane descriptionTextPane;
  private javax.swing.JButton increaseQuantityButton;
  private javax.swing.JLabel jLabel1;
  private javax.swing.JPanel jPanel1;
  private javax.swing.JScrollPane jScrollPane1;
  private javax.swing.JScrollPane jScrollPane2;
  private javax.swing.JScrollPane jScrollPane3;
  private javax.swing.JScrollPane jScrollPane4;
  private javax.swing.JScrollPane jScrollPane5;
  private javax.swing.JTextArea jTextArea1;
  private javax.swing.JLabel menuItemsLabel;
  private javax.swing.JList menuItemsList;
  private javax.swing.JPanel menuItemsPanel;
  private javax.swing.JButton minusQuantityButton;
  private javax.swing.JTextField tipAmountTextField;
  private javax.swing.JButton tipButton1;
  private javax.swing.JButton tipButton2;
  private javax.swing.JButton tipButton3;
  private javax.swing.JButton tipButton4;
  private javax.swing.JLabel tipLabel;
  private javax.swing.JPanel tipPanel;
  private javax.swing.JLabel titleLabel;
  private javax.swing.JButton viewReceiptButton;
  // End of variables declaration//GEN-END:variables
}
