package andre.exploringmars.model;


import static org.junit.Assert.fail;

import java.util.ArrayList;
import java.util.List;






import org.junit.Assert;
import org.junit.Test;

import andre.exploringmars.exception.InvalidInitializationCoordinatesException;
import andre.exploringmars.exception.InvalidProbePositionException;

public class ProbeTest {

	@Test
	public void testProbeConstructor() {
		Probe probe = new Probe(5, 10, Direction.SOUTH, createProbeCommandList(), createGrid());
		
		Assert.assertEquals(5, probe.getInitialX());
		Assert.assertEquals(5, probe.getCurrentX());
		Assert.assertEquals(10, probe.getInitialY());
		Assert.assertEquals(10, probe.getCurrentY());
		Assert.assertEquals(0, probe.getNextCommandIndex());
		Assert.assertEquals(Direction.SOUTH, probe.getInitialDirection());
		Assert.assertEquals(Direction.SOUTH, probe.getCurrentDirection());
	}

	
	@Test
	public void testProbeConstructorInvalidXCoordinate(){
		try{
			new Probe(-1, 10, Direction.SOUTH, createProbeCommandList(), createGrid());
			Assert.fail("Should throw InvalidInitializationCoordinatesException");
		} catch(InvalidInitializationCoordinatesException e){
			
		}
	}
	
	
	@Test
	public void testProbeConstructorInvalidYCoordinate(){		
		try{
			new Probe(10, -1, Direction.SOUTH, createProbeCommandList(), createGrid());
			Assert.fail("Should throw InvalidInitializationCoordinatesException");
		} catch(InvalidInitializationCoordinatesException e){
			
		}
	}
	
	
	@Test
	public void testHasNextProbeCommand(){
		//construct probe
		List<ProbeCommand> probeCommandList = createProbeCommandList();
		Probe probe = new Probe(5, 10, Direction.SOUTH, probeCommandList, createGrid());
		
		//assert has next command
		Assert.assertTrue(probe.hasNextProbeCommand());
		
		//run all commands
		for(int i=0; i<probeCommandList.size(); i++){
			probe.processNextProbeCommand();
		}
		
		//assert does not have any next command
		Assert.assertFalse(probe.hasNextProbeCommand());
	}
	
	
	@Test
	public void testProcessNextProbeCommand(){
		//construct probe
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.MOVE);
		probeCommandList.add(ProbeCommand.LEFT);
		Probe probe = new Probe(5, 10, Direction.SOUTH, probeCommandList, createGrid());
		
		Assert.assertEquals(0, probe.getNextCommandIndex());
		probe.processNextProbeCommand();
		Assert.assertEquals(9, probe.getCurrentY());
		Assert.assertEquals(1, probe.getNextCommandIndex());
	}
	
	
	@Test
	public void testProcessNextProbeCommandInvalidXPositionLowerThanZero(){
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.MOVE);
		Probe probe = new Probe(0, 0, Direction.WEST, probeCommandList, createGrid());
		try{
			probe.processNextProbeCommand();
			fail("Should throw InvalidProbePositionException");
		} catch(InvalidProbePositionException e){
			
		}
	}
	
	
	@Test
	public void testProcessNextProbeCommandInvalidXPositionGreaterThanMax(){
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.MOVE);
		Grid grid = createGrid();
		Probe probe = new Probe(grid.getMaxX(), 0, Direction.EAST, probeCommandList, grid);
		try{
			probe.processNextProbeCommand();
			fail("Should throw InvalidProbePositionException");
		} catch(InvalidProbePositionException e){
			
		}
	}
	
	
	@Test
	public void testProcessNextProbeCommandInvalidYPositionLowerThanZero(){
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.MOVE);
		Probe probe = new Probe(0, 0, Direction.SOUTH, probeCommandList, createGrid());
		try{
			probe.processNextProbeCommand();
			fail("Should throw InvalidProbePositionException");
		} catch(InvalidProbePositionException e){
			
		}
	}
	
	
	@Test
	public void testProcessNextProbeCommandInvalidYPositionGreaterThanMax(){
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.MOVE);
		Grid grid = createGrid();
		Probe probe = new Probe(0, grid.getMaxY(), Direction.WEST, probeCommandList, grid);
		try{
			probe.processNextProbeCommand();
			fail("Should throw InvalidProbePositionException");
		} catch(InvalidProbePositionException e){
			
		}
	}
	
	
	@Test
	public void testProcessAllProbeCommands(){
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.LEFT);
		probeCommandList.add(ProbeCommand.MOVE);
		probeCommandList.add(ProbeCommand.MOVE);
		probeCommandList.add(ProbeCommand.RIGHT);
		probeCommandList.add(ProbeCommand.MOVE);
		Probe probe = new Probe(5, 3, Direction.WEST, probeCommandList, createGrid());
		probe.processAllProbeCommands();

		Assert.assertFalse(probe.hasNextProbeCommand());
		Assert.assertEquals(4, probe.getCurrentX());
		Assert.assertEquals(1, probe.getCurrentY());
	}
	
	
	private List<ProbeCommand> createProbeCommandList(){
		List<ProbeCommand> probeCommandList = new ArrayList<ProbeCommand>();
		probeCommandList.add(ProbeCommand.LEFT);
		probeCommandList.add(ProbeCommand.MOVE);
		probeCommandList.add(ProbeCommand.RIGHT);
		return probeCommandList;
	}
	
	private Grid createGrid(){
		return new Grid(10, 10);
	}
}
