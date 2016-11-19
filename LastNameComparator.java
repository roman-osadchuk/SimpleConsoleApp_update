package test;

import java.util.Comparator;

public class LastNameComparator implements Comparator<AccountMainteiner>{

	@Override
	public int compare(AccountMainteiner ac1, AccountMainteiner ac2) {
		String ln1 = ac1.getLast_name();
		String ln2 = ac2.getLast_name();
		return ln1.compareToIgnoreCase(ln2);
	}
}
