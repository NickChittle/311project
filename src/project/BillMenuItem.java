package project;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.ArrayList;

import javax.swing.JButton;
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

  private JLabel priceLabel;
  private JLabel quantityLabel;

  private JButton minusQuantityButton;
  private JButton plusQuantityButton;

  BillMenuItem(MenuItem item) {
    this.item = item;
    this.quantity = 1;

    JLabel itemNameLabel = new JLabel(getName());
    priceLabel = new JLabel();
    quantityLabel = new JLabel();
    Border menuItemBorder = new BevelBorder(BevelBorder.RAISED);

    minusQuantityButton = new JButton("-");
    minusQuantityButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        minusQuantity();
      }
    });

    plusQuantityButton = new JButton("+");
    plusQuantityButton.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        plusQuantity();
      }
    });

    GridBagLayout layout = new GridBagLayout();
    this.setLayout(layout);
    this.setBorder(menuItemBorder);

    GridBagConstraints c = new GridBagConstraints();
    JPanel quantityPanel = new JPanel();
    quantityPanel.setLayout(new GridBagLayout());

    c.weightx = 1;
    c.gridx = 0;
    c.gridy = 0;
    quantityPanel.add(minusQuantityButton, c);
    c.gridx = 1;
    quantityPanel.add(quantityLabel, c);
    c.gridx = 2;
    quantityPanel.add(plusQuantityButton, c);

    c.fill = GridBagConstraints.HORIZONTAL;
    c.weightx = 1;
    c.gridy = 0;
    c.gridx = 0;
    itemNameLabel.setPreferredSize(new Dimension(180, 30));
    this.add(itemNameLabel, c);
    priceLabel.setPreferredSize(new Dimension(60, 30));
    c.gridx = 1;
    this.add(priceLabel, c);
    c.gridy = 1;
    c.gridx = 0;
    c.weightx = 1;
    quantityPanel.setPreferredSize(new Dimension(100, 30));
    this.add(quantityPanel, c);

    updateLabels();

    this.setPreferredSize(size);
    this.setSize(size);
    this.setVisible(true);
  }

  public MenuItem getMenuItem() {
    return item;
  }

  public void updateLabels() {
    priceLabel.setText(String.format("$%.2f", getPrice()));
    quantityLabel.setText("" + getQuantity());
  }

  public void plusQuantity() {
    quantity++;
    updateLabels();
    publish();
  }

  public void minusQuantity() {
    if (quantity != 0) {
      quantity--;
    }
    updateLabels();
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
    return "Name: " + getName();
  }
}
