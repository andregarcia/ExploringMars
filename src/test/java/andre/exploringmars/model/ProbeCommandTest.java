package andre.exploringmars.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import andre.exploringmars.exception.InvalidProbeCommandException;

public class ProbeCommandTest {

	@Test
	public void testFromCharacter() {
		Assert.assertTrue(ProbeCommand.fromCharacter('L').equals(ProbeCommand.LEFT));
		Assert.assertTrue(ProbeCommand.fromCharacter('R').equals(ProbeCommand.RIGHT));
		Assert.assertTrue(ProbeCommand.fromCharacter('M').equals(ProbeCommand.MOVE));
	}
	
	@Test
	public void testFromCharacterInvalidCharacter(){
		try{
			ProbeCommand.fromCharacter('Q');
			fail("Should throw InvalidProbeCommandException");
		} catch(InvalidProbeCommandException e){
			
		}
	}

}
