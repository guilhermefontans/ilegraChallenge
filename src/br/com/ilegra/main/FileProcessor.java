package br.com.ilegra.main;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.HashSet;
import java.util.Scanner;

import br.com.ilegra.builders.BuilderCustomer;
import br.com.ilegra.builders.BuilderSale;
import br.com.ilegra.builders.BuilderSalesMan;
import br.com.ilegra.entities.Customer;
import br.com.ilegra.entities.Sale;
import br.com.ilegra.entities.Salesman;
import br.com.ilegra.entities.TypesRegisters;

/**
 * 
 * @author guilherme
 *
 */
public class FileProcessor {

	private File file;
	protected HashSet<Salesman> salesMen = new HashSet<>();
	protected HashSet<Sale> sales = new HashSet<>();
	protected HashSet<Customer> customers = new HashSet<>();

	public FileProcessor(File file) {
		this.file = file;
	}

	/**
	 * Read all files from directory passed through parameter
	 * to class constructor 
	 * @throws FileNotFoundException
	 */
	protected void readFromFile() throws FileNotFoundException {
		Scanner scanner = new Scanner(this.file);
		while (scanner.hasNextLine()) {
			String line = scanner.nextLine();
			String[] splitedLine = line.split("ç");

			if (splitedLine.length > 0) {
				if (splitedLine[0].equals(TypesRegisters.SALESMAN_TYPE.value)) {
					BuilderSalesMan builder = new BuilderSalesMan();
					Salesman salesMan = builder.buid(splitedLine);
					this.salesMen.add(salesMan);
				}

				if (splitedLine[0].equals(TypesRegisters.CUSTOMER_TYPE.value)) {
					BuilderCustomer builder = new BuilderCustomer();
					Customer customer = builder.buid(splitedLine);
					this.customers.add(customer);
				}

				if (splitedLine[0].equals(TypesRegisters.SALE_TYPE.value)) {
					BuilderSale builder = new BuilderSale(this.salesMen);
					Sale sale = builder.buid(splitedLine);
					this.sales.add(sale);
				}
			}
		}
		scanner.close();
	}

	/**
	 * This function generate other file in the path passed through parameter
	 * @param outPutPathName Path to report
	 */
	protected void generateOutPutFile(File outPutPathName) {
		try {
			int indexExtensionFile = this.file.getName().lastIndexOf(".dat");
			String outPutFileName = outPutPathName.getAbsolutePath() + System.getProperty("file.separator")
					+ this.file.getName().substring(0, indexExtensionFile) + ".done.dat";
			File outPutFile = new File(outPutFileName);
			PrintWriter output = new PrintWriter(outPutFile);
			output.printf("The amount of clients in the file %s is: %d\n", this.file, customers.size());
			output.printf("The amount of salesman in the file %s is: %d\n", this.file.getName(), this.salesMen.size());
			output.printf("The most expensive sale in the file %s was the sale ID: %d\n", this.file.getName(),
					this.getMostExpensiveSale());
			output.printf("The worst salesman ever in the file %s was the salesman: %s\n", this.file.getName(),
					this.getTheWorstSalesMan());
			output.close();
			System.out.println("Making file: " + outPutFile.getName());
		} catch (Exception e) {
			e.getMessage();
		}
	}

	/**
	 * This function move files already processed
	 * to other directory
	 * @param pathTo path to files processed will
	 */
	protected void moveProcessedFile(File pathTo) {
		System.out.printf("Moving processed  file %s to: %s\n", this.file.getName(), pathTo.getAbsolutePath());
		this.file.renameTo(
				new File(pathTo.getAbsolutePath() + System.getProperty("file.separator") + this.file.getName()));
		
	}

	/**
	 * @return id of more expensive sale in the file
	 */
	private int getMostExpensiveSale() {
		double maxExpensiveValue = 0;
		int maxExpensiveId = 0;
		for (Sale sale : this.sales) {
			if (sale.getTotal() > maxExpensiveValue) {
				maxExpensiveValue = sale.getTotal();
				maxExpensiveId = sale.getId();
			}
		}

		return maxExpensiveId;
	}

	/**
	 * @return String of the worst salesman in the file
	 */
	private String getTheWorstSalesMan() {
		Salesman worstSalesMan = this.salesMen.iterator().next();
		for (Salesman salesman : this.salesMen) {
			if (salesman.getTotalSaled() < worstSalesMan.getTotalSaled()) {
				worstSalesMan = salesman;
			}
		}

		return worstSalesMan.getName();
	}
}