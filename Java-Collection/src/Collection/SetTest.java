package Collection;

import java.util.HashSet;
import java.util.LinkedHashSet;

public class SetTest {
	public static void main(String[] args) {
		LinkedHashSet<String>set = new LinkedHashSet<String>();
		
		set.add("Milk");
		set.add("bread");
		set.add("butter");
		set.add("cheese");
		set.add("ham");
		
		System.out.println(set);
	}
}
