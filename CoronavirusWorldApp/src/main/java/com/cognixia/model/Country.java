package com.cognixia.model;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

public class Country {
	
	private String cname;
	private String capname;
	private int coronaCases;
	private int population;
	
	
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public String getCapname() {
		return capname;
	}
	public void setCapname(String capname) {
		this.capname = capname;
	}
	public int getPopulation() {
		return population;
	}
	public void setPopulation(int population) {
		this.population = population;
	}
	public int getCoronaCases() {
		return coronaCases;
	}
	public void setCoronaCases(int coronaCases) {
		this.coronaCases = coronaCases;
	}
	
	
	
	
	
	
	
}
