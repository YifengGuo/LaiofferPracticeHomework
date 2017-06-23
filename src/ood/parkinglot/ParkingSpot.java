package ood.parkinglot;

class ParkingSpot {
	private VehicleSize size;
	private Vehicle currentVehicle;
	
	public ParkingSpot(VehicleSize size) {
		this.size = size;
	}
	
	public boolean isFit(Vehicle v) {
		if(currentVehicle == null || v.getSize().getSize() <= size.getSize()) return true;
		return false;
	}
	
	public void park(Vehicle v) {
		currentVehicle = v;
	}
	
	public void leave() {
		currentVehicle = null;
	}
	
	public Vehicle getVehicle() {
		return currentVehicle;
	}
	
}
