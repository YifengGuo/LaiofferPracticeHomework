package ood.parkinglot;

public class ParkingLot {
	private Level[] levels;
	public ParkingLot(int levelNum, int spotsPerLevel) {
		levels = new Level[levelNum];
		for(int i = 0; i < levelNum; i++) {
			levels[i] = new Level(spotsPerLevel);
		}
	}
	
	public boolean hasSpot(Vehicle v) {
		for(Level l : levels) {
			if(l.hasSpot(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean park(Vehicle v) {
		for(Level l : levels) {
			if(l.park(v)) {
				return true;
			}
		}
		return false;
	}
	
	public boolean leave(Vehicle v) {
		for(Level l : levels) {
			if(l.leave(v)) {
				return true;
			}
		}
		return false;
	}
	
	
}
