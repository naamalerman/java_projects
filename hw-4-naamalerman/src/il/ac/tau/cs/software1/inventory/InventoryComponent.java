package il.ac.tau.cs.software1.inventory;

import il.ac.tau.cs.software1.components.*;

import il.ac.tau.cs.software1.math.*;

public class InventoryComponent implements IComponent{
	private static final Vector2 INVENTORY_POSITION = new Vector2(-100.0f, -100.0f);
	private static final float INITIAL_MAX_WEIGHT = 10;
	Inventory inventory;
	float maxWeight;
	
	public InventoryComponent() {
		inventory = new NaiveInventory();
		maxWeight = INITIAL_MAX_WEIGHT;
	}
	
	public Inventory getInventory() {
		return inventory;
	}
	
	public Vector2 getInventoryPosition() {
		return INVENTORY_POSITION;
	}
	
	public void setMaxWeight(float weight) {
		maxWeight=weight;
	}
	
	public float getMaxWeight() {
		return maxWeight;
	}
}
