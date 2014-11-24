package project;

import java.util.ArrayList;


/**
 * Written by Chris Bennett for 60-311
 * Bill Menu Item used to show
 */

public class BillMenuItem implements Subject {

  private MenuItem item;
  private int quantity;
  private ArrayList<Observer> observers = new ArrayList<Observer>();

  public BillMenuItem(MenuItem item) {
    this.item = item;
    this.quantity = 1;
  }

  public MenuItem getMenuItem() {
    return item;
  }

  public void setQuantity(int q) {
    this.quantity = q;
    publish();
  }

  public void plusQuantity() {
    quantity++;
    publish();
  }

  public void minusQuantity() {
    if (quantity != 0) {
      quantity--;
    }
    publish();
  }

  public void subscribe(Observer o) {
    this.observers.add(o);
  }

  public void publish() {
    for (Observer o : this.observers) {
      o.update();
    }
  }

  public int getQuantity() {
    return quantity;
  }

  public double getPrice() {
    return item.getPrice() * quantity;
  }

  public double getPriceForOne() {
    return item.getPrice();
  }

  public String getName() {
    return item.getName();
  }

  @Override
  public String toString() {
    return String.format("%s, Qty: %d, $%.2f", getName(), getQuantity(), getPrice());
  }
}
