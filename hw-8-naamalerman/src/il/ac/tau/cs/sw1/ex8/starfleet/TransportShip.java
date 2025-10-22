package il.ac.tau.cs.sw1.ex8.starfleet;

import java.util.List;
import java.util.Set;

public class TransportShip extends mySpaceship{
	public String name;
	public int commissionYear;
	public float maximalSpeed;
	public Set<? extends CrewMember> crewMembers;
	public List<Weapon> weapons;
	public int cargoCapacity;
	public int passengerCapacity;
	
	public TransportShip(String name, int commissionYear, float maximalSpeed, Set<CrewMember> crewMembers, int cargoCapacity, int passengerCapacity){
		this.name = name;
		this.commissionYear = commissionYear;
		this.maximalSpeed = maximalSpeed;
		this.crewMembers = crewMembers;
		this.cargoCapacity = cargoCapacity;
		this.passengerCapacity = passengerCapacity;
	}
	
	public int getCargoCapacity() {
		return this.cargoCapacity;
	}
	
	public int getPassengerCapacity() {
		return this.passengerCapacity;
	}
	
	public int getAnnualMaintenanceCost() {
		return 300+5*this.cargoCapacity+3*this.passengerCapacity;
	}
}
