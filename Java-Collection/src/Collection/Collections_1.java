package Collection;

import java.util.Hashtable;
import java.util.Properties;

public class Collections_1 {
	
}

//List : 순서가 있는 데이터의 집합, 데이터의 중복을 허용한다.
//ex) 대기자 명단

//Set : 순서를 유지하지 않는 데이터의 집합, 데이터의 중복을 허용하지 않는다.
//ex) 양의 정수집합, 소수의 집합
//구현클래스 : HashSet, TreeSet등

//Map : 키(key)와 값(value)의 쌍(pair)으로 이루어진 데이터의 집합
//순서는 유지되지 않으며 키는 중복을 허용하지 않고, 값은 중복을 허용한다.
//ex) 우편번호, 지역번호(전화번호)
//구현클래스 : HashMap, TreeMap, Hashtable, Properties 


//List - 순서(O), 중복(X)
//Set - 순서(X), 중복(X)
//Map - 순서(O), 중복 - 키(X), 값(O)

//==================================================================

//List인터페이스 -순서(O), 중복(O)
//추가 void add(int index, Object element)
//    boolean addAll(int index, Collection c)
//읽기 Object get(int index)
//    Object set(int index, Object element)
//검색 int indexOf(Object o)  왼쪽->오른쪽
//    int lastIndexOf(Object o)  오른쪽->왼쪽
//삭제 Object remove(int index)
//정렬 void sort(Comparator c)  //지정된 비교자로 List를 정렬
//    List subList(int fromIndex, int toIndex) 
      //지정된 범위부터 있는 객체를 반환한다.


//Set인터페이스 - 순서(X), 중복(X)
//집합과 관련된 메서드(Collection에 변화가 있으면 true, 아니면 false를 반환.)
//boolean addAll(Collection c) : 지정된 객체들을 Collection에 추가한다(합집합)
//boolean containsAll(Collection c) : 지정된 객체들이 포함되어 있는지 확인한다
//boolean removeAll(Collection c) : 지정된 객체들을 삭제한다(차집합)
//boolean retainAll(Collection c) : 지정된 객체만을 남기고 나머지는 삭제한다(교집합)


//Map인터페이스 - 순서(X), 중 키(X), 값(O)












