package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import project.database.DatabaseManager;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();;

    DatabaseManager db = new DatabaseManager();
    menuItems.addAll(db.getItems());
    for (MenuItem item : menuItems) {
      System.out.println(item);
    }

    Map<String, Category> categorizedMenuItems = new HashMap<String, Category>();
    for (MenuItem item : menuItems) {
      if (!categorizedMenuItems.containsKey(item.getCategory())) {
        categorizedMenuItems.put(item.getCategory(), new Category(item.getCategory()));
      }
      categorizedMenuItems.get(item.getCategory()).addMenuItem(item);
    }

    // Temp creates test windows
    BillInterface BI = new BillInterface();

    for (Category c : categorizedMenuItems.values()) {
      BI.addCategory(c);
    }

    boolean noTaxTest = false;
    if (noTaxTest) {
      MenuItem testCheapItemForNoTax = new MenuItem("Cheap Item", 2.99, "Really Cheap", "Appetizer");
      BI.addMenuItem(testCheapItemForNoTax);
    } else {
      // Add item to bill
      for (MenuItem item : menuItems) {
        BI.addMenuItem(item);
      }
    }
  }
}
