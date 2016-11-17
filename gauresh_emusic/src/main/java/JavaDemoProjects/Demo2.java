package JavaDemoProjects;

import java.util.Scanner;

public class Demo2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		char[] charArr = {};
		int a = 0;

		Scanner sc = new Scanner(System.in);
		System.out.println("Enter string");
		s = sc.nextLine();

		int i = s.length() - 1;
		while (i >= 0) {
			char c = s.charAt(i);
			charArr[a] = c;
			a++;
			i--;
		}
	}
}
