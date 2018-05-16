package shopping.service.impl;

import shopping.model.User;
import shopping.model.Address;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.UserMapper;
import shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public User register(String phoneNum, String password) {
		User user = User.createUser(phoneNum, password);
		
		if(userMapper.verifyUser(phoneNum) == null){
			userMapper.addUser(user);
			if(user.getId()!=0) {
				return user;
			}
			return null;//注册失败
		}
		return null;//账户已存在
	}
		

	

	@Override
	public User login(String phoneNum, String password) {
		User user = userMapper.getUser(phoneNum, password);
		return user;
	}




	@Override
	public int nickNameChange(int id, String nickName) {
		int updateState = userMapper.updateNickName(id,nickName);
		return updateState;
	}
	
	@Override
	public boolean isRightPassword(int id, String oldPassword) {
		if(userMapper.verifyPassword(id,oldPassword) != null)
			return true;
		else
			return false;
	}

	
	@Override
	public int passwordChange(int id, String newPassword) {
		return userMapper.updatePassword(id,newPassword);
	}
	
	@Override
	public Address addAddress(int user_id, String address_info, String contact_name, String contact_phone,boolean is_main) {
		Address address = Address.createAddress(user_id, address_info, contact_name, contact_phone,is_main);
		userMapper.addAddress(address);
		if(address.getAddress_id() != 0) {
			return address;
		}
		else
			return null;
	}
	
	@Override
	public int addressChange(int address_id, int user_id, String address_info, String contact_name, String contact_phone,
			boolean is_main) {
		Address address = Address.createAddress(address_id,user_id, address_info, contact_name, contact_phone,is_main);
		if(is_main) {
			userMapper.set_other_address_not_main(user_id,false);
		}
		return userMapper.updateAddress(address);

	}
}
