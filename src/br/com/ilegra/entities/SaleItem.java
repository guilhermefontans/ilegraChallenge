package br.com.ilegra.entities;

/**
 * 
 * @author guilherme
 *
 */
public class SaleItem implements IEntity {
	
	private int id;
	private int quantity;
	private double price;
	private double totalItem;
	
	public SaleItem(int id, int quantity, double price) {
		this.id = id;
		this.quantity = quantity;
		this.price = price;
		this.totalItem = quantity * price;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public double getTotalItem() {
		return totalItem;
	}

	public void setTotalItem(double totalItem) {
		this.totalItem = totalItem;
	}
}
