package Collection;
import java.util.*;
import java.util.Map.Entry;

public class MapTest {
	public static void main(String[] args) {
		/*
		 * Map 인터페이스이고 요놈을 구현한 구현 클래스가
		 * HashMap, TreeMap, LinkedHashMap 3개가 있다.
		 * 그래서 Map 타입의 변수는 위의 3개 타입의 객체를 수용할 수 있다.
		 * Map은 값을 <key, value>쌍으로 저장한다.
		 * Map은 Generic이다.
		 * 클래스, 메소드 내부에서 사용할 데이터 타입을 정하지 않고 실제 그 클래스 객체를 만들거나 
		 * 메소드를 호출할 때 사용할 데이터 타입을 파라미터로 받아서 처리하는것.
		 * 문자열 타입의 학번을 키로, Student 객체를 값으로 Map에 저장.
		 */
		
		Map<String, Student> map = new HashMap<>();
		
		//Map에 원소 (<key, value>로 구성된 entry)를 넣을 때는 
		//put 메소드를 사용 : put메소드는 원소 삽입과 변경에 모두 사용됨.
		//Map에서 원소(엔트리)를 읽을 때는 get(key) 메소드를 사용.
		//이미 존재하는 키 값으로 put하면
		//기존 원소를 replace 하게 된다.
		
		map.put("20201234", new Student(20201234, "황현종"));
		map.put("20201235", new Student(20201234, "황도경"));
		map.put("20201236", new Student(20201234, "황창호"));
		map.put("20201237", new Student(20201234, "황경화"));
		map.put("20201238", new Student(20201234, "황원정"));

		//원소값을 읽을 때는 키 값을 줘야 한다
//		Student std = map.get("20201237");
//		System.out.println(std);
		
		//map 객체에게 니가 가진 key 값 다 줘...	
		Set<String> keyset = map.keySet();
		//keyset에 있는 각 원소를 통해서 map에게 값을 요구하면 된다.
		//왜냐하면 그 원소가 map에 저장된 값이 key니까...
		
		Iterator<String> iter = keyset.iterator();
		while (iter.hasNext()) {
			String key = iter.next();
			Student std = map.get(key);
			System.out.println(std);
		}
		
		//Entry의 Set: <key, value> pair의 Set
		/*
		 * Map 객체에게 entrySet 메소드를 호출하면
		 * Map.Entry 타입 객체를 원소로 가지는 Set 객체가 반환 된다.
		 */
		Set<String> set1;
		Set<Integer> set2;
		Set<Student> set3;

		Set<Entry<String, Student>> entrySet = map.entrySet();
		
		Iterator<Map.Entry<String, Student>> iter2 = entrySet.iterator();
		
		while (iter2.hasNext()) {
			Map.Entry<String, Student> entry = iter2.next();
			String mykey = entry.getKey();
			Student mystd = entry.getValue();
			System.out.println("key: " + mykey + ", value: " + mystd);
		}
		
		for (Entry<String, Student> entry : map.entrySet()) {
			String mykey = entry.getKey();
			Student mystd = entry.getValue();
			System.out.println("key: " + mykey + ", value: " + mystd);
		}
	}
}


class Student{
	int number;
	String name;
	
	public String toString() {
		return "[number: " + number + ", name: " + name + "]";
	}
	public Student(int number, String name) {
		this.number = number;
		this.name = name;
	}
}




