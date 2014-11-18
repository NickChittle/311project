package tests;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import project.BillMenuItem;
import project.MenuItem;
import project.Model;
import project.TaxManager;

public class TaxManagerTest {
	Model model;
	TaxManager taxMan;
	BillMenuItem bItem;
	MenuItem cheapBurger = new MenuItem("Cheap Burger", 2.00, "Burger to test tax calculations under $4", "TestItems");
	MenuItem cheapPop = new MenuItem("Cheap Pop", 1.00, "Pop to test tax calculations of multiple things, under $4", "TestItems");
	MenuItem expensiveBurger = new MenuItem("Expensive Burger", 10.00, "Burger to test tax calculations above $4", "TestItems");
	//test for bill under $4, for 5% tax.
	@Test
	public void reducedTaxOneItem() {
		model = new Model();
		bItem = new BillMenuItem(cheapBurger);
		model.addBillMenuItem(bItem);
		taxMan = model.getTaxManager();
		
		assertTrue("Cheap Burger not added to Bill.", model.doesBillHaveMenuItem(cheapBurger));
		
		double cheapBurgerPrice = cheapBurger.getPrice();
		double subtotal = taxMan.getSubtotal();
		double tax = taxMan.calculateTax(subtotal);
		
		assertTrue("SubTotal not " + cheapBurgerPrice, subtotal == cheapBurgerPrice);
		assertTrue("Tax not " + (cheapBurgerPrice * .05), tax == cheapBurgerPrice * .05);
	}
	//test for bill under $4, with multiple items
	@Test
	public void reducedTaxMultipleItems(){
		model = new Model();
		bItem = new BillMenuItem(cheapBurger);
		model.addBillMenuItem(bItem);
		bItem = new BillMenuItem(cheapPop);
		model.addBillMenuItem(bItem);
		taxMan = model.getTaxManager();
		
		assertTrue("Cheap Burger not added to Bill.", model.doesBillHaveMenuItem(cheapBurger));
		assertTrue("Cheap Pop not added to Bill.", model.doesBillHaveMenuItem(cheapPop));
		
		double cheapBurgerPrice = cheapBurger.getPrice();
		double cheapPopPrice = cheapPop.getPrice();
		double sub = cheapBurgerPrice + cheapPopPrice;
		double subtotal = taxMan.getSubtotal();
		double tax = taxMan.calculateTax(subtotal);
		
		assertTrue("SubTotal not " + sub, subtotal == sub);
		assertTrue("Tax not " + (sub * .05), tax == sub * .05);
	}
	//test for bill exactly $4
	@Test
	public void reducedTax(){
		model = new Model();
		bItem = new BillMenuItem(cheapBurger);
		bItem.plusQuantity();
		model.addBillMenuItem(bItem);
		taxMan = model.getTaxManager();
		
		assertTrue("Cheap Burger not added to Bill.", model.doesBillHaveMenuItem(cheapBurger));

		double cheapBurgerPrice = cheapBurger.getPrice();
		double sub = cheapBurgerPrice * 2;
		double subtotal = taxMan.getSubtotal();
		double tax = taxMan.calculateTax(subtotal);
		
		assertTrue("Subtotal not " + sub, subtotal == sub);
		assertTrue("Tax not " + (sub * .05), tax == sub * .05);
	}
	//test for bill over $4 with one item
	@Test
	public void bigTaxOneItem(){
		model = new Model();
		bItem = new BillMenuItem(expensiveBurger);
		model.addBillMenuItem(bItem);
		taxMan = model.getTaxManager();
		
		assertTrue("Expensive Burger not added to Bill.", model.doesBillHaveMenuItem(expensiveBurger));
		
		double expensiveBurgerPrice = expensiveBurger.getPrice();
		
		double subtotal = taxMan.getSubtotal();
		double tax = taxMan.calculateTax(subtotal);
		
		assertTrue("SubTotal not " + expensiveBurgerPrice, subtotal == expensiveBurgerPrice);
		assertTrue("Tax not " + (expensiveBurgerPrice * .13), tax == expensiveBurgerPrice * .13);
	}
	//test for bill over $4 with one item
	@Test
	public void bigTaxMultipleItems(){
		model = new Model();
		bItem = new BillMenuItem(expensiveBurger);
		model.addBillMenuItem(bItem);
		bItem = new BillMenuItem(cheapBurger);
		model.addBillMenuItem(bItem);
		bItem = new BillMenuItem(cheapPop);
		model.addBillMenuItem(bItem);
		taxMan = model.getTaxManager();
		
		assertTrue("Expensive Burger not added to Bill.", model.doesBillHaveMenuItem(expensiveBurger));
		assertTrue("Cheap Burger not added to Bill.", model.doesBillHaveMenuItem(cheapBurger));
		assertTrue("Cheap Pop not added to Bill.", model.doesBillHaveMenuItem(cheapPop));

		double expensiveBurgerPrice = expensiveBurger.getPrice();
		double cheapBurgerPrice = cheapBurger.getPrice();
		double cheapPopPrice = cheapPop.getPrice();
		double sub = cheapBurgerPrice + cheapPopPrice + expensiveBurgerPrice;
		double subtotal = taxMan.getSubtotal();
		double tax = taxMan.calculateTax(subtotal);
		
		assertTrue("Subtotal not " + sub, subtotal == sub);
		assertTrue("Tax not " + (sub * .13), tax == sub * .13);
	}
}
