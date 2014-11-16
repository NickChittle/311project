package project;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Written by Chris Bennett for 60-311
 * Bill Menu Item used to show
 */

public class BillMenuItem extends JPanel implements Subject {
  //Size of the panel
  public static final int CONST_HEIGHT = 50;
  private Dimension size = new Dimension(200,CONST_HEIGHT);

  private MenuItem item;
  private int quantity;
  private ArrayList<Observer> observers = new ArrayList<Observer>();

  BillMenuItem(MenuItem item) {
    this.item = item;
    this.quantity = 1;

    JLabel JLbl_itemName = new JLabel(getName());
    JLabel JLbl_price = new JLabel("$" + getPrice());
    GridLayout gridLayout = new GridLayout(0,2);
    Border menuItemBorder = new BevelBorder(BevelBorder.RAISED);

    this.setBorder(menuItemBorder);
    this.add(JLbl_itemName);
    this.add(JLbl_price);
    this.setLayout(gridLayout);
    this.setPreferredSize(size);
    this.setSize(size);
    this.setVisible(true);

    this.addMouseListener(new MouseListener() {
      @Override
      public void mouseClicked(MouseEvent e) {
        publish();
        System.out.println("You clicked on "+ ((BillMenuItem) e.getComponent()));
      }

    @Override
    public void mouseEntered(MouseEvent arg0) {
      // TODO Auto-generated method stub
    }

    @Override
    public void mouseExited(MouseEvent arg0) {
      // TODO Auto-generated method stub
    }

    @Override
    public void mousePressed(MouseEvent arg0) {
      // TODO Auto-generated method stub
    }

    @Override
    public void mouseReleased(MouseEvent arg0) {
      // TODO Auto-generated method stub
    }
    }); // addMouseListener
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
    return "Name: " + getName();
  }
}
