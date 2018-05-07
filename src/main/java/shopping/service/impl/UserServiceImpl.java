package shopping.service.impl;

import shopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import shopping.mapper.UserMapper;
import shopping.service.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserMapper userMapper;
	
	@Override
	public String register(String password) {
		User user = new User();
		user.setPassword(password);
		userMapper.addUser(user);
		return String.valueOf(user.getId());
	}

}
