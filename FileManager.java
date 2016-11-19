package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.List;

public class FileManager {

	AccountManagement AM = new AccountManagement();
	
	private File file;

	public FileManager() {
		
	}

	public File getFile() {
		return file;
	}

	public void setFile(File file) {
		this.file = file;
	}


	
	/*
	* метод створює байтовий потік для запису
	 * @param message приймає стрічку як строку яку зчитуємо з клавіатури
	 * @param login приймає логін даного користувача
	 * записумо цю стрічку в файл messagelogin.txt
	 */
	public void writeToFile(String message, String login) throws IOException {
		File file = new File("message"+login+".txt");
		file.createNewFile();
		FileOutputStream fos = new FileOutputStream("message"+login+".txt", true);//writing bytes
		fos.write(message.getBytes());
		fos.close();
	}
	
	
	/*
	* метод створює байтовий потік для зчитування з файла
	 * зчитуєо дані і записуємо їх у змінну "a"
	 * зчитуємо доти токи не повернеться "-1" і тоді припиняємо зчитування
	 */
	public void readFromFile(String login) throws IOException {
		
		FileInputStream fis = new FileInputStream("message"+login+".txt");
		
		int a = fis.read();
		while(a != -1) {
			System.out.print((char)a);
			a = fis.read();
		}
		fis.close();
	}
	
	
	
	//сереалізація. метод зберігає дані в лісті
	public void savingObjects() throws IOException {

		FileOutputStream fos = new FileOutputStream("accounts.txt");
		ObjectOutputStream output = new ObjectOutputStream(fos);
		
		output.writeObject(AM.getAccountMainteiner());
		
		output.close();
		fos.close();
	}

	
	
	//десереалізація. додавання збереженої інформації назад в ліст
	public void addObjects() throws IOException, ClassNotFoundException {
		
		FileInputStream fis = new FileInputStream("accounts.txt");
		ObjectInputStream input = new ObjectInputStream(fis);
		
		@SuppressWarnings("unchecked")
		List<AccountMainteiner> deserializedAccounts = (List<AccountMainteiner>) input.readObject();
		
		AM.getAccountMainteiner().addAll(deserializedAccounts);
		
		fis.close();
		input.close();
		
	}
	
	
}
