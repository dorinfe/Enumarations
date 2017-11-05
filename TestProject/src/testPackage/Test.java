package testPackage;

import java.util.Scanner;

public class Test {

	public static int factorial(int n) {
		int result = 1;
		for (int i = 1; i <= n; i++) {
			result = result * i;
		}
		return result;
	}

	public static String[] factorialString(String input) {
		String[] output;

		char[] brakedString = input.toCharArray();
		output = enumarationCalculation(brakedString);

		return output;

	}

	
	//the idea is that we take the first letter each time and getting it to the end by swapping it with the next letter in line, this will get all the enumerations for the specific string
	// i got to it this way, with index numbers:
	//1  2  3
	//2  1  3
	//2  3  1
	//in this example -index 1 moved to the end, but we still didn't get all our enumerations, so we start over with the new first number.. and this is how i got to this solution :)
	
	
	private static String[] enumarationCalculation(char[] brakedString) {

		int size = brakedString.length;
		int permSize = factorial(size);
		String[] answer = new String[permSize];
		int index = 0;
		buildString(brakedString, index, size, 0, permSize,answer);
		
		return answer;
	}

	private static String buildString(char[] brakedString, int index, int size, int count, int permSize, String[] answer) {
		//reached the end of our array
		if (index == size - 1) {
			if (count == permSize) { //making sure we have all our enumerations, this is the closing call of the recursion
				return (new String(brakedString));
			} else {
				
				//if we did reach the end of the array, but didn't reach the number of enumerations, we start from the beginning to change the next letter
				return buildString(brakedString, 0, size, count, permSize, answer);
			}
		}
		//adding the current enumeration to our array
		answer[count]=new String(brakedString);
		//getting the next enumeration
		swap(brakedString, index);
		//calling the function again with the new enumeration
		return buildString(brakedString, ++index, size,++count,permSize, answer);

	}

	
	//swap help us swapping 2 leeters each time
	private static void swap(char[] brakedString, int index) {
		char holder = brakedString[index];
		brakedString[index] = brakedString[index + 1];
		brakedString[index + 1] = holder;

	}
/*
	public String reverse(String s)

	{

		char[] toRevese = new char[s.length()];
		int j = 0;

		for (int i = s.length() - 1; i >= 0; i--) {

			toRevese[j] = s.charAt(i);
			j++;

		}

		String s1 = new String(toRevese);

		return s1;

	}
*/
	public static void main(String[] args) {


		Scanner scanner = new Scanner(System.in);
		System.out.println("please enter the string you want to perform permutation on:");
		String input = scanner.nextLine();
		String[] answer = factorialString(input);
		System.out.print("[");
		for(int i=0; i< answer.length; i++)
		{
			if(i<answer.length-1) {
			System.out.print(answer[i]+",");
			}
			else {
				System.out.println(answer[i]+"]");
				System.out.println("have a good day!");
			}
		}
	}
}
