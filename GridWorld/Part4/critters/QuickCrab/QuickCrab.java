import info.gridworld.grid.Grid;
import info.gridworld.grid.Location;

import java.util.ArrayList;

/*
 *  A QuickCrab processes actors the same way a CrabCritter does. 
 *  A QuickCrab moves to one of the two locations, 
 *  randomly selected, that are two spaces to its right or left, 
 *  if that location and the intervening location are both empty. 
 *  Otherwise, a QuickCrab moves like a CrabCritter.
 */
public class QuickCrab extends CrabCritter {
	public ArrayList<Location> getMoveLocations()
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        int[] dirs =
            { Location.LEFT, Location.RIGHT };
        for (Location loc : getLocationsInDirections(dirs, 2))
            if (getGrid().get(loc) == null)
                locs.add(loc);

        return locs;
    }
	public ArrayList<Location> getLocationsInDirections(int[] directions, int stepNumbers)
    {
        ArrayList<Location> locs = new ArrayList<Location>();
        Grid gr = getGrid();
        for (int d : directions) {
            Location loc = getLocation();
            for (int i = 0; i < stepNumbers; i++) {
                Location neighborLoc = loc.getAdjacentLocation(getDirection() + d);
                if (gr.isValid(neighborLoc) && gr.get(neighborLoc) == null) {
                    loc = neighborLoc;
                } else {
                    break;
                }
            }
            if (loc != getLocation()) {
                locs.add(loc);
            }
        }
        return locs;
    }    
}