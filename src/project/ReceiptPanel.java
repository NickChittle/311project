package project;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class ReceiptPanel extends JPanel {
  private Model model;
  private MainFrame mainFrame;

  private JTable table;

  public ReceiptPanel(Model model, MainFrame mainFrame) {
    this.model = model;
    this.mainFrame = mainFrame;

    GridBagLayout layout = new GridBagLayout();
    GridBagConstraints c = new GridBagConstraints();
    setLayout(layout);
    table = new JTable(model);
    JScrollPane scrollPane = new JScrollPane(table);
    scrollPane.setPreferredSize(new Dimension(600, 300));

    c.gridx = 0;
    c.gridy = 0;
    c.weightx = 1;
    c.fill = GridBagConstraints.HORIZONTAL;
    add(scrollPane, c);

    JPanel taxPanel = new JPanel();
    taxPanel.setLayout(new GridLayout());
    JLabel taxLabel = model.getTaxManager().getTaxLabel();  // Managed by the TaxManager object.
    taxPanel.add(taxLabel);

    c.gridy = 1;
    add(taxPanel, c);
    c.gridy = 2;
    add(createBackButton(), c);
    c.gridy = 3;
    add(createSaveBillButton(), c);
    c.gridy = 4;
    add(createLoadBillButton(), c);
  }

  public JButton createSaveBillButton() {
    JButton button = new JButton("Save Bill");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainFrame.saveBill();
      }
    });
    return button;
  }

  public JButton createLoadBillButton() {
    JButton button = new JButton("Load Bill");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainFrame.showLoadBillLayout();
      }
    });
    return button;
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
