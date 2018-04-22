import static org.junit.Assert.*;
import info.gridworld.actor.*;
import info.gridworld.grid.*;
import info.gridworld.actor.ActorWorld;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import java.awt.Color;


public class JumperTest {
	 public ActorWorld w = new ActorWorld();
	 public Jumper a = new Jumper();
	 public Jumper b = new Jumper();
	 public Rock r = new Rock();
	 public Flower f = new Flower();
	 public Actor x = new Actor();

	@Before
	public void setUp() throws Exception {
		w.add(new Location(0, 0), a);
		a.setDirection(90);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void testAct() {
		a.act();
		assertEquals(a.getDirection(), 90);
		assertEquals(a.getLocation(), new Location(0, 2));
	}

	@Test
	public void testJumper() {
		assertEquals(a.getColor(), Color.BLUE);
	}

	@Test
	public void testJump() {
		a.jump();
		assertEquals(a.getLocation(), new Location(0, 2));
	}

	@Test
	public void testCanJump() {
		a.canJump();
		assertEquals(a.canJump(), true);
	}
	@Test
	public void testMoveOutGridside() {
		a.moveTo(new Location(0, 0));
        a.setDirection(Location.NORTH);
        a.move();
        assertEquals(null, a.getLocation());
	}
	@Test
	public void testActOutGridside() {
		a.act();
        assertEquals(new Location(0, 2), a.getLocation());
        assertEquals(90, a.getDirection());

        a.moveTo(new Location(1, 0));
        a.setDirection(Location.NORTH);
        a.act();
        assertEquals(new Location(1, 0), a.getLocation());
        assertEquals(45, a.getDirection());
	}
	@Test
	public void testMoveToTheRock() {
		 a.setDirection(Location.SOUTH);
		 w.add(r);
         r.moveTo(new Location(0, 1));
         a.act();
         assertEquals(new Location(2, 0), a.getLocation());
         r.moveTo(new Location(4, 0));
         a.act();
         assertEquals(new Location(2, 0), a.getLocation());
         assertEquals(225, a.getDirection());
	}
	@Test
	public void testMoveToFollow() {
		a.setDirection(0);
		a.moveTo(new Location(4, 4));
        w.add(new Location(2, 4), f);
        Location loc = new Location(4, 4);
        a.act();
        assertEquals(loc, a.getLocation());
        assertEquals(45, a.getDirection());
        loc = new Location(2, 6);
        a.act();
        assertEquals(loc, a.getLocation());
        assertEquals(45, a.getDirection());
	}
	@Test
	public void testActorFacingActor() {
		b.setDirection(0);
		a.setDirection(180);
		a.moveTo(new Location(2, 4));
        w.add(new Location(4, 4), b);
        a.act();
        b.act();
        assertEquals(new Location(2, 4), a.getLocation());
        assertEquals(225, a.getDirection());
        assertEquals(new Location(4, 4), b.getLocation());
        assertEquals(45, b.getDirection());
	}
	
  
}
