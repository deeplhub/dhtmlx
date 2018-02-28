package com.dhtmlx.model;

/**
 * Í¼±í
 * 
 */
public class Chart {

	private Integer id;
	private float sales;
	private String year;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public float getSales() {
		return sales;
	}

	public void setSales(float sales) {
		this.sales = sales;
	}

	public String getYear() {
		return year;
	}

	public void setYear(String year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return "Chart [id=" + id + ", sales=" + sales + ", year=" + year + "]";
	}

}
