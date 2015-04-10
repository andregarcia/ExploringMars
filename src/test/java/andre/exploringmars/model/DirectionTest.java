package andre.exploringmars.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import andre.exploringmars.exception.InvalidDirectionException;

public class DirectionTest {

	@Test
	public void testFromCharacter() {
		Assert.assertTrue(Direction.fromCharacter('N').equals(Direction.NORTH));
		Assert.assertTrue(Direction.fromCharacter('S').equals(Direction.SOUTH));
		Assert.assertTrue(Direction.fromCharacter('E').equals(Direction.EAST));
		Assert.assertTrue(Direction.fromCharacter('W').equals(Direction.WEST));
	}
	
	@Test
	public void testFromCharacterWhiteSpace(){
		try{
			Direction.fromCharacter(' ');
			fail("Should throw InvalidDirectionException");
		} catch(InvalidDirectionException e){
			
		}
	}
	
	@Test
	public void testFromCharacterInvalidCharacter(){
		try{
			Direction.fromCharacter('P');
			fail("Should throw InvalidDirectionException");
		} catch(InvalidDirectionException e){
			
		}
	}

}
