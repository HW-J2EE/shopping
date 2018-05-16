package shopping.mapper;

import org.apache.ibatis.annotations.Param;

import shopping.model.User;

public interface UserMapper {
	public void addUser(User user);
	
	public User getUser(@Param("phoneNum")String phoneNum, @Param("password")String password);

	public String verifyUser(@Param("phoneNum")String phoneNum);
}
