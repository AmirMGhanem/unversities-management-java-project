package University;

public class address {

	private String city;
	private String street;
	private String postCode;
	
	
	public address() {}
	public address(String city, String street, String postCode) {
		super();
		this.city = city;
		this.street = street;
		this.postCode = postCode;
	}
	public address(address add)
	{
		this.city = add.city;
		this.street = add.street;
		this.postCode =add.postCode;
	}
	
	
	
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getStreet() {
		return street;
	}
	public void setStreet(String street) {
		this.street = street;
	}
	public String getPostCode() {
		return postCode;
	}
	public void setPostCode(String postCode) {
		this.postCode = postCode;
	}
	@Override
	public String toString() {
		return "address [city=" + city + ", street=" + street + ", postCode=" + postCode + "]";
	}
	
	
	
}
