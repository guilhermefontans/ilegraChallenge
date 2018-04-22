package br.com.ilegra.builders;

import br.com.ilegra.entities.SaleItem;

public class BuilderSaleItem implements IBuilder{

	private static final int ID = 0;
	private static final int QUANTITY = 1;
	private static final int PRICE = 2;
	
	@Override
	public SaleItem buid(String[] data) {
		return new SaleItem(
				Integer.parseInt(data[ID]),
				Integer.parseInt(data[QUANTITY]),
				Double.parseDouble(data[PRICE])
		);
	}
}
