package com.team11.cab.service;

import java.util.ArrayList;

import com.team11.cab.model.Slot;

public class FacilityTypeSchedule {
	private String facilityName;
	private int facilityId;
	private ArrayList<Slot> schedule;
	
	public FacilityTypeSchedule(String facilityName, int facilityId, ArrayList<Slot> schedule) {
		super();
		this.facilityName = facilityName;
		this.facilityId = facilityId;
		this.schedule = schedule;
	}

	public String getFacilityName() {
		return facilityName;
	}

	public void setFacilityName(String facilityName) {
		this.facilityName = facilityName;
	}

	public int getFacilityId() {
		return facilityId;
	}

	public void setFacilityId(int facilityId) {
		this.facilityId = facilityId;
	}

	public ArrayList<Slot> getSchedule() {
		return schedule;
	}

	public void setSchedule(ArrayList<Slot> schedule) {
		this.schedule = schedule;
	}
	
}
