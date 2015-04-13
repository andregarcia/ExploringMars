package andre.exploringmars.exception;

public class InvalidInputException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -4133234498929979055L;

	private int lineNumber;
	private String line;
	
	public InvalidInputException(String line, int lineNumber){
		super(String.format("Input is invalid. Error on line %d = [%s] (ignoring empty lines)", lineNumber, line));
		this.lineNumber = lineNumber;
		this.line = line;
	}

	public int getLineNumber() {
		return lineNumber;
	}

	public String getLine() {
		return line;
	}
	
	
}
