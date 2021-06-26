package Collection;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;

public class MapTest2 {
	public static void main(String[] args) {
		String[]str = {"to", "be", "or", "not", "to", "be", "is", "a", "problem"};
		/*
		 *  Map에다 단어를 키로, 그 단어가 출현한 회수를 값으로 저장
		 */
		Map<String, Integer> map = new HashMap<>();
		//str 배열에 각 원소에 대해서 각 원소를 key라 하자.
		// 그 원소를 키(key)로 가지는 엔트리가 있는지 검사
		// 만약에 그러한 엔트리가 있으면
		// 			있다라는 것은 map.get(key)반환 되는 값이 null이 아니라는 의미
		//			int count = map.get(key);  //Integer 값인데 int 변수에 넣어도 돼?
											   //auto unboxing...
											   //객체타입의 값을 대응되는 기본 타입의 변수에 저장하려고 하면
											   //자바는 자동으로 그 객체타입의 값을 기본 타입의 값으로 변환
		// 그러한 엔트리가 없으면
		// 이 key에 해당하는 단어는 처음나온거다. 그럼, map에 추가하면 된다.
		// map.put(key, 1);  //자바는 auto boxing.. -> 기본 타입 값을 대응되는 객체 타입 값으로 자동 변환
		// {"to", "be", "or", "not", "to", "be", "is", "a", "problem"}
		// map: <"to",2>, <"be", 2>, <"or", 1>, <"not", 1>, <"is", 1>, <"a", 1>, <"problem", 1>
		for (String key : str) {
			Integer count = map.get(key);
			if(count != null) {
				
			}else {  //이 단어는 지금 처음 나왔다.
				map.put(key, 1);
			}
		}
	}
}
