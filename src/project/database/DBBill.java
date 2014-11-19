package project.database;

public class DBBill {
  private int billId;
  private double total;

  public DBBill(int id, double total) {
    this.billId = id;
    this.total = total;
  }

  public int getId() {
    return billId;
  }

  public double getTotal() {
    return total;
  }

  public String toString() {
    return String.format("%d : $%.2f", getId(), getTotal());
  }
}
