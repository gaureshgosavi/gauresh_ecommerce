package JavaDemoProjects;

public class Demo {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String s= "AbcDe";
		char[] c= s.toCharArray();
		int i= 0;
		while(i<= s.length()-1){
			char a=c[i];
			if (a >= 'A' && a <= 'Z'){
				int x= c[i];
				x= x+32;
				System.out.println(c[x]);
			}
			if (a >= 'a' && a <= 'z'){
				int x= c[i];
				x= x-32;
				System.out.println(c[x]);
			}
			i++;
		
		}
	}

}
