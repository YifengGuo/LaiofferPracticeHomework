package ood.parkinglot;

public enum VehicleSize {
	Large(2),
	Compact(1);
	
	private int size;

	VehicleSize(int size) {
		this.size = size;
	}
	
	public int getSize() {
		return size;
	}
}
