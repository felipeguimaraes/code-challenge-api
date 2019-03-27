package com.felipeguimaraes.codechallenge.api.bean;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.index.CompoundIndex;
import org.springframework.data.mongodb.core.index.CompoundIndexes;
import org.springframework.data.mongodb.core.mapping.Document;

@CompoundIndexes({
		@CompoundIndex(def = "{'coverageArea' : '2dsphere'}", background = true, name = "coverageArea_2dsphere"),
		@CompoundIndex(def = "{'address' : '2dsphere'}", background = true, name = "address_2dsphere"),
		@CompoundIndex(def = "{'document' : 1}", background = true, unique = true, name = "document_cnpj") })
@Document
public class Pdv {

	@Id
	private Long id;

	private String tradingName;

	private String ownerName;

	private String document;

	CoverageArea coverageArea;

	Address address;

	public Pdv() {

	}

	public Pdv(String tradingName, String ownerName, String document, CoverageArea coverageArea, Address address) {
		super();
		this.tradingName = tradingName;
		this.ownerName = ownerName;
		this.document = document;
		this.coverageArea = coverageArea;
		this.address = address;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTradingName() {
		return tradingName;
	}

	public void setTradingName(String tradingName) {
		this.tradingName = tradingName;
	}

	public String getOwnerName() {
		return ownerName;
	}

	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}

	public String getDocument() {
		return document;
	}

	public void setDocument(String document) {
		this.document = document;
	}

	public CoverageArea getCoverageArea() {
		return coverageArea;
	}

	public void setCoverageArea(CoverageArea coverageArea) {
		this.coverageArea = coverageArea;
	}

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

}
