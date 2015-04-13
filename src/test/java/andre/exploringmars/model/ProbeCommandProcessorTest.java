package andre.exploringmars.model;

import org.junit.Assert;
import org.junit.Test;

public class ProbeCommandProcessorTest {
	
	
	@Test
	public void testProcessProbeCommandWhenMoveNorth() {
		Probe probe = new Probe(5, 3, Direction.NORTH, null, null, 0);
		
		Assert.assertEquals(3, probe.getCurrentY());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.MOVE);
		Assert.assertEquals(4, probe.getCurrentY());
		
		
	}
	
	
	@Test
	public void testProcessProbeCommandWhenMoveSouth() {
		Probe probe = new Probe(5, 3, Direction.SOUTH, null, null, 0);
		
		Assert.assertEquals(3, probe.getCurrentY());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.MOVE);
		Assert.assertEquals(2, probe.getCurrentY());
		
		
	}
	
	
	@Test
	public void testProcessProbeCommandWhenMoveEast() {
		Probe probe = new Probe(5, 3, Direction.EAST, null, null, 0);
		
		Assert.assertEquals(5, probe.getCurrentX());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.MOVE);
		Assert.assertEquals(6, probe.getCurrentX());
		
	}
	
	
	@Test
	public void testProcessProbeCommandWhenMoveWest() {
		Probe probe = new Probe(5, 3, Direction.WEST, null, null, 0);
		
		Assert.assertEquals(5, probe.getCurrentX());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.MOVE);
		Assert.assertEquals(4, probe.getCurrentX());
		
	}
	
	
	@Test
	public void testProcessProbeCommandWhenTurnRightWestPosition() {
		Probe probe = new Probe(5, 3, Direction.WEST, null, null, 0);
		
		Assert.assertEquals(Direction.WEST, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.RIGHT);
		Assert.assertEquals(Direction.NORTH, probe.getCurrentDirection());
		
	}
	
	
	@Test
	public void testProcessProbeCommandWhenTurnRightNorthPosition() {
		Probe probe = new Probe(5, 3, Direction.NORTH, null, null, 0);
		
		Assert.assertEquals(Direction.NORTH, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.RIGHT);
		Assert.assertEquals(Direction.EAST, probe.getCurrentDirection());
		
	}
	
	@Test
	public void testProcessProbeCommandWhenTurnRightEastPosition() {
		Probe probe = new Probe(5, 3, Direction.EAST, null, null, 0);
		
		Assert.assertEquals(Direction.EAST, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.RIGHT);
		Assert.assertEquals(Direction.SOUTH, probe.getCurrentDirection());
		
	}
	
	@Test
	public void testProcessProbeCommandWhenTurnRightSouthPosition() {
		Probe probe = new Probe(5, 3, Direction.SOUTH, null, null, 0);
		
		Assert.assertEquals(Direction.SOUTH, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.RIGHT);
		Assert.assertEquals(Direction.WEST, probe.getCurrentDirection());
		
	}

	
	
	
	
	
	@Test
	public void testProcessProbeCommandWhenTurnLeftWestPosition() {
		Probe probe = new Probe(5, 3, Direction.WEST, null, null, 0);
		
		Assert.assertEquals(Direction.WEST, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.LEFT);
		Assert.assertEquals(Direction.SOUTH, probe.getCurrentDirection());
		
	}
	
	
	
	@Test
	public void testProcessProbeCommandWhenTurnLeftNorthPosition() {
		Probe probe = new Probe(5, 3, Direction.NORTH, null, null, 0);
		
		Assert.assertEquals(Direction.NORTH, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.LEFT);
		Assert.assertEquals(Direction.WEST, probe.getCurrentDirection());
		
	}
	
	@Test
	public void testProcessProbeCommandWhenTurnLeftEastPosition() {
		Probe probe = new Probe(5, 3, Direction.EAST, null, null, 0);
		
		Assert.assertEquals(Direction.EAST, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.LEFT);
		Assert.assertEquals(Direction.NORTH, probe.getCurrentDirection());
		
	}

	
	@Test
	public void testProcessProbeCommandWhenTurnLeftSouthPosition() {
		Probe probe = new Probe(5, 3, Direction.SOUTH, null, null, 0);
		
		Assert.assertEquals(Direction.SOUTH, probe.getCurrentDirection());
		ProbeCommandProcessor.processProbeCommand(probe, ProbeCommand.LEFT);
		Assert.assertEquals(Direction.EAST, probe.getCurrentDirection());
		
	}
	
	
}
