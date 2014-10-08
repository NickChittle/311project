import database.DatabaseManager;
import java.sql.SQLException;

public class Main {
  public static void main(String[] args) {
    System.out.println("Hello World");
    DatabaseManager db;
    try {
      db = new DatabaseManager();
      for (String item : db.getItems()) {
        System.out.println(item);
      }
    } catch (SQLException e) {
      System.out.println("SQLException: " + e.toString());
    }
  }
}
