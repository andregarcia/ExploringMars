package andre.exploringmars.exception;

public class InvalidInitializationCoordinatesException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = -1900508558856564531L;

	
	public InvalidInitializationCoordinatesException(int maxX, int maxY){
		super(String.format("Position or size cannot be initialized with values %d, %d", maxX, maxY));
	}
	
	
}
