package com.capgemini.springcore.annotation.beans;

import com.capgemini.springcore.interfaces.Engine;

public class Isuzu implements Engine {

	@Override
	public int getCC() {
		return 1800;
	}

	@Override
	public String getType() {
		return "4-Stroke Petrol";
	}

}
