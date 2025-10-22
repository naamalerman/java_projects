package il.ac.tau.cs.sw1.ex8.starfleet;
import java.util.List;
import java.util.Set;

public class myBattleShip extends mySpaceship {
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<? extends CrewMember> crewMembers;
	public int cargoCapacity;
	public int passengerCapacity;
	public List<Weapon> weapons;
	
	public myBattleShip(String name, int commissionYear, float maximalSpeed, Set<? extends CrewMember> crewMembers, List<Weapon> weapons){
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
		this.weapons = weapons;
	}
	
	
	public List<Weapon> getWeapon(){
		return null;
		
	}
	
	@Override
	public int getFirePower() {
		int weaponsPower = 0;
		for(Weapon w: weapons) {
			weaponsPower+=w.getFirePower();
		}
		return super.getFirePower() + weaponsPower;
	}
	
	public int getAnnualMaintenanceCost() {
		return 0;
	}
	
	public int getWeaponsCost() {
		int weaponsCost = 0;
		for(Weapon w: weapons) {
			weaponsCost+=w.getAnnualMaintenanceCost();
		}
		return weaponsCost;
	}
}

