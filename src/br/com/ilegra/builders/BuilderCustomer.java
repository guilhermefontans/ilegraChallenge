package br.com.ilegra.builders;

import br.com.ilegra.entities.Customer;

public class BuilderCustomer implements IBuilder{

	private static final int CNPJ = 1;
	private static final int NAME = 2;
	private static final int AREA = 3;
	
	@Override
	public Customer buid(String[] data) {
		return new Customer(
				data[NAME],
				data[AREA],
				Long.parseLong(data[CNPJ])
		);
	}
}
