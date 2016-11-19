package test;

import java.util.Comparator;

public class AgeComparator implements Comparator<AccountMainteiner>{
	
	@Override
	public int compare(AccountMainteiner age1, AccountMainteiner age2) {
		int oc1 = age1.getAge();
		int oc2 = age2.getAge();
		return oc1 - oc2;
	}

}
