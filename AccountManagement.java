package test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Scanner;

public class AccountManagement {
	
	static Scanner SC = new Scanner(System.in);		

	//� ����� ��� ������ ���������� �� ���� ��������
	private static List<AccountMainteiner> accounts = new ArrayList<AccountMainteiner>();
	
	protected List<AccountMainteiner> getAccountMainteiner(){
		return accounts;
	}
	
	
	
	//�������� �� ����� �� �������� �� ��� � �������
	protected void showAccountLogins(){
		int count = 1;
		for(AccountMainteiner acc : accounts){
			System.out.println("account number(" + count + ") - login = " + acc.getLogin());
			count++;
		}
	}
	
	
	
	//�������� ��� ���������� ��� �������� �������
	protected void showCurrentAccount(String login) {
		for(AccountMainteiner acc : accounts) {
			if(acc.getLogin().equals(login)) {
				System.out.println(acc);
			}
		}
	}
	
		
	
	//�������� ��� ���������� ��� �� ��������
	protected void showAllInformationInAccounts() {
		for(AccountMainteiner ac� : accounts) {
			System.out.println(ac�);
		}
	}
	
	
	/*
	*����� �������� �� ���������� ������� ������ ������������
	 *�������� ���� � ������ ����� ������ �� ������� ������� ���.
	 *���� �������� ����� ���� ���� ������� ���������� ��� ��� 
	 *�������� ����� ��� ���������� ������ ���������
	 *����� ������ ������ �� ���� �������� ����� ������ ��� ���������� ��� �� ����� � �����
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
	
	
	
	//����� ������� �����  ������� � �������� ���� � ������ ArrayList
	protected void createAccount(String login, String password1, String password2, String first_name, 
			String last_name, String occupation, int age, int capital){
		accounts.add(new AccountMainteiner(login, password1, password2, first_name, last_name, occupation, age, capital));
	}
	
	
	
	//�������� �� ������� �� ������� (��� ����������)
	static AccountMainteiner acc1 = new AccountMainteiner("rom1", "1pass", "pass1", "Roman", "Osadchuk", "Progr", 22, 900);
	static AccountMainteiner acc2 = new AccountMainteiner("rom2", "2pass", "pass2", "Igor", "Petrenko", "Lawyer", 23, 100);
	static AccountMainteiner acc3 = new AccountMainteiner("rom3", "3pass", "pass3", "Petro", "Yatsuk", "Welder", 19, 300);
	static AccountMainteiner acc4 = new AccountMainteiner("rom4", "4pass", "pass4", "Stepan", "Snihur", "Artist", 28, 250);
	static AccountMainteiner acc5 = new AccountMainteiner("rom5", "5pass", "pass5", "Mykola", "Zozylya", "Plumer", 25, 600);
	
	
	
	//����� �������� 5 ��������� ��������� �� ������
	protected static void addAll() {
		accounts.addAll(Arrays.asList(acc1, acc2, acc3, acc4, acc5));
	}


	
	/*
	* ����� �������� �� ���� � ������ ���������� ������� ��������
	 * @param login ������ ���� ���� ����������
	 * @param password ������ ������ ���� ����������
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
	*����� ��� ��������� ��������� ���� ��� ���������� ���� ������
	*@param login	 ������ ���� ��� ����� � �������
	*@param password ������ ������ ��� ����� � �������
	*@param getField ������ ��������� �������� �������� ����������� ���� � ������� �� ������� ������ �� 1 �� 6
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
	*����� ��� ��������� ��������� ���� ��� ���������� ���� ������
	*@param login	 ������ ���� ��� ����� � �������
	*@param password ������ ������ ��� ����� � �������
	*@param getField ������ ������������� �������� �������� ����������� ���� � ������� �� ������� ������ �� 1 �� 6
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
	*����� ��� ���� ���� ��� ���������� ���� ������
	*@param login	 ������ ���� ��� ����� � �������
	*@param password ������ ������ ��� ����� � �������
	*@param getField ������� ����� ���� �� �������� �� �������� �������� ��� ������ ������
	*@param setField ����� �������� ���� ��� ��� ����������
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
	*����� ��� ���� ���� ��� ���������� ���� ������
	*@param login	 ������ ���� ��� ����� � �������
	*@param password ������ ������ ��� ����� � �������
	*@param getField ������� ����� ���� �� �������� �� ������������ �������� ��� ������ ������
	*@param setField ����� �������� ���� ��� ��� ����������
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
	*����� ������� �������� �����������
	*@param login	 ������ ����
	*@param password ������ ������
	*��������� ���������� ��� �� �� �������� �������� ��� ��������� ��'���� � ����
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
	 * ����� ������� �������� �������� �� ������� ���������
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
