package info.gridworld.grid;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.*;
import info.gridworld.grid.*;

/**
 * <code>AbstractGrid</code> contains the methods that are common to grid
 * implementations. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid2<E> extends AbstractGrid<E> {
	 private Map<Location, E> occupantMap;
	 private int numRow;
	 private int numCol;
	 public SparseBoundedGrid2(int rows, int cols) {
	        if (rows <= 0) {
	            throw new IllegalArgumentException("rows <= 0");
	        }
	        if (cols <= 0) {
	            throw new IllegalArgumentException("cols <= 0");
	        }
	        numRow = rows;
	        numCol = cols;
	        occupantMap = new HashMap<Location, E>();
	    }
	 public int getNumRows() {
	        return numRow;
	    }

	    public int getNumCols() {
	        return numCol;
	    }
	    public boolean isValid(Location loc)
	    {
	        return 0 <= loc.getRow() && loc.getRow() < getNumRows()
	                && 0 <= loc.getCol() && loc.getCol() < getNumCols();
	    }

	    public ArrayList<Location> getOccupiedLocations()
	    {
	        ArrayList<Location> theLocations = new ArrayList<Location>();

	        // Look at all grid locations.
	        for (Location loc : occupantMap.keySet()) {
	            theLocations.add(loc);
	        }
	        return theLocations;
	    }

	    public E get(Location loc)
	    {
	        if (!isValid(loc))
	            throw new IllegalArgumentException("Location " + loc
	                    + " is not valid");
	        return occupantMap.get(loc); // unavoidable warning
	    }

	    public E put(Location loc, E obj)
	    {
	    	if (!isValid(loc)){
	            throw new IllegalArgumentException("Location " + loc
	                    + " is not valid");
	        }
	        if (obj == null){
	            return null;
	        }
	        return occupantMap.put(loc, obj);
	    }

	    public E remove(Location loc)
	    {
	    	if (!isValid(loc)) {
	            throw new IllegalArgumentException("Location " + loc
	                    + " is not valid");
	        }
	        return occupantMap.remove(loc);
	    }
}

