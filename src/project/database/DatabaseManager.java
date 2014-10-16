package project.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import java.util.ArrayList;
import java.util.List;

import project.MenuItem;

public class DatabaseManager {
  private static final String URL = "jdbc:mysql://localhost:3306/311project";
  private static final String USER = "java";
  private static final String PASSWORD = "311projectpassword";

  private Connection conn;

  public DatabaseManager() throws SQLException {
    conn = DriverManager.getConnection(URL, USER, PASSWORD);
  }

  public List<MenuItem> getItems() {
    String query = "SELECT NAME, PRICE, DESCRIPTION, CATEGORY FROM ITEMS";
    List<MenuItem> items = new ArrayList<MenuItem>();
    try {
      Statement stmt = conn.createStatement();
      ResultSet rs = stmt.executeQuery(query);
      while (rs.next()) {
        String name = rs.getString("NAME");
        double price = rs.getDouble("PRICE");
        String description = rs.getString("DESCRIPTION");
        String category = rs.getString("CATEGORY");
        items.add(new MenuItem(name, price, description, category));
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    } finally {
    }
    return items;
  }
}
