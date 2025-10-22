package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class ColonialViper extends Fighter{
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<CrewWoman> crewMembers;
	public List<Weapon> weapons;

	public ColonialViper(String name, int commissionYear, float maximalSpeed, Set<CrewWoman> crewMembers,
			List<Weapon> weapons) {
		super(name, commissionYear, maximalSpeed, crewMembers, weapons);
	}
	
	@Override
	public int getAnnualMaintenanceCost() {
		int memberCost = crewMembers.size()*50;
		return 4000+super.getWeaponsCost()+memberCost+((int) (500* maximalSpeed));
	}
}
