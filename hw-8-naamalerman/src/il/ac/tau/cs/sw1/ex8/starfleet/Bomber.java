package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Bomber extends myBattleShip{
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<? extends CrewMember> crewMembers;
	public List<Weapon> weapons;
	public int numberOfTechnicians;

	public Bomber(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, List<Weapon> weapons, int numberOfTechnicians){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
		this.numberOfTechnicians = numberOfTechnicians;
	}

	public int getNumberOfTechnicians() {
		return this.numberOfTechnicians;
	}
	
	public int getAnnualMaintenanceCost() {
		int technician = (int) Math.ceil((5000+super.getWeaponsCost())*(this.numberOfTechnicians*10)/100); 
		return technician;
	}
}
