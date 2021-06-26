package Collection;

import java.util.*;


public class ArrayListTest {
	public static void main(String[] args) {
		//기본 길이(용량, capacity)가 10인 ArrayList를 생성
		ArrayList list1 = new ArrayList(10);
		//ArrayList에는 객체만 저장가능
		//autoboxing에 의해 기본형이 참조형으로 자동 변환
//		list1.add(new Integer(5));
		list1.add(5);
		list1.add(new Integer(4));
		list1.add(new Integer(2));
		list1.add(new Integer(0));
		list1.add(new Integer(1));
		list1.add(new Integer(3));
		//ArrayList(Collection c)
		ArrayList list2 = new ArrayList(list1.subList(1, 4));
		System.out.println(list1);
		System.out.println(list2);
		
		list2.add("B");
		list2.add("C");
		list2.add(3, "A");
		
		System.out.println(list2);
		
//		Collections.sort(list2);
//		System.out.println(list2);
		
		System.out.println("index=" + list1.indexOf(3));
		//지정된 인덱스위치의 값을 알려준다
		System.out.println("index=" + list1.indexOf(new Integer(2)));
		//원래 다 적어줘야 하는데 autoboxing에 의해 간단하게 사용 가능
		
		list1.remove(1);  //인덱스가 1인 객체를 삭제
		list1.remove(new Integer(1));  //1을 삭제
		
		System.out.println(list1.containsAll(list2));
		//list1에 list2를 모두 포함하고 있는지?
		
		System.out.println(list1.retainAll(list2));
		System.out.print(list1);
		
	}

	
	
	
	

}

//ArrayList는 기존의 Vector를 개선한 것으로 구현원리와 기능적으로 동일
//ArrayList와 달리 Vector는 자체적으로 동기화처리가 되어 있다.
//List인터페이스를 구현하므로, 저장순서가 유지되고 중복을 허용한다
//데이터의 저장공간으로 배열을 사용한다.(배열기반)

