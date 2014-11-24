package project;

import java.util.List;
import java.util.ArrayList;

public class TaxManager implements Observer, Subject {
  private ArrayList<Observer> observers = new ArrayList<Observer>();
  private Bill bill;
  private MainFrame mainFrame;
  // Swings components can only have one parent, so we have multiple versions of them.
  

  public TaxManager(Bill bill) {
    this.bill = bill;
    updateTaxLabel();
  }

  public List<BillMenuItem> getBillMenuItems() {
    return bill.getBillMenuItems();
  }

  public void addBillMenuItem(BillMenuItem i) {
    i.subscribe(this);
    updateTaxLabel();
  }
  
  public String getTaxLabelText() {
    double subtotal = getSubtotal();
    double tax = calculateTax(subtotal);
    double taxedTotal = subtotal + tax;
    double tip = bill.getTip().getTip(taxedTotal);
    double total = taxedTotal + tip;

    return String.format("Subtotal: $%.2f, Tax: $%.2f, Tip $%.2f, Total $%.2f", subtotal, tax, tip, total);
  }

  public void updateTaxLabel() {
    publish();
  }

  public double getTaxedTotal() {
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

  @Override
  public void update() {
    updateTaxLabel();
  }

  @Override
  public void subscribe(Observer o) {
    this.observers.add(o);
  }

  @Override
  public void publish() {
    for (Observer o : this.observers) {
      o.update();
    }
  }
}
