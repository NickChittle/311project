package project;

import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;

public class BillInterface extends JPanel {
  private Dimension size = new Dimension(600,500);
  private JPanel billPanel;
  private JPanel foodPanel;

  private Model model;
  private Menu menu;
  private MainFrame mainFrame;
  private JList jLst; 
  
  public BillInterface(Model model, MainFrame mainFrame) {
    this.model = model;
    this.mainFrame = mainFrame;

    //Border
    Border defaultBorder = new BevelBorder(BevelBorder.LOWERED);

    //Define Panels
    JPanel taxPanel = new JPanel();
    taxPanel.setBorder(defaultBorder);
    taxPanel.setLayout(new GridLayout());
    JLabel taxLabel = model.getTaxManager().getTaxLabel();  // Managed by the TaxManager object.
    taxPanel.add(taxLabel);

    taxPanel.setBorder(defaultBorder);
    billPanel = new JPanel();

    foodPanel = new JPanel();
    foodPanel.setBorder(defaultBorder);
    foodPanel.setLayout(new GridLayout(0, 1));

  
    //Prep BillPanel
    GridBagLayout billPanelLayout = new GridBagLayout();
    JScrollPane scrollingBillPanel = new JScrollPane(billPanel);
    scrollingBillPanel.getVerticalScrollBar().setUnitIncrement(16);
    scrollingBillPanel.setWheelScrollingEnabled(true);

    billPanel.setLayout(billPanelLayout);
    billPanel.setBorder(defaultBorder);

    //Prep billInterface
    GridBagLayout billInterfacePanel = new GridBagLayout();
    setLayout(billInterfacePanel);
    GridBagConstraints c = new GridBagConstraints();
    c.weightx = 1;
    c.weighty = 1;
    c.fill = GridBagConstraints.BOTH;
    c.gridx = 0;
    c.gridy = 0;
    this.add(foodPanel, c);
    c.gridx = 1;
    c.gridy = 0;
    this.add(scrollingBillPanel, c);
    c.gridx = 0;
    c.gridy = 1;
    c.weighty = 0.1;
    this.add(taxPanel, c);
    c.gridx = 1;
    c.gridy = 1;
    c.weighty = 0.1;
    this.add(createReceiptButton(), c);
  }

  public JButton createReceiptButton() {
    JButton button = new JButton("View Receipt");
    button.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        mainFrame.showLayout(MainFrame.RECEIPT_LAYOUT_NAME);
      }
    });
    return button;
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
    category.addMouseListener(new MouseListener() {
	      @Override
	      public void mouseClicked(MouseEvent e) {
	        // Make this expand the category.
	        System.out.println("You clicked on " + ((Category) e.getComponent()));
	        
	        int componentIndex =-1;
	        int listIndex =-1;
	        int index=0;
  		for(Component comp : foodPanel.getComponents())
  		{
  			if (comp == e.getComponent())
  			{
  				componentIndex=index;
  			}
  			if (comp == jLst)
  			{
  				
  				listIndex=index;
  			}
  			index++;
  		}
	        
	        
	        if(listIndex != -1)
	        {
	        	foodPanel.remove(jLst);
	        	System.out.println("remove");
	        	if (componentIndex > listIndex) componentIndex--;
	        }
	        
	        if(listIndex != componentIndex+1)
	        {	    		
	    		
	        	Object[] items = ((Category) e.getComponent()).getMenuItems();
	    		
	    		jLst = new JList<Object>(items);
	    		jLst.setPreferredSize(new Dimension(200,50));
	        	jLst.addMouseListener(new MouseAdapter() 
	        	{
	        	    public void mouseClicked(MouseEvent evt) 
	        	    {
	        	        JList<Object> list = (JList<Object>)evt.getSource();
	        	        if (evt.getClickCount() == 2) 
	        	        {
	        	           addMenuItem((MenuItem)jLst.getSelectedValue());
	        	        }	        	        
	        	    }
	        	});
	    		
	    		
	    		
	    		
	    		foodPanel.add(jLst, componentIndex+1);
	        }
	        foodPanel.revalidate();
      	foodPanel.repaint();
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
    return true;
  }

  public boolean addMenuItem(MenuItem item) {
    if (model.doesBillHaveMenuItem(item)) {
      BillMenuItem i = model.getBillMenuItemFromMenuItem(item);
      i.plusQuantity();
    } else {
      GridBagConstraints c = new GridBagConstraints();
      c.gridwidth = 0;
      c.weightx = 1;
      c.weighty = 1;
      c.fill = GridBagConstraints.HORIZONTAL;
      c.anchor = GridBagConstraints.NORTH;

      BillMenuItem bmi = new BillMenuItem(item);
      model.addBillMenuItem(bmi);
      c.ipady = bmi.getPreferredSize().height;
      billPanel.add(bmi,c);
    }

    return true;
  }

  private void removeMenuItem(BillMenuItem bmi) {
    billPanel.remove(bmi);
  }

  public boolean removeMenuItem(int index) {
    if (index < 0 ||  index > billPanel.getComponents().length)
      return false;
    removeMenuItem((BillMenuItem) billPanel.getComponents()[index]);
    return true;
  }

  public void setMenu(Menu menu) {
    this.menu = menu;
    foodPanel.removeAll();
    billPanel.removeAll();
    for (Category c : menu.getCategoriesList()) {
      addCategory(c);
    }
  }
}
