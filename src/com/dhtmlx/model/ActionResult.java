package com.dhtmlx.model;

import java.util.Map;

public class ActionResult {
	private String id;
	private String status;
	private String nid;
	private Map<String, String> attrs;
	private String output;

	public ActionResult(String status, String id, String nid, String output, Map<String, String> attrs) {
		this.id = id;
		this.status = status;
		this.nid = nid;
		this.attrs = attrs;
		this.output = output;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getNid() {
		return nid;
	}

	public void setNid(String nid) {
		this.nid = nid;
	}

	public Map<String, String> getAttrs() {
		return attrs;
	}

	public void setAttrs(Map<String, String> attrs) {
		this.attrs = attrs;
	}

	public String getOutput() {
		return output;
	}

	public void setOutput(String output) {
		this.output = output;
	}

	/**
	 * DataActionת��Ϊxml��ʽ���ݿͻ���
	 * dataProcessor
	 * 
	 * @return DataAction��������ΪXML�ַ���
	 */
	public String resultToXml() {
		if (null == this.id) {
			this.id = "";
		}
		if (null == this.nid) {
			this.nid = this.id;
		}
		StringBuilder sBuilder = new StringBuilder("<action type='");
		sBuilder.append(this.status).append("' sid='").append(id).append("' tid='").append(this.nid).append("' ");
		// ����������� this.attrs ����ֵ������ʽ sBuilder.append(��).append("=").append(ֵ);
		if (null != this.attrs) {
			for (Map.Entry<String, String> entry : attrs.entrySet()) {
				sBuilder.append(entry.getKey()).append("='").append(entry.getValue()).append("' ");
			}
		}
		sBuilder.append(">").append(null == this.output ? "" : output).append("</action>");
		return sBuilder.toString();
	}
}
