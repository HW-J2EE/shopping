package shopping.service.impl;

import shopping.model.User;
import org.springframework.stereotype.Service;

import shopping.service.TestService;

@Service
public class TestServiceImpl implements TestService {

	@Override
	public String helloWorld(User user) {
		return "helloWorld!!"+user.toString();
	}

}
