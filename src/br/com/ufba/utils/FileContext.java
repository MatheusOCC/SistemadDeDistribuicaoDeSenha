package br.com.ufba.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class FileContext {

	public void saveFile(String fileName, Object object) throws Exception {
		try {
			ObjectOutputStream obStream = new ObjectOutputStream(new FileOutputStream(fileName + ".txt"));
			obStream.writeObject(object);
		} catch (FileNotFoundException e) {
			new Exception("Não foi possível encontrar o caminho.");
		} catch (IOException e) {
			new Exception("Erro ao gravar o arquivo.");
		}
	}

	@SuppressWarnings("resource")
	public Object getFile(String fileName) throws Exception {
		ObjectInputStream obStream;
		try {
			obStream = new ObjectInputStream(new FileInputStream(fileName + ".txt"));
			return obStream.readObject();
		} catch (IOException e) {
			new Exception("Não foi possível encontrar o arquivo.");
		}

		return null;
	}
}
