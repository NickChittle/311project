/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package project;

import java.util.ArrayList;
import java.util.List;
import javax.swing.table.AbstractTableModel;

public class Bill extends AbstractTableModel {
  public static String[] columnNames = {"Name", "Price", "Quantity", "Amount"};
  private ArrayList<BillMenuItem> billMenuItems;
  private TaxManager taxManager;
  private Tip tip;

  public Bill() {
    billMenuItems = new ArrayList<BillMenuItem>();
    this.taxManager = new TaxManager(this);
    tip = new Tip();
  }
  
  public Tip getTip() {
    return tip;
  }
  
  public double getTotal() {
    return taxManager.getTaxedTotal();
  }
  
  public TaxManager getTaxManager() {
    return taxManager;
  }

  public List<BillMenuItem> getBillMenuItems() {
    return billMenuItems;
  }
  
  public boolean doesBillHaveMenuItem(MenuItem item) {
    for (BillMenuItem i : getBillMenuItems()) {
      if (i.getMenuItem() == item) {
        return true;
      }
    }
    return false;
  }

  public BillMenuItem getBillMenuItemFromMenuItem(MenuItem item) {
    for (BillMenuItem i : getBillMenuItems()) {
      if (i.getMenuItem() == item) {
        return i;
      }
    }
    return null;
  }

  public void addBillMenuItem(BillMenuItem item) {
    billMenuItems.add(item);
    taxManager.addBillMenuItem(item);
    fireTableDataChanged();
  }

  @Override
  public String getColumnName(int col) {
    return columnNames[col];
  }

  @Override
  public int getRowCount() {
    return getBillMenuItems().size();
  }

  @Override
  public int getColumnCount() {
    return columnNames.length;
  }

  @Override
  public Object getValueAt(int row, int col) {
    BillMenuItem item = getBillMenuItems().get(row);
    switch (col) {
      case 0:
        return item.getName();
      case 1:
        return item.getPriceForOne();
      case 2:
        return item.getQuantity();
      case 3:
        return String.format("%.2f", item.getPrice());
    }
    return "";
  }
  
  @Override
  public String toString() {
    return taxManager.getTaxLabelText();
  }
}
