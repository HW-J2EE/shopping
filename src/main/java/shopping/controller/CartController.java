package shopping.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import shopping.model.CartDetail;
import shopping.model.ResultModel;
import shopping.model.mongo.Order;
import shopping.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping(value="/addCommodityToCart")
	public ResultModel addCommodityToCart(
			int userId,
			int commodityId,
			int count) {

		if(cartService.addCommodityToCart(userId, commodityId, count)) {
			return ResultModel.successResult(null);
		}else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("/getCarts")
	public ResultModel getCart(int userId) {
		Map<String, Object> data = new HashMap<>();
		CartDetail cart = cartService.getCarts(userId);
		data.put("cart", cart);
		return ResultModel.successResult(data);
	}
	
	@RequestMapping("/generateOrder")
	public ResultModel generateOrder(int userId, int[] commodityIds) {
		Order order = cartService.generateOrder(userId, commodityIds);
		if(order!=null) {
			Map<String, Object> data = new HashMap<>();
			data.put("order", order);
			return ResultModel.successResult(data);
		}else {
			return ResultModel.failResult();
		}
	}
	
	@RequestMapping("getOrders")
	public ResultModel getOrders(int userId) {
		Map<String, Object> data = cartService.getOrders(userId);
		return ResultModel.successResult(data);
	}
	
	@RequestMapping("orderPay")
	public ResultModel orderPay(long orderId) {
		cartService.orderPay(orderId);
		return ResultModel.successResult(null);
	}
	@RequestMapping("orderCancel")
	public ResultModel orderCancel(long orderId) {
		cartService.orderCancel(orderId);
		return ResultModel.successResult(null);
	}
	
}
