package com.capgemini.springcore.annotation.beans;

import com.capgemini.springcore.interfaces.Engine;

public class VolksWagon implements Engine {

	@Override
	public int getCC() {
		return 1700;
	}

	@Override
	public String getType() {
		return "4-Stroke Diesel";
	}

}
