package andre.exploringmars.input;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;

import andre.exploringmars.exception.InvalidDirectionException;
import andre.exploringmars.exception.InvalidInitializationCoordinatesException;
import andre.exploringmars.exception.InvalidProbeCommandException;
import andre.exploringmars.model.Direction;
import andre.exploringmars.model.Grid;
import andre.exploringmars.model.Probe;
import andre.exploringmars.model.ProbeCommand;
import junit.framework.TestCase;

public class InputTransformerTest extends TestCase {

	
	@Test
	public void testGridInputLineToGrid(){
		String inputLine = "5 10";
		Grid grid = InputTransformer.gridInputLineToGrid(inputLine);
		Assert.assertEquals(5, grid.getMaxX());
		Assert.assertEquals(10, grid.getMaxY());
	}
	
	
	@Test
	public void testGridInputLineToGridTerminatedByNewLine(){
		String inputLine = "3 1\n";
		Grid grid = InputTransformer.gridInputLineToGrid(inputLine);
		Assert.assertEquals(3, grid.getMaxX());
		Assert.assertEquals(1, grid.getMaxY());
	}
	
	
	@Test
	public void testGridInputLineToGridInvalidCoordinates(){
		String inputLine = "-1 10";
		try{
			InputTransformer.gridInputLineToGrid(inputLine);
			fail("Should throw InvalidInitializationCoordinates exception");
		} catch(InvalidInitializationCoordinatesException e){
			
		}
	}
	
	
	@Test
	public void testProbePositionInputLineToProbe(){
		String inputLine1 = "1 2 N";
		String inputLine2 = "LMLMR";
		Probe probe = InputTransformer.probeInputLinesToProbe(createGrid(), inputLine1, inputLine2, 0);
		Assert.assertEquals(1, probe.getInitialX());
		Assert.assertEquals(1, probe.getCurrentX());
		Assert.assertEquals(2, probe.getInitialY());
		Assert.assertEquals(2, probe.getCurrentY());
		Assert.assertEquals(Direction.NORTH, probe.getInitialDirection());
		Assert.assertEquals(Direction.NORTH, probe.getCurrentDirection());
	}
	
	
	@Test
	public void testProbePositionInputLineToProbeInvalidCoordinates(){
		String inputLine1 = "-1 7 N";
		String inputLine2 = "LMLMR";
		try{
			InputTransformer.probeInputLinesToProbe(createGrid(), inputLine1, inputLine2, 0);
			fail("Should throw InvalidInitializationCoordinates exception");
		} catch(InvalidInitializationCoordinatesException e){
			
		}
	}
	
	
	@Test
	public void testProbePositionInputLineToProbeInvalidDirection(){
		String inputLine1 = "1 7 Z";
		String inputLine2 = "LMLMR";
		try{
			InputTransformer.probeInputLinesToProbe(createGrid(), inputLine1, inputLine2, 0);
			fail("Should throw InvalidDirectionException exception");
		} catch(InvalidDirectionException e){
			
		}
	}
	
	
	@Test
	public void testCommandInputLineToProbeCommandList(){
		String inputLine = "LMLMR";
		List<ProbeCommand> probeCommands = InputTransformer.commandInputLineToProbeCommandList(inputLine);
		Assert.assertEquals(inputLine.length(), probeCommands.size());
		Assert.assertTrue(probeCommands.get(0).equals(ProbeCommand.LEFT));
		Assert.assertTrue(probeCommands.get(1).equals(ProbeCommand.MOVE));
		Assert.assertTrue(probeCommands.get(2).equals(ProbeCommand.LEFT));
		Assert.assertTrue(probeCommands.get(3).equals(ProbeCommand.MOVE));
		Assert.assertTrue(probeCommands.get(4).equals(ProbeCommand.RIGHT));
		
	}
	
	
	@Test
	public void testCommandInputLineToProbeCommandListTerminatedByNewLine(){
		String inputLine = "LMR\n";
		List<ProbeCommand> probeCommands = InputTransformer.commandInputLineToProbeCommandList(inputLine);
		Assert.assertEquals(inputLine.trim().length(), probeCommands.size());
		Assert.assertTrue(probeCommands.get(0).equals(ProbeCommand.LEFT));
		Assert.assertTrue(probeCommands.get(1).equals(ProbeCommand.MOVE));
		Assert.assertTrue(probeCommands.get(2).equals(ProbeCommand.RIGHT));
		
	}
	
	
	@Test
	public void testCommandInputLineToProbeCommandListInvalidProbeCommand(){
		String inputLine = "LMLMQL";
		try{
			InputTransformer.commandInputLineToProbeCommandList(inputLine);
			fail("Should throw InvalidProbeCommandException exception");
		} catch(InvalidProbeCommandException e){
			
		}
	}
	
	
	private Grid createGrid(){
		return new Grid(10, 10);
	}
}
