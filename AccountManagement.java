package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
	
	static Scanner SC = new Scanner(System.in);		

	//в цьому лісті будуть зберігатися всі наші аккаунти
	private static List<AccountMainteiner> accounts = new ArrayList<AccountMainteiner>();
	
	protected List<AccountMainteiner> getAccountMainteiner(){
		return accounts;
	}
	
	
	
	//виводить на екран всі аккаунти які вже є створені
	protected void showAccountLogins(){
		int count = 1;
		for(AccountMainteiner acc : accounts){
			System.out.println("account number(" + count + ") - login = " + acc.getLogin());
			count++;
		}
	}
	
	
	
	//виводить всю інформацію про поточний аккаунт
	protected void showCurrentAccount(String login) {
		for(AccountMainteiner acc : accounts) {
			if(acc.getLogin().equals(login)) {
				System.out.println(acc);
			}
		}
	}
	
		
	
	//виводить всю інформацію про всі аккаунти
	protected void showAllInformationInAccounts() {
		for(AccountMainteiner acс : accounts) {
			System.out.println(acс);
		}
	}
	
	
	/*
	*метод перевіряє чи інформація відповідає правам адміністратора
	 *запитуємо логін і пароль адміна допоки не отримаєм правльні дані.
	 *якщо протягом трьох спро було введено неправильні дані тоді 
	 *пропонуєм вийти або продовжити дальше вгадувати
	 *метод працює допоки не буде введений вірний пароль або користувач сам не вийде з циклу
	*/
	protected boolean checkIfAdmin() {
		
		int count = 0;
		boolean isValid = false;
		do {
			
			System.out.println("enter admin's login: ");
			String admins_login = SC.next();
			System.out.println("enter admin's password: ");
			String admins_password = SC.next();
			
			if((admins_login.equals("admin")) && (admins_password.equals("admin1"))){
				isValid = true;

			}else {
				
				System.out.println("Login or password are invalid!");
				if(count == 3) {
					System.out.println("press 1 to continue: ");
					System.out.println("press 0 to exit: ");
					if(SC.next().equals("1")) {
						isValid = false;
						count = 0;
					}else {
						count = 0;
						return false;
					}
				}
				count++;
			}
			
		}while(!isValid);
		
		return true;
		
	}//checkIfAdmin
	
	
	
	//метод створює новий  аккаунт і добавляє його в список ArrayList
	protected void createAccount(String login, String password1, String password2, String first_name, 
			String last_name, String occupation, int age, int capital){
		accounts.add(new AccountMainteiner(login, password1, password2, first_name, last_name, occupation, age, capital));
	}
	
	
	
	//аккаунти які створені по дефолту (для тестування)
	static AccountMainteiner acc1 = new AccountMainteiner("rom1", "1pass", "pass1", "Roman", "Osadchuk", "Progr", 22, 900);
	static AccountMainteiner acc2 = new AccountMainteiner("rom2", "2pass", "pass2", "Igor", "Petrenko", "Lawyer", 23, 100);
	static AccountMainteiner acc3 = new AccountMainteiner("rom3", "3pass", "pass3", "Petro", "Yatsuk", "Welder", 19, 300);
	static AccountMainteiner acc4 = new AccountMainteiner("rom4", "4pass", "pass4", "Stepan", "Snihur", "Artist", 28, 250);
	static AccountMainteiner acc5 = new AccountMainteiner("rom5", "5pass", "pass5", "Mykola", "Zozylya", "Plumer", 25, 600);
	
	
	
	//метод добавляє 5 дефолтних аккаунтиів до списку
	protected static void addAll() {
		accounts.addAll(Arrays.asList(acc1, acc2, acc3, acc4, acc5));
	}


	
	/*
	* метод перевіряє чи логін і пароль відповідають певному аккаунту
	 * @param login приймає логін який перевіряємо
	 * @param password приймає пароль який перевіряємо
	*/
	protected boolean checkInformation(String login, String password) {
		
		for(AccountMainteiner acc : accounts){
			if((acc.getLogin().equals(login)) && acc.getPassword1().equals(password)) {
				System.out.println("Login and password are valid");
				return true;
			}
		}
		
		System.out.println("Login or password are invalid");
		return false;
	}


	/*
	*метод для отримання поточного поля яке користувач хоче змінити
	*@param login	 приймає логін щоб увійти в аккаунт
	*@param password приймає пароль щоб увійти в аккаунт
	*@param getField приймає стрічковий параметр аккаунту користувача який є заданий по натиску кнопки від 1 до 6
	*/
	protected String getField(String login, String password, String getField) {
		
		for(AccountMainteiner ac : accounts){
			
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				
				if(getField.equals("first_name")) {
					return ac.getFirst_name();
				}
				if(getField.equals("last_name")) {
					return ac.getLast_name();
				}
				if(getField.equals("password1")) {
					return ac.getPassword1();
				}
				if(getField.equals("occupation")) {
					return ac.getOccupation();
				}		
			}
		}
		
		return "Field wasn't set up";
	}
	
	
	
	/*
	*метод для отримання поточного поля яке користувач хоче змінити
	*@param login	 приймає логін щоб увійти в аккаунт
	*@param password приймає пароль щоб увійти в аккаунт
	*@param getField приймає цілочисельний параметр аккаунту користувача який є заданий по натиску кнопки від 1 до 6
	*/
	protected int getFieldInt(String login, String password, String getField) {
		
		for(AccountMainteiner ac : accounts){
			
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				
				if(getField.equals("age")) {
					return ac.getAge();
				}
				if(getField.equals("capital")) {
					return ac.getCapital();
				}
			}
		}
		
		return 0;
	}
	
	
	/*
	*метод для зміни поля яке користувач хоче змінити
	*@param login	 приймає логін щоб увійти в аккаунт
	*@param password приймає пароль щоб увійти в аккаунт
	*@param getField завдяки цьому полю ми отримуємо то стрічкове значення яке хочемо змінити
	*@param setField змінює значення поля яке ввів користувач
	*/
	protected void setField(String login, String password, String getField, String setField) {
		
		for(AccountMainteiner ac : accounts){
			
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				
				if(getField.equals("first_name")) {
					ac.setFirst_name(setField);
				}
				if(getField.equals("last_name")) {
					ac.setLast_name(setField);
				}
				if(getField.equals("password1")) {
					ac.setPassword1(setField);
					ac.setPassword2(setField);
				}
				if(getField.equals("occupation")) {
					ac.setOccupation(setField);
				}
			}
		}
	}
	
	
	
	/*
	*метод для зміни поля яке користувач хоче змінити
	*@param login	 приймає логін щоб увійти в аккаунт
	*@param password приймає пароль щоб увійти в аккаунт
	*@param getField завдяки цьому полю ми отримуємо то цілочисельне значення яке хочемо змінити
	*@param setField змінює значення поля яке ввів користувач
	*/
	protected void setFieldInt(String login, String password, String getField, int setFieldInt) {
		
		for(AccountMainteiner ac : accounts){
			
			if((ac.getLogin().equals(login)) && ac.getPassword1().equals(password)){
				
				if(getField.equals("age")) {
					ac.setAge(setFieldInt);
				}
				if(getField.equals("capital")) {
					ac.setCapital(setFieldInt);
				}
			}
		}
	}
	
	
	/*
	*метод видаляє аккаунти користувача
	*@param login	 приймає логін
	*@param password приймає пароль
	*видаляємо ітератором так як він найкраще підходить для видалення об'єктів з ліста
	*/
	protected void deleteAccount(String login, String password) {
		
		Iterator<AccountMainteiner> iter = accounts.iterator();
		
		while(iter.hasNext()) {
			AccountMainteiner temp = iter.next();
			if((temp.getLogin().equals(login)) && temp.getPassword1().equals(password)){
				iter.remove();
				System.out.println("your account (" + login + ") was successfully deleted");
			}
		}
	}
	
	
	/*
	 * метод порівнює значення аккаунтів за певними критеріями
	*/
	protected void comparator(int number) {
		
			if(number == 1) {
				Collections.sort(accounts, new FirstNameComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println("Login: "+acc.getLogin()+" First Name "+acc.getFirst_name());
				}
			}
			else if(number == 2) {
				Collections.sort(accounts, new LastNameComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println("Login: "+acc.getLogin()+" Last Name "+acc.getLast_name());
				}
			}
			else if(number == 3) {
				Collections.sort(accounts, new OccupationComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println("Login: "+acc.getLogin()+" Occupation "+acc.getOccupation());
				}
			}
			else if(number == 4) {
				Collections.sort(accounts, new AgeComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println("Login: "+acc.getLogin()+" Age "+acc.getAge());
				}
			}
			else if(number == 5) {
				Collections.sort(accounts, new CapitalComparator());
				for(AccountMainteiner acc : accounts) {
					System.out.println("Login: "+acc.getLogin()+" Capital "+acc.getCapital());
				}
			}
		}


	
}
