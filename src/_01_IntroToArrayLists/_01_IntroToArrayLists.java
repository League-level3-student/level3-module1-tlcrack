package _01_IntroToArrayLists;

import java.util.ArrayList;

public class _01_IntroToArrayLists {
	public static void main(String[] args) {
		//1. Create an array list of Strings
		//   Don't forget to import the ArrayList class
		ArrayList<String> stringList = new ArrayList<String>();
		//2. Add five Strings to your list
		stringList.add("Hi");
		stringList.add("Hello");
		stringList.add("Hey");
		stringList.add("Hiya");
		stringList.add("Yo");
		//3. Print all the Strings using a standard for-loop
		for(int i = 0; i<=stringList.size()-1; i++) {
			System.out.println(stringList.get(i));
		}
		
		//4. Print all the Strings using a for-each loop
		for(String s : stringList) {
			System.out.println(s);
		}
		//5. Print only the even numbered elements in the list.
		for(int i = 0; i<=stringList.size()-1; i++) {
			if(i%2==0) {
				System.out.println(stringList.get(i));
			}
		}
		//6. Print all the Strings in reverse order.
		for(int i = stringList.size()-1;i>=0; i-- ) {
			System.out.println(stringList.get(i));
		}
		//7. Print only the Strings that have the letter 'e' in them.
		for(int i = 0; i<=stringList.size()-1; i++) {
			if(stringList.get(i).contains("e")) {
				System.out.println(stringList.get(i));
			}
		}
	}
}
