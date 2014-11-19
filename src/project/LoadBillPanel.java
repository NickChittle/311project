package project;

import java.util.List;
import java.util.ArrayList;

import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;

import project.database.DatabaseManager;
import project.database.DBBill;

public class LoadBillPanel extends JPanel {
  private MainFrame mainFrame;
  private JList billList;

  public LoadBillPanel(MainFrame mainFrame) {
    this.mainFrame = mainFrame;
    createBillListObject();
    readBillsFromDB();

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(layout);
    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 1;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(billList, c);
    c.gridy = 1;
    add(createBackButton(), c);
  }

  private void createBillListObject() {
    billList = new JList();
    billList.addMouseListener(new MouseAdapter() {
      public void mouseClicked(MouseEvent evt) {
        JList<Object> list = (JList<Object>)evt.getSource();
        if (evt.getClickCount() == 2) {
          loadBillClick((DBBill)billList.getSelectedValue());
        }
      }
    });
  }

  public void readBillsFromDB() {
    DatabaseManager db = new DatabaseManager();
    List<DBBill> bills = db.getBills();
    Object[] listArray = bills.toArray();
    billList.setListData(listArray);
  }

  public void loadBillClick(DBBill bill) {
    mainFrame.loadBill(bill.getId());
    mainFrame.showLayout(MainFrame.BILL_LAYOUT_NAME);
  }

  public JButton createBackButton() {
    JButton button = new JButton("Back");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainFrame.showBillInterfaceLayout();
      }
    });
    return button;
  }
}
