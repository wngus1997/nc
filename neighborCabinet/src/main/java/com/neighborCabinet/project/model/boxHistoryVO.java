package com.neighborCabinet.project.model;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

public class boxHistoryVO {
	private int ordDNo;
	private String ordNo;
	private String boxType;
	private int boxQty;
	private int selPrice;
	private String ordDate;
	private String userId;
	
	public int getOrdDNo() {
		return ordDNo;
	}
	public void setOrdDNo(int ordDNo) {
		this.ordDNo = ordDNo;
	}
	public String getOrdNo() {
		return ordNo;
	}
	public void setOrdNo(String ordNo) {
		this.ordNo = ordNo;
	}
	public String getBoxType() {
		return boxType;
	}
	public void setBoxType(String boxType) {
		this.boxType = boxType;
	}
	public int getBoxQty() {
		return boxQty;
	}
	public void setBoxQty(int boxQty) {
		this.boxQty = boxQty;
	}
	public int getSelPrice() {
		return selPrice;
	}
	public void setSelPrice(int selPrice) {
		this.selPrice = selPrice;
	}
	public String getOrdDate() {
		return ordDate;
	}
	public void setOrdDate(String ordDate) {
		this.ordDate = ordDate;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}	
	
	
}
