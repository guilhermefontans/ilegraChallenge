package br.com.ilegra.entities;

public enum TypesRegisters {

	SALESMAN_TYPE ("001"),
	CUSTOMER_TYPE ("002"),
	SALE_TYPE ("003");
	
	public String value;
	private TypesRegisters(String value) {
		this.value = value;
	}
}
