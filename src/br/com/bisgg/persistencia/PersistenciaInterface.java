package br.com.bisgg.persistencia;

import java.io.IOException;
import java.util.LinkedList;

/**
 * @author Ivanicio Jr <jsiilva@outlook.com.br>
 *
 */
public interface PersistenciaInterface {

	/**
	 * 
	 * Método para obter os objetos objeto em um dado arquivo
	 * @author Ivanicio Jr
	 * @param String fileName
	 * @return 
	 * @throws ClassNotFoundException 
	 * @throws IOException 
	 * 
	 */
	public LinkedList<String> get (String fileName) throws IOException, ClassNotFoundException;
}
