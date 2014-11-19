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

import java.util.ArrayList;

public class Category extends JPanel {
  //Size of the panel
  public static final int CONST_HEIGHT = 50;
  Dimension size = new Dimension(200,CONST_HEIGHT);

  private String categoryName;
  private ArrayList<MenuItem> items;

  public Category(String categoryName) {
    this.categoryName = categoryName;
    this.items = new ArrayList<MenuItem>();
    initLayout();
  }

  public Category(String categoryName, ArrayList<MenuItem> items) {
    this.categoryName = categoryName;
    initLayout();
    for (MenuItem item : items) {
      addMenuItem(item);
    }
  }

  public void addMenuItem(MenuItem item) {
    this.items.add(item);

  }

  private void initLayout() {
    GridLayout gridLayout = new GridLayout(0,1);
    Border menuItemBorder = new BevelBorder(BevelBorder.RAISED);

    this.setBorder(menuItemBorder);
    this.add(new JLabel(getName()));
    this.setLayout(gridLayout);
    this.setPreferredSize(size);
    this.setSize(size);
    this.setVisible(true);

    
  }

  public String getName() {
    return this.categoryName;
  }

  @Override
  public String toString() {
    return "Name: " + getName();
  }

  public Object[] getMenuItems() {
    return items.toArray();
  }
}
