package test;

import java.io.IOException;
import java.util.Scanner;

public class Main {                  //D E C L A R A T I O N S
	
	
	private final static Scanner SC = new Scanner(System.in);
	private static AccountManagement AM = new AccountManagement();
	private final static EnterLogInAndPassword LP = new EnterLogInAndPassword();
	private final static FileManager FM = new FileManager();

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		
		//AccountManagement.addAll();    //додає дефолтні аккаунти
		FM.addObjects();//десереалізуємо збережені дані і додаємо їх в список
		
		boolean isRun = true;	//вводимо змінну для виходу із циклу
		
		while(isRun){
			
			
			System.out.println("\nEnter 1 to create an account");
			System.out.println("Enter 2 to show account logins");
			System.out.println("Enter 3 to change information in account");
			System.out.println("Enter 4 to delete account");
			System.out.println("Enter 5 to sort information in accounts");
			System.out.println("Enter 6 to save some information to the file");
			System.out.println("Enter 7 to get information from the file");
			System.out.println("Enter 8 to show all information in accounts (for admin)");
			System.out.println("Enter 9 to delete the cuttent file");
			System.out.println("Enter 0 to exit");
			
			switch (SC.next()) {
				case "1":{
					createAccount();
					break;
				}
				case "2":{
					showAccountLogins();
					break;
				}
				case "3":{
					changeInformation();
					break;
				}
				case "4":{
					deleteAccount();
					break;
				}
				case "5":{
					sortInformation();
					break;
				}
				case "6":{
					saveToFile();
					break;
				}
				case "7":{
					readFromFile();
					break;
				}
				case "8":{
					showAllInformationInAccounts();
					break;
				}
				case "9":{
					deleteTheFile();
					break;
				}
				case "0":{
					FM.savingObjects();//зберігаємо всі дані аккаунтів і виходимо
					isRun = false;
					break;
					}
				default:{
					defaultMethod();
					break;
				}
			}//switch
		}//while
	}//main	

	

	/*
	 * метод створює аккаунт і добавляє його в ліст
	 * перші три параметри обробляються в іншому класі щоб пройти перевірку 
	 * в кінці метод виводить поточний аккаунт
	*/
	private static void createAccount() {
		LP.createAccountChecker();
		String login = LP.getLogin();
		String password1 = LP.getPassword1();
		String password2 = LP.getPassword2();
		System.out.println("enter your first name");	
		String first_name = SC.next();
		System.out.println("enter your last name");
		String last_name = SC.next();
		System.out.println("enter your occupation");
		String occupation = SC.next();
		System.out.println("enter your age");
		int age = SC.nextInt();
		System.out.println("enter amount of your capital funds");
		int capital = SC.nextInt();
		AM.createAccount(login, password1, password2, first_name, last_name, occupation, age, capital);
		AM.showCurrentAccount(login);
	}

	
	
	//виводимо тільки всі аккаунти
	private static void showAccountLogins() {	
		AM.showAccountLogins();
	}
	
	
	
	//виводить всю інформацію про всі аккаунти (для адміна)
	private static void showAllInformationInAccounts() {
		if(AM.checkIfAdmin()){
			AM.showAllInformationInAccounts();
		}else {
			System.out.println("Try again later");
		}	
	}
	
	
	
	/*
	 * метод змінює інформацію про користувача крім логіна
	 * спочатку перевіряємо чи вірний логін і пароль а тоді дозволяємо змінити інформацію
	*/
	private static void changeInformation() {
		
		System.out.println("enter login to your account");
		String login = SC.next();
		System.out.println("enter password to your account");
		String password = SC.next();
		
		if(AM.checkInformation(login, password)){
			
			//змінна для виходу із циклу
			boolean isRun = true;
			
			do {
			System.out.println("\nenter 1 if you want to change your first name");
			System.out.println("enter 2 if you want to change your last name");
			System.out.println("enter 3 if you want to change your password");
			System.out.println("enter 4 if you want to change your occupation");
			System.out.println("enter 5 if you want to change your age");
			System.out.println("enter 6 if you want to change your capital funds");
			System.out.println("enter 0 to get back to previous menu");
			
			switch(SC.next()){
				case "1":{
					String getField = "first_name";
					System.out.println("your current first name is " + AM.getField(login, password, getField));
					System.out.println("enter your new first name");
					String new_first_name = SC.next();
					String setField = new_first_name;
					AM.setField(login, password, getField, setField);
					break;
				}
				case "2":{
					String getField = "last_name";
					System.out.println("your current last name is " + AM.getField(login, password, getField));
					System.out.println("enter your new last name");
					String new_last_name = SC.next();
					String setField = new_last_name;
					AM.setField(login, password, getField, setField);
					break;
				}
				case "3":{
					String getField = "password1";
					System.out.println("your current password is " + AM.getField(login, password, getField));
					System.out.println("enter your new password");
					String new_password1 = SC.next();
					String setField = new_password1;
					AM.setField(login, password, getField, setField);
					break;
				}
				case "4":{
					String getField = "occupation";
					System.out.println("your current occupation is " + AM.getField(login, password, getField));
					System.out.println("enter your new occupation");
					String new_occupation = SC.next();
					String setField = new_occupation;
					AM.setField(login, password, getField, setField);
					break;
				}
				case "5":{
					String getField = "age";
					System.out.println("your current age is " + AM.getFieldInt(login, password, getField));
					System.out.println("enter your new age");
					int new_age = SC.nextInt();
					int setFieldInt = new_age;
					AM.setFieldInt(login, password, getField, setFieldInt);
					break;
				}
				case "6":{
					String getField = "capital";
					System.out.println("your current capital funds is " + AM.getFieldInt(login, password, getField));
					System.out.println("enter your new capital funds");
					int new_capital = SC.nextInt();
					int setFieldInt = new_capital;
					AM.setFieldInt(login, password, getField, setFieldInt);
					break;
				}
				case "0":{
					isRun = false;
					break;
				}
				default :{
					System.out.println("you entered unknown command");
				}
		    }//switch
		}//do
		while (isRun);//end of do-while
		}//if
		else{
			System.out.println("you entered wrong login or password");
		}
	}//method
	
	
	
	/*
	 * метод спочатку просить ввести логін і пароль для адміна
	 * бо тільки він може видаляти аккаунти
	 * далі адмін, знаючи пароль і логін до аккаунту користувача,
	 * може його видалити 
	*/
	private static void deleteAccount() {
		
		if(AM.checkIfAdmin()){
			System.out.println("enter login to account which you want to remove");
			String login = SC.next();
			System.out.println("enter password to this account");
			String password = SC.next();
			
			if(AM.checkInformation(login, password)) {
				AM.deleteAccount(login, password);
			}
			
		}else {
			System.out.println("Re-enter admin's information");
		}
	}

	
	
	/*
	 * метод для сортування інформації по вибраному критерію
	*/
	private static void sortInformation() {
		
		boolean isRun = true;   //змінна для виходу із циклу
		
		while(isRun){
			
			System.out.println("\nEnter 1 to sort first names");
			System.out.println("Enter 2 to sort last names");
			System.out.println("Enter 3 to sort occupations");
			System.out.println("Enter 4 to sort age");
			System.out.println("Enter 5 to sort capital funds");
			System.out.println("Enter 0 to get back to urevious menu");
			
			switch (SC.next()) {
				case "1":{
					int number = 1;
					AM.comparator(number);
					break;
				}
				case "2":{
					int number = 2;
					AM.comparator(number);
					break;
				}
				case "3":{
					int number = 3;
					AM.comparator(number);
					break;
				}
				case "4":{
					int number = 4;
					AM.comparator(number);
					break;
				}
				case "5":{
					int number = 5;
					AM.comparator(number);
					break;
				}
				case "0":{
					isRun = false;
					break;
				}
				default:{
					defaultMethod();
					break;
				}
		    }//switch
	    }//while
	}//method
	
	
	
	/*
	 * метод записує інформацію у файл
	 * приймає цілу стрічку яку користувач введе з клавіатури
	*/
	private static void saveToFile() throws IOException, ClassNotFoundException {
		
		System.out.println("enter login to your account");
		String login = SC.next();
		System.out.println("enter password to your account");
		String password = SC.next();
		
		if(AM.checkInformation(login, password)) {
					
			String message = "\n";		//сюди записуємо то що введе користувач
			System.out.println("enter information which you want to save to file");
			SC.nextLine();				//метод працює тільки таким чином
			message += SC.nextLine();	//інакше зчитує "\n" як інпут і йде дальше		
			
			
			/*
			 * метод записує стрічку у файл
			 * @param message приймає цілу стрічку яку користувач введе з клавіатури
			 * @param login   приймає логін щоб створити новий файл з назвою "messagelogin.txt"
			 * якщо такий файл вже існує то він просто дописує інформацію в нього
			*/
			FM.writeToFile(message, login);
			
		}else {
			System.out.println("Password or login is invalid");
		}	
	}//method
	
	
	
	//метод зчитує інформацію з файла і виводить її на екран
	private static void readFromFile() throws IOException {
		
		System.out.println("enter login to your account");
		String login = SC.next();
		System.out.println("enter password to your account");
		String password = SC.next();
		
		if(AM.checkInformation(login, password)) {
			
			//перегрузка даного методу
			//приймає login для зчитування інформації з конкретного файлу
			FM.readFromFile(login);
		}	
	}
	
	
	//метод повністю видаляє файл
	//потребує дані адміна бо тільки він може видаляти файли
	private static void deleteTheFile() {
		
		if(AM.checkIfAdmin()){
			FM.getFile().delete();
		}else {
			System.out.println("Admin's login or password is not correct!");
		}
	}


	private static void defaultMethod() {
		
		System.out.println("you entered unknown command");
	}
	
}

