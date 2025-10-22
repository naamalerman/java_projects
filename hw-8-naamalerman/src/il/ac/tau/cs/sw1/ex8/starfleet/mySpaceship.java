package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.Set;

public abstract class mySpaceship implements Spaceship{
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<? extends CrewMember> crewMembers;
	public int cargoCapacity;
	public int passengerCapacity;
	
	public String getName() {
		return this.name;
	}
	
	public int getCommissionYear() {
		return this.commissionYear;
	}
	
	public float getMaximalSpeed() {
		return this.maximalSpeed;
	}

	public int getFirePower() {
		return 10;
	}
	
	public Set<? extends CrewMember> getCrewMembers(){
		return this.crewMembers;
	}
	
	public String toString() {
		String txt = this.getClass().getName();
//		for(int i=0; i this.getClass().getFields().length;
		return txt;
	}

}
