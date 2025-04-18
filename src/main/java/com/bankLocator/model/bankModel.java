package com.bankLocator.model;

public class bankModel {
    private String name;
    private String address;

    public bankModel(String name, String address) {
        this.setName(name);
        this.address = address;
    }

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
