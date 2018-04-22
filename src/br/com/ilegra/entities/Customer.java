package br.com.ilegra.entities;

/**
 * 
 * @author guilherme
 *
 */
public class Customer implements IEntity{
	
	private String name;
	private String area;
	private long cnpj;
	
	public Customer(String name, String area, long cnpj) {
		this.name = name;
		this.area = area;
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public long getCnpj() {
		return cnpj;
	}
	public void setCnpj(long cnpj) {
		this.cnpj = cnpj;
	}
}
