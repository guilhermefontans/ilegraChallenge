package br.com.ilegra.entities;

import java.util.HashSet;

/**
 * 
 * @author guilherme
 *
 */
public class Sale implements IEntity{

	private int id;
	private Salesman salesMan;
	private HashSet<SaleItem> saleItems;
	private double total;
	
	public Sale(int id, HashSet<SaleItem> saleItems) {
		this.id = id;
		this.saleItems = saleItems;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Salesman getSalesMan() {
		return salesMan;
	}
	public void setSalesMan(Salesman salesMan) {
		this.salesMan = salesMan;
	}
	public HashSet<SaleItem> getSaleItems() {
		return saleItems;
	}
	public void setSaleItems(HashSet<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}
}
