package JavaDemoProjects;

import java.util.Scanner;

public class Demo1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s;
		int c;
		
		Scanner sc= new Scanner(System.in);
		System.out.println("Enter string");
		s= sc.nextLine();
		
		int i= 0;
		while(i<= s.length()-1){
			c= s.charAt(i);
			if(c<91){
				System.out.println((char)(c+32));
			}
			else{
				System.out.println((char)(c-32));
			}
			i++;
		}

	}

}
