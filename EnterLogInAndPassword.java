package test;

import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.regex.PatternSyntaxException;

	public class EnterLogInAndPassword {
	
	static Scanner sc = new Scanner(System.in);
	static AccountManagement AM = new AccountManagement();
	
	private String login;				//поле для вводу логіну
	private String password1;			//поле для введення пароля
	private String password2;			//поле для перевірки співпадіння паролів
	
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getPassword1() {
		return password1;
	}

	public void setPassword1(String password) {
		this.password1 = password;
	}
	
	public String getPassword2() {
		return password2;
	}

	public void setPassword2(String password2) {
		this.password2 = password2;
	}

	
	
	/*
	* метод для створення аккаунту
	 * вимагає ввести логін який підлягає певним критеріям
	 * вимагає ввести пароль єким підлягає певним критеріям
	 * вимагає повторити введення паролю
	*/
	protected void createAccountChecker(){
		
		//запитуєм користувача ввести логін
		//вводимо додаткову змінну (флажок) щоб переконатись що логін відповідає певним критеріям
		
		boolean isValidLogin = false;
		
		do {
			System.out.println("Enter your login (it should starts from a letter and contain from 3 to 15 symbols)");
			login = sc.nextLine();
			if(testLogin(login)){
				isValidLogin = true;
				
				for(AccountMainteiner acc : AM.getAccountMainteiner()) {
					if(acc.getLogin().equals(login)) {
						isValidLogin = false;
						System.out.println("This login is already exist!");
						break;
					}
				}
				
			}else{
				System.out.println("Your login does not correspond to criterias. Please re-check it!");
			}
		} while (!isValidLogin);
		
		
		//запитуємо в користувача ввести пароль такий щоб відповідав певним критеріям
		
		boolean isValidPassword = false;
		do {
			System.out.println("Enter your password (it should starts from a number and contain less than 10 symbols)");
			password1 = sc.nextLine();
			if(testPassword(password1)){
				isValidPassword = true;
				System.out.println("Password is valid");
			}
			else{
				System.out.println("Your password is not correct. Please re-check it!");
			}
		} while (!isValidPassword);
		
		
		//запитуємо в користувача повторити пароль
		
		isValidPassword = false;
		do {
			System.out.println("Re-enter your password");
			password2 = sc.nextLine();
			if(password1.equals(password2)){
				isValidPassword = true;
				System.out.println("Passwords matches");
			}
			else{
				System.out.println("Passwords are not equal. re-enter your password!");
			}
		} while (!isValidPassword);
				
	}//createAccountChecker();
	
	
	
	/*
	* метод для перевірки правильності введення логіну
	 * @param testLog приймає логін який перевіряємо
	*/
	protected boolean testLogin(String testLog) throws PatternSyntaxException {
			Pattern pattern = Pattern.compile("^[a-zA-Z]{1}[a-zA-Z\\d]{2,14}$");
			Matcher matcher = pattern.matcher(testLog);
			if(matcher.matches()) return true;
		return false;
	}
	
	
	
	/*
	 * метод для перевірки правильності введення пороля
	 * @param testPass приймає пароль який перевіряємо
	*/
	protected boolean testPassword(String testPass) throws PatternSyntaxException {
			Pattern pattern = Pattern.compile("^\\d{1}[a-zA-Z\\d]{2,9}$");
			Matcher matcher = pattern.matcher(testPass);
			if(matcher.matches()) return true;
		return false;
		
	}
	
	
	
	/*
	 * метод для перевірки чи в даній стрічці містяться тільки букви
	 * @param ifString приймає стрічку яку перевіряємо
	*/
	protected boolean checkForString(String ifString) {
		Pattern pattern = Pattern.compile("^[a-zA-Z]+$");
		Matcher matcher = pattern.matcher(ifString);
		if(matcher.matches()) return true;
		return false;
	}
	
	
	
	/*
	 * метод для перевірки чи в даному числі містяться тільки цифри
	 * @param ifInt приймає ціле число яке перевіряємо
	*/
	protected boolean checkForInteger(CharSequence ifInt) {	
		Pattern pattern = Pattern.compile("^\\d+$");
		Matcher matcher = pattern.matcher(ifInt);
		if(matcher.matches()) return true;
		return false;
	}
	
	
	
}
