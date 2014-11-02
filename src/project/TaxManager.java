package project;

import java.util.ArrayList;

import javax.swing.JLabel;

public class TaxManager implements Observer {
  private JLabel label;
  private ArrayList<BillMenuItem> menuItems;

  public TaxManager(JLabel l) {
    this.label = l;
    this.menuItems = new ArrayList<BillMenuItem>();
  }

  public void addBillMenuItem(BillMenuItem i) {
    menuItems.add(i);
    i.subscribe(this);
    updateTaxLabel();
  }

  public void updateTaxLabel() {
    double subtotal = getSubtotal();
    double tax = calculateTax(subtotal);
    double total = subtotal + tax;

    String text = String.format("Subtotal: $%.2f, Tax: $%.2f, Total $%.2f", subtotal, tax, total);
    label.setText(text);
  }

  public double getSubtotal() {
    double subtotal = 0;
    for (BillMenuItem i : menuItems) {
      subtotal += i.getPrice();
    }
    return subtotal;
  }

  public double calculateTax(double subtotal) {
    double tax = 0;
    if (subtotal >= 5) {
      tax = 0.13 * subtotal;
    }
    return tax;
  }

  public void update() {
    updateTaxLabel();
  }
}
