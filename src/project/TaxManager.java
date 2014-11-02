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
    calculateTax();
  }

  public void calculateTax() {
    double subtotal = 0;
    for (BillMenuItem i : menuItems) {
      subtotal += i.getPrice();
    }
    double tax = 0;;
    if (subtotal >= 5) {
      tax = 0.13 * subtotal;
    }
    double total = tax + subtotal;

    String text = String.format("Subtotal: %.2f, Tax: %.2f, Total %.2f", subtotal, tax, total);
    label.setText(text);
  }

  public void update() {
    calculateTax();
  }
}
