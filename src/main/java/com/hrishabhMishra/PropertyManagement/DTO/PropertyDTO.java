package com.hrishabhMishra.PropertyManagement.DTO;

//import lombok.Getter;
//import lombok.Setter;

//@Getter
//@Setter
//There was lombok issue, hence manually created getters and setters.
public class PropertyDTO {
	
	private Long id;
	private String title;
	private String description;
	private String ownerName;
	private String address;
	private double price;
	
	
	
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public String getOwnerName() {
		return ownerName;
	}
	public void setOwnerName(String ownerName) {
		this.ownerName = ownerName;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public double getPrice() {
		return price;
	}
	public void setPrice(double price) {
		this.price = price;
	}
	

}
