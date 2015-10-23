import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Random;

public class Main {
	
	static long  time;
	static long  end;
	
	public static void initList(List<Integer> lista){
		Random r = new Random();
		for (int i = 0; i < 1000000; i++) {
			lista.add(r.nextInt());		
		}
	}
	
	public static long getElements(List<Integer> lista){
		Random r = new Random();
		time = System.currentTimeMillis();
		for (int i = 0; i < lista.size()/10; i++) {		
			lista.get(r.nextInt(lista.size()));
		}
		end = System.currentTimeMillis();
		return end-time;
	}
	
	public static long timeElapsedForInitializationOfLis(List<Integer> lista){
		time = System.currentTimeMillis();
		initList(lista);
		end = System.currentTimeMillis();
		return end - time;
	}
	
	public static long timeElapsedForRemovingTheFirstElementOfList(List<Integer> lista){
		time = System.currentTimeMillis();
		lista.remove(0);
		end = System.currentTimeMillis();
		return end-time;
	}
	
	public static long timeElapsedForRemovingTheLAstElementOfList(List<Integer> lista){
		time = System.currentTimeMillis();
		lista.remove(lista.size()-1);
		end = System.currentTimeMillis();
		return end - time;
	}
	
	public static long timeElapsedForRemovingTheMiddleElementOfList(List<Integer> lista){
		time = System.currentTimeMillis();
		lista.remove(lista.size()/2);
		end = System.currentTimeMillis();
		return end-time;
	}
	
	public static void printTheResultsForArrayList(List<Integer> lista){
		System.out.println("time elapsed for initializaton of Array List "+ timeElapsedForInitializationOfLis(lista));
		System.out.println("Reaching the 10 percent of elements of Array List "+Long.toBinaryString(getElements(lista)));
		System.out.println("removing the first element of Array List "+timeElapsedForRemovingTheFirstElementOfList(lista));
		System.out.println("removing the last element of Array List "+timeElapsedForRemovingTheLAstElementOfList(lista));
		System.out.println("removing the middle element of Array List "+timeElapsedForRemovingTheMiddleElementOfList(lista));	
	}
	
	public static void printTheResultsForLinkedList(List<Integer> lista){
		System.out.println("time elapsed for initializaton of Linked List "+ timeElapsedForInitializationOfLis(lista));
		System.out.println("Reaching the 10 percent of elements of Linked List "+Long.toBinaryString(getElements(lista)));
		System.out.println("removing the first element of Linked List "+timeElapsedForRemovingTheFirstElementOfList(lista));
		System.out.println("removing the last element of Linked List "+timeElapsedForRemovingTheLAstElementOfList(lista));
		System.out.println("removing the middle element of Linked List "+timeElapsedForRemovingTheMiddleElementOfList(lista));	
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		List<Integer> lista = new ArrayList<Integer>();
		printTheResultsForArrayList(lista);
		/////////////////////////////////////////////////////////////////////////
		lista = new LinkedList<Integer>();
		printTheResultsForLinkedList(lista);
	}
}
