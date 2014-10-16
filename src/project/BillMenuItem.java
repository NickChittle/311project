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
  //JFrame Objects
  JLabel JLbl_itemName;
  JLabel JLbl_price;
  //Size of the panel

  int CONST_HEIGHT = 50;
  Dimension size = new Dimension(200,CONST_HEIGHT);
  int price;
  String name;

  BillMenuItem(String name)
  {
    this.name = name;
    this.price = 5;
    JLbl_itemName = new JLabel(name);
    JLbl_price = new JLabel("$" + price);
    GridLayout gridLayout =new GridLayout(0,2);
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

  public int getPrice()
  {
    return price;
  }

  public String getName()
  {
    return name;
  }

  @Override
  public String toString()
  {
    return "Name: " + name;
  }
}
