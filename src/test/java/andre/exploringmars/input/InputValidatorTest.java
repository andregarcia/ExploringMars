package andre.exploringmars.input;



import static org.junit.Assert.fail;

import org.junit.Assert;
import org.junit.Test;

import andre.exploringmars.exception.InvalidInputException;

public class InputValidatorTest {

	
	
	@Test
	public void testValidateGridLine() {
		String line = "5 5";
		InputValidator.validateGridLine(line, 0);
	}

	@Test
	public void testValidateGridLineShouldFail(){
		String line = "5 5 a";
		try{
			InputValidator.validateGridLine(line, 0);
			fail("Should throw InvalidInputException");
		} catch(InvalidInputException e){
			Assert.assertEquals(0, e.getLineNumber());
			Assert.assertEquals(line, e.getLine());
		}
	}
	
	
	
	@Test
	public void testValidateProbeLine1(){
		String line = "3 2 S  ";
		InputValidator.validateProbeLine1(line, 3);
	}
	
	@Test
	public void testValidateProbeLine1ShouldFail(){
		String line = "3 S";
		try{
			InputValidator.validateProbeLine1(line, 3);
			fail("Should throw InvalidInputException");
		} catch(InvalidInputException e){
			Assert.assertEquals(3, e.getLineNumber());
			Assert.assertEquals(line, e.getLine());
		}
	}
	
	@Test
	public void testValidateProbeLine2(){
		String line = "LMLMRRLMR";
		InputValidator.validateProbeLine2(line, 4);
	}
	
	@Test
	public void testValidateProbeLine2ShouldFail(){
		String line = "LMLMQ";
		try{
			InputValidator.validateProbeLine2(line, 4);
			fail("Should throw InvalidInputException");
		} catch(InvalidInputException e){
			Assert.assertEquals(4, e.getLineNumber());
			Assert.assertEquals(line, e.getLine());
		}
	}
	
}
