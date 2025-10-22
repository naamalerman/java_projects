package program;

public class ProductTest {
	public static void main(String[] args) {
		Product p1 = new Product();
		Product p2 = new Product("apple", 3.0, 10);
		p1.displayProductInfo();
		p2.displayProductInfo();
		System.out.println(p1.calculateTotalPrice());
		System.out.println(p2.calculateTotalPrice());
	}

}
