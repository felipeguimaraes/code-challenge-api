package com.felipeguimaraes.codechallenge.api.bean;

import java.util.ArrayList;
import java.util.List;

public class CoverageArea {

	private String type;

	private List<List<List<List<Double>>>> coordinates = new ArrayList<>();

	protected CoverageArea() {

	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public List<List<List<List<Double>>>> getCoordinates() {
		return coordinates;
	}

	public void setCoordinates(List<List<List<List<Double>>>> coordinates) {
		this.coordinates = coordinates;
	}

}
