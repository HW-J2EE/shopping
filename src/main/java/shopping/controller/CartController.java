package shopping.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopping.model.CartDetail;
import shopping.model.ResultModel;
import shopping.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addCommodityToCart")
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

}
