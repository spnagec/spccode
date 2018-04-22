/* 
 * AP(r) Computer Science GridWorld Case Study:
 * Copyright(c) 2005-2006 Cay S. Horstmann (http://horstmann.com)
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
 * @author Chris Nevison
 * @author Barbara Cloud Wells
 * @author Cay Horstmann
 */

import info.gridworld.actor.Actor;
import info.gridworld.actor.Critter;
import info.gridworld.grid.Location;

import java.awt.Color;
/**
 * A <code>ChameleonCritter</code> takes on the color of neighboring actors as
 * it moves through the grid. <br />
 * The implementation of this class is testable on the AP CS A and AB exams.
 */
public class BlusterCritter extends Critter
{
	private int courage;
	 private static double lightenFactor = 0.05; 
	public BlusterCritter(int c) {
	       super();
	       courage = c;
	   }
	public int getCourage() {
		return courage;
	}
	public int getnumber() {
		int number = 0;
		Location center = getLocation();
		for (int i = center.getRow() - 2; i <= center.getRow() + 2; i++) {
            for (int j = center.getCol() - 2; j <= center.getCol() + 2; j++) {
                Location tempLoc = new Location(i, j);
                if (getGrid().isValid(tempLoc)) {
                    Actor a = getGrid().get(tempLoc);
                    if (a != null && a != this && a instanceof Critter) {
                        number++;
                    }
                }
            }
        }
		return number;
	}
	public void processActors() {
		if(this.courage > getnumber())
			proce(lightenFactor);
		if(this.courage < getnumber())
			proce(-lightenFactor);
	}
	public void proce(double newcourage) {
		 Color c = getColor();
         int red = (int) (c.getRed() * (1 + newcourage));
         int green = (int) (c.getGreen() * (1 + newcourage));
         int blue = (int) (c.getBlue() * (1 + newcourage));
         setColor(new Color(red, green, blue));
	}
}
