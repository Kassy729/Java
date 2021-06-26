package Collection;

import java.util.Arrays;
import java.util.List;


public class WildCardTest {
	public static void main(String[] args) {
		List<Integer> li = Arrays.asList(1,2,3);
		List<String> ls = Arrays.asList("one", "two", "three");
		MyList.printList(li);
    	MyList.printList(ls);
	}
}

class MyList{
	public static void printList(List<?> list) {
		for(Object elem : list)
			System.out.println(elem + " ");
		System.out.println();
	}
}

//<? extends T> : 와일드 카드의 상한 제한, T와 그 자손들만 가능
//<? super T> : 와일드 카드의 하한 제한, T와 그 조상들만 가능
//<?> : 제한없음, 모든 타입이 가능. <? extends Object>와 동일



