package il.ac.tau.cs.sw1.ex8.starfleet;

public class CrewWoman implements CrewMember{
	public String name;
	public int age;
	public int yearsInService;
	
	public CrewWoman(int age, int yearsInService, String name){
		this.name = name;
		this.age = age;
		this.yearsInService = yearsInService;
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
	

}
