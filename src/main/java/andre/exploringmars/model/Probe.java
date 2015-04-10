package andre.exploringmars.model;

import java.util.List;

import andre.exploringmars.exception.InvalidInitializationCoordinatesException;
import andre.exploringmars.exception.InvalidProbePositionException;
import andre.exploringmars.exception.NoMoreProbeCommandsException;

public class Probe {

	
	private int initialX;
	private int initialY;
	private Direction initialDirection;
	
	private int currentX;
	private int currentY;
	private Direction currentDirection;
	
	List<ProbeCommand> probeCommandList;
	private int nextCommandIndex;
	
	private Grid grid;
	
	public Probe(int initialX, int initialY, Direction initialDirection, List<ProbeCommand> probeCommandList, Grid grid){
		if(initialX<0 || initialY<0){
			throw new InvalidInitializationCoordinatesException(initialX, initialY);
		}
		
		this.initialX = initialX;
		this.initialY = initialY;
		this.initialDirection = initialDirection;
		
		this.currentX = initialX;
		this.currentY = initialY;
		this.currentDirection = initialDirection;
		
		this.probeCommandList = probeCommandList;
		this.nextCommandIndex = 0;
		
		this.grid = grid;
	}
	
	
	public boolean hasNextProbeCommand(){
		return this.nextCommandIndex<probeCommandList.size();
	}
	
	
	public void processNextProbeCommand(){
		if(nextCommandIndex>=probeCommandList.size()){
			throw new NoMoreProbeCommandsException();
		}
		ProbeCommandProcessor.processProbeCommand(this, probeCommandList.get(nextCommandIndex++));
		validateProbePosition();
	}
	
	
	public void processAllProbeCommands(){
		while(hasNextProbeCommand()){
			processNextProbeCommand();
		}
	}
	
	
	private void validateProbePosition(){
		if(this.currentX<0 || this.currentY<0 || this.currentX>grid.getMaxX() || this.currentY>grid.getMaxY()){
			throw new InvalidProbePositionException(this.currentX, this.currentY);
		}
	}

	
	/////// GETTERS / SETTERS ////////
	
	public int getInitialX() {
		return initialX;
	}


	public void setInitialX(int initialX) {
		this.initialX = initialX;
	}


	public int getInitialY() {
		return initialY;
	}


	public void setInitialY(int initialY) {
		this.initialY = initialY;
	}


	public Direction getInitialDirection() {
		return initialDirection;
	}


	public void setInitialDirection(Direction initialDirection) {
		this.initialDirection = initialDirection;
	}


	public int getCurrentX() {
		return currentX;
	}


	public void setCurrentX(int currentX) {
		this.currentX = currentX;
	}


	public int getCurrentY() {
		return currentY;
	}


	public void setCurrentY(int currentY) {
		this.currentY = currentY;
	}


	public Direction getCurrentDirection() {
		return currentDirection;
	}


	public void setCurrentDirection(Direction currentDirection) {
		this.currentDirection = currentDirection;
	}


	public int getNextCommandIndex() {
		return nextCommandIndex;
	}


	public void setNextCommandIndex(int currentCommandIndex) {
		this.nextCommandIndex = currentCommandIndex;
	}
	
	
	
}


