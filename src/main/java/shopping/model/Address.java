package shopping.model;

public class Address {
	private int address_id;
	private int user_id;
	private String address_info;
	private String contact_name;
	private String contact_phone;
	private boolean is_main;
	public int getAddress_id() {
		return address_id;
	}
	public void setAddress_id(int address_id) {
		this.address_id = address_id;
	}
	public int getUser_id() {
		return user_id;
	}
	public void setUser_id(int user_id) {
		this.user_id = user_id;
	}
	public String getAddress_info() {
		return address_info;
	}
	public void setAddress_info(String address_info) {
		this.address_info = address_info;
	}
	public String getContact_name() {
		return contact_name;
	}
	public void setContact_name(String contact_name) {
		this.contact_name = contact_name;
	}
	public String getContact_phone() {
		return contact_phone;
	}
	public void setContact_phone(String contact_phone) {
		this.contact_phone = contact_phone;
	}
	public boolean isIs_main() {
		return is_main;
	}
	public void setIs_main(boolean is_main) {
		this.is_main = is_main;
	}
	
	@Override
	public String toString() {
		return "Address [address_id=" + getAddress_id() + ", user_id=" + getUser_id() + ", address_info=" + getAddress_info() + 
				", contact_name="+getContact_name()+", contact_phone="+getContact_phone()+", is_main="+isIs_main()+"]";
	}
	
	public static Address createAddress(int user_id,String address_info,
			String contact_name, String contact_phone,boolean is_main) {
		Address address = new Address();
		//address.setAddress_id(address_id);
		address.setUser_id(user_id);
		address.setAddress_info(address_info);
		address.setContact_name(contact_name);
		address.setContact_phone(contact_phone);
		address.setIs_main(is_main);
		return address;
	}
	
	
	public static Address createAddress(int address_id,int user_id,String address_info,
			String contact_name, String contact_phone,boolean is_main) {
		Address address = new Address();
		address.setAddress_id(address_id);
		address.setUser_id(user_id);
		address.setAddress_info(address_info);
		address.setContact_name(contact_name);
		address.setContact_phone(contact_phone);
		address.setIs_main(is_main);
		return address;
	}
	
	
}
