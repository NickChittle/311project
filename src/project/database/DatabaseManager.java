package project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;
import project.Bill;

import project.MenuItem;
import project.BillMenuItem;
import project.Tip;
import project.Tip.TipType;

public class DatabaseManager {
  private static boolean IS_TEST_DB = false;

  private static final String URL = "jdbc:mysql://localhost:3306/311project";
  private static final String USER = "java";
  private static final String PASSWORD = "311projectpassword";

  private Connection conn;

  public DatabaseManager() {
    try {
      conn = DriverManager.getConnection(URL, USER, PASSWORD);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
      System.out.println("Reading Fake Data");
      IS_TEST_DB = true;
    }
  }

  public List<MenuItem> getItems() {
    if (IS_TEST_DB) {
      return getTestItems();
    }

    String query = "SELECT ID, NAME, PRICE, DESCRIPTION, CATEGORY FROM ITEMS";
    List<MenuItem> items = new ArrayList<MenuItem>();
    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        int id = rs.getInt("ID");
        String name = rs.getString("NAME");
        double price = rs.getDouble("PRICE");
        String description = rs.getString("DESCRIPTION");
        String category = rs.getString("CATEGORY");
        items.add(new MenuItem(id, name, price, description, category));
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }
    return items;
  }

  public List<MenuItem> getTestItems() {
    System.out.println("Reading Fake Data");
    List<MenuItem> items = new ArrayList<MenuItem>();
    items.add(new MenuItem(0, "Pizza", 10.99, "It\'s Pretty Good", "Entree"));
    items.add(new MenuItem(1, "Burger", 9.99, "It\'s Really Good", "Entree"));
    items.add(new MenuItem(2, "Brownie", 5.99, "It\'s So Good", "Dessert"));
    items.add(new MenuItem(3, "Garlic Bread With Cheese", 5.99, "It\'s the Best", "Appetizer"));
    return items;
  }

  public void saveBill(Bill bill) {
    if (IS_TEST_DB) {
      return;
    }
    
    int billId;
    if (bill.isLoadedBill()) {
      billId = bill.getBillID();
      updateBillInDB(bill);
    }else {
      billId = createBillInDB(bill);
    }
    if (billId < 0) {
      System.out.println("Could not get proper billId");
      return;
    }
    try {
      for (BillMenuItem item : bill.getBillMenuItems()) {
        int itemId = item.getMenuItem().getId();
        int quantity = item.getQuantity();
        Statement s = conn.createStatement();
        String q = "INSERT INTO BILLS_ITEMS VALUES(" + billId + ", " + itemId + ", " + quantity + ")";
        s.executeUpdate(q);
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }
  }
  
  private void updateBillInDB(Bill bill) {
    if (!bill.isLoadedBill()) {
      return;
    }
    Tip tip = bill.getTip();
    double total = bill.getTotalWithoutTip();
    int tipType = tip.getTipType().ordinal();
    double tipAmount = tip.getTipAmount();
    double tipPercent = tip.getTipPercent();
    int billId = bill.getBillID();
    try {
      Statement s = conn.createStatement();
      String q = "DELETE FROM BILLS_ITEMS WHERE BILL_ID=" + billId;
      s.executeUpdate(q);
      q = String.format("UPDATE BILLS SET TOTAL=%f, TIP_TYPE=%d, TIP_AMOUNT=%f, TIP_PERCENT=%f WHERE ID=%d", total, tipType, tipAmount, tipPercent, billId);
      s.executeUpdate(q);
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }
  }
  
  public int createBillInDB(Bill bill) {
    Tip tip = bill.getTip();
    double total = bill.getTotalWithoutTip();
    int tipType = tip.getTipType().ordinal();
    double tipAmount = tip.getTipAmount();
    double tipPercent = tip.getTipPercent();
    String query = String.format("INSERT INTO BILLS VALUES(DEFAULT, %f, %d, %f, %f)", total, tipType, tipAmount, tipPercent);
    try {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
      ResultSet rs = stmt.getGeneratedKeys();
      if (rs.next()) {
        return rs.getInt(1);
      } else {
        System.out.println("Could not get key from inserted Bill");
        return -1;
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }
    return -1;
  }

  /**
   * Menu Items are the read in list of items.
   */
  public Bill readBill(DBBill dbBill, List<MenuItem> menuItems) {
    if (IS_TEST_DB) {
      return new Bill();
    }
    Bill bill = new Bill(dbBill.getId());
    bill.setTip(dbBill.getTip());
    String query = "SELECT ITEM_ID, QUANTITY FROM BILLS_ITEMS WHERE BILL_ID=" + dbBill.getId();
    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        int itemId = rs.getInt("ITEM_ID");
        int quantity = rs.getInt("QUANTITY");
        for (MenuItem i : menuItems) {
          if (i.getId() == itemId) {
            BillMenuItem bmi = new BillMenuItem(i);
            bmi.setQuantity(quantity);
            bill.addBillMenuItem(bmi);
            break;
          }
        }
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }

    return bill;
  }

  public List<DBBill> getBills() {
    ArrayList<DBBill> billIds = new ArrayList<DBBill>();
    if (IS_TEST_DB) {
      return billIds;
    }

    String query = "SELECT ID, TOTAL, TIP_TYPE, TIP_AMOUNT, TIP_PERCENT FROM BILLS";
    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        int id = rs.getInt("ID");
        double total = rs.getDouble("TOTAL");
        int tipType = rs.getInt("TIP_TYPE");
        double tipAmount = rs.getDouble("TIP_AMOUNT");
        double tipPercent = rs.getDouble("TIP_PERCENT");
        Tip tip = new Tip();
        TipType enumTipType = TipType.values()[tipType];
        if (enumTipType == TipType.AMOUNT) {
          tip.setTipAmount(tipAmount);
        } else if (enumTipType == TipType.PERCENT) {
          tip.setTipPercent(tipPercent);
        }
        billIds.add(new DBBill(id, total, tip));
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }
    return billIds;
  }
}
