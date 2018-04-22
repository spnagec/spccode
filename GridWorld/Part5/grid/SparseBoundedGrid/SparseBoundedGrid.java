/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2002-2006 College Entrance Examination Board 
 * (http://www.collegeboard.com).
 *
 * This code is free software; you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation.
 *
 * This code is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 * 
 * @author Alyce Brady
 * @author APCS Development Committee
 * @author Cay Horstmann
 */
package info.gridworld.grid;
import java.util.ArrayList;
import java.util.LinkedList;
import info.gridworld.grid.*;

/**
 * A <code>BoundedGrid</code> is a rectangular grid with a finite number of
 * rows and columns. <br />
 * The implementation of this class is testable on the AP CS AB exam.
 */
public class SparseBoundedGrid<E> extends AbstractGrid<E>
{
    private LinkedList<OccupantInCol>[] occupantArray;// the array storing the grid elements
    private int numRow;
    private int numCol;

    /**
     * Constructs an empty bounded grid with the given dimensions.
     * (Precondition: <code>rows > 0</code> and <code>cols > 0</code>.)
     * @param rows number of rows in BoundedGrid
     * @param cols number of columns in BoundedGrid
     */
    public class OccupantInCol {
        private Object occupant;
        private int col;

        public OccupantInCol(Object tocu, int tcol) {
            occupant = tocu;
            col = tcol;
        }

        public Object getOccupant() {
            return occupant;
        }

        public int getCol() {
            return col;
        }

        public void setOccupant(Object ocu) {
            occupant = ocu;
        }
    }
    public SparseBoundedGrid(int rows, int cols)
    {
        if (rows <= 0)
            throw new IllegalArgumentException("rows <= 0");
        if (cols <= 0)
            throw new IllegalArgumentException("cols <= 0");
        numRow = rows;
        numCol = cols;
        occupantArray = (LinkedList<OccupantInCol>[]) new LinkedList<?>[numRow];
        for (int i = 0; i < numRow; i++) {
            occupantArray[i] = new LinkedList<OccupantInCol>();
        }
    }

    public int getNumRows()
    {
        return numRow;
    }

    public int getNumCols()
    {
        // Note: according to the constructor precondition, numRows() > 0, so
        // theGrid[0] is non-null.
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
        for (int r = 0; r < getNumRows(); r++)
        {
            for (OccupantInCol ocu : occupantArray[r])
            {
                // If there's an object at this location, put it in the array.
            	 theLocations.add(new Location(r, ocu.getCol()));
            }
        }

        return theLocations;
    }

    public E get(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        for(OccupantInCol ocu : occupantArray[loc.getRow()]) {
        	if(loc.getCol() == ocu.getCol())
        		return (E) ocu.getOccupant();
        }
        return null;
    }

    public E put(Location loc, E obj)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        if (obj == null)
            throw new NullPointerException("obj == null");

        // Add the object to the grid.
        E oldOccupant = get(loc);
        if (oldOccupant != null) {
            for (OccupantInCol ocu : occupantArray[loc.getRow()]) {
                if (ocu.getCol() == loc.getCol()) {
                    ocu.setOccupant(obj);
                    break;
                }
            }
        } else {
            occupantArray[loc.getRow()].add(new OccupantInCol(obj, loc.getCol()));
        }
        return oldOccupant;
    }

    public E remove(Location loc)
    {
        if (!isValid(loc))
            throw new IllegalArgumentException("Location " + loc
                    + " is not valid");
        
        // Remove the object from the grid.
        E r = get(loc);
        if (r != null) {
            for (OccupantInCol ocu : occupantArray[loc.getRow()]) {
                if (ocu.getCol() == loc.getCol()) {
                    occupantArray[loc.getRow()].remove(ocu);
                    break;
                }
            }
        }
        return r;
    }
}
