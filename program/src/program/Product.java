package program;

public class Product {
	private String name;
	private double price;
	private int quantity;
	
	public Product() {
		this.name = "Unknown";
		this.price = 0.0;
		this.quantity = 0;
	}
	
	public Product(String name, double price, int quantity) {
		this.name = name;
		this.price = price;
		this.quantity = quantity;
	}
	
	public void displayProductInfo() {
		System.out.println("Name: "+this.name+", Price: "+this.price+", Quantity: "+this.quantity);
	}
	
	public double calculateTotalPrice() {
		return this.price*this.quantity;
	}
}
