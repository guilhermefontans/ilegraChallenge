package br.com.ilegra.entities;

/**
 * 
 * @author guilherme
 *
 */
public class Salesman implements IEntity{
	
	private String name;
	private Long cpf;
	private double salary;
	private double totalSaled = 0;
	
	public Salesman(String name, Long cpf, double salary) {
		this.name = name;
		this.cpf = cpf;
		this.salary = salary;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getCpf() {
		return cpf;
	}

	public void setCpf(long cpf) {
		this.cpf = cpf;
	}

	public double getSalary() {
		return salary;
	}

	public void setSalary(double salary) {
		this.salary = salary;
	}

	public double getTotalSaled() {
		return totalSaled;
	}

	public void setTotalSaled(double totalSaled) {
		this.totalSaled += totalSaled;
	}

	public void setCpf(Long cpf) {
		this.cpf = cpf;
	}
	
}
