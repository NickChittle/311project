package project;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

/**
 * Written by Chris Bennett for 60-311
 * Bill Menu Item used to show
 */

public class BillMenuItem extends JPanel
{
  //Size of the panel
  public static final int CONST_HEIGHT = 50;
  Dimension size = new Dimension(200,CONST_HEIGHT);

  MenuItem item;
  int quantity;

  BillMenuItem(MenuItem item)
  {
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

  public double getPrice()
  {
    return item.getPrice() * quantity;
  }

  public String getName()
  {
    return item.getName();
  }

  @Override
  public String toString()
  {
    return "Name: " + getName();
  }
}
