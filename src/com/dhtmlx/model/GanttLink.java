package com.dhtmlx.model;

public class GanttLink {
	private int id;
	private int source;
	private int target;
	private String type;
	private long version;

	public int getSource() {
		return source;
	}

	public void setSource(int source) {
		this.source = source;
	}

	public int getTarget() {
		return target;
	}

	public void setTarget(int target) {
		this.target = target;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
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
//		// TODO: Warning - this method won't work in the case the id fields are
//		// not set
//		if (!(object instanceof GanttLink)) {
//			return false;
//		}
//		GanttLink other = (GanttLink) object;
//		if (this.id != other.id) {
//			return false;
//		}
//		return true;
//	}

	@Override
	public String toString() {
		return "GanttLink [id=" + id + ", source=" + source + ", target=" + target + ", type=" + type + ", version="
				+ version + "]";
	}

}
