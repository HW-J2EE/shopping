package shopping.service;

import java.util.List;
import java.util.Map;

import shopping.model.CartDetail;
import shopping.model.mongo.Order;

public interface CartService {
	public boolean addCommodityToCart(int userId, int commodityId, int count);

	public CartDetail getCarts(int userId);

	public Order generateOrder(int userId, int[] commodityIds);

	public Map<String, Object> getOrders(int userId);

	public void orderPay(long orderId);

	public void orderCancel(long orderId);
}
