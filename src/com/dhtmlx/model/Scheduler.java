package com.dhtmlx.model;

import org.springframework.format.annotation.DateTimeFormat;

/**
 * »’≥Ã
 * 
 */
public class Scheduler {

	private int id;
	private String text;
	private String start_date;
	private String end_date;
	private String scheduler_type;
	private String warn_date;
	private String warn_info;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getText() {
		return text;
	}

	public void setText(String text) {
		this.text = text;
	}

	public String getStart_date() {
		return start_date;
	}

	public void setStart_date(String start_date) {
		this.start_date = start_date;
	}

	public String getEnd_date() {
		return end_date;
	}

	public void setEnd_date(String end_date) {
		this.end_date = end_date;
	}

	public String getScheduler_type() {
		return scheduler_type;
	}

	public void setScheduler_type(String scheduler_type) {
		this.scheduler_type = scheduler_type;
	}

	public String getWarn_date() {
		return warn_date;
	}

	public void setWarn_date(String warn_date) {
		this.warn_date = warn_date;
	}

	public String getWarn_info() {
		return warn_info;
	}

	public void setWarn_info(String warn_info) {
		this.warn_info = warn_info;
	}

	@Override
	public String toString() {
		return "Scheduler [id=" + id + ", text=" + text + ", start_date=" + start_date + ", end_date=" + end_date
				+ ", scheduler_type=" + scheduler_type + ", warn_date=" + warn_date + ", warn_info=" + warn_info + "]";
	}

}
