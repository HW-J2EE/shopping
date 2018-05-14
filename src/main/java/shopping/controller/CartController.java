package shopping.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import shopping.service.CartService;

@RestController
@RequestMapping("/cart")
public class CartController {

	@Autowired
	private CartService cartService;
	
	@RequestMapping("/addCommodityToCart")
	public boolean addCommodityToCart(
			int userId,
			int commodityId,
			int count) {
		return cartService.addCommodityToCart(userId, commodityId, count);
	}
}
