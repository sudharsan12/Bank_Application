package Customer;

import java.util.Comparator;

public class CustomerComparator implements Comparator{

	

	@Override
	public int compare(Object o1, Object o2) {
	
		Customer c1=(Customer)o1;
		Customer c2=(Customer)o2;
	
		if(c1.balance<c2.balance)
			return 1;
		else if(c1.balance>c2.balance)
		return -1;
		
		return 0;
	}
	
	
}
