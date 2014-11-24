/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.awt.CardLayout;
import java.util.ArrayList;
import java.util.List;
import project.database.DatabaseManager;

/**
 *
 * @author chittle
 */
public class MainFrame extends javax.swing.JFrame {
  private static final String MAIN_PANEL_NAME = "mainPanelName";
  private static final String LOAD_BILL_PANEL_NAME = "loadBillPanelName";
  private static final String RECEIPT_PANEL_NAME = "receiptPanelName";
  private static final String BILL_PANEL_NAME = "billPanelName";
  
  private Menu menu;
  private ArrayList<Bill> bills;
  private int currentBillIndex;

  /**
   * Creates new form MainFrame
   */
  public MainFrame() {
    initComponents();
    menu = new Menu();
    billPanel1.setMenu(menu);
    bills = new ArrayList<Bill>();
    mainPanel1.setBillsList(bills);
    currentBillIndex = -1;
  }

  /**
   * This method is called from within the constructor to initialize the form.
   * WARNING: Do NOT modify this code. The content of this method is always
   * regenerated by the Form Editor.
   */
  @SuppressWarnings("unchecked")
  // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
  private void initComponents() {

    mainPanel1 = new project.MainPanel(this);
    billPanel1 = new project.BillPanel(this);
    loadBillPanel1 = new project.LoadBillPanel(this);
    receiptPanel1 = new project.ReceiptPanel(this);

    setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
    getContentPane().setLayout(new java.awt.CardLayout());
    getContentPane().add(mainPanel1, "mainPanelName");
    getContentPane().add(billPanel1, "billPanelName");
    getContentPane().add(loadBillPanel1, "loadBillPanelName");
    getContentPane().add(receiptPanel1, "receiptPanelName");

    pack();
  }// </editor-fold>//GEN-END:initComponents

  public void showBillPanel() {
    showView(BILL_PANEL_NAME);
  }

  public void showMainPanel() {
    showView(MAIN_PANEL_NAME);
  }

  public void showReceiptPanel() {
    showView(RECEIPT_PANEL_NAME);
  }

  public void showLoadBillPanel() {
    showView(LOAD_BILL_PANEL_NAME);
  }
  
  public void openLoadBillView() {
    loadBillPanel1.readBillsFromDB();
    showLoadBillPanel();
  }
  
  public void openReceiptView(int index) {
    if (index >= 0 && index < bills.size()) {
      this.receiptPanel1.setBill(bills.get(index));
    } else {
      System.out.println("Tried to open receipt for bill outside range: " + index);
    }
    
    showReceiptPanel();
  }
  
  public void openReceiptForCurrentBill() {
    openReceiptView(currentBillIndex);
  }
  
  public void openBill(int index) {
    currentBillIndex = index;
    this.billPanel1.setBill(bills.get(index));
    showBillPanel();
  }
  
  public void openNewBill(Bill bill) {
    bills.add(bill);
    currentBillIndex = bills.size() - 1;
    this.billPanel1.setBill(bill);
    resetMainPanelList();
    showBillPanel();
  }
  
  public void openNewBill() {
    Bill b = new Bill();
    openNewBill(b);
  }
  
  public void loadBill(int billId) {
    DatabaseManager db = new DatabaseManager();

    List<BillMenuItem> items = db.readBill(billId, menu.getMenuItems());
    Bill bill = new Bill();
    for (BillMenuItem item : items) {
      bill.addBillMenuItem(item);
    }
    openNewBill(bill);
  }
  
  public void saveBill() {
    DatabaseManager db = new DatabaseManager();
    if (currentBillIndex >= 0 && currentBillIndex < bills.size()) {
      Bill bill = bills.get(currentBillIndex);
      db.saveBill(bill.getBillMenuItems(), bill.getTaxManager().getTotal());
    }
  }
  
  public void resetMainPanelList() {
    mainPanel1.revalidateBillsList();
  }

  public void showView(String name) {
    CardLayout card = (CardLayout)getContentPane().getLayout();
    card.show(getContentPane(), name);
  }
  /**
   * @param args the command line arguments
   */
  public static void main(String args[]) {
    /* Set the Nimbus look and feel */
    //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
    /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
     * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
     */
    try {
      for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
        if ("Nimbus".equals(info.getName())) {
          javax.swing.UIManager.setLookAndFeel(info.getClassName());
          break;
        }
      }
    } catch (ClassNotFoundException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (InstantiationException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (IllegalAccessException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    } catch (javax.swing.UnsupportedLookAndFeelException ex) {
      java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
    }
    //</editor-fold>

    /* Create and display the form */
    java.awt.EventQueue.invokeLater(new Runnable() {
      public void run() {
        new MainFrame().setVisible(true);
      }
    });
  }

  // Variables declaration - do not modify//GEN-BEGIN:variables
  private project.BillPanel billPanel1;
  private project.LoadBillPanel loadBillPanel1;
  private project.MainPanel mainPanel1;
  private project.ReceiptPanel receiptPanel1;
  // End of variables declaration//GEN-END:variables
}
