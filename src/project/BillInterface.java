package project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.Vector;

import javax.swing.BoxLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class BillInterface extends JFrame {
	Dimension size = new Dimension(600,500);
	JPanel billPanel;
  JPanel foodPanel;

	public BillInterface()
	{
		super("Bill Interface");

		//Border
    Border defaultBorder = new BevelBorder(BevelBorder.LOWERED);

		//Define Panels
		billPanel = new JPanel();
		JPanel bottomPanel = new JPanel();
		foodPanel = new JPanel();
		foodPanel.setBorder(defaultBorder);
    foodPanel.setLayout(new GridLayout(0, 1));
		foodPanel.add(new JLabel("Food Panel!"));

		//Prep BillPanel
		GridBagLayout billPanelLayout = new GridBagLayout();
		JScrollPane scrollingBillPanel = new JScrollPane(billPanel);
		//scrollingBillPanel.setVerticalScrollBar(new JScrollBar());
		scrollingBillPanel.setWheelScrollingEnabled(true);

		billPanel.setLayout(billPanelLayout);
		billPanel.setBorder(defaultBorder);

		//Prep billInterface
		GridBagLayout billInterfacePanel = new GridBagLayout();
		this.setLayout(billInterfacePanel);
		GridBagConstraints c=new GridBagConstraints();
		c.weightx=1;
		c.weighty=1;
		c.fill = GridBagConstraints.BOTH;
		c.gridx=0;
		c.gridy=0;
		this.add(foodPanel,c);
		c.gridx=1;
		c.gridy=0;
		this.add(scrollingBillPanel,c);
		c.gridx=0;
		c.gridy=1;
		c.weighty =0.1;
		this.add(bottomPanel,c);

		this.pack();
    this.setSize(size);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setVisible(true);
		System.out.println("End BillInterface");
	}

	@Override
	public Dimension size()
	{
		return new Dimension(0,0);
	}

  public boolean addCategory(Category category) {
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		c.ipady = category.getPreferredSize().height;
		foodPanel.add(category,c);
		return true;
  }

	public boolean addMenuItem(MenuItem item)
	{
		GridBagConstraints c = new GridBagConstraints();
		c.gridwidth = 0;
		c.weightx = 1;
		c.weighty = 1;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.anchor = GridBagConstraints.NORTH;
		BillMenuItem bmi = new BillMenuItem(item);
		c.ipady = bmi.getPreferredSize().height;
		billPanel.add(bmi,c);
		return true;
	}

	private void removeMenuItem(BillMenuItem bmi)
	{
		billPanel.remove(bmi);
	}

	public boolean removeMenuItem(int index)
	{
		if (index < 0 ||  index > billPanel.getComponents().length)
			return false;

		removeMenuItem((BillMenuItem) billPanel.getComponents()[index]);
		return true;
	}
}
