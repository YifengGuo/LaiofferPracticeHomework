package ood.parkinglot;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Each Level's spot number is immutable
 * and half is for compact and half is for large
 */
public class Level {
	public int spotsNum;
	private List<ParkingSpot> spots;
	public Level(int spotsNum) {
		this.spotsNum = spotsNum;
		spots = new ArrayList<>(spotsNum);
		for(int i = 0; i < spotsNum / 2; i++) {
			spots.add(new ParkingSpot(VehicleSize.Compact));
		}
		for(int i = spotsNum / 2; i < spotsNum; i++) {
			spots.add(new ParkingSpot(VehicleSize.Large));
		}
		
		Collections.unmodifiableList(spots); // make the element in the spots immutable
	}										 //which means the half-half distribution of spots cannot be changed
	
	public boolean hasSpot(Vehicle v) {
		for(ParkingSpot ps : spots) {
			if(ps.isFit(v)) {
				return true;
			}
		}
		return false;
	}
	
	//both two apis are linked with apis in ParkingLot
	public boolean park(Vehicle v) {
		for(ParkingSpot ps : spots) {
			if(ps.isFit(v)) {
				ps.park(v);
				return true;
			}
		}
		return false;
	}
	
	public boolean leave(Vehicle v) {
		for(ParkingSpot ps : spots) {
			if(ps.getVehicle() == v) {
				ps.leave();
				return true;
			}
		}
		return false;
	}
}
