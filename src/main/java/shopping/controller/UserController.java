package shopping.controller;

import java.util.HashMap;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shopping.model.ResultModel;
import shopping.model.User;
import shopping.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@RequestMapping("/register")
	@ResponseBody
	public ResultModel register(
			String phoneNum,
			String password) {
		HashMap<String, Object> hashMap = new HashMap<>();
		
		User user = userService.register(phoneNum, password);
		
		if(user!=null) {
			hashMap.put("user", user);
			return ResultModel.successResult(hashMap);
		}else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultModel regin(String phoneNum, String password) {
		HashMap<String, Object> hashMap = new HashMap<>();
		User user = userService.regin(phoneNum,password);
		if(user!=null) {
			hashMap.put("user", user);
			return ResultModel.successResult(hashMap);
		}else {
			return ResultModel.failResult();
		}
	}
}
