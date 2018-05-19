package shopping.service;

import shopping.model.User;
import shopping.model.Address;

public interface UserService {

	User register(String phoneNum, String password);

	User login(String phoneNum, String password);

	int nickNameChange(int id, String nickName);

	boolean isRightPassword(int id, String oldPassword);

	int passwordChange(int id, String newPassword);

	Address addAddress(int user_id, String address_info, String contact_name, String contact_phone, boolean is_main);

	int addressChange(int userId, String address);

}
