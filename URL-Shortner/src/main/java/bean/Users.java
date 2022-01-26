package bean;

import java.util.*;

public class Users {
	private int uid;
	private String longUrlVisitor;
	private String shortUrlVisitor;
	private String ipAddress;
	private String visitedDate;
	private String visitedTime;
	public Users() {
		super();
	}
	
	public Users(String longUrlVisitor, String shortUrlVisitor, String ipAddress, String visitedDate,
			String visitedTime) {
		super();
		this.longUrlVisitor = longUrlVisitor;
		this.shortUrlVisitor = shortUrlVisitor;
		this.ipAddress = ipAddress;
		this.visitedDate = visitedDate;
		this.visitedTime = visitedTime;
	}

	public Users(int uid, String longUrlVisitor, String shortUrlVisitor, String ipAddress, String visitedDate,
			String visitedTime) {
		super();
		this.uid = uid;
		this.longUrlVisitor = longUrlVisitor;
		this.shortUrlVisitor = shortUrlVisitor;
		this.ipAddress = ipAddress;
		this.visitedDate = visitedDate;
		this.visitedTime = visitedTime;
	}
	public int getUid() {
		return uid;
	}
	public void setUid(int uid) {
		this.uid = uid;
	}
	public String getLongUrlVisitor() {
		return longUrlVisitor;
	}
	public void setLongUrlVisitor(String longUrlVisitor) {
		this.longUrlVisitor = longUrlVisitor;
	}
	public String getShortUrlVisitor() {
		return shortUrlVisitor;
	}
	public void setShortUrlVisitor(String shortUrlVisitor) {
		this.shortUrlVisitor = shortUrlVisitor;
	}
	public String getIpAddress() {
		return ipAddress;
	}
	public void setIpAddress(String ipAddress) {
		this.ipAddress = ipAddress;
	}
	public String getVisitedDate() {
		return visitedDate;
	}
	public void setVisitedDate(String visitedDate) {
		this.visitedDate = visitedDate;
	}
	public String getVisitedTime() {
		return visitedTime;
	}
	public void setVisitedTime(String visitedTime) {
		this.visitedTime = visitedTime;
	}
	
}
