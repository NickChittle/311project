package project;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class MainFrame {
  public static final String BILL_LAYOUT_NAME = "billLayout";

  private JFrame frame;

  private JPanel mainPanel;
  private CardLayout cardLayout;
  private BillInterface billPanel;

  private Menu menu;

  public MainFrame() {
    super();

    frame = new JFrame("Pi Restaurant");

    mainPanel = new JPanel();
    cardLayout = new CardLayout();
    mainPanel.setLayout(cardLayout);

    billPanel = new BillInterface();

    mainPanel.add(billPanel, BILL_LAYOUT_NAME);

    menu = new Menu();
    billPanel.setMenu(menu);
    addSomeBillItems();

    frame.add(mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public void showLayout(String name) {
    cardLayout.show(mainPanel, name);
  }

  public void addSomeBillItems() {
    for (MenuItem item : menu.getMenuItems()) {
      billPanel.addMenuItem(item);
    }
  }
}
