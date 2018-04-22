package br.com.ilegra.main;

import java.io.File;
import java.io.FileFilter;

import br.com.ilegra.util.FileUtil;

/**
 * 
 * @author guilherme
 *
 */
public class Application {

	private String homePath;
	private String pathFilesIn;
	private String pathFilesOut;
	private String pathFilesProcessed;
	
	/**
	 * This method raise the initial configurations necessary to run the software 
	 * @throws Exception
	 */
	public void run() throws Exception {
		this.homePath = System.getenv("HOMEPATH");
		if (this.homePath == null) {
			throw new Exception("Undefined environment variable HOMEPATH");
		}
		this.pathFilesIn = homePath + "/data/in";
		this.pathFilesOut = homePath + "/data/out";
		this.pathFilesProcessed = homePath + "/data/processed";
		
		File dirFilesIn = new File(pathFilesIn);
		if (!dirFilesIn.exists()) {
			throw new Exception("Path does not exists: " + dirFilesIn);
		} else if (!dirFilesIn.isDirectory()) {
			throw new Exception("Path is not a directory: " + dirFilesIn);
		} else if (!dirFilesIn.canRead()) {
			throw new Exception("Could not read path: " + dirFilesIn);
		}
		
		File[] files = dirFilesIn.listFiles(this.getFiltersToList());
		File outPutPathDir = FileUtil.createPath(this.pathFilesOut);
		File processedPathDir = FileUtil.createPath(this.pathFilesProcessed);
		if (files.length == 0) {
			System.out.println("########There are not new files to process########");
		}
		for (File file : files) {
			System.out.printf("########Readin file %s########\n", file.getName());
			if(!file.canRead()) {
				throw new Exception("Impossible to read file " + file.getName());
			}
			this.processFile(file, outPutPathDir, processedPathDir);
		}
	}
		
	/**
	 * Filter to get only files to exiting with string .dat
	 * @return FileFilter
	 */
	private FileFilter getFiltersToList() {
		return new java.io.FileFilter() {
			@Override
			public boolean accept(File file) {
				return file.isFile() && file.getName().endsWith(".dat");
			}
		}; 
	}
	
	/**
	 * 
	 * This function call all others methods in order in than make this software
	 * work.
	 * 
	 * @param file to read data
	 * @param pathToOut to print data
	 * @param pathToSucced to remove files already processed 
	 * @throws Exception
	 */
	private void processFile(File file, File pathToOut, File pathToSucced ) throws Exception {
		FileProcessor fileProcessor = new FileProcessor(file);
		fileProcessor.readFromFile();
		fileProcessor.generateOutPutFile(pathToOut);
		fileProcessor.moveProcessedFile(pathToSucced);
	} 
}
