package com.team11.cab.model;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "facilitytype")
public class FacilityType {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int typeId;
	private String typeName;
	private String description;

	@JsonBackReference
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "facilityType")
	private List<Facility> facilities;

	public FacilityType() {
		super();
	}

	public FacilityType(int typeId, String typeName, String description, List<Facility> facilities) {
		super();
		this.typeId = typeId;
		this.typeName = typeName;
		this.description = description;
		this.facilities = facilities;
	}

	public int getTypeId() {
		return typeId;
	}

	public void setTypeId(int typeId) {
		this.typeId = typeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public List<Facility> getFacilities() {
		return facilities;
	}

	public void setFacilities(List<Facility> facilities) {
		this.facilities = facilities;
	}

}
