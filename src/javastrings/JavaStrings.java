package javastrings;

public class JavaStrings {

	public static void main(String[] args) {
		
		StringBuffer ab = new StringBuffer("Javatpoint");
		//System.out.println(ab.replace(0, 3, "hello"));
		//System.out.println(ab.delete(0, 3));
		System.out.println(ab.reverse());
		System.out.println(ab.capacity());
		
		String a = "Javatpoint ";
		System.out.println(a.trim());
		String b = "JAVA"; 
		System.out.println(a.concat(b));
		System.out.println(a.replace("J", "R"));
		System.out.println(a.replace("J", "T"));
		
		
		System.out.println(a.equalsIgnoreCase(b));
		
		System.out.println(a.isEmpty());
		System.out.println(b.hashCode());
		System.out.println(a.equals(b));
		
		String x = new String("Java"); 
		String y = new String("Java");
		System.out.println(x.equals(y));
		System.out.println(x.hashCode());
		System.out.println(y.hashCode());
		System.out.println("-------------------------------");
		System.out.println(a.intern());
		String[] arrOfStr = a.split("p", 2);
		for (String s : arrOfStr)
            System.out.println(s);
		
		System.out.println("+++++++++++++++++++++++++++");
		int value=30;  
		String s1=String.valueOf(value);  
		System.out.println(s1+10);//concatenating string with 10  
		
	}
	
	
}
