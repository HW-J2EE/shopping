package shopping.model;

public class User {
private int id;
	private String phoneNum;
	private String nickname;
	private String password;
	
	public String getPhoneNum() {
		return phoneNum;
	}
	public void setPhoneNum(String phoneNum) {
		this.phoneNum = phoneNum;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getNickname() {
		return nickname;
	}
	public void setNickname(String nickname) {
		this.nickname = nickname;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	@Override
	public String toString() {
		return "User [id=" + id + ", nickname=" + nickname + ", password=" + password + "]";
	}
	public static User createUser(String phoneNum2, String password2) {
		User user = new User();
		user.setPhoneNum(phoneNum2);
		user.setPassword(password2);
		user.setNickname(phoneNum2);
		return user;
	}
}
