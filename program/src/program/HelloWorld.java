package program;

public class HelloWorld {
	//one line comment
	public static void main(String[] args) {
//		int num1 = 15;
//		boolean b1 = func1(num1);
//		boolean b2 = func2(num1);
//		System.out.println("and :" + (b1 && b2));
//		System.out.println("or :" + (b1 || b2));
//		System.out.println("------------------");
//		System.out.println("-- calculating b3: ");
//		boolean b3 = func1(num1) && func2(num1); //*
//		System.out.println("-- calculating b4: ");
//		boolean b4 = func1(num1) || func2(num1); //**
//		System.out.println("not :" + !b4);
		ex3();
		String[] argi = {"2"};
		ifelse(argi);
		}
	
		public static boolean func1(int x) {
		System.out.println("func1");
		return x > 10;
		}
		public static boolean func2(int x) {
		System.out.println("func2");
		return x % 2 == 0; //% is modulo, same as in Python
		}
		
		public static void ex3() {
		int num1 = 15;
		int num2 = num1++;
		System.out.println("num1 is " + num1);
		System.out.println("num2 is " + num2);
		int num3 = 12;
		int num4 = ++num3;
		System.out.println("num3 is " + num3);
		System.out.println("num4 is " + num4);
		}
		
		public static void ifelse(String[] args) {
		if (args.length < 1) {
		System.out.println("missing arguments!");
		}
		else {
		int num = Integer.parseInt(args[0]);
		if (num % 2 == 0) {
		System.out.println("*");
		}
		
		if (num % 5 == 0) {
		System.out.println("**");
		}
		else {
		System.out.println("***");
		}
		
		}
		}
}
