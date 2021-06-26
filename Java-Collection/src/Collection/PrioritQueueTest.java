package Collection;

import java.util.*;
public class PrioritQueueTest {
	public static void main(String[] args) {
//		test1();
		test2();
		
	}
	
	private static void test2() {
		/*
		 * 우선순위 위에 들어갈 원소를 정렬하는 방법은 2가지가 있다.
		 * 1. 그원소의 클래스 Comparable 인터페이스를 구현하는 것
		 * 2. 우선순위 큐에게 그 원소를 비교하는 방법을 따로 얄려주는 것
		 *    => Comparable 인터페이스를 구현하는 것이다.
		 *  참고로, 원소가 Comparable 인터페이스를 구현한 객체이고 
		 *  	  우선순위 큐에서 원소를 비교하는 방법도 따로 알려주면 
		 *  	  도대체 어떤 순서로 정렬하라는 건가?
		 */
		
		MyTaskComparator comp = new MyTaskComparator();
//		Queue<MyTask> q = new PriorityQueue<>(comp);
//		Queue<MyTask> q = new PriorityQueue<>(new Comparator<MyTask>() {
//
//			@Override
//			public int compare(MyTask o1, MyTask o2) {
//				// TODO Auto-generated method stub
//				return o2.priority - o1.priority;
//			}
//		}); //무명클래스로 생성
		
		//자바에서 람다란? : 오직 하나의 추상 메소드만을 가진 인터페이스의 구현체
		Queue<MyTask> q = new PriorityQueue<>(
		(o1, o2) -> o2.priority - o1.priority
		);  //람다식


		q.add(new MyTask(5, "작업1"));
		q.add(new MyTask(1, "작업2"));
		q.add(new MyTask(7, "작업3"));
		q.add(new MyTask(8, "작업4"));
		q.add(new MyTask(4, "작업5"));
		
		while (q.size() > 0) {
			MyTask task = q.poll();
			System.out.println(task);
		}
	}
	
	private static void test1() {
		Queue<Integer> q = new PriorityQueue<>();
		
		Random random = new Random();
		//무작위로 1 ~ 100개의 정수를 넣자
		for(int i=0; i<10; i++) {
			int val = random.nextInt(100)+1;
			q.offer(val);
		}
		//큐 안의 내용을 출력해보고
		System.out.println(q);
		
		//큐의 원소를 하나씩 순서대로 빼보자.
		while (q.size() > 0) {
			System.out.println(q.poll());
		}
	}
}


class MyTask implements Comparable<MyTask>{
	int priority;
	String desc;
	
	public MyTask (int priority, String desc) {
		this.priority = priority;
		this.desc = desc;
	}
	
	@Override
	public String toString() {
		return "[priority:" + priority + ", desc: " + desc + "]";
	}


	public int compareTo(MyTask o) {  //comparable이 제네릭이기 때문에 타입에따라서 바뀐다.
		//내가 크면 양수, 같으면 0, 내가 작으면 음수를 반환하면 된다.
		return this.priority - o.priority;
	}
}



class MyTaskComparator implements Comparator<MyTask>{  
	@Override
	public int compare(MyTask o1, MyTask o2) {
		//o1이 크면 양수, 같으면 o, o2가 크면 음수를 반환 
//		return o1.desc.compareTo(o2.desc);  <= desc값을 기준으로 정렬하고 싶다면
		return (-1) * (o1.priority - o2.priority);
	}
	
}

//comparable 인터페이스를 이용해서 거꾸로 꺼내기
//내가 수정할수 있는 소스면 comparable 인터페이스를 구현
//제 3자가 했다면 


