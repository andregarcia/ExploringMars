package andre.exploringmars.input;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import andre.exploringmars.exception.InvalidInputException;

public class InputValidator {

	
	public static void validateInput(List<String> inputLines){
		validateGridLine(inputLines.get(0), 0);
		for(int i=1; i<inputLines.size(); ){
			validateProbeLine1(inputLines.get(i++), i);
			validateProbeLine2(inputLines.get(i++), i);
		}
		
	}
	
	
	public static void validateGridLine(String line, int lineNumber){
		Pattern p = Pattern.compile("^[0-9]+\\s+[0-9]+\\s*$");
		Matcher m = p.matcher(line);
		if(!m.find()){
			throw new InvalidInputException(line, lineNumber);
		}
	}
	
	public static void validateProbeLine1(String line, int lineNumber){
		Pattern p = Pattern.compile("^[0-9]+\\s+[0-9]+\\s+[NSEW]\\s*$");
		Matcher m = p.matcher(line);
		if(!m.find()){
			throw new InvalidInputException(line, lineNumber);
		}
	}
	
	public static void validateProbeLine2(String line, int lineNumber){
		Pattern p = Pattern.compile("^[LRM]*\\s*$");
		Matcher m = p.matcher(line);
		if(!m.find()){
			throw new InvalidInputException(line, lineNumber);
		}
	}
}
