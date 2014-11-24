package project.database;

import project.Tip;

public class DBBill {
  private int billId;
  private double total;
  private Tip tip;

  public DBBill(int id, double total, Tip tip) {
    this.billId = id;
    this.total = total;
    this.tip = tip;
  }

  public int getId() {
    return billId;
  }

  public double getTotal() {
    return total;
  }
  
  public Tip getTip() {
    return tip;
  }

  public String toString() {
    return String.format("%d - Total: $%.2f, Tip: %s", getId(), getTotal(), tip.getLoadTipString(getTotal()));
  }
}
