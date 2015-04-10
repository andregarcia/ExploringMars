package andre.exploringmars.exception;

public class InvalidProbePositionException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7797330513639837353L;

	
	public InvalidProbePositionException(int x, int y){
		super(String.format("Invalid probe position %d, %d", x, y));
	}
	
	
	
}
