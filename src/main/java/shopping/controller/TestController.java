package shopping.controller;

import shopping.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import shopping.service.TestService;

@Controller
@RequestMapping("/test")
public class TestController {

	@Autowired
	private TestService testService;
	
	@RequestMapping("/")
	public String hello() {
		return "index";
	}
	
	@RequestMapping("/hello")
	@ResponseBody
	public String helloworld(User user) {
		return testService.helloWorld(user);
	}
}
