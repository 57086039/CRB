package org.java.util;

import java.util.Date;

public class serviceCondition {
	private String clientname;
	
	private String summary;
	
	private Long stid;
	
	private Date start;
	
	private Date end;
	
	private Long ssid;

	public String getClientname() {
		return clientname;
	}

	public void setClientname(String clientname) {
		this.clientname = clientname;
	}

	public String getSummary() {
		return summary;
	}

	public void setSummary(String summary) {
		this.summary = summary;
	}

	public Long getStid() {
		return stid;
	}

	public void setStid(Long stid) {
		this.stid = stid;
	}

	public Date getStart() {
		return start;
	}

	public void setStart(Date start) {
		this.start = start;
	}

	

	public Date getEnd() {
		return end;
	}

	public void setEnd(Date end) {
		this.end = end;
	}

	public Long getSsid() {
		return ssid;
	}

	public void setSsid(Long ssid) {
		this.ssid = ssid;
	}

	public serviceCondition(String clientname, String summary, Long stid,
			Date start, Date date, Long ssid) {
		super();
		this.clientname = clientname;
		this.summary = summary;
		this.stid = stid;
		this.start = start;
		this.end = date;
		this.ssid = ssid;
	}

	public serviceCondition() {
		super();
	}

	@Override
	public String toString() {
		return "serviceCondition [clientname=" + clientname + ", summary="
				+ summary + ", stid=" + stid + ", start=" + start + ", date="
				+ end + ", ssid=" + ssid + "]";
	}
	
	

}
