package shopping.controller;

import java.util.HashMap;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import shopping.model.Address;
import shopping.model.Commodity;
import shopping.model.ResultModel;
import shopping.model.User;
import shopping.service.CommodityService;
import shopping.service.UserService;

@RequestMapping("/user")
@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	@Autowired
	private CommodityService commodityService;
	
	@RequestMapping("/register")
	@ResponseBody
	public ResultModel register(
			String phoneNum,
			String password) {
		HashMap<String, Object> hashMap = new HashMap<>();
		
		User user = userService.register(phoneNum, password);
		
		if(user!=null) {
			hashMap.put("userId", user.getId());
			return ResultModel.successResult(hashMap);
		}else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/login")
	@ResponseBody
	public ResultModel login(String phoneNum, String password) {
		HashMap<String, Object> hashMap = new HashMap<>();
		User user = userService.login(phoneNum,password);
		if(user!=null) {
			List<Commodity> commodities = commodityService.recommondCommodictories(user.getId(), 3);
			hashMap.put("user", user);
			hashMap.put("commodities", commodities);
			return ResultModel.successResult(hashMap);
		}else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/nickNameChange")
	@ResponseBody
	public ResultModel nickNameChange(int id,String nickName) {
		HashMap<String, Object> hashMap = new HashMap<>();
		int updateSate = userService.nickNameChange(id, nickName);
		if(updateSate != 0) {
			//hashMap.put("updateState", updateSate);
			return ResultModel.successResult(hashMap);
		}
		else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/passwordChange")
	@ResponseBody
	public ResultModel passwordChange(int id,String oldPassword,String newPassword){
		HashMap<String,Object> hashMap = new HashMap<>();
		boolean isRightPassword = userService.isRightPassword(id,oldPassword);
		
		if(isRightPassword) {
			int updateSate = userService.passwordChange(id, newPassword);
			if(updateSate != 0) {
				//hashMap.put("updateState", updateSate);
				return ResultModel.successResult(hashMap);
			}
			else {
				return ResultModel.failResult();
			}
		}
		else {
			return ResultModel.failResult();
		}
		
	}


	
	@RequestMapping("/addAddress")
	@ResponseBody
	public ResultModel addAddress(int user_id, String address_info, String contact_name, 
			String contact_phone,boolean is_main ){
		HashMap<String,Object> hashMap= new HashMap<>();
		Address address = userService.addAddress(user_id, address_info, contact_name, contact_phone,is_main);
		if(address != null) {
			hashMap.put("addressId", address.getAddress_id());
			return ResultModel.successResult(hashMap);
		}
		else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/addressChange")
	@ResponseBody
	public ResultModel addressChange(int userId, String address)
	{
		HashMap<String, Object> hashMap = new HashMap<>();
		int updateState =  userService.addressChange(userId, address);
		//hashMap.put("updateState", updateState);
		if(updateState != 0)
			return ResultModel.successResult(hashMap);
		else
			return ResultModel.failResult();
	}
}
