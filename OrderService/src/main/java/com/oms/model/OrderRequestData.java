package com.oms.model;

import java.util.List;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotNull;

public class OrderRequestData {
	@NotNull(message="itemList can't be blank")
	private List<Item> itemList;
	@NotNull(message="First name can't be blank")
	private String customerFirstName;
	@NotNull(message="Last name can't be blank")
	private String customerLastName;
	@NotNull(message="Address can't be blank")
	private String shippingAddress;
	@Email
	private String email;
	
	public List<Item> getItemList() {
		return itemList;
	}
	public void setItemList(List<Item> itemList) {
		this.itemList = itemList;
	}
	public String getCustomerFirstName() {
		return customerFirstName;
	}
	public void setCustomerFirstName(String customerFirstName) {
		this.customerFirstName = customerFirstName;
	}
	public String getCustomerLastName() {
		return customerLastName;
	}
	public void setCustomerLastName(String customerLastName) {
		this.customerLastName = customerLastName;
	}
	public String getShippingAddress() {
		return shippingAddress;
	}
	public void setShippingAddress(String shippingAddress) {
		this.shippingAddress = shippingAddress;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
	
}
