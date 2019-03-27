package com.felipeguimaraes.codechallenge.api.bean;

import java.util.ArrayList;
import java.util.List;

public class Address {

	private String type;

	private List<Double> coordinates = new ArrayList<Double>();

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<Double> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<Double> coordinates) {
		this.coordinates = coordinates;
	}

}
