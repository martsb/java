package majasDarbi;

import java.io.File;
import java.io.IOException;

public class FileWriter {
		
	public static void main(String[] args) throws IOException {
		File file1 = new File("C:\\Users\\Marts Druvis Lauma\\Desktop\\info.txt");
		if (!file1.exists()) {
			System.out.println("New file time!");
			file1.createNewFile();
		}

	}

}
