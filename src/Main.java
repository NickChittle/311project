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
    
    //Temp creates test windows
    BillInterface BI = new BillInterface();
    
    //Add item to bill
	for(int i=0;i<10;i++)
		BI.addMenuItem("Item: " + i);
	//Removes item by index, handles out of bounds
	BI.removeMenuItem(99);
  }
}
