package test;

import java.util.Comparator;

public class FirstNameComparator implements Comparator<AccountMainteiner>{
	
	@Override
	public int compare(AccountMainteiner ac1, AccountMainteiner ac2) {
		String fn1 = ac1.getFirst_name();
		String fn2 = ac2.getFirst_name();
		return fn1.compareTo(fn2);
	}

}
