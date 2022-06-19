package com.pojo;

public class UpdateAddress_Input_Pojo {
	
	private String address_id;
    private String first_name;
    private String last_name;
    private String mobile;
    private String apartment;
    private int state;
    private int city;
    private int country;
    private String zipcode;
    private String address;
    private String address_type;
    
   //generation constructors with field     
	public UpdateAddress_Input_Pojo(String address_id, String first_name, String last_name, String mobile,
			String apartment, int state, int city, int country, String zipcode, String address,
			String address_type) {
		super();
		this.address_id = address_id;
		this.first_name = first_name;
		this.last_name = last_name;
		this.mobile = mobile;
		this.apartment = apartment;
		this.state = state;
		this.city = city;
		this.country = country;
		this.zipcode = zipcode;
		this.address = address;
		this.address_type = address_type;
	}

	public String getAddress_id() {
		return address_id;
	}

	public String getFirst_name() {
		return first_name;
	}

	public String getLast_name() {
		return last_name;
	}

	public String getMobile() {
		return mobile;
	}

	public String getApartment() {
		return apartment;
	}

	public int getState() {
		return state;
	}

	public int getCity() {
		return city;
	}

	public int getCountry() {
		return country;
	}

	public String getZipcode() {
		return zipcode;
	}

	public String getAddress() {
		return address;
	}

	public String getAddress_type() {
		return address_type;
	}
	
	


}
