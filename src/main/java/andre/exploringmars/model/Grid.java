package andre.exploringmars.model;

import andre.exploringmars.exception.InvalidInitializationCoordinatesException;

public class Grid {

	
	private int maxX;
	private int maxY;
	
	
	public Grid(int maxX, int maxY){
		if(maxX<=0 || maxY<=0){
			throw new InvalidInitializationCoordinatesException(maxX, maxY);
		}
		this.maxX = maxX;
		this.maxY = maxY;
	}


	public int getMaxX() {
		return maxX;
	}


	public void setMaxX(int maxX) {
		this.maxX = maxX;
	}


	public int getMaxY() {
		return maxY;
	}


	public void setMaxY(int maxY) {
		this.maxY = maxY;
	}
	
	
}
