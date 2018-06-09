package com.team11.cab.model;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

/* facility class */

@Entity
@Table(name = "facility")
public class Facility {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int FacilityId;
	private String FacilityName;
	private int FacilityType;
	private String Location;
	private String Description;
	public Facility() {
		super();
	}	
	
	public Facility(int facilityId, String facilityName, int facilityType, String location, String description) {
		super();
		this.FacilityId = facilityId;
		this.FacilityName = facilityName;
		this.FacilityType = facilityType;
		this.Location = location;
		this.Description = description;
	}

	
	@ManyToOne(cascade=CascadeType.ALL,fetch=FetchType.EAGER)
    @JoinColumn(name="facilitytype_TypeId")//加入一列作为外键
	private FacilityType facilitytype;
	
	public int getFacilityId() {
		return FacilityId;
	}

	public void setFacilityId(int facilityId) {
		FacilityId = facilityId;
	}

	public String getFacilityName() {
		return FacilityName;
	}

	public void setFacilityName(String facilityName) {
		FacilityName = facilityName;
	}

	public int getFacilityType() {
		return FacilityType;
	}

	public void setFacilityType(int facilityType) {
		FacilityType = facilityType;
	}

	public String getLocation() {
		return Location;
	}

	public void setLocation(String location) {
		Location = location;
	}

	public String getDescription() {
		return Description;
	}

	public void setDescription(String description) {
		Description = description;
	}

	
	
	public FacilityType getFacilityTypeObject() {
        return facilitytype; 
    }
    public void setFacilityType(FacilityType facilitytype) {
        this.facilitytype = facilitytype;
    }
	
	
	@Override
	public String toString() {
		return "Facility [FacilityId=" + FacilityId + ", FacilityName=" + FacilityName + ", FacilityType="
				+ FacilityType + ", Location=" + Location + ", Description=" + Description + "]";
	}
	
	
	
	

}
