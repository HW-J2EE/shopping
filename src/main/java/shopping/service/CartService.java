package shopping.service;

import shopping.model.CartDetail;

public interface CartService {
	public boolean addCommodityToCart(int userId, int commodityId, int count);

	public CartDetail getCarts(int userId);
}
