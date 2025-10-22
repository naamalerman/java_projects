package il.ac.tau.cs.software1.pacman;

import il.ac.tau.cs.software1.core.*;
import il.ac.tau.cs.software1.components.*;

public class PacmanBonusPotion extends PacmanBonus {
	public PacmanBonusPotion(PacmanGridComponent initialPosition) {
		super(initialPosition);
		this.imageComponent = new ImageComponent("bonus-potion");
		this.bonusScore = 500;
	}
	
	@Override
	public void onHit(GameObject other) {
		if(other instanceof PacmanPlayer) {
			EventManager eventManager = EventManager.getInstance();
			eventManager.notifyEvent("potionCollected", this, null);
		}
	}
}
