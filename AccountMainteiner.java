package test;

import java.io.Serializable;

public class AccountMainteiner implements Serializable{
	
	/**
	 * serial version for serializable FileMAnager
	 */
	private static final long serialVersionUID = -7040468370378014518L;
	
	private String login;
	private String password1;
	private String password2;
	private String first_name;
	private String last_name;
	private String occupation;
	private int age;
	private int capital;
	
	
	public String getLogin() {
		return login;
	}
	public void setLogin(String login) {
		this.login = login;
	}
	public String getPassword1() {
		return password1;
	}
	public void setPassword1(String password1) {
		this.password1 = password1;
	}
	public String getPassword2() {
		return password2;
	}
	public void setPassword2(String password2) {
		this.password2 = password2;
	}
	public String getFirst_name() {
		return first_name;
	}
	public void setFirst_name(String first_name) {
		this.first_name = first_name;
	}
	public String getLast_name() {
		return last_name;
	}
	public void setLast_name(String last_name) {
		this.last_name = last_name;
	}
	public String getOccupation() {
		return occupation;
	}
	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getCapital() {
		return capital;
	}
	public void setCapital(int capital) {
		this.capital = capital;
	}
	
	
	public AccountMainteiner(String login, String password1, String password2,
			String first_name, String last_name, String occupation, int age, 
			int capital) {
		this.login = login;
		this.password1 = password1;
		this.password2 = password2;
		this.first_name = first_name;
		this.last_name = last_name;
		this.occupation = occupation;
		this.age = age;
		this.capital = capital;
	}
	
	
	public AccountMainteiner() {
		
	}
	
	
	@Override
	public String toString() {
		return "Account: (login=" + login + ", password1=" + password1
				+ ", password2=" + password2 + ", first_name=" + first_name
				+ ", last_name=" + last_name + ",  occupation="
				+ occupation + " age=" + age + ", capital=" + capital + ")";
	}
	
	
}
