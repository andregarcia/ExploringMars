package andre.exploringmars.model;

import static org.junit.Assert.*;

import org.junit.Assert;
import org.junit.Test;

import andre.exploringmars.exception.InvalidInitializationCoordinatesException;

public class GridTest {

	@Test
	public void testGridConstructor() {
		Grid grid = new Grid(10, 5);
		Assert.assertEquals(10, grid.getMaxX());
		Assert.assertEquals(5, grid.getMaxY());
	}
	
	
	@Test
	public void testGridConstructorInvalidXCoordinate(){
		try{
			new Grid(-1, 10);
			fail("Should throw InvalidInitializationCoordinatesException");
		} catch(InvalidInitializationCoordinatesException e){
			
		}
	}
	
	
	@Test
	public void testGridConstructorInvalidYCoordinate(){
		try{
			new Grid(10, -1);
			fail("Should throw InvalidInitializationCoordinatesException");
		} catch(InvalidInitializationCoordinatesException e){
			
		}
	}
	
}
