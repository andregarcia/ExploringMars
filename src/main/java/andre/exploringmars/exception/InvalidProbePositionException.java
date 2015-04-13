package andre.exploringmars.exception;

public class InvalidProbePositionException extends RuntimeException{

	
	/**
	 * 
	 */
	private static final long serialVersionUID = -7797330513639837353L;

	private int x;
	private int y;
	private int probeNumber;
	
	public InvalidProbePositionException(int x, int y, int probeNumber){
		super(String.format("Probe number %d got out of bounds (position (%d, %d)).", probeNumber, x, y));
		this.x = x;
		this.y = y;
		this.probeNumber = probeNumber;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getProbeNumber() {
		return probeNumber;
	}

	public void setProbeNumber(int probeNumber) {
		this.probeNumber = probeNumber;
	}
	
	
	
}
