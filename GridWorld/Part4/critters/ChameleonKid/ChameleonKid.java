import info.gridworld.actor.Actor;

import java.util.ArrayList;
public class ChameleonKid extends ChameleonCritter {
	public ArrayList<Actor> getActors() {
	    ArrayList<Actor> neighbors = new ArrayList<Actor>();
		makeNeighbors(0, neighbors);
		makeNeighbors(180, neighbors);
		return neighbors;
	}
	public void makeNeighbors(int angle, ArrayList<Actor> actors) {
		if (getGrid().isValid(getLocation().getAdjacentLocation(getDirection()+angle))) {
            Actor target = getGrid().get(getLocation().getAdjacentLocation(getDirection()+angle));
            if (target != null) {
                actors.add(target);
            }
		}
	}
}
