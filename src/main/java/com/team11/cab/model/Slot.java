package com.team11.cab.model;

public class Slot {
	private String slotName;
	private Boolean booked;
	
	public Slot(String slotName, Boolean booked) {
		super();
		this.slotName = slotName;
		this.booked = booked;
	}

	public String getSlotName() {
		return slotName;
	}

	public void setSlotName(String slotName) {
		this.slotName = slotName;
	}

	public Boolean getBooked() {
		return booked;
	}

	public void setBooked(Boolean booked) {
		this.booked = booked;
	}
	
}
