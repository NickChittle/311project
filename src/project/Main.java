package project;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;

import project.database.DatabaseManager;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
    DatabaseManager db;
    ArrayList<MenuItem> menuItems = new ArrayList<MenuItem>();;
    try {
      db = new DatabaseManager();
      menuItems.addAll(db.getItems());
      for (MenuItem item : menuItems) {
        System.out.println(item);
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
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

    // Add item to bill
    for (MenuItem item : menuItems) {
      BI.addMenuItem(item);
    }
  }
}
