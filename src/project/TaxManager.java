package project;

import java.util.List;
import java.util.ArrayList;

import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class TaxManager implements Observer {
  private JLabel taxLabel;
  private Model model;
  // Swings components can only have one parent, so we have multiple versions of them.
  private ArrayList<JLabel> taxLabels;

  public TaxManager(Model model) {
    this.model = model;
    taxLabels = new ArrayList<JLabel>();
    updateTaxLabel();
  }

  public JLabel getTaxLabel() {
    JLabel label = new JLabel("Tax Label");
    taxLabels.add(label);
    updateTaxLabel();
    return label;
  }

  public List<BillMenuItem> getBillMenuItems() {
    return model.getBillMenuItems();
  }

  public void addBillMenuItem(BillMenuItem i) {
    i.subscribe(this);
    updateTaxLabel();
  }

  public void updateTaxLabel() {
    double subtotal = getSubtotal();
    double tax = calculateTax(subtotal);
    double total = subtotal + tax;

    String text = String.format("Subtotal: $%.2f, Tax: $%.2f, Total $%.2f", subtotal, tax, total);
    for (JLabel label : taxLabels) {
      label.setText(text);
    }
  }

  public double getTotal() {
    double subtotal = getSubtotal();
    double tax = calculateTax(subtotal);
    return subtotal + tax;
  }

  public double getSubtotal() {
    double subtotal = 0;
    for (BillMenuItem i : getBillMenuItems()) {
      subtotal += i.getPrice();
    }
    return subtotal;
  }

  public double calculateTax(double subtotal) {
    double tax = 0;
    if (subtotal <= 4) {
      tax = 0.05 * subtotal;
    } else {
      tax = 0.13 * subtotal;
    }
    return tax;
  }

  public void update() {
    updateTaxLabel();
  }
}
