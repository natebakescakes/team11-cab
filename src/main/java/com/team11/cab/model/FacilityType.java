package com.team11.cab.model;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "facilitytype")
public class FacilityType {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int TypeId;
	private String TypeName;
    private String Description;
    
    
	public FacilityType() {
		super();
	}


	public FacilityType(int typeId, String typeName, String description) {
		super();
		this.TypeId = typeId;
		this.TypeName = typeName;
		this.Description = description;
	}
	
	
	@OneToMany(cascade=CascadeType.ALL,fetch=FetchType.LAZY,mappedBy="facility")
	private Set<Facility> setFacility; 
    
    
    

	 public int getTypeId() {
		return TypeId;
	}


	public void setTypeId(int typeId) {
		TypeId = typeId;
	}


	public String getTypeName() {
		return TypeName;
	}


	public void setTypeName(String typeName) {
		TypeName = typeName;
	}


	public String getDescription() {
		return Description;
	}


	public void setDescription(String description) {
		Description = description;
	}


	public Set<Facility> getSetFacility() {
		return setFacility;
	}


	public Set<Facility> getSetfacility() {
	        return setFacility;
	    }
	 
	    public void setSetFacility(Set<Facility> setFacility) {
	        this.setFacility = setFacility;
	    }
    
}




