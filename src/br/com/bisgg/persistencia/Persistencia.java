package br.com.bisgg.persistencia;
import java.io.*;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.stream.Collectors;

public class Persistencia implements PersistenciaInterface {

	private String ext = ".txt";
	private String dir = "data/";

	/*
	 *
	 * Método para obter objetos de um dado arquivo
	 *
	 * @arguments String filename
	 * FileName: Nome do arquivo que será consumido
	 *
	 * @return Object
	 *
	 * */
	public LinkedList<Object> get (String fileName) throws IOException, ClassNotFoundException {

		BufferedReader br = null;
		FileReader fr = null;

		LinkedList<Object> objects = new LinkedList<>();

		try {
			fr = new FileReader(dir+fileName+ext);
			br = new BufferedReader(fr);

			String line = br.readLine();

			while (line != null) {
				objects.add(line);
				line = br.readLine();
			}

		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		finally {
			try {
				if (br != null)
					br.close();

				if (fr != null)
					fr.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}

		return objects;
	}

	/*
	 *
	 * Método para verificar se um arquivo existe
	 *
	 * @arguments String filename
	 * FileName: Nome do arquivo que será verificado
	 *
	 * @return Boolean
	 *
	 * */
	public boolean isExists (String fileName) throws IOException {
		File file = new File(dir+fileName+ext);
		
		if (file.exists())
			return true; 
		
		return false;
	}

	public boolean isEmpty (String fileName) throws IOException {
		File file = new File(dir+fileName+ext);

		if (file.length() == 0)
			return true;

		return false;
	}
}
