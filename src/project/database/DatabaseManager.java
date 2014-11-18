package project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import project.MenuItem;
import project.BillMenuItem;

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
    } finally {
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

  public void saveBill(List<BillMenuItem> billMenuItems) {
    if (IS_TEST_DB) {
      return;
    }
    String query = "INSERT INTO BILLS VALUES (DEFAULT)";
    try {
      Statement stmt = conn.createStatement();
      stmt.executeUpdate(query, Statement.RETURN_GENERATED_KEYS);
      ResultSet rs = stmt.getGeneratedKeys();
      int billId;
      if (rs.next()) {
        billId = rs.getInt(1);
      } else {
        System.out.println("Could not get key from inserted Bill");
        return;
      }
      for (BillMenuItem item : billMenuItems) {
        int itemId = item.getMenuItem().getId();
        int quantity = item.getQuantity();
        Statement s = conn.createStatement();
        String q = "INSERT INTO BILLS_ITEMS VALUES(" + billId + ", " + itemId + ", " + quantity + ")";
        s.executeUpdate(q);
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    } finally {
    }
  }

  /**
   * Menu Items are the read in list of items.
   */
  public List<BillMenuItem> readBill(int billId, List<MenuItem> menuItems) {
    ArrayList<BillMenuItem> items = new ArrayList<BillMenuItem>();
    if (IS_TEST_DB) {
      return items;
    }
    String query = "SELECT ITEM_ID, QUANTITY FROM BILLS_ITEMS WHERE BILL_ID=" + billId;
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
            items.add(bmi);
            break;
          }
        }
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    } finally {
    }

    return items;
  }
}
