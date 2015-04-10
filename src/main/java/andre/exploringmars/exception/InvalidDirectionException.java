package andre.exploringmars.exception;

public class InvalidDirectionException extends RuntimeException{

	/**
	 * 
	 */
	private static final long serialVersionUID = 8891925092277541781L;

	
	public InvalidDirectionException(String direction){
		super(String.format("The specified direction '%s' is invalid.", direction));
	}
	
}
