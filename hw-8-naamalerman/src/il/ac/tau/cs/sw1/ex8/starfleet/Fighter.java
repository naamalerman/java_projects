package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class Fighter extends myBattleShip{
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<? extends CrewMember> crewMembers;
	public List<Weapon> weapons;
	
	public Fighter(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	public int getAnnualMaintenanceCost() {
		int engineCost = (int) Math.ceil(this.maximalSpeed*1000);
		return 2500+ engineCost + super.getWeaponsCost();
	}
}
