package shopping.service.impl;

import shopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.object.UpdatableSqlQuery;
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
		
	/*
	@Override
	public User register(String phoneNum, String password) {
		User user = User.createUser(phoneNum, password);
		userMapper.addUser(user);
		if(user.getId()!=0) {
			return user;
		}
		return null;
	}*/
	

	@Override
	public User regin(String phoneNum, String password) {
		User user = userMapper.getUser(phoneNum, password);
		return user;
	}

}
