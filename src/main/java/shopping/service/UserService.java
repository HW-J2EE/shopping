package shopping.service;

import shopping.model.User;

public interface UserService {

	User register(String phoneNum, String password);

	User regin(String phoneNum, String password);

}
