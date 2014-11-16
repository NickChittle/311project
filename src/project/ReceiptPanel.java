package project;

import java.awt.Dimension;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;

import javax.swing.JTable;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class ReceiptPanel extends JPanel {
  private Model model;

  private JTable table;

  public ReceiptPanel(Model model) {
    this.model = model;


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
  }
}
