package project;

import java.util.List;

import java.awt.CardLayout;
import javax.swing.JFrame;
import javax.swing.JPanel;

import project.database.DatabaseManager;

public class MainFrame {
  public static final String BILL_LAYOUT_NAME = "billLayout";
  public static final String RECEIPT_LAYOUT_NAME = "receiptLayout";

  private JFrame frame;

  private JPanel mainPanel;
  private CardLayout cardLayout;
  private BillInterface billPanel;
  private ReceiptPanel receiptPanel;

  private Model model;

  public MainFrame() {
    super();

    model = new Model();

    frame = new JFrame("Pi Restaurant");

    mainPanel = new JPanel();
    cardLayout = new CardLayout();
    mainPanel.setLayout(cardLayout);

    billPanel = new BillInterface(model, this);
    receiptPanel = new ReceiptPanel(model, this);

    mainPanel.add(billPanel, BILL_LAYOUT_NAME);
    mainPanel.add(receiptPanel, RECEIPT_LAYOUT_NAME);

    billPanel.setMenu(model.getMenu());
    addSomeBillItems();

    //loadBill(5);

    //showLayout(RECEIPT_LAYOUT_NAME);
    showLayout(BILL_LAYOUT_NAME);
    frame.add(mainPanel);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    frame.pack();
    frame.setVisible(true);
  }

  public void saveBill() {
    DatabaseManager db = new DatabaseManager();
    db.saveBill(model.getBillMenuItems());
  }

  public void loadBill(int billId) {
    billPanel.clearBillMenuItems();
    DatabaseManager db = new DatabaseManager();

    List<BillMenuItem> items = db.readBill(billId, model.getMenu().getMenuItems());
    for (BillMenuItem item : items) {
      billPanel.addBillMenuItem(item);
    }
  }

  public void showLayout(String name) {
    cardLayout.show(mainPanel, name);
  }

  public void addSomeBillItems() {
    int count = 0;
    for (MenuItem item : model.getMenu().getMenuItems()) {
      billPanel.addMenuItem(item);
      count++;
      if (count >= 6) {
        break;
      }
    }
  }
}
