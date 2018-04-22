package br.com.ilegra.builders;

import java.util.HashSet;

import br.com.ilegra.entities.Sale;
import br.com.ilegra.entities.SaleItem;
import br.com.ilegra.entities.Salesman;

public class BuilderSale implements IBuilder{
	private static final int SALE_ID = 1;
	private static final int ITEMS = 2;
	private static final int SALESMAN = 3;
	
	private static HashSet<Salesman>salesMen;
	
	public BuilderSale(HashSet<Salesman>salesmen) {
		salesMen = salesmen;
	}
	
	@Override
	public Sale buid(String[] data) {
		Sale sale = new Sale(
				Integer.parseInt(data[SALE_ID]),
				this.getItemsOfSale(data)
		);
				
		sale.setTotal(sale.getSaleItems().stream().mapToDouble(item->item.getTotalItem()).sum());
		salesMen.forEach(salesMan-> {
			if (salesMan.getName().toUpperCase().equals(data[SALESMAN].toUpperCase())) {
				salesMan.setTotalSaled(sale.getTotal());
				sale.setSalesMan(salesMan);
			}
		});
		return sale;
	}
	
	private HashSet<SaleItem> getItemsOfSale(String[] data) {
		HashSet<SaleItem>saleItems = new HashSet<>();
		BuilderSaleItem builder = new BuilderSaleItem();
		String[] items = data[ITEMS].replace("[", "").replace("]", "").split(",");
		for (String item : items) {
			String[] splitedItens = item.split("-");
			saleItems.add(builder.buid(splitedItens));
		}
		return saleItems;
	}
}
