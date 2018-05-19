package shopping.mapper;

import org.apache.ibatis.annotations.Param;

import shopping.model.Address;
import shopping.model.User;

public interface UserMapper {
	public void addUser(User user);
	
	public User getUser(@Param("phoneNum")String phoneNum, @Param("password")String password);

	public String verifyUser(@Param("phoneNum")String phoneNum);

	public int updateNickName(@Param("id")int id, @Param("nickName")String nickName);

	public String verifyPassword(@Param("id")int id, @Param("oldPassword")String oldPassword);

	public int updatePassword(@Param("id")int id, @Param("newPassword")String newPassword);

	public void addAddress(Address address);

	public void set_other_address_not_main(@Param("user_id")int user_id,@Param("is_main")boolean is_main);

	public int updateAddress(@Param("userId")int userId, @Param("address")String address);
}
