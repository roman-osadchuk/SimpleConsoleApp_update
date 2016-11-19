package test;

import java.util.Comparator;

public class OccupationComparator implements Comparator<AccountMainteiner>{

	@Override
	public int compare(AccountMainteiner ac1, AccountMainteiner ac2) {
		String oc1 = ac1.getFirst_name();
		String oc2 = ac2.getFirst_name();
		return oc2.compareTo(oc1);
	}
}
