package il.ac.tau.cs.sw1.ex8.starfleet;


import java.util.List;
import java.util.Set;

public class StealthCruiser extends Fighter{
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<? extends CrewMember> crewMembers;
	public List<Weapon> weapons;
	public static int totalStealthCruiser = 0;
	
	
	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		totalStealthCruiser++;
	}

	public StealthCruiser(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers){
		super(name, commissionYear, maximalSpeed, crewMembers, null);
		totalStealthCruiser++;
	}

	@Override 
	public int getAnnualMaintenanceCost() {
		return super.getAnnualMaintenanceCost()+totalStealthCruiser*50;
	}
	
}
