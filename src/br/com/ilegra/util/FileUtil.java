package br.com.ilegra.util;

import java.io.File;

/**
 * 
 * @author guilherme
 *
 */
public class FileUtil {
	public static File createPath(String path) throws Exception{
		File pathDir = new File(path);

		if (!pathDir.exists()) {
			if (!pathDir.mkdirs()) {
				throw new Exception("Could not create processed path: " + path);
			}
		} else if (!pathDir.isDirectory()) {
			throw new Exception("Processed Path is not a directory: " + path);
		}
		return pathDir;
	}
}
