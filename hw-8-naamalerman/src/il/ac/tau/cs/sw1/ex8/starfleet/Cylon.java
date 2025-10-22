package il.ac.tau.cs.sw1.ex8.starfleet;

public class Cylon implements CrewMember{
	public String name;
	public int age;
	public int yearsInService;
	public int modelNumber;
		
	public Cylon(String name, int age, int yearsInService, int modelNumber) {
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
		this.modelNumber = modelNumber;
	}
	
	public String getName() {
		return this.name;
	}
	
	public int getAge() {
		return this.age;
	}
	
	public int getYearService() {
		return this.yearsInService;
	}
	
	public int getModelNumber() {
		return this.modelNumber;
	}
	

}
