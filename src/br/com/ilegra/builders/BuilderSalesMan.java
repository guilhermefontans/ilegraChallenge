package br.com.ilegra.builders;

import br.com.ilegra.entities.Salesman;

public class BuilderSalesMan implements IBuilder{

	private static final int CPF = 1;
	private static final int NAME = 2;
	private static final int SALARY = 3;
	
	public Salesman buid(String[] data) {
		return new Salesman(
				data[NAME],
				Long.parseLong(data[CPF]),
				Double.parseDouble(data[SALARY])
		);
	}
}
