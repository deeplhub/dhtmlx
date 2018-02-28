package com.dhtmlx.model;


public class GanttTask {
	private int id;
	private String text;
	private String start_date;
	private int duration;
	private float progress;
	private int sortorder;
	private int parent;
	private long version;

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

	public int getDuration() {
		return duration;
	}

	public void setDuration(int duration) {
		this.duration = duration;
	}

	public float getProgress() {
		return progress;
	}

	public void setProgress(float progress) {
		this.progress = progress;
	}

	public int getSortorder() {
		return sortorder;
	}

	public void setSortorder(int sortorder) {
		this.sortorder = sortorder;
	}

	public int getParent() {
		return parent;
	}

	public void setParent(int parent) {
		this.parent = parent;
	}

	public long getVersion() {
		return version;
	}

	public void setVersion(long version) {
		this.version = version;
	}

//	@Override
//	public int hashCode() {
//		int hash = 0;
//		hash += (int) id;
//		return hash;
//	}
//
//	@Override
//	public boolean equals(Object object) {
//		if (!(object instanceof GanttTask)) {
//			return false;
//		}
//		GanttTask other = (GanttTask) object;
//		if (this.id != other.id) {
//			return false;
//		}
//		return true;
//	}

	@Override
	public String toString() {
		return "GanttTask [id=" + id + ", text=" + text + ", start_date=" + start_date + ", duration=" + duration
				+ ", progress=" + progress + ", sortorder=" + sortorder + ", parent=" + parent + ", version=" + version
				+ "]";
	}

}
