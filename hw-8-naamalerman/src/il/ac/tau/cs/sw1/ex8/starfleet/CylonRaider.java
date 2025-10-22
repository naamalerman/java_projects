package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class CylonRaider extends Fighter{
	
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<CrewWoman> crewMembers;
	public List<Weapon> weapons;

	public CylonRaider(String name, int commissionYear, float maximalSpeed, Set<Cylon> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}

	public int getAnnualMaintenanceCost() {
		int memberCost = crewMembers.size()*50;
		return 3500+super.getWeaponsCost()+memberCost+((int) (1200*maximalSpeed));
	}
}
