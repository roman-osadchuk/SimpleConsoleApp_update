package test;

import java.util.Comparator;

public class CapitalComparator implements Comparator<AccountMainteiner>{
	
	@Override
	public int compare(AccountMainteiner cap1, AccountMainteiner cap2) {
		int c1 = cap1.getCapital();
		int c2 = cap2.getCapital();
		return c2 - c1;
	}

}
